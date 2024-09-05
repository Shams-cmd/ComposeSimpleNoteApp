package com.example.newcomposesetup

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newcomposesetup.screens.QuoteDetails
import com.example.newcomposesetup.screens.QuoteList
import com.example.newcomposesetup.screens.QuoteListItems
import com.example.newcomposesetup.screens.QuoteListScreen
import com.example.newcomposesetup.ui.theme.NewComposeSetUpTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadassetsFromFile(applicationContext)
        }

        setContent {
       //    QuoteListItems()
           App()
        }
    }

  @Composable
  fun App(){
     if (DataManager.isDataLoaded.value){
         if (DataManager.currentPage.value==Pages.DETAILS){
             QuoteListScreen(data = DataManager.data) {
                 DataManager.switchPages(it)
             }
         }else{
             DataManager.currentQuote?.let { QuoteDetails(quoteData = it) }
         }

     }
  }


}

enum class Pages{
    LISTING,
    DETAILS
}





