package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList gifts = new ArrayList();
        gifts.add(new Gift(5, 5000));
        gifts.add(new Gift(6, 9000));
        gifts.add(new Gift(6, 3048));
        gifts.add(new Gift(5, 2670));
        gifts.add(new Gift(6, 1500));
        gifts.add(new Gift(7, 7599));
        gifts.add(new Gift(7, 4500));
        gifts.add(new Gift(8, 9999));
        gifts.add(new Gift(7, 1234));
        gifts.add(new Gift(9, 2222));
        gifts.add(new Gift(9, 333));
        gifts.add(new Gift(10, 11));
        gifts.add(new Gift(10, 8500));

        Task1 task1 = new Task1(gifts, 2);
        task1.solve();

        Task2 task2 = new Task2(gifts, 5000);
        task2.solve();

        Task3 task3 = new Task3(gifts, 2);
        task3.solve();

        Task1Greedy tg1 = new Task1Greedy(gifts, 2);
        tg1.solve();

        Task2Greedy tg2 = new Task2Greedy(gifts, 5000);
        tg2.solve();

        Task3Greedy tg3 = new Task3Greedy(gifts, 2);
        tg3.solve();
    }
}
