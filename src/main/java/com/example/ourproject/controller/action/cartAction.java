package com.example.ourproject.controller.action;

import com.example.ourproject.VO.CartVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class cartAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "myCart.jsp";

        String id = request.getParameter("id");

        DAO dao = DAO.getInstance();

        List<CartVO> list = dao.cartSelect(id);

//        특정 id의 cart테이블의 product의 정보를 모두 빼와야함.

        request.setAttribute("product",list);

        RequestDispatcher dis =request.getRequestDispatcher(url);
        dis.forward(request, response);


    }

}