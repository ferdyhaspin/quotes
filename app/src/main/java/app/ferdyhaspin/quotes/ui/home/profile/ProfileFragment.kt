package app.ferdyhaspin.quotes.ui.home.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders

import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.AppDatabase
import app.ferdyhaspin.quotes.data.network.NetworkConnectionInterceptor
import app.ferdyhaspin.quotes.data.network.Service
import app.ferdyhaspin.quotes.data.repositories.UserRepository
import app.ferdyhaspin.quotes.databinding.FragmentProfileBinding
import app.ferdyhaspin.quotes.ui.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val interceptor = NetworkConnectionInterceptor(requireContext())
        val db = AppDatabase(requireContext())
        val service = Service(interceptor)
        val repository = UserRepository(service, db)
        val factory = ViewModelFactory(ProfileViewModel(repository))

        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        val viewModel = ViewModelProviders.of(this, factory).get(ProfileViewModel::class.java)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root

    }


}
