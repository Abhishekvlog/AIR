package com.dexter.air.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dexter.air.model.local.DAO
import com.dexter.air.model.local.SessionEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val dao: DAO) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            dao.addData(SessionEntity(1,5))
            dao.addData(SessionEntity(2,9))
            dao.addData(SessionEntity(3,12))
            dao.addData(SessionEntity(4,6))
            dao.addData(SessionEntity(5,5))
            dao.addData(SessionEntity(6,11))
            dao.addData(SessionEntity(7,8))
            dao.addData(SessionEntity(8,5))
            dao.addData(SessionEntity(9,0))
            dao.addData(SessionEntity(10,15))
            dao.addData(SessionEntity(11,11))
            dao.addData(SessionEntity(12,3))
            dao.addData(SessionEntity(13,8))
            dao.addData(SessionEntity(14,2))
            dao.addData(SessionEntity(15,8))
            dao.addData(SessionEntity(16,3))
            dao.addData(SessionEntity(17,18))
            dao.addData(SessionEntity(18,6))
            dao.addData(SessionEntity(19,3))
            dao.addData(SessionEntity(20,15))
            dao.addData(SessionEntity(21,7))
            dao.addData(SessionEntity(22,1))
            dao.addData(SessionEntity(23,3))
            dao.addData(SessionEntity(24,8))
            dao.addData(SessionEntity(25,13))
            dao.addData(SessionEntity(26,7))
            dao.addData(SessionEntity(27,5))
            dao.addData(SessionEntity(28,4))
            dao.addData(SessionEntity(29,12))
            dao.addData(SessionEntity(30,9))
            dao.addData(SessionEntity(31,8))
        }
    }

     var data=MutableLiveData<List<SessionEntity>>()
    var list=data as LiveData<List<SessionEntity>>
    fun getData(days:Int=7){
        CoroutineScope(Dispatchers.IO).launch {
            list=dao.getData(days)
        }
    }

}

class MainViewModelFactory(val dao: DAO) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(dao) as T
    }


}