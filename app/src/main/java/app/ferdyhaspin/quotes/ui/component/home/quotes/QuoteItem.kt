package app.ferdyhaspin.quotes.ui.component.home.quotes

import app.ferdyhaspin.quotes.App
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.Quote
import app.ferdyhaspin.quotes.databinding.ItemQuoteBinding
import app.ferdyhaspin.quotes.utils.toast
import com.xwray.groupie.Item
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuoteBinding>() {

    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
        viewBinding.quoteItem = quote

        viewBinding.author.setOnClickListener {
            App.context.toast(quote.author)
        }

        viewBinding.root.setOnClickListener {
            App.context.toast(quote.quote)
        }
    }
}