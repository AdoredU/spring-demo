package cn.adoredu.ioc;

import cn.adoredu.ioc.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {

    @Test
    public void test() {
        // 1. 加载配置文件，创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 得到配置创建的对象
        UserService userService = (UserService) context.getBean("userService");
//        User user = (User) context.getBean("user");

        // 查看结果
//        System.out.println(userService);
        userService.add();
//        user.show();
    }
}
