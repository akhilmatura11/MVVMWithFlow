package com.mvvm.flows.data.localdatasource

import com.mvvm.flows.data.names.Names
import com.mvvm.flows.data.names.NamesDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val namesDao: NamesDao) {
    fun getNames() = namesDao.getNames()

    fun insertNames(namesList: List<Names>) = namesDao.insertAll(namesList)
}
