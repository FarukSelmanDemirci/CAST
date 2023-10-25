package com.example.deneme


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(initialValue = DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "COST EUROPEAN COOPERATION IN SCIENCE AND TECHNOLOGY ") },
                navigationIcon = {
                    IconButton(onClick = {
                        // Coroutine başlatma işlemi
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            DrawerMenu()
        }
    ) {
        ContentScreen()
    }
}
@Composable
fun DrawerMenu() {
    Column(
        modifier = Modifier.fillMaxSize().background(Color.LightGray).padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween // Öğeleri başlangıç ve son noktalarına yerleştir
    ) {
        // Diğer menü öğeleri
        Column {
            DrawerMenuItem(text = "Home", iconResId = R.drawable.anasayfa, onClick = { /* Tıklama işlemi */ })
            DrawerMenuItem(text = "About", iconResId = R.drawable.hakkimizda, onClick = { /* Tıklama işlemi */ })
            DrawerMenuItem(text = "Our Mission", iconResId = R.drawable.misyon, onClick = { /* Tıklama işlemi */ })
            DrawerMenuItem(text = "Communications", iconResId = R.drawable.iletisim, onClick = { /* Tıklama işlemi */ })
            DrawerMenuItem(text = "Resources", iconResId = R.drawable.kaynak, onClick = { /* Tıklama işlemi */ })
            DrawerMenuItem(text = "Announcements", iconResId = R.drawable.duyurular, onClick = { /* Tıklama işlemi */ })
        }

        // Kullanıcı girişi için tuş
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(CircleShape)
                .background(Color(0xFF6200EE)) // Aynı arka plan rengi
                .clickable(onClick = { /* Kullanıcı girişi işlemi */ }),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            // Vector asset'i eklediğimiz kısım
            Image(
                painter = painterResource(id = R.drawable.kullanicigiris),
                contentDescription = null,
                modifier = Modifier.size(24.dp).padding(end = 16.dp)// Icon ile metin arasında boşluk ekledik
            )
            Text(text = "User Login", color = Color.White)
        }
    }
}

@Composable
fun DrawerMenuItem(text: String, iconResId: Int, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(CircleShape)
            .background(Color(0xFF6200EE)) // Burada arka plan rengini mavi olarak ayarladık
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        // Vector asset'i eklediğimiz kısım
        Image(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(24.dp) // Bu boyutu ihtiyacınıza göre ayarlayabilirsiniz.
        )

        Spacer(modifier = Modifier.width(16.dp)) // Icon ile metin arasında boşluk ekledik
        Text(text = text, color = Color.White) // Metnin rengini beyaz olarak ayarladık
    }
}




@Composable
fun ContentScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.your_image),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop // Resmin merkezini ayarlamak için ekledim.
            )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Cost Action: INE-CSC")
        Text(text = "Implementation Network Europe for Cancer Survivorship Care (CA21152)")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* Tıklama işlemleri */ }) {
            Text(text = "Learn More", color = Color.White)
        }
    }
}
