package com.erkindilekci.graphqlcountryexplorer.data

import com.apollographql.apollo3.ApolloClient
import com.erkindilekci.CountriesQuery
import com.erkindilekci.CountryQuery
import com.erkindilekci.graphqlcountryexplorer.domain.CountryClient
import com.erkindilekci.graphqlcountryexplorer.domain.DetailedCountry
import com.erkindilekci.graphqlcountryexplorer.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}