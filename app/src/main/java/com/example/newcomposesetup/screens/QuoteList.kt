package com.example.newcomposesetup.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.newcomposesetup.models.QuoteData

@Composable
fun QuoteList(data: Array<QuoteData>,onCLick : (quoteData : QuoteData)-> Unit){

    LazyColumn(content = {
        items(data){
           QuoteListItems(quoteData = it,onCLick)
        }
    })

}