package cn.yt4j.javabean.test;

import cn.yt4j.javabean.pojo.Staff;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class T {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Staff.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            System.out.println(propertyDescriptor);

            Class<?> propertyType=propertyDescriptor.getPropertyType();

        });
    }
}
