package cn.adoredu.tx;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrderService {

    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void account() {
        orderDao.reduceMoney();
        int a = 10 / 0;
        orderDao.addMoney();
    }
}
