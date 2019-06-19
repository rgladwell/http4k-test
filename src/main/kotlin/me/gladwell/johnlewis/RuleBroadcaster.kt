package me.gladwell.johnlewis

import arrow.data.Validated.Valid

interface RuleBroadcaster {

    fun broadcast(rule: Valid<Rule>)

}
