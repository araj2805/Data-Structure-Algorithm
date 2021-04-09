package Sorting;

import java.util.Scanner;

public class PizzaConfusion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int max = -1;
        String name = "";

        for (int i = 0; i < n; i++) {
            String na = sc.next();
            int rating = sc.nextInt();

            if (rating > max) {
                max = rating;
                name = na;
            } else if (rating == max) {
                if (na.compareTo(name) < 0)
                    name = na;
            }
        }


        System.out.println(name);

    }
}


