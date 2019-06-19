package me.gladwell.johnlewis

import org.spekframework.spek2.Spek
import assertk.assertThat
import assertk.assertions.*

import me.gladwell.johnlewis.BoostRule.Companion.validate

object RuleTests: Spek({

    group("validation") {

        test("succeeds for numeric ID") {
            val rule = BoostRule(ProductId("123"))
            assertThat(validate(rule).isValid).isTrue()
        }

        test("fails for non-numeric ID") {
            val rule = BoostRule(ProductId("not-an-id"))
            assertThat(validate(rule).isInvalid).isTrue()
        }

    }

})
