package com.example.speisekarteapp

/**
 * Die Klasse Drink repräsentiert ein Getränk mit Namen und Preis.
 * Es enthält auch Informationen über die verfügbare Kapazität und die aktuelle Anzahl des Getränks.
 */
class Drink(val name: String, val price: Float) {
    private var capacity = 50 // Maximale Kapazität des Getränks

    var count: Int = 0
        set(value) {
            if (value <= capacity) {
                field = value // Setze die Anzahl des Getränks
            } else {
                throw Exception("Soviel $name ist nicht da") // Wirf eine Exception, wenn die angegebene Anzahl die Kapazität überschreitet
            }
        }

    /**
     * Die verfügbare Menge des Getränks.
     * Dies wird berechnet, indem die Kapazität des Getränks von der aktuellen Anzahl abgezogen wird.
     */
    val availableQuantity: Int
        get() = capacity - count
}
