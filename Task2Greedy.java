package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task2Greedy implements GreedyAlgorithm {
    private ArrayList<Gift> bestGifts = new ArrayList<Gift>();
    private ArrayList<Gift> gifts;
    private int amount;

    public Task2Greedy(ArrayList<Gift> gifts, int amount) {
        this.gifts = (ArrayList<Gift>) gifts.clone();
        if (amount >= 100 & amount < 50000) {
            this.amount = amount;
        } else {
            throw new IllegalArgumentException("100 ≤ Amount < 50000");
        }
    }
    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 7 || gift.getQuality() >= 9);
    }

    private void solution() {
        removeExcess(gifts);
        Collections.sort(gifts, new Comparator<Gift>() {
            @Override
            public int compare(Gift gift1, Gift gift2) {
                return gift1.getPrice()/gift1.getQuality() - gift2.getPrice()/gift2.getQuality();
            }
        });

        for (Gift gift: gifts) {
            int sum = getSum(bestGifts);
            if (sum + gift.getPrice() < amount) {
                bestGifts.add(gift);
            }
        }
    }

    public void solve() {
        solution();
        System.out.println("     TASK - 2 - Greedy Algorithm    ");
        System.out.println("Maximum amount of gifts: " + getBestGifts().size());
        System.out.println("Total sum: " + getSum(getBestGifts()));
        System.out.println("===== List of gifts: =====");
        for (Gift gift: getBestGifts()) {
            System.out.println(gift);
        }
        System.out.println();
    }

    public ArrayList<Gift> getBestGifts() {
        return bestGifts;
    }
}