/*
 * Copyright 2022 Fatih OZTURK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.reddity.app.home.listing.footer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reddity.app.home.R
import com.reddity.app.model.PostVoteStatus
import com.reddity.app.model.PostVoteStatus.DOWN_VOTE
import com.reddity.app.model.PostVoteStatus.NONE
import com.reddity.app.model.PostVoteStatus.UPVOTE
import com.reddity.app.ui.commons.LocalReddityTextCreator
import com.reddity.app.ui.theme.ReddityTheme

@Composable
fun ItemVoteView(
    onVoteClicked: (PostVoteStatus) -> Unit = {},
    voteCount: Int,
    voteStatus: PostVoteStatus
) {
    val textCreator = LocalReddityTextCreator.current

    Row {
        RedditVoteButton(
            modifier = Modifier.size(20.dp),
            isVoted = voteStatus == UPVOTE,
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_upvote),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                    contentDescription = null
                )
            },
            selectedIcon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_upvote_fill),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                    contentDescription = null
                )
            },
            onVoteClicked = {
                if (voteStatus == UPVOTE) {
                    onVoteClicked.invoke(NONE)
                } else {
                    onVoteClicked.invoke(UPVOTE)
                }
            }
        )
        Text(
            text = textCreator.postFormattedCountText(voteCount),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = MaterialTheme.colors.onBackground
        )
        RedditVoteButton(
            modifier = Modifier.size(20.dp),
            isVoted = voteStatus == DOWN_VOTE,
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_downvote),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                    contentDescription = null
                )
            },
            selectedIcon = {
                Image(
                    painter = painterResource(id = R.drawable.icon_downvote_fill),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary),
                    contentDescription = null
                )
            },
            onVoteClicked = {
                if (voteStatus == DOWN_VOTE) {
                    onVoteClicked.invoke(NONE)
                } else {
                    onVoteClicked.invoke(DOWN_VOTE)
                }
            }
        )
    }
}

@Composable
fun RedditVoteButton(
    modifier: Modifier,
    isVoted: Boolean = false,
    onVoteClicked: () -> Unit = {},
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
) {
    IconButton(modifier = modifier, onClick = onVoteClicked) {
        if (isVoted) selectedIcon() else icon()
    }
}

@Preview
@Composable
fun VoteViewPreview() {
    ReddityTheme {
        Surface {
            ItemVoteView(voteCount = 2000, voteStatus = NONE)
        }
    }
}