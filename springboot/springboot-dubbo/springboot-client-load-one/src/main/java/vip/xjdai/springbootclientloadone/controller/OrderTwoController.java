package vip.xjdai.springbootclientloadone.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.xjdai.order.model.User;
import vip.xjdai.order.service.UserService;

@RestController
public class OrderTwoController {

    @Reference
    private UserService userService;

    @RequestMapping("/getUserTwo")
    public User getUserTwo() {
        //调用服务
        return userService.findUserById((long) 8888);
    }

}