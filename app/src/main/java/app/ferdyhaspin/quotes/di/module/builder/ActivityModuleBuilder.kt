/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 10:47 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:47 AM
 */

/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 10:47 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:47 AM
 */

/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/30/20 9:59 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/21/20 4:45 PM
 */
package app.ferdyhaspin.quotes.di.module.builder

import app.ferdyhaspin.quotes.ui.component.auth.LoginActivity
import app.ferdyhaspin.quotes.ui.component.auth.SignUpActivity
import app.ferdyhaspin.quotes.ui.component.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class ActivityModuleBuilder {
    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeSignActivity(): SignUpActivity

    @ContributesAndroidInjector
    abstract fun contributeHomeActivity(): HomeActivity
}
