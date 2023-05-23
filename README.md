# Aufgaben
In der App soll eine Speisekarte programmiert werden 🍽️

## 1 Speisekarte - Data Binding

<p align="center">
<img height="300" src="https://user-images.githubusercontent.com/101095654/221518756-ddaab536-bc93-4c64-a4be-329570605b83.png">
</p>

Dein Freund Synti vom Restaurant Syntaxis kommt auf dich zu, da er seinen Kunden die Möglichkeit geben möchte über eine App zu bestellen.
Dazu sollen die die Kunden per Klick auf das Symbol ihre Bestellung aufgeben.  
Schaue dir zuerst den bereits vorhandenen Code in der `MainActivity.kt` an!

* Wir wollen die Elemente aus dem XML Layout mit dem Code verknüpfen und müssen daher `dataBinding` in der `build.gradle(Module)` Datei aktivieren 
    * Hinweis: Synchronisiere das Projekt mit “Sync Now”.
    * Schaue gerne auch in die Vorlesungsfolien, wenn du dir unsicher bist!
* Nun können wir das Layout `activity_main.xml` in ein Data Binding Layout umwandeln
* Gehe nun in die `MainActivity.kt` und erstelle dort eine variable `binding` und
verbinde diese mit der `activity_main.xml`
* Nun kannst du mit binding und der ID des xml Elements auf alle View Elemente
zugreifen, z.B.: `binding.drink1Name`
    * Setze den Text von `drink1Name` bis `drink3Name` auf den Namen, der in der
entsprechenden `drink` Variable gespeichert ist
    * Setze den Text von `drink1Price` bis `drink3Price` auf den Preis, der in der
entsprechenden `drink` Variable gespeichert ist
    * Setze den Text von `drink1Count` bis `drink3Count` auf die Anzahl, der in der
entsprechenden `drink` Variable gespeichert ist

Hinweis: Bei den Klassenvariablen findest du die `drink` Variablen:
```kotlin
private val drink1 = Drink("Kaffee", 3.95f)
private val drink2 = Drink("Wein", 4.20f)
private val drink3 = Drink("Cocktail", 6.90f)
```

* Programmiere in der MainActivity nun drei `onClickListener` für die drei Drink Buttons,
in denen jeweils Folgendes passiert:
    * Die Funktion `addToBill` wird aufgerufen, um den insgesamten Preis der
Rechnung zu bekommen
    * Das `count` Attribut des Drink-Objektes wird um eins erhöht
    * Aktualisiere das View Element, welches die Anzahl des entsprechenden
Getränkes anzeigt.
    * Außerdem soll auch der endgültige Preis der Rechnung in der UI aktualisiert
werden. Schaue hierzu in der `activity_main.xml`, auf welches View Element
hierfür zugegriffen werden muss.
* Führe die App aus und probiere, ob sie funktioniert


* `BONUS` Füge der App eine “ZURÜCKSETZEN” Funktion hinzu, der die Anzahl aller
Getränke und die Summe auf 0 setzt und die entsprechenden Layout Elemente anpasst

    Hinweis: es existiert bereits ein resetButton, die über die `binding` Variable
angesprochen werden kann.


* `BONUS` Formatiere die Preise, sodass z.B. 4.20€ statt 4.2€ angezeigt wird. Dafür kannst
du die Funktion `<String>.format(num)` verwenden

    Beispiel: Zahlendarstellung mit 3 Dezimalstellen.
    
    `"%.3f".format(num)` 
    
    3.987654 -> 3.987

## 2 Speisekarte - Exception Handling

In dieser Aufgabe wollen wir mithilfe von Exceptions verhindern, dass mehr Getränke von einer
Sorte bestellt werden, als vorhanden sind. Schaue dir hierfür den Code in der Klasse `Drink.kt`
an.

* Packe dafür deine Anweisungen in jedem onClickListener für `drink1`, `drink2` und
`drink3` in einen `try` block

* Falls das Erhöhen der Anzahl die Grenze überschreitet, wirft die Klasse Drink
automatisch eine Exception. Diese wird nun im `catch` Block gefangen und Folgendes
ausgeführt
    * Lasse dir die Nachricht der Exception im `catch` Block anzeigen, indem du sie mit
`Log` in der Logcat ausgibst
    * Deaktiviere den Button für den entsprechenden Drink, damit keine weiteren
Exceptions geworfen werden
* Ändere den Resetbutton ab, sodass er nun auch alle Buttons wieder aktiviert


* `BONUS` Erstelle eine neue Klassenvariable `customerMoney`, in der festgelegt wird, wie
viel Geld der Kunde dabei hat. Falls der Gesamtbetrag darüber hinaus steigt, soll
Exception mit einer passenden Nachricht geworfen werden. Diese wird bereits in den
clickListenern der Buttons gefangen.
