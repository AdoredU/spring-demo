package cn.adoredu.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("userService")
public class UserService {

    @Autowired
    private UserDao userDao;
    // 注解方式不需要定义set方法

    public void add() {
        System.out.println("userServive add...");
        userDao.add();
    }
}
