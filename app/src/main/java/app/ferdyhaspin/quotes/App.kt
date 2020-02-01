package app.ferdyhaspin.quotes

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDexApplication
import app.ferdyhaspin.quotes.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

open class App : MultiDexApplication(), HasActivityInjector, HasSupportFragmentInjector{

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        initDagger()

    }

    open fun initDagger() {
        DaggerAppComponent.builder().build().inject(this)
    }

    override fun activityInjector() = activityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment>  = fragmentInjector

    companion object {
        lateinit var context: Context
    }
}