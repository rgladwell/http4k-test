package me.gladwell.johnlewis

import arrow.data.*
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonSubTypes.Type
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes(
    Type(value = BoostRule::class, name = "boost")
)
sealed class Rule

data class BoostRule(val product: ProductId) : Rule() {

    companion object {

        fun validate(rule: BoostRule): Validated<Exception, BoostRule> {
            return when {
                isNumber(rule.product.id) -> rule.valid()
                else -> Exception().invalid()
            }
        }

        fun isNumber(string: String): Boolean {
            try {
                Integer.parseInt(string)
            } catch(t: Throwable) {
                return false
            }
            return true
        }
    }

}

