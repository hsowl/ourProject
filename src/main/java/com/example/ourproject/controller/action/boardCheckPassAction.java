package com.example.ourproject.controller.action;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class boardCheckPassAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));
//        String pass = request.getParameter("pass");

//        BoardDAO bDao = BoardDAO.getInstance();
//        BoardVO vo =bDao.selectOneBoardByNum(num);

//        if(vo.getPass().equals(pass)){
//            url = "/board/checkSuccess.jsp";
//        }else{
//            url = "/board/boardCheckPass.jsp";
//            request.setAttribute("message","비밀번호가 틀립니다");
//        }
        String url = "checkSuccess.jsp";
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }
}
