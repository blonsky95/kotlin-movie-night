package com.ang.acb.movienight.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ang.acb.movienight.R
import com.ang.acb.movienight.ui.common.MessageBox

@Composable
fun CastDetailsScreen(
    viewModel: CastDetailsViewModel = hiltViewModel(),
    upPressed: () -> Unit
) {
    Scaffold(
        topBar = { CastDetailsTopBar(upPressed = upPressed) }
    ) {
        if (viewModel.errorMessage != null) {
            MessageBox(messageResId = viewModel.errorMessage!!)
        } else {
            if (viewModel.errorMessage != null) {
                MessageBox(messageResId = viewModel.errorMessage!!)
            } else {
                viewModel.castDetails?.let {
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        CastInfoAvatarRow(cast = it)

                        if (it.biography != null && it.biography.isNotEmpty()) {
                            MovieInfoHeader(stringResource(R.string.cast_details_biography_label))
                            Text(it.biography, modifier = Modifier.padding(horizontal = 16.dp))
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}