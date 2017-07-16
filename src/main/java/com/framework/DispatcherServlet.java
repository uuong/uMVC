package com.framework;

import com.framework.bean.*;
import com.framework.helper.AopHelper;
import com.framework.helper.ConfigHelper;
import com.framework.helper.ControllerHelper;
import com.framework.helper.IocHelper;
import com.framework.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/12 0012
 * Time: 22:48
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        ServletContext servletContext = servletConfig.getServletContext();

        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");

        ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");


        try {
            Class.forName(AopHelper.class.getName());
            Class.forName(IocHelper.class.getName());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestMethod = req.getMethod().toLowerCase();

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String requestPath = null;
        if (contextPath != null && contextPath.length() > 0) {
            requestPath = url.substring(contextPath.length());
        }

        Handler handler = ControllerHelper.getActionMethod(requestMethod, requestPath);
        if (handler != null) {
            Class<?> aClass = handler.getControllerClass();
            Method method = handler.getMethod();
            Object object = BeanContainer.getBean(aClass);


            Map<String, Object> paramMap = new HashMap<>();
            Enumeration<String> paramNames = req.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = paramNames.nextElement();
                String paramValue = req.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String body = CodecUtil.decodeUrl(StreamUtil.getString(req.getInputStream()));
            if (StringUtil.isNotEmpty(body)) {
                String[] params = StringUtil.splitString(body, "&");
                if (ArrayUtil.isNotEmpty(params)) {
                    for (String param : params) {
                        String[] array = StringUtil.splitString(param, "=");
                        if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }
            //陷入误区
            //只关注调用 不知可以改变被调用方法参数类型
            //被spring 框架误导

            Param param = new Param(paramMap);
            Object result;
            if (param.isEmpty()) {
                result = BeanFactory.invokeMethod(object, method);
            } else {
                result = BeanFactory.invokeMethod(object, method, param);
            }
            if (result instanceof View) {
                View view = (View) result;
                String path = view.getPath();
                if (StringUtil.isNotEmpty(path)) {
                    //转发
                    if (path.startsWith("/")) {
                        resp.sendRedirect(req.getContextPath() + path);
                    } else {
                        Map<String, Object> map = view.getModel();
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            req.setAttribute(entry.getKey(),entry.getValue());
                        }
                        req.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(req, resp);
                    }
                }
            } else {
                Data data = (Data) result;
                Object model = data.getModel();
                if (model != null) {
                    resp.setContentType("application/json");
                    resp.setCharacterEncoding("UTF-8");
                    PrintWriter writer = resp.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }


        }
    }

}
