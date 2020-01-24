/*
 * Created by ferdyhaspin on 1/23/20 5:58 PM
 */

package app.ferdyhaspin.quotes.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.data.network.SafeApiRequest
import app.ferdyhaspin.quotes.data.network.Service
import app.ferdyhaspin.quotes.data.preferences.PreferenceProvider
import app.ferdyhaspin.quotes.utils.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

private const val MINIMUM_INTERVAL = 6

class QuoteRepository(
    private val api: Service,
    private val db: AppDatabase,
    private val prefs: PreferenceProvider
) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes() : LiveData<List<Quote>> {
        return withContext(Dispatchers.IO){
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        val lastSavedAt = prefs.getLastSavedAt()

        if (lastSavedAt == null || isFetchNeeded(LocalDateTime.parse(lastSavedAt))) {
            try {
                val response = apiRequest { api.getQuotes() }
                quotes.postValue(response.quotes)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun isFetchNeeded(savedAt: LocalDateTime): Boolean {
        return ChronoUnit.HOURS.between(savedAt, LocalDateTime.now()) > MINIMUM_INTERVAL
    }

    private fun saveQuotes(quotes: List<Quote>) {
        Coroutines.io {
            prefs.saveLastSavedAt(LocalDateTime.now().toString())
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}