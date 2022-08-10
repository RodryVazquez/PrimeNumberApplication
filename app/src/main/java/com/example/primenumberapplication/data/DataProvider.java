package com.example.primenumberapplication.data;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    List<PrimeNumberItem> primeNumberItemList;

    public DataProvider() {

    }

    public List<PrimeNumberItem> getPrimeNumberItemList() {
        return primeNumberItemList;
    }

    public void setPrimeNumberItemList(List<PrimeNumberItem> primeNumberItemList) {
        this.primeNumberItemList = primeNumberItemList;
    }

    public void buildPrimeNumbersDataSource(int pageStartIndex, int size) {
        List<PrimeNumberItem> items = new ArrayList<>();
        if (pageStartIndex == 2) {
            items.add(new PrimeNumberItem(0, 0));
            items.add(new PrimeNumberItem(1, 0));
        }

        for (int i = pageStartIndex; i <= size; i++) {
            int primeNumberCounter = sieveEratosthenes(i);
            items.add(new PrimeNumberItem(i, primeNumberCounter));
        }
        setPrimeNumberItemList(items);
    }

    public int sieveEratosthenes(int n) {
        int primeNumberCounter = 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    prime[j] = false;
                }
            }
        }

        for (int j = 2; j <= n; j++) {
            if (prime[j]) {
                primeNumberCounter++;
            }
        }
        return primeNumberCounter;
    }
}
