package app.ferdyhaspin.quotes

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDexApplication
import app.ferdyhaspin.quotes.di.component.AppComponent
import app.ferdyhaspin.quotes.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class App : MultiDexApplication(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()

    }

    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

    companion object {
        lateinit var context: Context
    }
}