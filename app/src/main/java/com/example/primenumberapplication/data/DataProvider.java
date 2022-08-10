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
        for (int i = pageStartIndex; i <= size; i++) {
            int counter = 0;
            for (int j = 0; j <= i; j++) {
                if(MathUtils.INSTANCE.isPrime(j)){
                    counter ++;
                }
            }
            items.add(new PrimeNumberItem(i, counter));
        }
        setPrimeNumberItemList(items);
    }
}
