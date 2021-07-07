package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class OrderItem extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "ITEM_ID")
    private Item items;

    private int orderPrice;
    private int count;

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setItems(Item items) {
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public Item getItems() {
        return items;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getId() {
        return id;
    }


    public int getOrderPrice() {
        return orderPrice;
    }

    public int getCount() {
        return count;
    }
}
