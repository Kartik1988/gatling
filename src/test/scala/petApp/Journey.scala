package petApp

import io.gatling.core.scenario.Simulation
import configuration.TestConfiguration
import configuration.HttpConfiguration
import io.gatling.core.Predef._
import io.gatling.core.Predef.atOnceUsers
import io.gatling.core.structure.{PopulationBuilder, ScenarioBuilder}


import scala.concurrent.duration._


trait simulationConfiguration extends Simulation with Scenario {

  val constantRateTime: FiniteDuration
  val rampupTime: FiniteDuration
  val rampdownTime: FiniteDuration
  val timeoutAtEndofTest: FiniteDuration = DurationInt(10).minutes
  lazy val load = TestConfiguration.userpersecond
}

class Journey extends simulationConfiguration
{
  override val constantRateTime:FiniteDuration = DurationInt(TestConfiguration.constantratetime).minutes
  override val rampupTime:FiniteDuration = DurationInt(TestConfiguration.rampuptime).minutes
  override val rampdownTime:FiniteDuration = DurationInt(TestConfiguration.rampdowntime).minutes


  setUp(petStore.inject(constantUsersPerSec(2) during (60 seconds)))

}

