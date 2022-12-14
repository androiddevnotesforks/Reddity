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
package com.reddity.app.domain.usecase

import com.reddity.app.data.repository.RedditPostsRepository
import com.reddity.app.model.PostVoteStatus
import com.reddity.app.model.Result
import javax.inject.Inject

class ChangePostVoteStatusUseCase @Inject constructor(
    private val redditPostsRepository: RedditPostsRepository
) {
    suspend operator fun invoke(postId: String, vote: PostVoteStatus): Result<Unit> =
        redditPostsRepository.postVote(postId = postId, request = vote)
}