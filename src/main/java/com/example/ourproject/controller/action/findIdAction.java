package com.example.ourproject.controller.action;

import com.example.ourproject.VO.MemberVO;
import com.example.ourproject.controller.action.Action;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class findIdAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "findId.jsp";
        String name = request.getParameter("name");
        String pw = request.getParameter("pw");

        DAO Dao = DAO.getInstance();
        MemberVO mVo = Dao.findId(name, pw);

        RequestDispatcher dis = request.getRequestDispatcher("idCheck.jsp");
        dis.forward(request, response);
    }
}
