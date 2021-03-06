/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 10:59 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/21/20 4:21 PM
 */
package app.ferdyhaspin.quotes.di.module

import androidx.lifecycle.ViewModel
import app.ferdyhaspin.quotes.di.scope.ViewModelKey
import app.ferdyhaspin.quotes.ui.component.auth.AuthViewModel
import app.ferdyhaspin.quotes.ui.component.home.profile.ProfileViewModel
import app.ferdyhaspin.quotes.ui.component.home.quotes.QuotesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    internal abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuotesViewModel::class)
    internal abstract fun bindQuotesViewModel(viewModel: QuotesViewModel): ViewModel
}
