package com.example.ourproject.controller.action;

import com.example.ourproject.VO.ProductVO;
import com.example.ourproject.dao.DAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class productDetailAction implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        DAO Dao = DAO.getInstance();

        ProductVO vo = Dao.selectOneProductByNo(no);
        String url = "productDetail.jsp";

        request.setAttribute("product",vo);
        //이성진
        RequestDispatcher dis = request.getRequestDispatcher(url);
        dis.forward(request,response);
    }
}
