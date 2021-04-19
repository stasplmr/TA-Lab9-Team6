package com.company;

import java.util.ArrayList;

public class Task1 implements DynamicProgramming {

    private ArrayList<Gift> gifts;
    private ArrayList<Gift> cheapestGifts;
    private int amount;
    private int[] denominations = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500};

    public Task1(ArrayList<Gift> gifts, int amount) {
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

    private void check(ArrayList<Gift> items) {
        if (cheapestGifts == null) {
            if (items.size() == amount) {
                cheapestGifts = items;
            }
        } else {
            if (items.size() == amount && getSum(items) < getSum(cheapestGifts)) {
                cheapestGifts = items;
            }
        }
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

    private int min() {
        int sum = getSum(getCheapestGifts());
        int temp[] = new int[sum + 1];
        temp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            temp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= sum; i++)
        {
            for (int denomination : denominations) {
                if (denomination <= i) {
                    int result = temp[i - denomination];
                    if (result != Integer.MAX_VALUE && result + 1 < temp[i]) {
                        temp[i] = result + 1;
                    }
                }
            }
        }
        return temp[sum];
    }

    public void solve() {
        try {
            System.out.println("     TASK - 1 - Dynamic Programming    ");
            solution(gifts);
            System.out.println("Minimum amount of bills: " + min());
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

    private ArrayList<Gift> getCheapestGifts() {
        return cheapestGifts;
    }
}