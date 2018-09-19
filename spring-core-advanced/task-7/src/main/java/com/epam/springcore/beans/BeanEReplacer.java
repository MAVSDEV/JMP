package com.epam.springcore.beans;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class BeanEReplacer implements MethodReplacer {

    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        if (isFormatMessageMethod(method)) {

            String msg = (String) objects[0];

            return "<h2>replaced: " + msg + "</h2>";
        } else {
            throw new IllegalArgumentException("Unable to reimplement method "
                    + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {

        // check correct number of params
        if (method.getParameterTypes().length != 1) {
            return false;
        }

        // check method name
        if (!("getName".equals(method.getName()))) {
            return false;
        }

        // check return type
        if (method.getReturnType() != String.class) {
            return false;
        }

        // check parameter type is correct
        if (method.getParameterTypes()[0] != String.class) {
            return false;
        }

        return true;
    }
}