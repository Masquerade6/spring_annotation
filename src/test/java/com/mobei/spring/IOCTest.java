package com.mobei.spring;

import com.mobei.spring.annotation.MainConfig;
import com.mobei.spring.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {

    @Test
    public void testComponentScan() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig.class);

//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String item : beanDefinitionNames) {
//            System.out.println(item);
//        }

        String[] beanNamesForType = applicationContext.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    @Test
    public void testImportSelector() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String item : beanDefinitionNames) {
            System.out.println(item);
        }
    }

    @Test
    public void testFactoryBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

        // 工厂Bean获取的是ColorFactoryBean的方法getObject返回的对象
        Object color = applicationContext.getBean("colorFactoryBean");
        // 输出的是: class com.mobei.spring.bean.Color
        System.out.println(color.getClass());

        // 如果要获取ColorFactoryBean自身的对象需要在colorFactoryBean前面加&符号
        Object colorFactoryBean = applicationContext.getBean("&colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
    }

}
