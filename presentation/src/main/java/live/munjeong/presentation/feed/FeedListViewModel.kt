package live.munjeong.presentation.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import live.munjeong.domain.usecase.GetFeedListUseCase
import javax.inject.Inject

@HiltViewModel
class FeedListViewModel @Inject constructor(private val getFeedList: GetFeedListUseCase) :
    ViewModel() {
    init {
        viewModelScope.launch {
            getFeedList("")
        }
    }
}