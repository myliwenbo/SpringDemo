package cn.lwb.log.console;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.lwb.SpringbootLogbakOrLombokApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootLogbakOrLombokApplication.class)
public class SpringbootLogbakOrLombokApplicationTests {

    @Autowired
    private ConsoleLog consoleLog;

    @Test
    public void contextLoads() {
        consoleLog.countOrder();
    }

}