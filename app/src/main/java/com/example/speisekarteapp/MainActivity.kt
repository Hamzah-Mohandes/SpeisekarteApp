package com.example.speisekarteapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.speisekarteapp.databinding.ActivityMainBinding
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

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main) // variableto Binding


        // Binding name und preisen Viwe schriette
        // Namen
        binding.drink1Name.text = drink1.name
        binding.drink2Name.text = drink2.name
        binding.drink3Name.text = drink3.name


        // Preisen

        binding.drink1Price.text = drink1.price.toString()
        binding.drink2Price.text = drink2.price.toString()
        binding.drink3Price.text = drink3.price.toString()

        // Counter

        binding.drink1Count.text = drink1.count.toString()
        binding.drink2Count.text = drink2.count.toString()
        binding.drink3Count.text = drink3.count.toString()

        binding.drink1Button.setOnClickListener {
            try {
                drink1.count++ // Erhöhe die Anzahl des Getränks
                binding.drink1Count.text = drink1.count.toString() // Aktualisiere die Anzeige der Anzahl
                addToBill(drink1.price) // Füge den Preis zur Rechnung hinzu
                binding.totalPrice.text = bill.toString() // Aktualisiere die Anzeige der Gesamtsumme

                if (drink1.count > drink1.availableQuantity) {
                    // Überprüfe, ob die Anzahl die verfügbare Menge überschreitet
                    throw Exception("Nicht genügend ${drink1.name} vorhanden") // Wirf eine Exception mit entsprechender Nachricht
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message ?: "Unbekannter Fehler") // Gib die Fehlermeldung in der Logcat aus
                binding.drink1Button.isEnabled = false // Deaktiviere den Button für das Getränk
            }
        }

        binding.drink2Button.setOnClickListener {
            try {
                drink2.count++ // Erhöhe die Anzahl des Getränks
                binding.drink2Count.text = drink2.count.toString() // Aktualisiere die Anzeige der Anzahl
                addToBill(drink2.price) // Füge den Preis zur Rechnung hinzu
                binding.totalPrice.text = bill.toString() // Aktualisiere die Anzeige der Gesamtsumme

                if (drink2.count > drink2.availableQuantity) {
                    // Überprüfe, ob die Anzahl die verfügbare Menge überschreitet
                    throw Exception("Nicht genügend ${drink2.name} vorhanden") // Wirf eine Exception mit entsprechender Nachricht
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message ?: "Unbekannter Fehler") // Gib die Fehlermeldung in der Logcat aus
                binding.drink2Button.isEnabled = false // Deaktiviere den Button für das Getränk
            }
        }

        binding.drink3Button.setOnClickListener {
            try {
                drink3.count++ // Erhöhe die Anzahl des Getränks
                binding.drink3Count.text = drink3.count.toString() // Aktualisiere die Anzeige der Anzahl
                addToBill(drink3.price) // Füge den Preis zur Rechnung hinzu
                binding.totalPrice.text = bill.toString() // Aktualisiere die Anzeige der Gesamtsumme

                if (drink3.count > drink3.availableQuantity) {
                    // Überprüfe, ob die Anzahl die verfügbare Menge überschreitet
                    throw Exception("Nicht genügend ${drink3.name} vorhanden") // Wirf eine Exception mit entsprechender Nachricht
                }
            } catch (e: Exception) {
                Log.e(TAG, e.message ?: "Unbekannter Fehler") // Gib die Fehlermeldung in der Logcat aus
                binding.drink3Button.isEnabled = false // Deaktiviere den Button für das Getränk
            }
        }

        binding.resetButton.setOnClickListener {
            // Zurücksetzen der Zähler
            drink1.count = 0
            drink2.count = 0
            drink3.count = 0

            // Zurücksetzen der Rechnung
            bill = 0f

            // Aktualisieren der Anzeige
            binding.drink1Count.text = drink1.count.toString()
            binding.drink2Count.text = drink2.count.toString()
            binding.drink3Count.text = drink3.count.toString()
            binding.totalPrice.text = bill.toString()

            // Aktivieren aller Buttons
            binding.drink1Button.isEnabled = true
            binding.drink2Button.isEnabled = true
            binding.drink3Button.isEnabled = true
        }


        }

    /** Diese Funktion addiert den Preis zur Rechnung */
    private fun addToBill(price: Float?) {
        if (price != null) {
            bill += price
            bill = round(bill * 100) / 100
        }
    }


}