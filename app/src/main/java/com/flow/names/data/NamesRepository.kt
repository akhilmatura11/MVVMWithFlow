package com.flow.names.data

import com.flow.names.data.localdatasource.LocalDataSource
import com.flow.names.data.remotedatasource.RemoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NamesRepository @Inject constructor(private val localDataSource: LocalDataSource) {

    fun fetchNames() = flow {
        var names = localDataSource.getNames()
        if (names.isEmpty()) {
            names = RemoteData.fetchNames()
            localDataSource.insertNames(names)
        }
        emit(names)
    }.flowOn(Dispatchers.IO)

}
