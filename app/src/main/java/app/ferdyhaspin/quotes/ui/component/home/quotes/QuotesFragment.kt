package app.ferdyhaspin.quotes.ui.component.home.quotes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.ui.ViewModelFactory
import app.ferdyhaspin.quotes.ui.base.BaseFragment
import app.ferdyhaspin.quotes.utils.hide
import app.ferdyhaspin.quotes.utils.observe
import app.ferdyhaspin.quotes.utils.show
import app.ferdyhaspin.quotes.utils.toast
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_quotes.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class QuotesFragment : BaseFragment(), QuoteListener {

    @Inject
    lateinit var viewModel: QuotesViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(QuotesViewModel::class.java)
        viewModel.listener = this
        viewModel.getQuotes()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }

    override fun observeViewModel() {
        observe(viewModel.quotes, ::initRecyclerView)
    }

    private fun List<Quote>.toQuoteItem(): List<QuoteItem> {
        return map {
            QuoteItem(it)
        }
    }

    private fun initRecyclerView(list: List<Quote>) {
        val listItem = list.toQuoteItem()
        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(listItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    (layoutManager as LinearLayoutManager).orientation
                )
            )
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun showProgress(show: Boolean) {
        if (show)
            progress_bar.show()
        else
            progress_bar.hide()
    }

    override fun onFailure(message: String) {
        requireContext().toast(message)
    }
}
