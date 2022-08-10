package com.example.primenumberapplication.data;

import com.example.primenumberapplication.util.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    List<PrimeNumberItem> primeNumberItemList;

    public DataProvider(){}


    public List<PrimeNumberItem> getPrimeNumberItemList() {
        return primeNumberItemList;
    }

    public void setPrimeNumberItemList(List<PrimeNumberItem> primeNumberItemList) {
        this.primeNumberItemList = primeNumberItemList;
    }

    public void buildPrimeNumbersDataSource(int pageStartIndex, int size){
        List<PrimeNumberItem> items = new ArrayList<>();
        if(pageStartIndex == 2){
            items.add(new PrimeNumberItem(0, 0));
            items.add(new PrimeNumberItem(1, 0));
        }

        for (int i = pageStartIndex; i <= size; i++) {
            int primeNumberCounter = sieveEratosthenes(i);
            items.add(new PrimeNumberItem(i, primeNumberCounter));
        }
        setPrimeNumberItemList(items);
    }

    private int sieveEratosthenes(int n){

        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }


        for (int j = 2; j <= n; j++) {
            if(MathUtils.INSTANCE.isPrime(j)){

            }
        }
        return 0;
    }


}
