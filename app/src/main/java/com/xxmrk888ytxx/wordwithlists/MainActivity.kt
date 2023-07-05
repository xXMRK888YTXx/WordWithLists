package com.xxmrk888ytxx.wordwithlists

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth.FifthScreen
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth.FifthViewModel
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fifth.models.ScreenState
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.First.FirstScreen
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.First.ViewModelWithUsers
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth.FourthScreen
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Fourth.FourthViewModel
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Second.SecondScreen
import com.xxmrk888ytxx.wordwithlists.presentation.Screens.Third.ThirdScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()


            Scaffold(
                Modifier.fillMaxSize(),
                bottomBar = {
                    val screenNumbers = remember {
                        listOf(1, 2, 3, 4, 5)
                    }
                    NavigationBar(

                    ) {
                        screenNumbers.forEach {
                            this.NavigationBarItem(
                                selected = it.toString() == navController.currentDestination?.navigatorName,
                                onClick = { navController.navigate(it.toString()) { launchSingleTop = true } },
                                icon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.baseline_123_24),
                                        contentDescription = "",
                                    )
                                },
                                label = {
                                    Text(text = "$it")
                                },

                            )
                        }
                    }
                }
            ) { paddings ->
                NavHost(
                    navController = navController,
                    startDestination = "1",
                    modifier = Modifier.padding(paddings)
                ) {
                    composable("1") {
                        val viewModel = hiltViewModel<ViewModelWithUsers>()

                        val list by viewModel.users.collectAsState(initial = emptyList())


                        FirstScreen(
                            users = list
                        )
                    }

                    composable("2") {
                        val viewModel = hiltViewModel<ViewModelWithUsers>()

                        val list by viewModel.users.collectAsState(initial = emptyList())

                        SecondScreen(users = list)
                    }

                    composable("3") {
                        ThirdScreen()
                    }

                    composable("4") {
                        val viewModel = hiltViewModel<FourthViewModel>()

                        val items by viewModel.items.collectAsState(emptyList())

                        FourthScreen(items = items)
                    }

                    composable("5") {
                        val viewModel = hiltViewModel<FifthViewModel>()

                        val screenState by viewModel.screenState.collectAsState(
                            initial = ScreenState(
                                isLoading = false,
                                isPullToRefreshInProcess = false,
                                isEmptyList = false,
                                userList = emptyList()
                            )
                        )

                        FifthScreen(
                            screenState,
                            onClearList = { viewModel.toEmptyState() },
                            onPullRefresh = { viewModel.pullRefresh() }
                        )
                    }
                }
            }

        }
    }
}