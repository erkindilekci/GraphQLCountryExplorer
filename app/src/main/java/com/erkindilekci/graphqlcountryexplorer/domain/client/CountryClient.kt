package com.erkindilekci.graphqlcountryexplorer.domain.client

import com.erkindilekci.graphqlcountryexplorer.domain.model.DetailedCountry
import com.erkindilekci.graphqlcountryexplorer.domain.model.SimpleCountry

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}
