package app.ferdyhaspin.quotes.ui.component.home.quotes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.data.network.NetworkConnectionInterceptor
import app.ferdyhaspin.quotes.data.network.Service
import app.ferdyhaspin.quotes.data.preferences.PreferenceProvider
import app.ferdyhaspin.quotes.data.repositories.QuoteRepository
import app.ferdyhaspin.quotes.ui.ViewModelFactoryOld
import app.ferdyhaspin.quotes.utils.Coroutines
import app.ferdyhaspin.quotes.utils.hide
import app.ferdyhaspin.quotes.utils.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_quotes.*

/**
 * A simple [Fragment] subclass.
 */
class QuotesFragment : Fragment() {

    private lateinit var viewModel: QuotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quotes, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val interceptor = NetworkConnectionInterceptor(requireContext())
        val service = Service(interceptor)
        val db = AppDatabase(requireContext())
        val preferenceProvider = PreferenceProvider(requireContext())
        val repository = QuoteRepository(service, db, preferenceProvider)
        val factory = ViewModelFactoryOld(QuotesViewModel(repository))

        viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = Coroutines.main {
        progress_bar.show()
        viewModel.quotes.await().observe(this, Observer {
            progress_bar.hide()
            initRecyclerView(it.toQuoteItem())
        })
    }

    private fun initRecyclerView(list: List<QuoteItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(list)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun List<Quote>.toQuoteItem(): List<QuoteItem> {
        return map {
            QuoteItem(it)
        }
    }

}
