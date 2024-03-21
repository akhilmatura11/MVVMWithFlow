package com.mvvm.flows.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvm.flows.data.NamesRepository
import com.mvvm.flows.data.names.Names
import com.mvvm.flows.ui.NamesListAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    repository: NamesRepository
) : ViewModel() {
    val adapter: NamesListAdapter = NamesListAdapter()
    private var _names = MutableLiveData<List<Names>>()
    val names: LiveData<List<Names>> = _names

    init {
        viewModelScope.launch {
            repository.fetchNames()
                .catch {

                }
                .collect {
                    _names.value = it
                }
        }
    }

    fun updateNamesList(list: List<Names>) {
        adapter.updateList(list)
    }
}