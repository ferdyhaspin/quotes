/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 10:14 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:14 AM
 */

package app.ferdyhaspin.quotes.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun initializeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initializeViewModel()
        observeViewModel()
    }

    abstract fun observeViewModel()
}