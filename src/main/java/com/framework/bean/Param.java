package com.framework.bean;


import com.framework.util.CastUtil;
import com.framework.util.CollectionUtil;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/6/28 0028
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }
    public Object getKey(String name) {
        return paramMap.get(name);
    }
    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public boolean isEmpty() {
        return CollectionUtil.isEmpty(paramMap);
    }
}
