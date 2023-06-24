package com.kgurgul.cpuinfo.features.applications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.kgurgul.cpuinfo.ui.theme.CpuInfoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewApplicationsFragment : Fragment() {

    private val viewModel: NewApplicationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                CpuInfoTheme {
                    val uiState by viewModel.uiStateFlow.collectAsStateWithLifecycle()
                    ApplicationsScreen(
                        uiState = uiState,
                        onAppClicked = viewModel::onApplicationClicked,
                        onRefreshApplications = viewModel::onRefreshApplications,
                        onSnackbarDismissed = viewModel::onSnackbarDismissed,
                        onCardExpanded = viewModel::onCardExpanded,
                        onCardCollapsed = viewModel::onCardCollapsed,
                        onAppUninstallClicked = viewModel::onAppUninstallClicked,
                        onAppSettingsClicked = viewModel::onAppSettingsClicked,
                    )
                }
            }
        }
    }
}