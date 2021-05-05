package com.example.dachuang.ui.mainInterface

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.dachuang.R
import com.example.dachuang.ui.common.BaseActivity
import com.example.dachuang.ui.mainInterface.discover.DiscoverFragment
import com.example.dachuang.ui.mainInterface.goOut.GoOutFragment
import com.example.dachuang.ui.mainInterface.home.HomeFragment
import com.example.dachuang.ui.mainInterface.message.MessageFragment
import com.example.dachuang.ui.mainInterface.person.PersonFragment

class MainInterface : BaseActivity(), RadioGroup.OnCheckedChangeListener {
    var fragmentList = mutableListOf<Fragment>()
    private lateinit var homeFragment: HomeFragment
    private lateinit var goOutFragment: GoOutFragment
    private lateinit var discoverFragment: DiscoverFragment
    private lateinit var messageFragment: MessageFragment
    private lateinit var personFragment: PersonFragment
    private lateinit var currentFragment: Fragment

    override fun layoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        //设置RadioGroup的监听
        findViewById<RadioGroup>(R.id.rg).setOnCheckedChangeListener(this)
        //更改底部图标大小
        initChangeIcon()
        //初始化Fragment
        initFragment()
        //设置默认Fragment
        initSetNormalFragment()
        TODO("Not yet implemented")
    }

    override fun initDate() {
        TODO("Not yet implemented")
    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val fm = supportFragmentManager
        when (checkedId) {
            R.id.rb_home ->
                showFragment(fragmentList[0], fm)
            R.id.rb_discover ->
                showFragment(fragmentList[1], fm)
            R.id.rb_go_out ->
                showFragment(fragmentList[2], fm)
            R.id.rb_message ->
                showFragment(fragmentList[3], fm)
            R.id.rb_person ->
                showFragment(fragmentList[4], fm)
        }
    }

    //默认加载第一个fragment
    fun initSetNormalFragment() {
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
        initDrawable(findViewById(R.id.rb_home))
        initDrawable(findViewById(R.id.rb_discover))
        initDrawable(findViewById(R.id.rb_message))
        initDrawable(findViewById(R.id.rb_person))
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