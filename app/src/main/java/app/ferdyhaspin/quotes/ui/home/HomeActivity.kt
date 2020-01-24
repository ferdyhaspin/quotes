package app.ferdyhaspin.quotes.ui.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.utils.toast
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        val navController = Navigation.findNavController(this, R.id.fragment)
        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawer_layout)

        NavHostFragment.findNavController(fragment)
            .addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.logout -> {
                        toast("Logout")
                    }
                }
            }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.fragment),
            drawer_layout
        )
    }
}
