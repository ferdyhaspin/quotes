package app.ferdyhaspin.quotes.ui.component.home.profile


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.data.db.entities.User
import app.ferdyhaspin.quotes.databinding.FragmentProfileBinding
import app.ferdyhaspin.quotes.ui.ViewModelFactory
import app.ferdyhaspin.quotes.ui.base.BaseFragment
import app.ferdyhaspin.quotes.ui.component.auth.LoginActivity
import app.ferdyhaspin.quotes.utils.observe
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: ProfileViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun initializeViewModel() {
        viewModel = viewModelFactory.create(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun observeViewModel() {
    }
}
