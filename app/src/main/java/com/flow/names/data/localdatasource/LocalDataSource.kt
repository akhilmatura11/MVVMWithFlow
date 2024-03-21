package com.flow.names.data.localdatasource

import com.flow.names.data.names.Names
import com.flow.names.data.names.NamesDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(private val namesDao: NamesDao) {
    fun getNames() = namesDao.getNames()

    fun insertNames(namesList: List<Names>) = namesDao.insertAll(namesList)
}
