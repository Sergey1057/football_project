package ru.sergey1057.world

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
import ru.sergey1057.world.di.WorldComponent
import ru.sergey1057.world.view.WorldAdapter
import ru.sergey1057.world.viewmodel.ServerError
import ru.sergey1057.world.viewmodel.Success
import ru.sergey1057.world.viewmodel.WorldViewModel
import javax.inject.Inject


class WorldFragment : Fragment() {

    companion object {

        fun newInstance() = WorldFragment()
    }

    private val worldAdapter = WorldAdapter()

    private lateinit var viewModel: WorldViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WorldComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(WorldViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_world, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.packetLiveData.observe(viewLifecycleOwner){
                result ->
            when (result) {
                is Success -> {
                    worldAdapter.worldList.addAll(result.chempions)
                    worldAdapter.notifyDataSetChanged()
                }
                is Error -> Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                ServerError -> Snackbar.make(view, "Network error", 1000).show()
            }
        }

        val habitsListRecycler: RecyclerView = view.findViewById(R.id.worldRecycler)

        habitsListRecycler.adapter = worldAdapter

    }

}