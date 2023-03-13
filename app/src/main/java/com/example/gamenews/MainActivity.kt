package com.example.gamenews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var rv:RecyclerView
private val listGame = ArrayList<Game>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.RV)
        rv.setHasFixedSize(true)

        if (listGame.size == 0){
            listGame.addAll(getListGames())
        }


        showList()

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuabout_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.aboutpage->{
                val moveIntent = Intent(this@MainActivity, about::class.java)
                startActivity(moveIntent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListGames():ArrayList<Game> {
        val dataName = resources.getStringArray(R.array.game_name)
        val dataDev = resources.getStringArray(R.array.game_dev)
        val dataPrice = resources.getStringArray(R.array.game_price)
        val dataPhoto = resources.obtainTypedArray(R.array.game_picture)
        val dataDesc = resources.getStringArray(R.array.game_desc)
        val dataRate = resources.getStringArray(R.array.game_rate)
        val listGame = ArrayList<Game>()
        for (i in dataName.indices) {
            val game = Game(dataName[i], dataDev[i], dataPrice[i], dataPhoto.getResourceId(i, -1), dataDesc[i], dataRate[i])
            listGame.add(game)
        }
        return listGame
    }
    private fun showList(){
        for (i in 0..9){
            rv.layoutManager = LinearLayoutManager(this)
            val listGameAdapter = ListGameAdapter(listGame)
            rv.adapter = listGameAdapter
        }
    }

}