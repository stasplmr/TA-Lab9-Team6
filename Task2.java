package com.company;

import java.util.ArrayList;

public class Task2 implements DynamicProgramming {

    private ArrayList<Gift> bestGifts = null;
    private ArrayList<Gift> gifts;
    private int amount;

    public Task2(ArrayList<Gift> gifts, int amount) {
        this.gifts = (ArrayList<Gift>) gifts.clone();
        this.amount = amount;
    }

    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void check(ArrayList<Gift> items) {
        if (bestGifts == null) {
            if (getSum(items) <= amount) {
                bestGifts = items;
            }
        } else {
            if (getSum(items) <= amount && items.size() > bestGifts.size()) {
                bestGifts = items;
            }
        }
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 7 || gift.getQuality() >= 9);
    }

    private void solution(ArrayList<Gift> items) {
        removeExcess(items);
        if (items.size() > 0) {
            check(items);
        }
        for (int i = 0; i < items.size(); i++) {
            ArrayList<Gift> newList = new ArrayList<Gift>(items);
            newList.remove(i);
            solution(newList);
        }
    }

    public void solve() {
        solution(gifts);
        System.out.println("     TASK - 2 - Dynamic Programming    ");
        System.out.println("Maximum amount of gifts: " + getBestGifts().size());
        System.out.println("Total sum: " + getSum(getBestGifts()));
        System.out.println("===== List of gifts: =====");
        for (Gift gift: getBestGifts()) {
            System.out.println(gift);
        }
        System.out.println();
    }

    private ArrayList<Gift> getBestGifts() {
        return bestGifts;
    }
}