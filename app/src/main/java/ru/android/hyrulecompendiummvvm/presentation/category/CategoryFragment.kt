package ru.android.hyrulecompendiummvvm.presentation.category

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_category.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.android.hyrulecompendiummvvm.R
import ru.android.hyrulecompendiummvvm.base.ItemDecoration
import ru.android.hyrulecompendiummvvm.databinding.FragmentCategoryBinding
import ru.android.hyrulecompendiummvvm.presentation.state.CategoryVS


class CategoryFragment : Fragment() {

    private val viewModel: CategoryViewModel by viewModel()

    private val hyruleAdapter = CategoryAdapter()

    private val navArgs by navArgs<CategoryFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentCategoryBinding>(
            inflater,
            R.layout.fragment_category,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeViewModel()
    }

    private fun initView() {
        viewModel.getCategory(navArgs.category)
        with(recyclerView) {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = hyruleAdapter
            addItemDecoration(
                ItemDecoration(
                    2,
                    16
                )
            )
        }
        buttonBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    private fun observeViewModel() {
        viewModel.viewCategoryState.observe(viewLifecycleOwner, {
            when (it) {
                is CategoryVS.AddCategory -> {
                    it.categoryVM.data?.let { data -> hyruleAdapter.add(data) }
                }
                is CategoryVS.ShowLoader -> {
                    if (it.showLoader) {
                        pbPost.visibility = View.VISIBLE
                        recyclerView.visibility = View.INVISIBLE
                    } else {
                        pbPost.visibility = View.INVISIBLE
                        recyclerView.visibility = View.VISIBLE
                    }
                    Log.i("ShowLoader", it.showLoader.toString())
                }
                is CategoryVS.Error -> {
                    it.message?.let { message -> Log.i("Error", message) }
                }
            }
        })
    }

}