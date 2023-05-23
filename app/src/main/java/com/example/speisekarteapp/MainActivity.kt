package com.example.speisekarteapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.round


/** Main Activity, dient als Einstiegspunkt für die App */
val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    /** Klassen Variablen **/
    private var bill: Float = 0f
    private val drink1 = Drink("Kaffee", 3.95f)
    private val drink2 = Drink("Wein", 4.20f)
    private val drink3 = Drink("Cocktail", 6.90f)

    /** Lifecycle Funktion, wird aufgerufen wenn Activity erstellt wird */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO Schreibe hier deinen Code
    }

    /** Diese Funktion addiert den Preis zur Rechnung */
    private fun addToBill(price: Float?) {
        if (price != null) {
            bill += price
            bill = round(bill * 100) / 100
        }
    }
}