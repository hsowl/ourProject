package com.example.ourproject.controller.action;

import com.example.ourproject.VO.OrderSearchVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class orderUpdateAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "orderSearch.jsp";
        String id = request.getParameter("id");

        DAO dao = DAO.getInstance();
        OrderSearchVO vo = new OrderSearchVO();

        vo.setId(request.getParameter("id"));
        vo.setNo(Integer.parseInt(request.getParameter("no")));

        dao.insertOrder(vo);
        List<OrderSearchVO> list = dao.orderSelectDate(-1,id);
        request.setAttribute("orderSearch",list);

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);

        new orderSearchAction().execute(request, response);
    }
}