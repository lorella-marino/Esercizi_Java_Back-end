package it.epicode.esercizio1;

import it.epicode.eccomerce.Customer;
import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Order;
import it.epicode.eccomerce.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<Order> ordini = ListeEcommerce.getOrders();

        // mappa in cui la key è il customer e il value è la lista di ordini
        Map<Customer, List<Order>> listaOrdiniXCliente = ordini.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));

        listaOrdiniXCliente.forEach((customer, orders) -> {
            System.out.println("Cliente: " + customer.getName());
            System.out.println("Ordini: " + orders.stream()
                            .map(Order::getProducts).map(products -> products.stream()
                                    .map(Product::getName)
                                    .collect(Collectors.toList()))
                            .collect(Collectors.toList()));
        });
    }
}
