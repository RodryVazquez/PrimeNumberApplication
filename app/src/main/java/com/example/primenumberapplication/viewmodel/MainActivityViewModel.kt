package com.example.primenumberapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.primenumberapplication.data.PrimeNumberItem
import com.example.primenumberapplication.data.DataProvider

class MainActivityViewModel : ViewModel() {

    private val dataProvider =
        DataProvider()

    private val _listPrimeNumbers: MutableLiveData<List<PrimeNumberItem>> = MutableLiveData()
    val listPrimeNumbers: LiveData<List<PrimeNumberItem>>
        get() = _listPrimeNumbers

    fun fetchPrimeNumbers(page: Int, size: Int){
        dataProvider.buildPrimeNumbersDataSource(page, size)
        _listPrimeNumbers.value = dataProvider.primeNumberItemList
    }
}