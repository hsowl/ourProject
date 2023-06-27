package com.example.ourproject.controller.action;

import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.VO.OrderSearchVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class orderUpdateAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        MemberVO mvo = (MemberVO)session.getAttribute("id");

        DAO dao = DAO.getInstance();
        OrderSearchVO vo = new OrderSearchVO();

        String[] listNo = request.getParameterValues("no");

        for( int i=0; i<listNo.length; i++) {
            int no = Integer.parseInt(listNo[i]);
            vo.setNo(no);
            vo.setId(mvo.getId());
            dao.insertOrder(vo);
        }

        new orderSearchAction().execute(request, response);
    }
}