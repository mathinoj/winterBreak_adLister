package com.codeup.controller;

import com.codeup.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/gyms")
public class ViewGymsServlet HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute(
                "gym",
                DaoFactory.getGymsDao().all()
        );
        request.getRequestDispatcher("/WEB-INF/gyms.jsp").forward(request, response);
    }

}
