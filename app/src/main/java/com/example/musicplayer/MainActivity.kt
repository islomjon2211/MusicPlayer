package com.example.musicplayer

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var cardImg: ImageView
    lateinit var music: MediaPlayer
    private lateinit var set: AnimatorSet
    private lateinit var playBtn: ImageView
    var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardImg = findViewById<ImageView>(R.id.cardImg)
        playBtn = findViewById<ImageView>(R.id.playBtn)
        val Of = 0.0f
        val test1 = ObjectAnimator.ofFloat(cardImg, "rotation", Of, 360f)
        test1.duration = 1000

        val test2 = ObjectAnimator.ofFloat(cardImg, "rotation", Of, 360f)
        test1.duration = 500
        test1.repeatCount = 1000
        test2.repeatCount = 1000
        test1.duration = 1000
        test2.duration = 1000
        set = AnimatorSet()
        set.playSequentially(test1, test2)

        music = MediaPlayer.create(this, R.raw.music);
        playBtn.setOnClickListener { playMusic() }
    }

    fun playMusic() {
        if (isPlaying == false) {
            music.start()
            set.start()
            playBtn.setImageResource(R.drawable.ic_pause)
            isPlaying = true
        }
        else{
            music.pause()
            set.pause()
            playBtn.setImageResource(R.drawable.ic_play)
            isPlaying=false
        }

    }

}