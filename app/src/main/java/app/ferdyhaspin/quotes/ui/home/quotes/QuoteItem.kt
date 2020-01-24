package app.ferdyhaspin.quotes.ui.home.quotes

import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}