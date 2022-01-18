package live.munjeong.presentation.feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import live.munjeong.domain.model.Feed
import live.munjeong.domain.usecase.GetFeedListUseCase
import javax.inject.Inject

@HiltViewModel
class FeedListViewModel @Inject constructor(private val getFeedList: GetFeedListUseCase) :
    ViewModel() {

    private val _list = MutableStateFlow(emptyList<Feed>())
    val list: StateFlow<List<Feed>>
        get() = _list


    init {
        viewModelScope.launch {
            getFeedList("").getOrNull()?.let {
                _list.emit(it)
            }
        }
    }
}