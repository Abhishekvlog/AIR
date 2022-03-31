package com.dexter.air.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dexter.air.R
import com.dexter.air.model.local.SessionDatabase
import com.dexter.air.model.local.SessionEntity
import com.dexter.air.viewModel.MainViewModel
import com.dexter.air.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment(R.layout.fragment_detail) {
    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sessionDAO = SessionDatabase.getSessionDatabase(requireContext()).getSessionDAO()
        mainViewModel = ViewModelProvider(requireActivity(), MainViewModelFactory(sessionDAO))[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.list.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "${it.size}", Toast.LENGTH_SHORT).show()
            number_of_days.text = "Practice session for last ${it.size} days"
            setAdapter(it)
        })

    }

    private fun setAdapter(it: List<SessionEntity>?) {
        recyclerView_detail.adapter = DetailAdapter(it as ArrayList<SessionEntity>)
        recyclerView_detail.layoutManager = LinearLayoutManager(requireContext())
    }


}