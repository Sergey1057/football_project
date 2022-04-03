package ru.sergey1057.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import ru.sergey1057.core_api.mediator.AppWithFacade
import ru.sergey1057.home.di.HomeComponent
import ru.sergey1057.home.view.MainListAdapter
import ru.sergey1057.home.viewmodel.HomeViewModel
import ru.sergey1057.home.viewmodel.ServerError
import ru.sergey1057.home.viewmodel.Success
import javax.inject.Inject


class HomeFragment : Fragment() {

    companion object {

        fun newInstance() = HomeFragment()
    }

    private val mainListAdapter = MainListAdapter()

    private lateinit var viewModel: HomeViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.packetLiveData.observe(viewLifecycleOwner){
                result ->
            when (result) {
                is Success -> {
                    mainListAdapter.specificationsList.addAll(result.teamModels)
                    mainListAdapter.notifyDataSetChanged()
                }
                is Error -> Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                ServerError -> Snackbar.make(view, "Network error", 1000).show()
            }
        }

        val habitsListRecycler: RecyclerView = view.findViewById(R.id.habitsListRecycler)

        habitsListRecycler.adapter = mainListAdapter

    }

}