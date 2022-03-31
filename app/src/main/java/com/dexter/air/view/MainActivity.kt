package com.dexter.air.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dexter.air.R
import com.dexter.air.model.local.DAO
import com.dexter.air.model.local.SessionDatabase
import com.dexter.air.model.local.SessionEntity
import com.dexter.air.viewModel.MainViewModel
import com.dexter.air.viewModel.MainViewModelFactory
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var sessionDao: DAO
    lateinit var mainViewModel: MainViewModel
    lateinit var list: List<SessionEntity>

    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sessionDao = SessionDatabase.getSessionDatabase(this).getSessionDAO()

        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(sessionDao))[MainViewModel::class.java]

        val popupDays = PopupMenu(this, btn_last_days)
        popupDays.menuInflater.inflate(R.menu.days_menu, popupDays.menu)
        mainViewModel.getData()
        popupDays.setOnMenuItemClickListener { MenuItem ->
            val id = MenuItem.itemId
            if (id == R.id.days7) {
                btn_last_days.text = "last 7 days    "
                mainViewModel.getData(7)
            } else if (id == R.id.days14) {
                btn_last_days.text = "last 14 days   "
                mainViewModel.getData(14)
            } else if (id == R.id.days30) {
                btn_last_days.text = "last 30 days   "
                mainViewModel.getData(30)
            } else if (id == R.id.custom) {
                btn_last_days.text = "Custom data range   "
                mainViewModel.getData()
            }
            false
        }


        btn_last_days.setOnClickListener {
            popupDays.show()
        }
        mainViewModel.list.observe(this, Observer {
            list = it!!

        })
        card_view.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.frame_layout, DetailFragment())
                .addToBackStack("frag").commit()
        }
    }
}