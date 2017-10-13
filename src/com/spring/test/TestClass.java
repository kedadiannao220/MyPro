package com.spring.test;

import com.spring.MyTestBean;
import org.apache.xbean.spring.context.impl.XBeanXmlBeanFactory;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Created by admin on 03/08/2017.
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
//        LinkedHashSet linkedHashSet = new LinkedHashSet();

//        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
//
//        System.out.println(f1 == f2);
//        System.out.println(f3 == f4);
    }

    @Test
    public void testXml() {

//        ApplicationContext factory = new FileSystemXmlApplicationContext(
//            "src/resource/beanFactory.xml");

        ApplicationContext factory = new ClassPathXmlApplicationContext("beanFactory.xml");

        MyTestBean myTestBean = (MyTestBean) factory.getBean("myTestBean");

        System.out.println(myTestBean.getTestStr());

    }

    @Test
    public void test() throws IOException {

        //FileSystemResource
        //        Resource fileRes1 = new FileSystemResource(
        //            "/Users/admin/projects/myPro/src/resource/beanFactory.xml");
        //        Resource fileRes2 = new FileSystemResource("src/resource/beanFactory.xml");
        //
        //        // ClassPathResource
        //        Resource classRes = new ClassPathResource("beanFactory.xml");
        //
        //        // UrlResource
        //        //输出结果:/Users/admin/projects/myPro/target/classes/beanFactory.xml
        ////        System.out
        ////            .println(TestClass.class.getClassLoader().getResource("beanFactory.xml").getPath());
        //        Resource urlRes = new UrlResource(
        //            TestClass.class.getClassLoader().getResource("beanFactory.xml"));

        //        Resource servletRes = new ServletContextResource(TestClass.class.getClassLoader().)
        //            .createRelative("src/resource/beanFactory.xml");

        Resource res = new ClassPathResource("beanFactory.xml");

        BeanFactory beanFactory = new XBeanXmlBeanFactory(res);

        MyTestBean myTestBean = (MyTestBean) beanFactory.getBean("myTestBean");

        System.out.println(myTestBean.getTestStr());
    }
}
