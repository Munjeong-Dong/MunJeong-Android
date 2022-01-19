package live.munjeong.presentation.feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import live.munjeong.domain.model.Feed
import live.munjeong.domain.usecase.GetFeedListFlowUseCase
import live.munjeong.domain.usecase.GetFeedListUseCase
import javax.inject.Inject

@HiltViewModel
class FeedListViewModel @Inject constructor(private val getFeedList: GetFeedListFlowUseCase) :
    ViewModel() {

    private val _viewState = MutableStateFlow<ViewState>(ViewState.Loading)
    val viewState: Flow<ViewState> = _viewState

    sealed class ViewState {
        class Data(val data: List<Feed>) : ViewState()
        class Error(val err: Throwable) : ViewState()
        object Loading : ViewState()
    }


    init {
        observe("123")
    }


    private fun observe(memberId: String) {
        viewModelScope.launch {
            launch {
                val result = runCatching { getFeedList(memberId) }
                with(result) {
                    onFailure {
                        _viewState.value = ViewState.Error(it)
                    }
                }
            }

            getFeedList(memberId)
                .map { ViewState.Data(it) }
                .collect {
                    _viewState.value = it
                }
        }
    }
}