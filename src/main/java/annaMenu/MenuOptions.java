package annaMenu;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Anna on 11.02.2017.
 */
public class MenuOptions {
    static EntityManagerFactory emf;
    static EntityManager em;
    static Scanner scanner = new Scanner(System.in);
    public static void addMeals() {

            System.out.println ();
            System.out.print ("Enter name: ");
            String name = scanner.nextLine ();
            System.out.print ("Enter price: ");
            double price = Double.parseDouble (scanner.nextLine ());
            System.out.print ("Enter weight: ");
            int weight = Integer.parseInt (scanner.nextLine ());
            System.out.print ("discount(Y/N):");
            boolean isDiscount = false;
            String string = scanner.nextLine ();
            if (string.equals ("Y")) {
                isDiscount = true;
            }
            em.getTransaction ().begin ();
            try {
                Meals meal = new Meals (name, price, weight, isDiscount);
                em.persist (meal);
                em.getTransaction ().commit ();
            } catch (Exception e) {
                em.getTransaction ().rollback ();
            }


    }
    public static void minMaxPrice() {
        System.out.println();
        System.out.print("Enter min price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter max price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());
        List<Meals> result = null;

        TypedQuery<Meals> query = em.createQuery("SELECT m FROM Meals m WHERE m.price BETWEEN :minPrice AND :maxPrice ORDER BY m.price desc", Meals.class);
        query.setParameter("minPrice", minPrice);
        query.setParameter("maxPrice", maxPrice);
        result = query.getResultList();
        for (Meals meal : result) {
            System.out.println(result.toString());
        }

    }

    public static void discountOnly() {
        System.out.println();
        List<Meals> result = null;
        Query query = (Query) em.createQuery("SELECT m FROM Meals m WHERE m.discount=true", Meals.class);
        for (Meals meal : result) {
            System.out.println(meal);
        }
    }

    public static void sumWeight() {
        System.out.println();
        List<Meals> result = null;
        Query query = (Query) em.createQuery("SELECT m FROM Meals m ORDER BY m.weight ASC", Meals.class);
        int sum = 0;
        for (Meals meal : result) {
            if (sum + meal.getWeight() <= 1000) {
                sum += meal.getWeight();
                System.out.println(meal);
            }
        }
    }
}
