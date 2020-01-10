package com.brynachj.gatlingtests.basic

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._


class ActuatorSimulation extends Simulation {

  private val targetConf = System.getProperty("ENV")
  private val confName = if (targetConf != null) "application-" + targetConf else "application"
  private val conf = ConfigFactory.load(confName)
  private val coreBaseUrl = conf.getString("services.basic.baseUrl")
  private val contentType = "application/json"
  private val endpoint = ""
  private val additionalEndpoint = ""

  private val requestCount = Integer.getInteger("REQUESTS", 1)

  val httpProtocol = http
    .baseUrl(coreBaseUrl)
    .acceptHeader(contentType)

  val basicScenario: ScenarioBuilder = scenario("Get basic request")
    .exec(http("BasicRequest")
    .get(endpoint)
    .check(status.is(200)))

  setUp(basicScenario.inject(atOnceUsers(requestCount))).protocols(httpProtocol)

}