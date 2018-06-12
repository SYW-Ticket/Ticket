package com.ticket.insertOrder.daoRead;

import com.ticket.insertOrder.bean.Order;

public interface OrderDaoRead {
    Order selectOrderByID(int id);

}
