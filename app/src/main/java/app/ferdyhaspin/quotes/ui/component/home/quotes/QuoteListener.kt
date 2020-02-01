/*
 * Created by Ferdi Haspi Nur Imanulloh on 2/1/20 7:06 PM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:46 AM
 */

package app.ferdyhaspin.quotes.ui.component.home.quotes

interface QuoteListener {
    fun showProgress(show: Boolean)
    fun onFailure(message: String)
}