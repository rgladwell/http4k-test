package me.gladwell.johnlewis

import org.spekframework.spek2.Spek
import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.assertion.assertThat
import me.gladwell.johnlewis.BoostRule.Companion.validate

val isTrue = equalTo(true)

object RuleTests: Spek({

    group("validation") {
        test("succeeds for numeric ID") {
            val rule = BoostRule(ProductId("123"))
            assertThat(validate(rule).isValid, isTrue)
        }

        test("fails for non-numeric ID") {
            val rule = BoostRule(ProductId("not-an-id"))
            assertThat(validate(rule).isInvalid, isTrue)
        }
    }

})
