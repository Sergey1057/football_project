package ru.sergey1057.scorers

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
import ru.sergey1057.scorers.di.ScorersComponent
import ru.sergey1057.scorers.view.ScorersAdapter
import ru.sergey1057.scorers.viewmodel.ScorersViewModel
import ru.sergey1057.scorers.viewmodel.ServerError
import ru.sergey1057.scorers.viewmodel.Success
import javax.inject.Inject


class ScorersFragment : Fragment() {

    companion object {

        fun newInstance() = ScorersFragment()
    }

    private val scorersAdapter = ScorersAdapter()

    private lateinit var viewModel: ScorersViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ScorersComponent.create((requireActivity().application as AppWithFacade).getFacade())
            .inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ScorersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_scorers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.packetLiveData.observe(viewLifecycleOwner){
                result ->
            when (result) {
                is Success -> {
                    scorersAdapter.specificationsList.addAll(result.scorers)
                    scorersAdapter.notifyDataSetChanged()
                }
                is Error -> Toast.makeText(context, result.message, Toast.LENGTH_LONG).show()
                ServerError -> Snackbar.make(view, "Network error", 1000).show()
            }
        }

        val habitsListRecycler: RecyclerView = view.findViewById(R.id.scorersRecycler)

        habitsListRecycler.adapter = scorersAdapter

    }

}