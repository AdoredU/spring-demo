package cn.adoredu.ioc;

public class BeanFactory {

    public static UserService getUserService() {
        return new UserService();
    }
}
