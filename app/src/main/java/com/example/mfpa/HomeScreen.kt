package com.example.mfpa

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.mfpa.databinding.FragmentHomeScreenBinding


class HomeScreen : Fragment() {

    private lateinit var binding : FragmentHomeScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding = FragmentHomeScreenBinding.inflate(layoutInflater)

        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

  val menuHost: MenuHost = requireActivity()


        menuHost.addMenuProvider(object :MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                menuInflater.inflate(R.menu.settings_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

               return when (menuItem.itemId) {
                    R.id.settings -> {

                        true
                    }
                   else -> { false}
               }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

    }


}