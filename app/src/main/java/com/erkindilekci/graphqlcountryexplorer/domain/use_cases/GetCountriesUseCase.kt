package com.erkindilekci.graphqlcountryexplorer.domain.use_cases

import com.erkindilekci.graphqlcountryexplorer.domain.client.CountryClient
import com.erkindilekci.graphqlcountryexplorer.domain.model.SimpleCountry

class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient
            .getCountries()
            .sortedBy { it.name }
    }
}
