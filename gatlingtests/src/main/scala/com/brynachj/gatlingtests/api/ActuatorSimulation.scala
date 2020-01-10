package com.brynachj.gatlingtests.api

import com.typesafe.config.ConfigFactory
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._


class ActuatorSimulation extends Simulation {

  private val targetConf = System.getProperty("CLIENT")
  private val confName = if (targetConf != null) "application-" + targetConf else "application"
  private val conf = ConfigFactory.load(confName)
  private val coreBaseUrl = conf.getString("services.api.baseUrl")
  private val contentType = "application/json"
  private val restTemplateMugEndpoint = "tea/mug"
  private val restTemplateTeabagEndpoint = "tea/teabag"
  private val restTemplateHotWaterEndpoint = "tea/hot-water"
  private val restTemplateMilkEndpoint = "tea/milk"

  private val requestCount = Integer.getInteger("REQUESTS", 40)

  val httpProtocol = http
    .baseUrl(coreBaseUrl)
    .acceptHeader(contentType)

  val restTemplateMugScenario: ScenarioBuilder = scenario("Get mug request")
    .exec(http(targetConf + " MugRequest")
    .get(restTemplateMugEndpoint)
    .check(status.is(200)))

  val restTemplateTeabagScenario: ScenarioBuilder = scenario("Get teabag request")
    .exec(http(targetConf + " TeabagRequest")
      .get(restTemplateTeabagEndpoint)
      .check(status.is(200)))

  val restTemplateHotWaterScenario: ScenarioBuilder = scenario("Get hot water request")
    .exec(http(targetConf + " HotWaterRequest")
      .get(restTemplateHotWaterEndpoint)
      .check(status.is(200)))

  val restTemplateMilkScenario: ScenarioBuilder = scenario("Get milk request")
    .exec(http(targetConf + " MilkRequest")
      .get(restTemplateMilkEndpoint)
      .check(status.is(200)))

  setUp(restTemplateMugScenario.inject(atOnceUsers(requestCount)),
    restTemplateTeabagScenario.inject(atOnceUsers(requestCount)),
    restTemplateHotWaterScenario.inject(atOnceUsers(requestCount)),
    restTemplateMilkScenario.inject(atOnceUsers(requestCount))).protocols(httpProtocol)
}