package com.example.mfpa.module

import android.content.Context
import com.example.mfpa.Application.ApplicationClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Singleton
    @Provides
    fun provideApp (@ApplicationContext app:Context) : ApplicationClass{

        return app as ApplicationClass
    }

}