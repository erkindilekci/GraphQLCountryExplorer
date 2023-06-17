package com.erkindilekci.graphqlcountryexplorer.presentation.countryscreen

import com.erkindilekci.graphqlcountryexplorer.domain.model.DetailedCountry
import com.erkindilekci.graphqlcountryexplorer.domain.model.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
