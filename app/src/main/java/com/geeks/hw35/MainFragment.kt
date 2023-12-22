package com.geeks.hw35

import android.opengl.Visibility
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import com.geeks.hw35.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var count = 0
    private var plusOrMinus = true
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btCount.text = "+1"
        binding.tvCounter.text = "0"
        initListener()
    }

    private fun initListener() {
        binding.btCount.setOnClickListener {
            if (plusOrMinus) {
                if (count < 10) {
                    count++
                    binding.tvCounter.text = count.toString()
                } else {
                    plusOrMinus = false
                    binding.btCount.text = "-1"
                    count--
                    binding.tvCounter.text = count.toString()
                }
            } else {
                if (count > 0) {
                    count--
                    binding.tvCounter.text = count.toString()
                } else {
                    val bundle = Bundle()
                    bundle.putInt(keys.KEY_COUNTER, count)
                    val secondFragment = SecondFragment()
                    secondFragment.arguments = bundle
                    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment_container, secondFragment).commit()
                }
            }
        }
    }
}