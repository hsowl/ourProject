package com.example.ourproject.dao;

import com.example.ourproject.VO.CartVO;
import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.VO.ProductVO;
import com.example.ourproject.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {

    private DAO() {
    }

    private static DAO instance = new DAO();

    public static DAO getInstance() {
        return instance;
    }

    public ProductVO selectOneProductByNo(int no) {
        return new ProductVO();
    }

    public CartVO cartSelect(String id) {
        return new CartVO();
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

    public int insertBoard(CartVO vo) {
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
}
