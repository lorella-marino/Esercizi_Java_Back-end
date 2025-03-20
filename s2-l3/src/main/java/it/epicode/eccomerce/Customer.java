package it.epicode.eccomerce;

import lombok.Data;

@Data
public class Customer {
    private int id;
    private String name;
    private int tier;

    public Customer(int id, String name, int tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
