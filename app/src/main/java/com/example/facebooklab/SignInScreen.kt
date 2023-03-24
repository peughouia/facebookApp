package com.example.facebooklab

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen() {
   Box(
       Modifier
           .background(MaterialTheme.colors.surface)
           .fillMaxSize()){

       Column(
           Modifier
               .fillMaxWidth()
               .padding(top = 150.dp),
       horizontalAlignment = Alignment.CenterHorizontally) {
           Icon(Icons.Rounded.Facebook, contentDescription = null,
                modifier = Modifier.size(100.dp),
               tint = MaterialTheme.colors.primary
               )
           Spacer(Modifier.height(20.dp))
           Text("Sign In With FaceBook")
       }
   }

}
