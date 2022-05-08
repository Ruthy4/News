package com.androiddevs.mvvmnewsapp.data.di

import com.androiddevs.mvvmnewsapp.data.remote.api.NewsAPI
import com.androiddevs.mvvmnewsapp.data.local.db.ArticlesDatabase
import com.androiddevs.mvvmnewsapp.data.repository.NewsRepository
import com.androiddevs.mvvmnewsapp.data.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun providesCardInfoRepository(
        newsApi : NewsAPI,
        database: ArticlesDatabase
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi, database)
    }
}