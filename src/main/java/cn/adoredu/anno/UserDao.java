package cn.adoredu.anno;

import org.springframework.stereotype.Component;

@Component("userDao123")
public class UserDao {

    public void add() {
        System.out.println("userDao add...");
    }
}
