/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 5:03 PM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/14/20 4:42 PM
 */

package app.ferdyhaspin.quotes.ui.base


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment() {

    protected abstract fun initializeViewModel()

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    abstract fun observeViewModel()

}
