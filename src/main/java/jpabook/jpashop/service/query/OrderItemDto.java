package jpabook.jpashop.service.query;

import jpabook.jpashop.domain.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderItemDto {
    private String itemName;
    private int orderPrice;
    private int count;
    public OrderItemDto(OrderItem orderItem) {
        itemName = orderItem.getItem().getName();
        orderPrice = orderItem.getOrderPrice();
        count = orderItem.getCount();
    }
}
