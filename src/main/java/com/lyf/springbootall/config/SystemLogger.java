package com.lyf.springbootall.config;

public class SystemLogger {

    static {
        System.out.println("=================================================");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>System Env ");
//        Map<String, String> env = System.getenv();
//        for (String key : env.keySet()) {
//            System.out.println(key + ": " + env.get(key));
//        }

        System.getenv().forEach((key, value) -> System.out.println(key + ": " + value));

        System.out.println("=================================================");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>System Property ");
//        Set<String> propertyNames = System.getProperties().stringPropertyNames();
//        for (String propertyName : propertyNames) {
//            System.out.println(propertyName + ": " + System.getProperty(propertyName));
//        }
        System.getProperties().forEach((key, value) -> System.out.println(key + ": " + value));
        System.out.println("=================================================");
    }
}
