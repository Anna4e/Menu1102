package annaMenu;
import javax.management.Query;
import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

import static annaMenu.MenuOptions.em;
import static annaMenu.MenuOptions.emf;


public class Main {

    Scanner scanner = new Scanner(System.in);

    public void main(String[] args) {
        try {


            while (true) {
                System.out.println();
                System.out.println("1. Add new meal");
                System.out.println("2. Select dishes from range of prices");
                System.out.println("3. Select dishes just with discount");
                System.out.println("4. Select set of dishes with weight to 1 kg");


                int sc = Integer.parseInt(scanner.nextLine());
                switch (sc) {
                    case 1:
                        MenuOptions.addMeals();

                        break;
                    case 2:
                        MenuOptions.minMaxPrice();
                        break;
                    case 3:
                        MenuOptions.discountOnly();
                        break;
                    case 4:
                        MenuOptions.sumWeight();
                        break;
                }
            }

        } finally {
            em.close ();
            emf.close ();
            scanner.close();
        }
    }

  }

