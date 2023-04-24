package com.example.diaryapp.di

import android.content.Context
import androidx.room.Room
import com.example.diaryapp.data.repository.database.DateConverter
import com.example.diaryapp.data.repository.database.DiaryDatabase
import com.example.diaryapp.utils.Constants.DIARY_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideConverter() = DateConverter()

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DiaryDatabase {
        return Room.databaseBuilder(
            context = context, klass = DiaryDatabase::class.java, name = DIARY_DATABASE
        )
            .addTypeConverter(DateConverter()).build()
    }

    @Singleton
    @Provides
    fun provideDiaryDao(database: DiaryDatabase) = database.diaryDao()
}