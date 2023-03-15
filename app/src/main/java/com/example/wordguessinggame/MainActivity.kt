package com.srdev.wordlecompose

import android.app.GameState
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import java.lang.reflect.Modifier

class MainActivity : ComponentActivity(){
    fun main() {
        val words = arrayOf("activities", "views", "intents", "services", "content", "fragments", "android", "manifest")
        val selectedWord = words.random()
        val hiddenWord = selectedWord.replace(Regex("[A-Za-z]"), "_")
        var guesses = 10
        var guessedLetters = mutableListOf<Char>()

        println("Welcome to the Wordle game")
        println("Word has ${selectedWord.length} letters")
        println("You have $guesses guesses in order to get it correct")
        println("Guess the word: $hiddenWord")

        while (guesses > 0){
            print("Guess the character: ")
            val guess = readLine()?.lowercase()?.firstOrNull()

            if (guess == null || guess !in 'a'..'z') {
                println("Wrong word guessed, please guess again!")
                continue
            }
            guessedLetters.add(guess)

            if (guess in selectedWord){
                println("The word guessed is correct")
                hiddenWord.replaceRange(
                    selectedWord.indexOf(guess) *2,
                            selectedWord.indexOf(guess) *2+1,
                guess.toString()
                )
            if(!hiddenWord.contains("_")){
                println("Well done, the word you have guessed is correct!")
                return
            }
            } else {
               guesses--
               println("Incorrect, you have $guesses left!")
            }
                println("Guess the word: $hiddenWord")
        }
            println("You have run out of guesses, the word was $selectedWord")
    }


}