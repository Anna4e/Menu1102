package annaMenu;

import javax.persistence.*;

@Entity

@Table(name = "Menu")


public class Meals {
    @Id

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    private double price;

    @Column(name = "discount", nullable = false)
    private boolean discount;

    public Meals() {
    }

    public Meals(String name, double weight, double price, boolean discount) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.discount = discount;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "[ name = " + name + ", w = " + weight +
                ", price = " + price + ", discount = " + discount + "]";
    }
}

