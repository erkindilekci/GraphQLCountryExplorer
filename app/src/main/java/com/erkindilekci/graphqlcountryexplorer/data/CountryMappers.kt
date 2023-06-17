package com.erkindilekci.graphqlcountryexplorer.data

import com.erkindilekci.CountriesQuery
import com.erkindilekci.CountryQuery
import com.erkindilekci.graphqlcountryexplorer.domain.model.DetailedCountry
import com.erkindilekci.graphqlcountryexplorer.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}
