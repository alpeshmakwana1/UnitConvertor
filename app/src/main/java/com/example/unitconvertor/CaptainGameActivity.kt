package com.example.unitconvertor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.unitconvertor.ui.theme.UnitConvertorTheme
import kotlin.random.Random

class CaptainGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            UnitConvertorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CaptainGame()
                }
            }
        }
    }

    @Composable
    fun CaptainGame() {
        val treasureFound = remember { mutableStateOf(0) }
        val direction = remember { mutableStateOf("North") }
        val stormOrTreasure = remember { mutableStateOf("") }
        var stormOrTreasure1 by remember { mutableStateOf("") }

        Column {
            Text(text = "Treasure found Count :${treasureFound.value}")
            Text(text = "Current Direaction :${direction.value}")
            Text(text = "Result :${stormOrTreasure.value}")
            Text(text = "Result :${stormOrTreasure1}")

            Button(onClick = {
                direction.value = "North"
                checkTrasureFound(treasureFound,stormOrTreasure)
            }) {
                Text(text = "North")
            }
            Button(onClick = {
                direction.value = "East"
                checkTrasureFound(treasureFound, stormOrTreasure)
            }) {
                Text(text = "East")
            }
            Button(onClick = {
                direction.value = "South"
                checkTrasureFound(treasureFound, stormOrTreasure)
            }) {
                Text(text = "South")
            }
            Button(onClick = {
                direction.value = "West"
                checkTrasureFound(treasureFound, stormOrTreasure)
            }) {
                Text(text = "West")
            }
        }
    }

    fun checkTrasureFound(treasureFound: MutableState<Int>, stormOrTreasure: MutableState<String>) {
        if (Random.nextBoolean()) {
            treasureFound.value++;
            stormOrTreasure.value = "We found Treasure"
        } else {
            treasureFound.value = 0;
            stormOrTreasure.value = "Storm Ahead!"
        }
    }
}