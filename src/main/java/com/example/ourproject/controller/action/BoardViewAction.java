package com.example.ourproject.controller.action;

import com.example.ourproject.VO.QAVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Reader;

public class BoardViewAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
        DAO dao = DAO.getInstance();
        QAVO vo =dao.selectOneBoardByNo(no);
        request.setAttribute("Board",vo);
        String url = "checkSuccess.jsp";

        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }
}
