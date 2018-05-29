package com.rembedded.noso.rembeddedfieldsoom

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            val element = Field("fieldId", "fulfiller")
            val element2 = Field("fieldId2", "fulfiller2")
            val element3 = Field("fieldId3", "fulfiller3")
            val element4 = Field("fieldId4", "fulfiller4")
            val fields = mutableListOf(element, element2, element3, element4)
            val documentLocal = DocumentLocal("1", "noname", fields)

            App.appDatabase.getDocumentsDao().insertDocument(documentLocal)

            val doc = App.appDatabase.getDocumentsDao().getDocumentsById("1")

            Log.d("TAG", doc.id)

        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
