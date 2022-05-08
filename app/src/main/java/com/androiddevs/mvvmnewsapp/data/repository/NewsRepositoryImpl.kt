package com.androiddevs.mvvmnewsapp.data.repository

import com.androiddevs.mvvmnewsapp.data.remote.api.NewsAPI
import com.androiddevs.mvvmnewsapp.data.local.db.ArticlesDatabase
import com.androiddevs.mvvmnewsapp.data.models.Article

class NewsRepositoryImpl(private val newsApi: NewsAPI, private val database: ArticlesDatabase) :
    NewsRepository {

    override suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        newsApi.getBreakingNews(countryCode, pageNumber)

    override suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        newsApi.SearchForNews(searchQuery, pageNumber)

    override suspend fun upsert(article: Article) = database.getArticleDao().upsert(article)

    override fun getSavedNews() = database.getArticleDao().getAllArticles()

    override suspend fun deleteArticle(article: Article) =
        database.getArticleDao().deleteArticle(article)
}