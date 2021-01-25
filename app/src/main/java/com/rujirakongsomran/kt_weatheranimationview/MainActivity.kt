package com.rujirakongsomran.kt_weatheranimationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.github.matteobattilana.weather.PrecipType
import com.rujirakongsomran.kt_weatheranimationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var weather: PrecipType
    lateinit var weatherText: String
    private var number = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding.btnChange.setOnClickListener {
            changeWeather()
        }
    }

    private fun changeWeather() {
        var weatherSpeed = 0
        var weatherParticles = 0f

        if (number < 2) ++number else number = 0
        when (number) {
            0 -> {
                binding.screen.setBackgroundResource(R.drawable.clear)
                weather = PrecipType.CLEAR
                weatherText = "Clear"
            }
            1 -> {
                binding.screen.setBackgroundResource(R.drawable.snow)
                weather = PrecipType.SNOW
                weatherText = "Snow"
                weatherParticles = 5f
                weatherSpeed = 100
            }
            2 -> {
                binding.screen.setBackgroundResource(R.drawable.rain)
                weather = PrecipType.RAIN
                weatherText = "Rain"
                weatherParticles = 100f
                weatherSpeed = 800
            }
        }
        binding.tvWeather.text = weatherText
        binding.wv.apply {
            setWeatherData(weather)
            speed = weatherSpeed
            emissionRate = weatherParticles
            angle = 45
            fadeOutPercent = .85f
        }
    }
}