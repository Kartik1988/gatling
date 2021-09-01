package configuration

import com.typesafe.config._
import io.gatling.http.Predef._
import io.gatling.core.Predef._


import scala.util.Properties

object HttpConfiguration {
  val headers = Map(
    """Accept""" -> """text/html,application""",
    """cache-Control""" -> """no-cache"""
  )

  val postHeader = Map(
    "Cache-Control" -> "max-age=0",
    "Content-Type" -> "application/x-www-form-urlencoded"
  )

  val httpProtocol  = http.acceptHeader("image/png,image/*q=0.8,*/*;q=0.5")
    .acceptEncodingHeader("value=gzip,deflate")
    .acceptLanguageHeader("en-gb en:q=0.5")
    .userAgentHeader("Mozila/5.0 (Macintosh,Intel Mac OS X 10.09;rv:25.0) Gecklo/20100101 Firefox/25.0")
    .baseUrls("www.google.com")
    .shareConnections


 val waitTime = 5

}