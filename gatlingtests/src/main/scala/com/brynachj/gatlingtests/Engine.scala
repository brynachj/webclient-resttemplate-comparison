package com.brynachj.gatlingtests

import io.gatling.core.config.GatlingPropertiesBuilder

object Engine extends App {

  val props = new GatlingPropertiesBuilder()
    .resourcesDirectory(IDEPathHelper.resourcesDirectory.toString)
    .resultsDirectory(IDEPathHelper.resultsDirectory.toString)
    .binariesDirectory(IDEPathHelper.mavenBinariesDirectory.toString)

}
