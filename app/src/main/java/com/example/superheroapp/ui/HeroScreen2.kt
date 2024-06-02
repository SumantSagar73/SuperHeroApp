package com.example.superheroapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.Hero

@Composable
fun HeroItem2(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(8.dp), // Ensure card corners are rounded
        modifier = modifier
            .padding(dimensionResource(R.dimen.padding_medium))
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_medium))
                .fillMaxWidth()
                .sizeIn(minHeight = dimensionResource(R.dimen.image_size)),
            verticalAlignment = Alignment.CenterVertically // Center align items vertically
        ) {
            HeroInformation2(
                heroName = hero.nameRes,
                heroDescription = hero.descriptionRes,
                modifier = Modifier.weight(1f) // Give more space to text
            )
            Spacer(Modifier.width(16.dp))

            HeroIcon2(
                heroIcon = hero.imageRes,
                modifier = Modifier.size(72.dp) // Ensure image size is 72dp
            )
        }
    }
}

@Composable
fun HeroIcon2(
    @DrawableRes heroIcon: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(72.dp) // Set fixed size for the image
            .clip(RoundedCornerShape(8.dp)) // Clip image to rounded corners
    ) {
        Image(
            painter = painterResource(heroIcon),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.Crop // Crop the image to fit within the size
        )
    }
}

@Composable
fun HeroInformation2(
    @StringRes heroName: Int,
    @StringRes heroDescription: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(heroName),
            style = MaterialTheme.typography.bodyLarge, // Use bodyLarge for a smaller text size
            maxLines = 1, // Ensure text does not overflow
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(heroDescription),
            style = MaterialTheme.typography.bodyMedium, // Use bodyMedium for description
            maxLines = 2, // Limit description to 2 lines
            overflow = TextOverflow.Ellipsis // Add ellipsis if text overflows
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroInformationPreview2() {
    HeroInformation2(R.string.hero1, R.string.description1)
}

@Preview(showBackground = true)
@Composable
fun HeroIconPreview2() {
    HeroIcon2(R.drawable.android_superhero1)
}

@Preview
@Composable
fun HeroItemPreview2() {
    HeroItem2(hero = Hero(R.string.hero1, R.string.description1, R.drawable.android_superhero1))
}
