package com.example.newcomposesetup.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newcomposesetup.DataManager
import com.example.newcomposesetup.models.QuoteData


@Composable
fun QuoteDetails(quoteData: QuoteData){
    BackHandler() {
        DataManager.switchPages(null)
        
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFF3E3E3)
                    )
                )
            )){

        Card(elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(32.dp)) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
//                     .align(Alignment.Center)
                    .padding(16.dp, 24.dp)
            ) {
                Image(imageVector = Icons.Filled.Favorite,
                    contentDescription ="Quotes",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(text = quoteData.txt,
                    fontFamily = FontFamily.Monospace,
                    style = MaterialTheme.typography.headlineLarge)
                Spacer(Modifier.height(16.dp))
                Text(text = quoteData.author,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

    }
}