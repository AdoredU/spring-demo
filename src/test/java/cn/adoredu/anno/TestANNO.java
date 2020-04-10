package cn.adoredu.anno;

import cn.adoredu.anno.User;
import cn.adoredu.anno.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestANNO {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");

//        System.out.println(userService);
        userService.add();
    }
}
