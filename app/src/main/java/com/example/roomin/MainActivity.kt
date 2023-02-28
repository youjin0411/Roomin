package com.example.roomin
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.roomin.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var home_ly: LinearLayout? = null
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        init() //객체 정의
        //맨 처음 시작할 탭 설정
        bottomNavigationView!!.selectedItemId = R.id.home_ly
    }

    private fun init() {
        home_ly = findViewById(R.id.home_ly)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
    }


    internal inner class TabSelectedListener :
        BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
            when (menuItem.getItemId()) {
                R.id.tab_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, HomeFragment())
                        .commit()
                    return true
                }
                R.id.tab_money -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, PayService())
                        .commit()
                    return true
                }
                R.id.tab_user -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_ly, UserFragment())
                        .commit()
                    return true
                }

            }
            return false
        }
    }
}