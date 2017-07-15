package com.demo.service;

import com.framework.annotation.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/12 0012
 * Time: 22:59
 * To change this template use File | Settings | File Templates.
 */
@Service
public class indexService {
    public List getList() {
        String sql = "select * from customer";
        return null;
    }
    public static void f() {
        System.out.println("f");
    }
    public String ff() {
        System.out.println("ff");return "fffff";
    }
}
