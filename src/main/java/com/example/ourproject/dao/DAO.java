package com.example.ourproject.dao;

import com.example.ourproject.VO.CartVO;
import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.VO.ProductVO;

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

    public int insertMember(MemberVO vo) {
        return 0;
    }

    public CartVO cartSelect(String id) {
        return new CartVO();
    }
}
