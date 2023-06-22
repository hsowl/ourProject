package com.example.ourproject.dao;

import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.VO.ProductVO;
import com.example.ourproject.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DAO {

    private DAO() {
    }

    private static DAO instance = new DAO();

    public static DAO getInstance() {
        return instance;
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


    public ProductVO selectOneProductByNo(int no) {
    }
}

