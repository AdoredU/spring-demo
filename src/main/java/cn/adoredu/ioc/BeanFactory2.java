package cn.adoredu.ioc;

public class BeanFactory2 {

    public UserService getUserService() {
        return new UserService();
    }
}
