package com.demo.ctrl;

import com.demo.service.indexService;
import com.framework.RequestMethod;
import com.framework.annotation.Action;
import com.framework.annotation.AutoWired;
import com.framework.annotation.Controller;
import com.framework.bean.Data;
import com.framework.bean.Param;
import com.framework.bean.View;

import java.util.Map;

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
        if (indexService != null) {
            String list = indexService.ff();
            return new Data(list);
        }
        return new Data("not");
    }
    @Action(path = "/get",method = RequestMethod.GET)
    public View getView() {
        View view = new View("hello.jsp");
        view.addModel("list","132432");
        return view;
    }

    @Action(path = "/re",method = RequestMethod.GET)
    public View testRe() {
        return new View("/index");
    }

    @Action(path = "/in",method = RequestMethod.GET)
    public Data indexA(Param param) {
        Map<String,Object> map = param.getParamMap();
        if (indexService != null) {
            return new Data(map);
        }
        return new Data("not");
    }
}
