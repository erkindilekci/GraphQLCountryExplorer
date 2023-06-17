package com.erkindilekci.graphqlcountryexplorer.domain.use_cases

import com.erkindilekci.graphqlcountryexplorer.domain.client.CountryClient
import com.erkindilekci.graphqlcountryexplorer.domain.model.DetailedCountry

class GetCountryUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}
