package com.androidquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.androidquiz.databinding.FragmentGameOverBinding
import com.androidquiz.databinding.FragmentTitleBinding

class GameOverFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameOverBinding =
            DataBindingUtil.inflate(inflater,R.layout.fragment_game_over,container,false)

        binding.tryAgainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameOverFragment2_to_gameFragment))



        return binding.root
    }


}