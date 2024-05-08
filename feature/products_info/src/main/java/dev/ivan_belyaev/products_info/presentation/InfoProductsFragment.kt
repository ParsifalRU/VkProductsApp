package dev.ivan_belyaev.products_info.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.BaseFragment
import dev.ivan_belyaev.coreui.listeners.setDebouncedClickListener
import dev.ivan_belyaev.products_info.databinding.FragmentInfoProductsBinding
import dev.ivan_belyaev.products_info.di.InfoProductsComponent
import dev.ivan_belyaev.products_info.presentation.adapter.products_images.InfoProductsListAdapter
import dev.ivan_belyaev.products_info.presentation.model.InfoProductsUiModel
import dev.ivan_belyaev.products_info_api.AllProductsMediator
import dev.ivan_belyaev.products_info_api.InfoAboutProductModel

class InfoProductsFragment :
    BaseFragment<InfoProductsViewModel, FragmentInfoProductsBinding>(
        FragmentInfoProductsBinding::inflate
    ) {

    override val viewModel: InfoProductsViewModel by viewModels { viewModelFactory }
    private lateinit var adapter: InfoProductsListAdapter

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        navigateToAllFilmsScreen()
        setRecyclerView()
        viewModel.state.observe { state -> renderState(state) }
    }

    @SuppressLint("SetTextI18n")
    private fun renderState(state: InfoProductsUiModel) {
        with(binding) {
            textViewTitle.text = state.title
            textViewDiscountPercentage.text = "- ${state.discountPercentage} %"
            textViewBrand.text = "Бренд: ${state.brand}"
            textViewCategory.text = "Категория: ${state.category}"
            textViewCost.text = "${state.price} $"
            textViewDescriptionItem.text = state.description
            ratingBar.rating = state.rating.toFloat()
            textViewStock.text = "Осталось: ${state.stock}"

            adapter.submitList(state.image)
        }
    }

    private fun setRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerViewImages.layoutManager = linearLayoutManager
        adapter = InfoProductsListAdapter()
        binding.recyclerViewImages.adapter = adapter
    }

    private fun navigateToAllFilmsScreen() {
        binding.buttonBack.setDebouncedClickListener {
            viewModel.navigateToAllFilmsScreen()
        }
    }

    override fun inject(applicationProvider: ApplicationProvider) {
        InfoProductsComponent.init(
            applicationProvider,
            requireArguments().getSerializable(
                AllProductsMediator.MODEL_ID_EXTRA
            ) as InfoAboutProductModel
        ).inject(this)
    }
}