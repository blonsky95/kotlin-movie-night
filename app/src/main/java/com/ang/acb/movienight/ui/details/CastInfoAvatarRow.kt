package com.ang.acb.movienight.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ang.acb.movienight.domain.entities.CastDetails

@Composable
fun CastInfoAvatarRow(
    cast: CastDetails,
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        CastProfileImage(
            profileImageUrl = cast.profileImageUrl,
            modifier = Modifier
                .weight(2f)
                .aspectRatio(2 / 3f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            if (cast.name.isNullOrEmpty().not()) {
                MovieInfoHeader(title = "${cast.name}")
            }

            if (cast.birthday.isNullOrEmpty().not()) {
                MovieInfoHeader(title = "Born ${cast.birthday} in ${cast.placeOfBirth}")
            }
        }
    }
}