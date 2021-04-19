package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task1Greedy implements GreedyAlgorithm {

    private ArrayList<Gift> gifts;
    private ArrayList<Gift> cheapestGifts = new ArrayList<Gift>();
    private int amount;
    private int[] denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500};

    public Task1Greedy(ArrayList<Gift> gifts, int amount) {
        this.gifts = (ArrayList<Gift>) gifts.clone();
        this.amount = amount;
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 5 || gift.getQuality() >= 7);
    }

    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void solution(ArrayList<Gift> items) {
        removeExcess(items);
        Collections.sort(gifts, new Comparator<Gift>() {
            @Override
            public int compare(Gift gift1, Gift gift2) {
                return gift1.getPrice() - gift2.getPrice();
            }
        });

        for (int i = 0; i < amount; i++) {
            cheapestGifts.add(items.get(i));
        }
    }

    private int min() {
        int sum = getSum(cheapestGifts);
        int result = 0;
        int temp = 0;
        for (int i = denominations.length-1; i >= 0; i--) {
            temp = sum / denominations[i];
            result += temp;
            sum -= temp * denominations[i];
        }
        return result;
    }

    public void solve() {
        try {
            System.out.println("     TASK - 1 - Greedy Algorithm    ");
            solution(gifts);
            int amount = min();
            System.out.println("Minimum amount of bills: " + amount);
            System.out.println("Total sum: " + getSum(getCheapestGifts()));
            System.out.println("===== LIST OF GIFTS: =====");
            for (Gift gift : getCheapestGifts()) {
                System.out.println(gift);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println("ERROR: The number of gifts is too large: " + amount);
        }
    }

    public ArrayList<Gift> getCheapestGifts() {
        return cheapestGifts;
    }
}