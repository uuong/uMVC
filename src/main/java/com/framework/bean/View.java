package com.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/16 0016
 * Time: 9:40
 * To change this template use File | Settings | File Templates.
 */
public class View {
    private String path;
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }
    public View addModel(String key, Object value) {
        model.put(key,value);
        return this;
    }

    public Map<String, Object> getModel() {
        return model;
    }

    public String getPath() {
        return path;
    }
}
