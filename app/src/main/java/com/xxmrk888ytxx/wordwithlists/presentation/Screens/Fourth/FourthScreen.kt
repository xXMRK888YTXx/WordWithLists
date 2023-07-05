package com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth.models.FourthScreenModel
import kotlin.random.Random
import kotlin.random.nextInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FourthScreen(items:List<FourthScreenModel>) {


    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items) {

            when(it) {
                is FourthScreenModel.DefaultItem -> {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .height(150.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        if(!it.isReversed) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .background(randomColor()),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(it.bigItem.toString())
                            }

                            Column(modifier = Modifier.fillMaxHeight().weight(0.4f)

                            ) {
                                Box(modifier = Modifier.weight(1f)
                                    .fillMaxWidth()
                                    .background(randomColor()), contentAlignment = Alignment.Center) {
                                    Text(text = it.littleItems.first.toString())
                                }

                                Box(modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                                    .background(randomColor()), contentAlignment = Alignment.Center) {
                                    Text(text = it.littleItems.second.toString())
                                }
                            }
                        } else {
                            Column(modifier = Modifier.fillMaxHeight().weight(0.4f)

                            ) {
                                Box(modifier = Modifier.weight(1f)
                                    .fillMaxWidth()
                                    .background(randomColor()), contentAlignment = Alignment.Center) {
                                    Text(text = it.littleItems.first.toString())
                                }

                                Box(modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth()
                                    .background(randomColor()), contentAlignment = Alignment.Center) {
                                    Text(text = it.littleItems.second.toString())
                                }
                            }

                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .background(randomColor()),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(it.bigItem.toString())
                            }

                        }
                    }

                }
                is FourthScreenModel.SingleItem -> {
                    Box(modifier = Modifier.fillMaxWidth()
                        .height(100.dp)
                        .background(randomColor()), contentAlignment = Alignment.Center) {
                        Text(text = it.item.toString())
                    }
                }
            }
        }
    }
}

fun randomColor(): Color {
    return Color(
        red = Random(System.currentTimeMillis()).nextInt(0..255),
        green = Random(System.currentTimeMillis()).nextInt(0..255),
        blue = Random(System.currentTimeMillis()).nextInt(0..255)
    )
}