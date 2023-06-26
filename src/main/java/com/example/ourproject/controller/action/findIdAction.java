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
        int result = -1;
        String name = request.getParameter("name");
        String pw = request.getParameter("pw");

        DAO Dao = DAO.getInstance();
        MemberVO vo = Dao.findId(name, pw);

        if (vo.getName().equals(name) && vo.getPw().equals(pw)) {
            request.setAttribute("id", vo);
            request.setAttribute("name", vo);
            result = 1;
            url = "findIdResult.jsp";
        } else if (name == null){
            request.setAttribute("message", "이름을 입력하여 주십시오.");
            result = -1;
            url = "/findId.jsp";
        } else if (pw == null){
            request.setAttribute("message", "비밀번호를 입력하여 주십시오.");
            result = -1;
            url = "/findId.jsp";
        } else if (!vo.getName().equals(name)){
            request.setAttribute("message", "이름을 잘못 입력하셨습니다.");
            result = -1;
            url = "/findId.jsp";
        } else if (!vo.getPw().equals(pw)){
            request.setAttribute("message", "비밀번호를 잘못 입력하셨습니다.");
            result = -1;
            url = "/findId.jsp";
        }

        System.out.println(result);
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request, response);
    }
}
