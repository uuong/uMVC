package com.framework;

import demo.ctrl.Index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/index2")
public class Test extends HttpServlet{
    @Override
    public void init() throws ServletException {
        System.out.println("init index");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget");

        Index index = new Index();

        index.ff();
    }
}
