package it.epicode.esercizio4;

import it.epicode.eccomerce.ListeEcommerce;
import it.epicode.eccomerce.Order;

import java.time.LocalDate;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        List<Order> listaTier = ListeEcommerce.getOrders();

        LocalDate startDate = LocalDate.parse("2021-02-01");
        LocalDate endDate = LocalDate.parse("2021-04-01");

        System.out.println("Lista di prodotti, ordinati da clienti con tier=2, tra il 2021-02-01 e il 2021-04-01:");

        listaTier.stream()
                .filter(order -> order.getOrderDate().isAfter(startDate) &&
                        order.getOrderDate().isBefore(endDate) &&
                        order.getCustomer().getTier() == 2)
                .forEach (order -> System.out.println(order.getProducts()));
    }
}
