package com.example.newcomposesetup.screens

import android.graphics.drawable.Icon
import android.support.v4.os.IResultReceiver.Default
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newcomposesetup.models.QuoteData



@Composable
fun QuoteListItems(quoteData: QuoteData,onClick:(quoteData : QuoteData)->Unit){

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier.padding(8.dp)
            .clickable { onClick(quoteData) }

    ){
    Row(modifier = Modifier.padding(16.dp)) {
        Image(imageVector = Icons.Filled.Close,
        colorFilter = ColorFilter.tint(Color.White),
        alignment = Alignment.TopStart,
        contentDescription = "Quotes",
        modifier = Modifier
            .size(40.dp)
            .rotate(180F)
            .background(Color.Black)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = quoteData.txt,
                style = MaterialTheme.typography.bodyMedium,
               modifier = Modifier.padding(0.dp,0.dp,0.dp,0.dp)
            )
            
            Box(modifier = Modifier
                .background(Color(0xFFEEEEEE))
                .fillMaxWidth(.4f)
                .height(1.dp))

            Text(text = quoteData.author,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Thin,
                modifier = Modifier.padding(top = 4.dp))


            
        }
        
    }
        
    }

}







