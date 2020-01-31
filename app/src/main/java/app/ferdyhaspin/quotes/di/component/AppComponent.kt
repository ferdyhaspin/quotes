/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/31/20 10:47 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/31/20 10:46 AM
 */

package app.ferdyhaspin.quotes.di.component

import app.ferdyhaspin.quotes.App
import app.ferdyhaspin.quotes.di.module.AppModule
import app.ferdyhaspin.quotes.di.module.DataModule
import app.ferdyhaspin.quotes.di.module.ViewModelModule
import app.ferdyhaspin.quotes.di.module.builder.ActivityModuleBuilder
import app.ferdyhaspin.quotes.di.module.builder.FragmentModuleBuilder
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActivityModuleBuilder::class,
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ViewModelModule::class,
        FragmentModuleBuilder::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }

    fun inject(app: App)
}