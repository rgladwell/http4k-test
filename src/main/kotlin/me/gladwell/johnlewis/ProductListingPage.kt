package me.gladwell.johnlewis

data class ProductListingPage(
    val category: CategoryId,
    val rules: Collection<Rule>
)
