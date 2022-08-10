package com.example.primenumberapplication.util

import java.lang.Math.sqrt

object MathUtils {
    fun isPrime(num: Int): Boolean {
        if (num <= 1) {
            return false
        }
        var i = 2
        while (i <= sqrt(num.toDouble())) {
            if (num % i == 0) {
                return false
            }
            i++
        }
        return true
    }
}