package com.example.primenumberapplication

import com.example.primenumberapplication.data.DataProvider
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class DataProviderTest {

    private lateinit var dataProvider: DataProvider

    @Before
    fun setup(){
        dataProvider = DataProvider()
    }

    // method name , scenario , expected behavior

    @Test
    fun countPrimeNumbers_CheckPrimeNumbersOf100_ShouldReturn25(){
        val n = 100
        val numberOfPrimeNumbers = dataProvider.sieveEratosthenes(n)
        Assert.assertTrue(numberOfPrimeNumbers == 25)
    }

    @Test
    fun countPrimeNumbers_CheckPrimeNumbersOf10_ShouldReturn4(){
        val n = 10
        val numberOfPrimeNumbers = dataProvider.sieveEratosthenes(n)
        Assert.assertTrue(numberOfPrimeNumbers == 4)
    }

    @Test
    fun countPrimeNumbers_CheckPrimeNumbersOf23_ShouldReturn9(){
        val n = 23
        val numberOfPrimeNumbers = dataProvider.sieveEratosthenes(n)
        Assert.assertTrue(numberOfPrimeNumbers == 9)
    }

    @Test
    fun countPrimeNumbers_CheckPrimeNumbersOf351_ShouldReturn70(){
        val n = 351
        val numberOfPrimeNumbers = dataProvider.sieveEratosthenes(n)
        Assert.assertTrue(numberOfPrimeNumbers == 70)
    }
}