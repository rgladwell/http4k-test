package me.gladwell.johnlewis

import kotlin.test.Test
import kotlin.test.assertTrue

class RuleTest {

    @Test
    fun `verify validation succeeds for numeric ID`() {
        val rule = BoostRule(ProductId("123"))
        assertTrue(BoostRule.validate(rule).isValid)
    }

    @Test
    fun `verify validation fails for string ID`() {
        val rule = BoostRule(ProductId("not-an-id"))
        assertTrue(BoostRule.validate(rule).isInvalid)
    }

}
