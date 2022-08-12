package com.noisegain.siriuspractice.di.module

import com.noisegain.siriuspractice.data.mapper.TripsMapper
import com.noisegain.siriuspractice.data.mapper.TripsMapperImpl
import com.noisegain.siriuspractice.data.repository.TripsRepositoryImpl
import com.noisegain.siriuspractice.domain.repository.TripsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun tripsRepositoryProvider(repository: TripsRepositoryImpl): TripsRepository {
        return repository
    }
    @Provides
    fun tripsMapperProvider(mapper: TripsMapperImpl): TripsMapper {
        return mapper
    }
}