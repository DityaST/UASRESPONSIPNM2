
package com.ditya.disneyfilmuas.recycler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// merupakan tampilan atau gambar gambar didalam aplikasi ini yang mana bagian untuk untuk menampilkan
// informasi detail nama film deskripsi film gambar dan durasi film
@Parcelize
data class Poster(
  val name: String,
  val release: String,
  val playtime: String,
  val description: String,
  val poster: String
) : Parcelable
