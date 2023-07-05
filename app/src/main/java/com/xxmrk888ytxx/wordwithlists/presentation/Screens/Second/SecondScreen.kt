package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Second

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.xxmrk888ytxx.wordwithlists.R
import com.xxmrk888ytxx.wordwithlists.domain.UserRepository.model.User

@Composable
fun SecondScreen(
    users: List<User>,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(users) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(0.dp)
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SubcomposeAsyncImage(
                        model = it.avatarUrl,
                        contentDescription = "",
                        loading = { CircularProgressIndicator() },
                        modifier = Modifier.size(40.dp)
                    )

                    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        Text(text = "${it.firstName} ${it.lastName}", fontWeight = FontWeight.W900)

                        Text(text = "${it.age}")

                        Text(
                            text = it.description,
                            maxLines = 1
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = if (it.isMan) painterResource(id = R.drawable.baseline_man_24)
                        else painterResource(id = R.drawable.baseline_woman_24),
                        contentDescription = "",
                        modifier = Modifier.size(24.dp)
                    )


                }
            }
        }
    }
}