package com.example.dachuang.ui.mainInterface

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dachuang.R
import com.example.dachuang.ui.common.BaseActivity
import com.example.dachuang.ui.mainInterface.discover.DiscoverFragment
import com.example.dachuang.ui.mainInterface.goOut.GoOutFragment
import com.example.dachuang.ui.mainInterface.home.HomeFragment
import com.example.dachuang.ui.mainInterface.message.MessageFragment
import com.example.dachuang.ui.mainInterface.person.PersonFragment
import com.example.dachuang.ui.travel.TravelActivity

class MainInterfaceActivity : AppCompatActivity(),  RadioGroup.OnCheckedChangeListener {

    var fragmentList = mutableListOf<Fragment>()
    private lateinit var homeFragment: HomeFragment
    private lateinit var goOutFragment: GoOutFragment
    private lateinit var discoverFragment: DiscoverFragment
    private lateinit var messageFragment: MessageFragment
    private lateinit var personFragment: PersonFragment
    private lateinit var currentFragment: Fragment
    private  lateinit var radioGroup: RadioGroup


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_interface)
        initView()
        initDate()
    }

    private fun initView() {
        //设置RadioGroup的监听
        radioGroup= findViewById(R.id.rg)
        radioGroup.setOnCheckedChangeListener(this)
        //更改底部图标大小
        initChangeIcon()
        //初始化Fragment
        initFragment()
        //设置默认Fragment
        initSetNormalFragment()
    }

    private fun initDate() {
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val fm = supportFragmentManager
        when (checkedId) {
            R.id.rb_home ->
                showFragment(fragmentList[0], fm)
            R.id.rb_discover ->
                showFragment(fragmentList[1], fm)
            R.id.rb_go_out -> {
                val intent =Intent(this,TravelActivity::class.java)
                startActivity(intent)
            }
            R.id.rb_message ->
                showFragment(fragmentList[3], fm)
            R.id.rb_person ->
                showFragment(fragmentList[4], fm)
        }
    }


    //默认加载第一个fragment
    private fun initSetNormalFragment() {
        val fm = supportFragmentManager
        showFragment(fragmentList[0], fm)
    }


    fun initFragment() {
        currentFragment = Fragment()
        homeFragment = HomeFragment()
        goOutFragment = GoOutFragment()
        discoverFragment = DiscoverFragment()
        personFragment = PersonFragment()
        messageFragment = MessageFragment()

        fragmentList.add(homeFragment)
        fragmentList.add(discoverFragment)
        fragmentList.add(goOutFragment)
        fragmentList.add(messageFragment)
        fragmentList.add(personFragment)

    }

    private fun initChangeIcon() {
        initDrawable(radioGroup.findViewById(R.id.rb_home))
        initDrawable(radioGroup.findViewById(R.id.rb_discover))
        initDrawable(radioGroup.findViewById(R.id.rb_message))
        initDrawable(radioGroup.findViewById(R.id.rb_person))
    }

    private fun initDrawable(v: RadioButton) {
        val drawable = v.compoundDrawables[1]
        drawable.setBounds(0, 0, 60, 60)
        v.setCompoundDrawables(null, drawable, null, null)
    }


    private fun showFragment(fragment: Fragment, fm: FragmentManager) {
        //判断当前显示的是否是需要展示的Framgnet，可以省略不必要步骤
        if (currentFragment != fragment) {
            //隐藏当前Fragment
            val transaction = fm.beginTransaction()
            transaction.hide(currentFragment)
            //将fragment替换成目前传入的fragment
            currentFragment = fragment
            //判断当前fragment是否添加进事务中
            if (!fragment.isAdded) {
                //添加显示
                transaction.add(R.id.fl_layout, fragment).show(fragment).commit()
            } else {
                //显示
                transaction.show(fragment).commit()
            }
        }
    }
}