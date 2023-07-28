package com.bangkit.rakaminsubmission

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface NewsDao {

    @Insert
    suspend fun addToBookmark(newsBookmark: NewsBookmark)

    @Query("SELECT * FROM bookmark_news")
    fun getBookmarkNews(): LiveData<List<NewsBookmark>>

    @Query("SELECT count (*) FROM bookmark_news WHERE bookmark_news.url = :url")
    suspend fun checkNews(url: String): Int

    @Query("DELETE FROM bookmark_news WHERE bookmark_news.url= :url")
    suspend fun removeFromFavorite(url: String) : Int

}