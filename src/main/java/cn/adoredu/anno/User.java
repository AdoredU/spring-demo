package cn.adoredu.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")  // 相当于<bean id="user" class=""></bean>
//@Scope(value = "prototype")
public class User {

    public void add() {
        System.out.println("add...");
    }
}
