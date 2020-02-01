/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 5:20 PM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:27 AM
 */

package app.ferdyhaspin.quotes.di.module.builder

import app.ferdyhaspin.quotes.ui.component.home.profile.ProfileFragment
import app.ferdyhaspin.quotes.ui.component.home.quotes.QuotesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentModuleBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeQuoteFragment(): QuotesFragment
}