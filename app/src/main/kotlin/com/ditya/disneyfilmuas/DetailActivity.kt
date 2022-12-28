/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ditya.disneyfilmuas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.ditya.transformationlayout.TransformationAppCompatActivity
import com.ditya.transformationlayout.TransformationCompat
import com.ditya.transformationlayout.TransformationLayout
import com.ditya.disneyfilmuas.databinding.ActivityDetailBinding
import com.ditya.disneyfilmuas.recycler.Poster

class DetailActivity : TransformationAppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val binding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(binding.root)

    intent.getParcelableExtra<Poster>(posterExtraName)?.let {
      Glide.with(this)
        .load(it.poster)
        .into(binding.profileDetailBackground)
      binding.detailTitle.text = it.name
      binding.detailDescription.text = it.description
    }
  }

  companion object {
    const val posterExtraName = "posterExtraName"
    fun startActivity(
      context: Context,
      transformationLayout: TransformationLayout,
      poster: Poster
    ) {
      val intent = Intent(context, DetailActivity::class.java)
      intent.putExtra(posterExtraName, poster)
      TransformationCompat.startActivity(transformationLayout, intent)
    }
  }
}
