package com.jo.itsme.ui.composable.strangers

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jo.itsme.model.Post

@Composable
fun StrangerItem(post: Post) {
    Column(modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(5.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(post.user.imageName),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .height(50.dp)
                    .width(50.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                post.user.name,
                modifier = Modifier
                    .padding(2.dp)
                    .weight(1f),
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null
            )
        }

        Image(
            painterResource(post.imageId),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp)
                .clip(RoundedCornerShape(5))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                imageVector = if (post.didLike) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = null
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = null
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null
            )
        }
        Text("${post.likes} J'aime", style = MaterialTheme.typography.titleSmall)
        Text(
            post.description,
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            color = Color(35, 35, 35, 255),
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider()
    }

}