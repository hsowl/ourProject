package com.example.ourproject.controller.action;

import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class findPwAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "login.jsp";
        String id = request.getParameter("id");
        String name = request.getParameter("name");

        DAO Dao = DAO.getInstance();

//        MemberVO vo = Dao.findPw(id, name);

//        request.setAttribute("id", vo);
//        request.setAttribute("pw", vo);

        RequestDispatcher dis = request.getRequestDispatcher("updatePw.jsp");
        dis.forward(request, response);
    }
}
