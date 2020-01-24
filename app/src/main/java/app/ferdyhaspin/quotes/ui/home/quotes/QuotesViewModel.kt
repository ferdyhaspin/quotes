/*
 * Created by ferdyhaspin on 1/23/20 6:11 PM
 */

package app.ferdyhaspin.quotes.ui.home.quotes

import androidx.lifecycle.ViewModel
import app.ferdyhaspin.quotes.data.repositories.QuoteRepository
import app.ferdyhaspin.quotes.utils.lazyDeffered

class QuotesViewModel(private val repository: QuoteRepository) : ViewModel() {

    val quotes by lazyDeffered {
        repository.getQuotes()
    }

}