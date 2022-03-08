package ru.sergey1057.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.sergey1057.core_api.mediator.AppWithFacade
import ru.sergey1057.core_api.mediator.HomeMediator
import ru.sergey1057.core_api.mediator.ScorersMediator
import ru.sergey1057.core_api.mediator.WorldMediator
import ru.sergey1057.main.di.MainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var homeMediator: HomeMediator

    @Inject
    lateinit var scorersMediator: ScorersMediator

    @Inject
    lateinit var worldMediator: WorldMediator


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainComponent.create((application as AppWithFacade).getFacade()).inject(this)
        setContentView(R.layout.activity_main)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.mainNavigationView)
        homeMediator.startHomeScreen(
            R.id.mainFragmentsContainer,
            supportFragmentManager
        )
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    homeMediator.startHomeScreen(
                        R.id.mainFragmentsContainer,
                        supportFragmentManager
                    )
                    true
                }
                R.id.scorers -> {
                    scorersMediator.startScorersScreen(
                        R.id.mainFragmentsContainer,
                        supportFragmentManager
                    )
                    true
                }
                R.id.world -> {
                    worldMediator.startWorldScreen(
                        R.id.mainFragmentsContainer,
                        supportFragmentManager
                    )
                    true
                }
                else -> false
            }
        }

    }
}
