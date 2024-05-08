package dev.ivan_belyaev.all_products_api.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ivan_belyaev.all_products.databinding.FragmentAllProductsBinding
import dev.ivan_belyaev.all_products_api.di.AllProductsComponent
import dev.ivan_belyaev.all_products_api.presentation.adapter.AllProductModel
import dev.ivan_belyaev.all_products_api.presentation.adapter.AllProductsListAdapter
import dev.ivan_belyaev.all_products_api.presentation.model.AllProductsUiModel
import dev.ivan_belyaev.all_products_api.presentation.viewmodel.AllProductsViewModel
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment

class AllProductsFragment :
    BaseFragment<AllProductsViewModel, FragmentAllProductsBinding>(
        FragmentAllProductsBinding::inflate
    ) {

    override val viewModel: AllProductsViewModel by viewModels { viewModelFactory }

    private lateinit var adapter: AllProductsListAdapter
    private var list: List<AllProductModel> = emptyList()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        viewModel.state.observe { productsState ->
            renderAllProductsState(productsState)
        }
    }

    private fun renderAllProductsState(productsState: AllProductsUiModel) {
        binding.recyclerViewProducts.visibility = productsState.rootLayoutVisibility
        binding.downloadView.progressBar.visibility = productsState.downloadLayoutVisibility
        binding.downloadView.internetTextView.visibility = productsState.downloadLayoutVisibility

        val arrayList = ArrayList<AllProductModel>()
        for (i in 0..productsState.products.lastIndex) {
            arrayList.add(
                AllProductModel(
                    id = productsState.products[i].id,
                    title = productsState.products[i].title,
                    price = productsState.products[i].price,
                    thumbnail = productsState.products[i].thumbnail,
                    discountPercentage = productsState.products[i].discountPercentage,
                    rating = productsState.products[i].rating,
                    stock = productsState.products[i].stock,
                    description = productsState.products[i].description,
                    brand = productsState.products[i].brand,
                    category = productsState.products[i].category,
                    image = productsState.products[i].images,
                )
            )
        }
        list = list + arrayList
        adapter.submitList(list)
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        binding.recyclerViewProducts.layoutManager = linearLayoutManager
        adapter = AllProductsListAdapter(viewModel)
        binding.recyclerViewProducts.adapter = adapter
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        AllProductsComponent.init(applicationProvider)
            .inject(this)
    }
}