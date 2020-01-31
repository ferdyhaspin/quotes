/*
 * Created by Ferdi Haspi Nur Imanulloh on 1/30/20 10:00 AM
 *
 * Instagram : https://www.instagram.com/ferdyhaspin
 * LinkedIn : https://www.linkedin.com/in/ferdyhaspin
 * Github : https://www.github.com/ferdyhaspin
 *
 * Email : ferdihaspin@gmail.com
 *
 * Last modified 1/30/20 10:00 AM
 */

package app.ferdyhaspin.quotes.di.module

import android.content.Context
import app.ferdyhaspin.quotes.App
import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.network.NetworkConnectionInterceptor
import app.ferdyhaspin.quotes.data.network.Service
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return App.context
    }

    @Provides
    @Singleton
    fun provideNetworkConnectionInterceptor(): NetworkConnectionInterceptor {
        return NetworkConnectionInterceptor(provideContext())
    }

    @Provides
    @Singleton
    fun provideService(): Service {
        return Service(provideNetworkConnectionInterceptor())
    }

    @Provides
    @Singleton
    fun provideAppDatabase(): AppDatabase {
        return AppDatabase(provideContext())
    }
}