package com.example.ourproject.controller.action;

import com.example.ourproject.VO.OrderSearchVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class orderSearchAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "orderSearch.jsp";
        String id = request.getParameter("id");

        DAO dao = DAO.getInstance();


        int num = Integer.parseInt(request.getParameter("num"));

        List<OrderSearchVO> list = dao.orderSelectDate(num,id);

        request.setAttribute("orderSearch",list);

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
