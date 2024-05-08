package dev.ivan_belyaev.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import dev.ivan_belyaev.core.app.App
import dev.ivan_belyaev.core.app.ApplicationProvider
import dev.ivan_belyaev.core.base.di.ViewModelFactory
import dev.ivan_belyaev.core.navigation.NavigationCommand
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val inflate: (
        LayoutInflater,
        ViewGroup?,
        Boolean
    ) -> VB,
    private val overrideBackButton: Boolean = false
) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract val viewModel: VM

    private var _binding: VB? = null
    val binding get() = requireNotNull(_binding) { "Binding not initialized" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject((requireActivity().application as App).getApplicationProvider())
        _binding = inflate.invoke(
            inflater,
            container,
            false
        )
        return binding.root
    }

    protected abstract fun inject(applicationProvider: ApplicationProvider)

    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) {
        this.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach(action)
            .launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeNavigation()
    }

    private fun observeNavigation() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.navigation.collect { event ->
                event.getContentIfNotHandled()?.let { navigationCommand ->
                    handleNavigation(navigationCommand)
                }
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.ToDirection -> {
                findNavController().navigate(
                    resId = navCommand.navData.resId,
                    args = navCommand.navData.args
                )
            }

            is NavigationCommand.Back -> {
                findNavController().navigateUp()
            }
        }
    }
}