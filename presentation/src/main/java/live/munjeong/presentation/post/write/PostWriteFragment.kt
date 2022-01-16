package live.munjeong.presentation.post.write

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import live.munjeong.presentation.R

class PostWriteFragment : Fragment() {

    companion object {
        fun newInstance() = PostWriteFragment()
    }

    private lateinit var viewModel: PostWriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.post_write_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PostWriteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}