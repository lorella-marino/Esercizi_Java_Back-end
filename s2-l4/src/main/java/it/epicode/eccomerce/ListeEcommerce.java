package it.epicode.eccomerce;

import lombok.Data;

import java.util.List;

@Data
public class ListeEcommerce {

    public static List<Product> getProducts() {
        return List.of(
                new Product(1, "Product 1", "Books", 120.0),
                new Product(2, "Product 2", "Baby", 10.0),
                new Product(3, "Product 3", "Books", 150.0),
                new Product(4, "Product 4", "Boys", 20.0),
                new Product(5, "Product 5", "Books", 180.0),
                new Product(6, "Product 6", "Baby", 30.0),
                new Product(7, "Product 7", "Boys", 40.0)
        );
    }

    public static List<Customer> getCustomers() {
        return List.of(
                new Customer(1, "Customer 1", 1),
                new Customer(2, "Customer 2", 2),
                new Customer(3, "Customer 3", 3),
                new Customer(4, "Customer 4", 2),
                new Customer(5, "Customer 5", 1),
                new Customer(6, "Customer 6", 3),
                new Customer(7, "Customer 7", 2)
        );
    }

    public static List<Order> getOrders () {
        return List.of(
                new Order(1, "Shipped", "2021-01-01", "2021-01-05", getCustomers().get(0), List.of(getProducts().get(2), getProducts().get(1))),
                new Order(2, "Delivered", "2021-03-02", "2021-03-06", getCustomers().get(1), List.of(getProducts().get(2), getProducts().get(3))),
                new Order(3, "Pending", "2021-02-03", "2021-02-07", getCustomers().get(2), List.of(getProducts().get(4))),
                new Order(4, "Shipped", "2021-01-04", "2021-01-08", getCustomers().get(3), List.of(getProducts().get(5), getProducts().get(1), getProducts().get(2))),
                new Order(5, "Delivered", "2021-04-05", "2021-04-09", getCustomers().get(4), List.of(getProducts().get(3), getProducts().get(6))),
                new Order(6, "Pending", "2021-02-06", "2021-02-10", getCustomers().get(5), List.of(getProducts().get(6), getProducts().get(2), getProducts().get(4))),
                new Order(7, "Shipped", "2021-03-07", "2021-03-11", getCustomers().get(6), List.of(getProducts().get(5), getProducts().get(3)))
        );
    }
}

