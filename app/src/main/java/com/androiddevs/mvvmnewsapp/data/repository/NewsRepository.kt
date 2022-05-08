package com.androiddevs.mvvmnewsapp.data.repository

import androidx.lifecycle.LiveData
import com.androiddevs.mvvmnewsapp.data.models.Article
import com.androiddevs.mvvmnewsapp.data.models.NewsResponse
import retrofit2.Response

interface NewsRepository {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int): Response<NewsResponse>

    suspend fun searchNews(searchQuery: String, pageNumber: Int): Response<NewsResponse>

    suspend fun upsert(article : Article) : Long

    fun getSavedNews() : LiveData<List<Article>>

    suspend fun deleteArticle(article: Article)
}
