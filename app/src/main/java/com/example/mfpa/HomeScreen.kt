package com.example.mfpa

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.mfpa.databinding.FragmentHomeScreenBinding
import java.util.Collections


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


 //       menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        val animeAdapter = AnimeAdapter(requireContext(), precious.animeList!!)

        binding.recyclerview.adapter = animeAdapter
        binding.recyclerview.setHasFixedSize(true)

        itemTouchHelper.attachToRecyclerView(binding.recyclerview)
    }

  /**  override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.settings_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {

        return when (menuItem.itemId) {
            R.id.settings -> {

                findNavController().navigate(R.id.action_home_Screen_to_settingsFragment)

                true
            }
            else ->
                false
    }    } **/




   private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,0) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {

            val start = target.adapterPosition
            val end = target.adapterPosition

            Collections.swap(precious.animeList, start, end)

            binding.recyclerview.adapter!!.notifyItemMoved(start, end)

            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }

    })
}