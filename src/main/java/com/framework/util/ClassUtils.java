package com.framework.util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: krny
 * Date: 2017/7/12 0012
 * Time: 23:18
 * To change this template use File | Settings | File Templates.
 */
public class ClassUtils {
    static {
        System.out.println("Clas UTIL");
    }

    private static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Set<Class<?>> getClass(String packageName) {
        Set<Class<?>> classSet = new HashSet<>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while(urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String protocol = url.getProtocol();
                if (protocol.equals("file")) {
                    String packagePath = url.getPath().replaceAll("%20"," ");
                    addClass(classSet,packagePath,packageName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File path) {
                return (path.isFile() && path.getName().endsWith(".class") ) || path.isDirectory();
            }
        });
        if (files != null) {
            for (File file : files) {
                String fileName = file.getName();
                if (file.isFile()) {
                    String className = fileName.substring(0,fileName.lastIndexOf("."));
                    className = packageName + "." + className;
                    doAddClass(classSet,className);
                } else {
                    String packPath = packagePath  + "/" + fileName;
                    String packName = packageName + "."+ fileName;
                    addClass(classSet,packPath,packName);
                }
            }
        }

    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cl = loadClass(className,false);
        classSet.add(cl);
    }
    public static Class<?> loadClass(String className, boolean flag) {
        Class<?> cl = null;
        try {
            cl =  Class.forName(className,flag,getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cl;
    }

}
