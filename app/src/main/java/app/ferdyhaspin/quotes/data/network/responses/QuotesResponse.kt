/*
 * Created by ferdyhaspin on 1/23/20 6:06 PM
 */

package app.ferdyhaspin.quotes.data.network.responses

import app.ferdyhaspin.quotes.data.db.entities.Quote

data class QuotesResponse(
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)