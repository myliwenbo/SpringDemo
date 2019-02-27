package vip.xjdai.ioc.annotation.controller;

import org.springframework.stereotype.Component;

/**
 * @author lwb
 *
 */
@Component
public class ComponentD {

    public ComponentD() {
        System.out.println("初始化：" + this.getClass().getName());
    }

    public void test() {
        System.out.println("我是:" + this.getClass().getPackage() + "下的方法");
    }
}
