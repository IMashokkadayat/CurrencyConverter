package com.example.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.currencyconverter.ui.theme.CurrencyConverterTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer


import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import kotlin.math.roundToInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            CurrencyConverterTheme {
                Surface(modifier = Modifier.fillMaxSize()){
                    CurrencyConvert()
                    Spacer(Modifier.height(16.dp))



                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CurrencyConvert()
}

@Composable
fun CurrencyConvert() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Indian Rupee") }
    var outputUnit by remember { mutableStateOf("Indian Rupee") }
    var iExpand by remember { mutableStateOf(false) }
    var oExpand by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(0.01) }
    var oconversionFactor = remember { mutableStateOf(0.01) }

    fun ConvertCurrency(){
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100.0 / oconversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }
//helo
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,


        ) {
        Text("CURRENCY CONVERTER",
            style =  TextStyle(
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                fontSize = 24.sp
            )
        )

        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, label = { Text("Enter Value") }, onValueChange = {
            inputValue = it

        })
        Spacer(Modifier.height(16.dp))
        Row {
            Box {
                Button(onClick = {iExpand = true}) {
                    Text(text = inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = " Arrow Down "
                    )
                }
                DropdownMenu(expanded = iExpand,
                    onDismissRequest = { iExpand = false }) {
                    DropdownMenuItem(
                        text = { Text("Indian Rupee") },
                        onClick = {
                            iExpand = false
                            inputUnit = "Indian Rupee"
                            conversionFactor.value = 1.0
                            ConvertCurrency()



                        }
                    )
                    DropdownMenuItem(
                        text = { Text("US Dollar") },
                        onClick = {
                            iExpand = false
                            inputUnit = "US Dollar"
                            conversionFactor.value = 0.012
                            ConvertCurrency()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text("European Euro") },
                        onClick = {
                            iExpand = false
                            inputUnit = "European Euro"
                            conversionFactor.value = 0.0108
                            ConvertCurrency()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Nepalese Rupee") },
                        onClick = {
                            iExpand = false
                            inputUnit = "Nepalese Rupee"
                            conversionFactor.value = 1.60
                            ConvertCurrency()

                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Japanese Yen") },
                        onClick = {
                            iExpand = false
                            inputUnit = "Japanese Yen"
                            conversionFactor.value = 1.6948
                            ConvertCurrency()

                        }
                    )
                }


            }

            Spacer(Modifier.width(32.dp))

            Box {
                Button(onClick = {oExpand = true}) {
                    Text(text = outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = " Arrow Down "
                    )
                }
                DropdownMenu(expanded = oExpand,
                    onDismissRequest = { oExpand = false }) {
                    DropdownMenuItem(
                        text = { Text("Indian Rupees") },
                        onClick = {
                            oExpand = false
                            outputUnit = "Indian Rupees"
                            oconversionFactor.value = 1.0
                            ConvertCurrency()

                        }
                    )


                    DropdownMenuItem(
                        text = { Text("US Dollar") },
                        onClick = {
                            oExpand = false
                            outputUnit = "US Dollar"
                            oconversionFactor.value = 0.012
                            ConvertCurrency()

                        }
                    )

                    DropdownMenuItem(
                        text = { Text("European Euro") },
                        onClick = {
                            oExpand = false
                            outputUnit = "European Euro"
                            oconversionFactor.value = 0.0108
                            ConvertCurrency()

                        }
                    )




                    DropdownMenuItem(
                        text = { Text("Nepalese Rupee") },
                        onClick = {
                            oExpand = false
                            outputUnit = "Nepalese Rupee"
                            oconversionFactor.value = 1.60
                            ConvertCurrency()

                        }
                    )




                    DropdownMenuItem(
                        text = { Text("Japanese Yen") },
                        onClick = {
                            oExpand = false
                            outputUnit = "Japanese Yen"
                            oconversionFactor.value = 1.6948
                            ConvertCurrency()

                        }
                    )


                }

            }
        }
        Spacer(Modifier.height(16.dp))
        Text(text = "Output Result: ${outputValue} ${outputUnit}")







    }
}