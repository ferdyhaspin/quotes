/*
 * Created by ferdyhaspin on 1/23/20 6:11 PM
 */

package app.ferdyhaspin.quotes.ui.component.home.quotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.data.repositories.QuoteRepository
import app.ferdyhaspin.quotes.utils.ApiException
import app.ferdyhaspin.quotes.utils.Coroutines
import app.ferdyhaspin.quotes.utils.NoInternetException
import javax.inject.Inject

class QuotesViewModel @Inject
constructor(private val repository: QuoteRepository) : ViewModel() {

    var listener: QuoteListener? = null
    val quotes = MutableLiveData<List<Quote>>()

    fun getQuotes() {
        Coroutines.main {
            try {
                listener?.showProgress(true)
                val response = repository.getQuotesNew()
                val listResponse = response.quotes
                if (response.isSuccessful) {
                    quotes.postValue(listResponse)
                    return@main
                }
                listener?.onFailure("Terjadi kesalahan")
            } catch (e: ApiException) {
                listener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                listener?.onFailure(e.message!!)
            } finally {
                listener?.showProgress(false)
            }
        }

    }

}