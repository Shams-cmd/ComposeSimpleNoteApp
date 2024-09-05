package com.example.newcomposesetup

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.newcomposesetup.models.QuoteData
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {

    var data = emptyArray<QuoteData>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote : QuoteData?=null

    fun loadassetsFromFile(context : Context){
        val inputStream = context.assets.open("quots.json")
        val size : Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
        data=gson.fromJson(json,Array<QuoteData>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quoteData: QuoteData?){
        if (currentPage.value==Pages.LISTING){
            currentQuote=quoteData
            currentPage.value==Pages.DETAILS
        }else{
            currentPage.value=Pages.LISTING
        }
    }
}