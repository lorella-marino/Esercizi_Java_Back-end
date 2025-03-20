package it.epicode.eccomerce;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Order {
    private int id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Customer customer;
    private List<Product> products;

    public Order (int id, String status, String orderDate, String deliveryDate, Customer customer, List<Product> products) {
        this.id = id;
        this.status = status;
        this.orderDate = LocalDate.parse(orderDate);
        this.deliveryDate = LocalDate.parse(deliveryDate);
        this.customer = customer;
        this.products = products;
    }

    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}
