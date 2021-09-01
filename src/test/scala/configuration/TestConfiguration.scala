package configuration

import com.typesafe.config.{Config, ConfigFactory}
import net.sf.saxon.s9api.Serializer.Property

import scala.util.Properties

object TestConfiguration {

  private val rootConfig:Config = ConfigFactory.load()

  val host = readProperty("perftest.component.host")
  val port = readProperty("perftest.component.port")
  val protocol = readProperty("perftest.component.protocol")
  val hostpremises = readProperty("perftest.component.hostpremises")
  val protocolpremises = readProperty("perftest.component.protocolpremises")
  val rampuptime = readInt("perftest.ramup_time")
  val rampdowntime = readInt("perftest.rempdown_time")
  val  constantratetime = readInt("perftest.constant_rate_time")
  val  userpersecond = readInt("perftest.user_per_second")
  val  loadforendurance = readInt("perftest.load_for_endurance")
  val  dataCenter = readProperty("perftest.dataCenter")





  private def readProperty(property: String) =
    {
      Properties.propOrElse(property,rootConfig.getString(property))
    }

  private def readInt(property:String) =
    {
      rootConfig.getInt(property)
    }


}
