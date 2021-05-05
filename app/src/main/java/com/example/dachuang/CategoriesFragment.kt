package com.example.dachuang

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.example.dachuang.ui.mainInterface.MainInterfaceActivity

class CategoriesFragment : Fragment() {

    companion object {
        fun newInstance() = CategoriesFragment()
        var count = 0
    }

    private lateinit var viewModel: ChooseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        enterTransition = inflater.inflateTransition(R.transition.slide_right)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.categories_fragment, container, false)
        val bundle: Bundle? = this.arguments
        if (count == 0)
            return view
        val textView: TextView = view.findViewById(R.id.textView)
        textView.text = bundle?.getString("0")
        var checkedTextView: CheckedTextView = view.findViewById(R.id.style1)
        checkedTextView.text = bundle?.getString("1")
        checkedTextView = view.findViewById(R.id.style2)
        checkedTextView.text = bundle?.getString("2")
        checkedTextView = view.findViewById(R.id.style3)
        checkedTextView.text = bundle?.getString("3")
        checkedTextView = view.findViewById(R.id.style4)
        checkedTextView.text = bundle?.getString("4")
        checkedTextView = view.findViewById(R.id.style5)
        checkedTextView.text = bundle?.getString("5")
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val next: Button = view.findViewById(R.id.next)
        next.setOnClickListener {
            if (count < 3) {
                count++
                val fragmentManager = parentFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                val fragment = CategoriesFragment()
                val bundle: Bundle = Bundle()
                when (count) {
                    1 -> {
                        bundle.putString("0", "请选择您喜爱的小说类型")
                        bundle.putString("1", "类型1")
                        bundle.putString("2", "类型2")
                        bundle.putString("3", "类型3")
                        bundle.putString("4", "类型4")
                        bundle.putString("5", "类型5")
                    }
                    2 -> {
                        bundle.putString("0", "请选择您喜爱的电影类型")
                        bundle.putString("1", "类型1")
                        bundle.putString("2", "类型2")
                        bundle.putString("3", "类型3")
                        bundle.putString("4", "类型4")
                        bundle.putString("5", "类型5")
                    }
                    3 -> {
                        bundle.putString("0", "请选择您闲暇时喜欢干的事")
                        bundle.putString("1", "类型1")
                        bundle.putString("2", "类型2")
                        bundle.putString("3", "类型3")
                        bundle.putString("4", "类型4")
                        bundle.putString("5", "类型5")
                    }
                }
                fragment.arguments = bundle
                fragmentTransaction.replace(R.id.fragment, fragment)
                fragmentTransaction.commit()
            } else {// 进入下一界面
               val intent =Intent(activity,MainInterfaceActivity::class.java)
                startActivity(intent)
            }
        }
    }

}