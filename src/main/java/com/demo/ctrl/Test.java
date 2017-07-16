package com.demo.ctrl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/13 0013
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */

public class Test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("index");
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req,resp);
    }


}

