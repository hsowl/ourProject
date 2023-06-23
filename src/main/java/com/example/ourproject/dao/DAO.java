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
    public ProductVO selectOneBoardByNum(int no) {
        ProductVO vo = null;
        String sql = "select * from board where num=?";
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
                vo.setPrice(rs.getInt("price"));
                vo.setImage(rs.getString("image"));
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

    public List<QAVO> selectAllBoard() {
        List<QAVO> list = new ArrayList<QAVO>();

        String sql = "select * from QA order by num";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            conn = DBManager.getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();

            while (rs.next()){
                QAVO vo = new QAVO();
                vo.setNo(rs.getInt("no"));
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
    public CartVO cartSelect(String id) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        CartVO cvo = new CartVO();
        String sql = "select * from cart where id=?";

        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int no=rs.getInt("no");
                ProductVO pvo= selectOneProductByNo(no);
                cvo.setTitle(pvo.getTitle());
                cvo.setImage(pvo.getImage());
                cvo.setPrice(pvo.getPrice());
                cvo.setNo(rs.getInt("no"));
                cvo.setId(rs.getString("id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return cvo;
    }

}
