package me.gladwell.johnlewis

import org.spekframework.spek2.Spek
import kotlin.test.assertTrue

object RuleTests: Spek({

    group("validation") {
        test("succeeds for numeric ID") {
            val rule = BoostRule(ProductId("123"))
            assertTrue(BoostRule.validate(rule).isValid)
        }

        test("fails for non-numeric ID") {
            val rule = BoostRule(ProductId("not-an-id"))
            assertTrue(BoostRule.validate(rule).isInvalid)
        }
    }

})
