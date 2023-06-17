package com.erkindilekci.graphqlcountryexplorer.di

import com.apollographql.apollo3.ApolloClient
import com.erkindilekci.graphqlcountryexplorer.data.client.ApolloCountryClient
//import com.erkindilekci.graphqlcountryexplorer.data.client.ApolloCountryClient
import com.erkindilekci.graphqlcountryexplorer.domain.client.CountryClient
import com.erkindilekci.graphqlcountryexplorer.domain.use_cases.GetCountriesUseCase
import com.erkindilekci.graphqlcountryexplorer.domain.use_cases.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(countryClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(countryClient)
    }
}
