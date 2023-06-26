package com.example.ourproject.dao;

import com.example.ourproject.VO.*;
import com.example.ourproject.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    private DAO() {
    }

    private static DAO instance = new DAO();

    public static DAO getInstance() {
        return instance;
    }

    public ProductVO selectOneProductByNo(int no) {
        ProductVO vo = null;
        String sql = "select * from product where no=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            rs=pstmt.executeQuery();

            if (rs.next()){
                vo=new ProductVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setImage(rs.getString("image"));
                vo.setPrice(rs.getInt("price"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return vo;
    }
    public int insertMember(MemberVO vo) {

        int result = -1;

        Connection conn = null;
        PreparedStatement pstmt = null;

        String sql = "insert into member values(?,?,?,?,?,?,?)";

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getPw());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getName());
            pstmt.setString(5, vo.getBirthDate());
            pstmt.setString(6, vo.getGender());
            pstmt.setString(7, vo.getPhone());

            result = pstmt.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            DBManager.close(conn,pstmt);
        }
        return result;
    }
    public QAVO selectOneBoardByNo(int no) {
        QAVO vo = null;
        String sql = "select * from board where no=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,no);
            rs=pstmt.executeQuery();

            if (rs.next()){
                vo=new QAVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return vo;
    }

    public int insertProduct(CartVO vo) {
        int result = -1;
        String sql = "insert into cart (id,no) values(?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, vo.getId());
            pstmt.setInt(2,vo.getNo());
            result=pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DBManager.close(conn,pstmt);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public List<ProductVO> selectAllList() {
        List<ProductVO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from product order by no";

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setImage(rs.getString("image"));
                vo.setPrice(rs.getInt("price"));

                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return list;
    }

    public List<QAVO> selectAllBoard(int no) {
        List<QAVO> list = new ArrayList<QAVO>();

        String sql = "select * from QA where no=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, no);
            rs=pstmt.executeQuery();

            while (rs.next()){
                QAVO vo = new QAVO();
                vo.setNo(rs.getInt("no"));
                vo.setId(rs.getString("id"));
                vo.setPass(rs.getString("pass"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return list;
    }
    public int userCheck(String id, String pw) {
        int result = -1;

        String sql = "select pw from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if(rs.next()) { //id가 기본키이기 때문에 while문 돌릴필요 없다.
                String getpw = rs.getString("pw");
                if(getpw != null && getpw.equals(pw)) {
                    result = 1; //id, pw ==> ok
                }else {
                    result = 0; //id ==> ok, pw ==> false
                }
            }else {
                result = -1; //id ==> false
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return result;
    }
    public MemberVO getMember(String id) {
        MemberVO vo = null;

        String sql = "select * from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                vo = new MemberVO();

                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setEmail(rs.getString("email"));
                vo.setName(rs.getString("name"));
                vo.setBirthDate(rs.getString("birthDate"));
                vo.setGender(rs.getString("gender"));
                vo.setPhone(rs.getString("phone"));

            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return vo;
    }
    public List<CartVO> cartSelect(String id) {
        List<CartVO> list = new ArrayList<CartVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        CartVO cvo = new CartVO();
        String sql = "select * from cart where id=?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int no= rs.getInt("no");
                ProductVO pvo =selectOneProductByNo(no);
                cvo.setImage(pvo.getImage());
                cvo.setTitle(pvo.getTitle());
                cvo.setPrice(pvo.getPrice());
                cvo.setNo(rs.getInt("no"));
                cvo.setId(rs.getString("id"));
                list.add(cvo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return list;
    }

    public int confirmID(String id) {
        int result = -1;
        String sql = "select id from member where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = 1;
            } else {
                result = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return result;
    }

    public void infoUpdate(MemberVO vo) {
        String sql = "update member set id = ?, pw=?, email=?, name=?, phone=? where id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPw());
            pstmt.setString(3,vo.getEmail());
            pstmt.setString(4,vo.getName());
            pstmt.setString(5,vo.getPhone());
            pstmt.setString(6,vo.getId());

            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
             DBManager.close(conn, pstmt);
        }
    }
    public List<OrderSearchVO> orderSelectDate(int num, String id){
        OrderSearchVO vo = new OrderSearchVO();
        List<OrderSearchVO> list = new ArrayList<OrderSearchVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";

        try {
            if(num==-1){
                sql ="select * form orderSearch";
            } else if (num==0) {
                sql ="select * from orderSearch Where orderdate<=add_months(sysdate,-1)";
            } else {
                sql = "select * from orderSearch Where orderdate<=add_months(sysdate,-3)";
            }
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int no=rs.getInt("no");
                ProductVO pvo= selectOneProductByNo(no);
                vo.setTitle(pvo.getTitle());
                vo.setImage(pvo.getImage());
                vo.setPrice(pvo.getPrice());
                vo.setId(rs.getString("id"));
                vo.setNo(rs.getInt("no"));
                list.add(vo);
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }

        return list;
    }
    public void insertOrder(OrderSearchVO vo) {
        String sql = "insert into orderSearch(id, no, orderDate) values(?,?,sysdate)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn = DBManager.getConnection();
            pstmt =conn.prepareStatement(sql);

            pstmt.setString(1, vo.getId());
            pstmt.setInt(2, vo.getNo());

            pstmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn, pstmt);
        }
    }
    public List<ProductVO> searchList(String keyword) {
        List<ProductVO> list = new ArrayList<>();
        System.out.println("keyword = "+keyword);

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from product where title like ?";

        try{
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+keyword+"%");
            rs = pstmt.executeQuery();

            while (rs.next()){
                ProductVO vo = new ProductVO();
                vo.setNo(rs.getInt("no"));
                vo.setTitle(rs.getString("title"));
                vo.setImage(rs.getString("image"));
                vo.setPrice(rs.getInt("price"));

                list.add(vo);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return list;
    }

    public MemberVO findId(String name, String pw) {
        MemberVO vo = null;

        String sql = "select id from member where (name=? and pw=?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,pw);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                vo = new MemberVO();

                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));

            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            DBManager.close(conn,pstmt,rs);
        }
        return vo;
    }
    public int insertBoard(QAVO vo) {
        int result = -1;
        String sql = "insert into QA(no,id,pass,title,content) values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNo());
            pstmt.setString(2, vo.getId());
            pstmt.setString(3, vo.getPass());
            pstmt.setString(4, vo.getTitle());
            pstmt.setString(5, vo.getContent());
            result=pstmt.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DBManager.close(conn,pstmt);
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
