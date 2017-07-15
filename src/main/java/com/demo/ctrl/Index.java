package com.demo.ctrl;

import com.demo.service.indexService;
import com.framework.RequestMethod;
import com.framework.annotation.Action;
import com.framework.annotation.AutoWired;
import com.framework.annotation.Controller;
import com.framework.bean.Data;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/12 0012
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class Index {
    @AutoWired
    private indexService indexService;

    @Action(path = "/index",method = RequestMethod.GET)
    public Data index() {
        System.out.println("Index . index");
        if (indexService != null) {
            String list = indexService.ff();
            return new Data(list);
        }
        return new Data("not");
    }

    @Action(path = "/in",method = RequestMethod.GET)
    public Data indexA(String name) {
        System.out.println("innnnnnnnnnnnnnn");
        if (indexService != null) {
            return new Data(name);
        }
        return new Data("not");
    }



    public void ff() {
        if (indexService != null) {
            indexService.ff();
        } else {
            System.out.println("index  is not");
        }

    }
}
