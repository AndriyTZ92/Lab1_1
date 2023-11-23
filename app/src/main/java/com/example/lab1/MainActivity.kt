package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileWithDetails(
                        name = "Андрій Кошмак",
                        location = "Київ, Україна",
                        text = "Мене звати Андрій і я навчаюсь у КПІ ІТС",
                        photoId = R.drawable.image1,
                        smallPhotoId = R.drawable.image2,
                        photoIds = listOf(R.drawable.ikonka1, R.drawable.ikonka2, R.drawable.ikonka3)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileWithDetails(
    name: String,
    location: String,
    photoId: Int,
    photoIds: List<Int>,
    smallPhotoId: Int,
    modifier: Modifier = Modifier,
    text: String
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Circle photo centered
        Box(
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = photoId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }

        // Spacer
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 78.dp), // Загальний відступ
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Box for Text
            // Text with name
            Text(
                text = name,
                style = MaterialTheme.typography.headlineLarge
                    .copy(
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                modifier = Modifier
                    .padding(top = 7.dp, start = 30.dp) // Задає відступ вгорі та зліва
            )


            // Box for Small Photo (image2)
            Box(
                modifier = Modifier
                    .size(25.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .offset(x = 3.dp), // Задає відстань
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = smallPhotoId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.medium)
                )
            }

            // Other elements as needed
        }






        // Text with location
        Text(
            text = location,
            style = MaterialTheme.typography.headlineLarge
                .copy(
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Normal,
                    fontSize = 9.sp,
                    color = Color.Gray
                ),
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
        // Spacer
        Spacer(modifier = Modifier.height(4.dp))

        // Row with three photos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp), // Відстань від країв
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            photoIds.forEach { photo ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Photo
                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(MaterialTheme.shapes.medium)
                    ) {
                        Image(
                            painter = painterResource(id = photo),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(MaterialTheme.shapes.medium)
                        )
                    }

                    // Text
                    Text(
                        text = when (photo) {
                            R.drawable.ikonka1 -> "Фото"
                            R.drawable.ikonka2 -> "Підписники"
                            R.drawable.ikonka3 -> "Стежить"
                            else -> ""
                        },
                        style = MaterialTheme.typography.bodyMedium
                            .copy(
                                fontSize = 10.sp,
                                color = Color.Gray
                            ),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }


        // Spacer

        Spacer(modifier = Modifier.height(450.dp))

// Call Button
        // Call Button
        Button(
            onClick = { /* Дії при натисканні */ },
            colors = ButtonDefaults.buttonColors(

                contentColor = Color.White
            ),
            modifier = Modifier

        ) {
            Text(text = "Викликати")
        }

        // Text with additional information

    }
}

// ...

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Lab1Theme {
        ProfileWithDetails(
            name = "Андрій Кошмак",
            location = "Київ, Україна",
            photoId = R.drawable.image1,
            smallPhotoId = R.drawable.image2,
            photoIds = listOf(R.drawable.ikonka1, R.drawable.ikonka2, R.drawable.ikonka3),
            text = "Мене звати Андрій і я навчаюсь у КПІ ІТС"
        )
    }
}