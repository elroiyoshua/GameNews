package com.example.gamenews

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.navigation.ui.AppBarConfiguration

private lateinit var gameName : TextView
private lateinit var gameDev : TextView
private lateinit var gamePict : ImageView
private lateinit var gamePrice : TextView
private lateinit var gameRate :TextView
private lateinit var gameDesc : TextView
private lateinit var shareBtn : Button
private  lateinit var game: String



class DetailActivity : AppCompatActivity() {
    companion object {
        const val KEY_GAME = "key_game"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataGame = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(KEY_GAME,Game::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(KEY_GAME)
        }


        gameName = findViewById(R.id.judulGame)
        gameDesc =findViewById(R.id.descgame)
        gameDev = findViewById(R.id.developergame)
        gamePrice = findViewById(R.id.hargagame)
        gameRate = findViewById(R.id.ratinggame)
        gamePict = findViewById(R.id.gambarGame)
        shareBtn = findViewById(R.id.buttonshare)
        if (dataGame != null) {
            gameName.text = dataGame.name
            gameDesc.text = dataGame.desc
            gameDev.text = dataGame.dev
            gamePrice.text = dataGame.price
            gameRate.text = dataGame.rate
            gamePict.setImageResource(dataGame.photo)
            game = satuin(dataGame.name,dataGame.dev,dataGame.price)
        }



        shareBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, game)



            val chooser = Intent.createChooser(intent,"Share Using")
            startActivity(chooser)
        }

    }
    fun satuin(kata1 :String,Kata2 :String,kata3:String):String{
        return "Im sharing $kata1 developed by $Kata2 and cost for $kata3 "
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}






