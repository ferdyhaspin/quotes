package app.ferdyhaspin.quotes.ui.component.home.profile


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import app.ferdyhaspin.quotes.R
import app.ferdyhaspin.quotes.databinding.FragmentProfileBinding
import app.ferdyhaspin.quotes.ui.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    @Inject
    lateinit var viewModel: ProfileViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = viewModelFactory.create(ProfileViewModel::class.java)

        val binding: FragmentProfileBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root

    }
}
