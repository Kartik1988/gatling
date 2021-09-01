package petApp

import configuration.TestConfiguration
import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.jdbc.Predef._
import scala.util.Random


trait Scenario {


lazy val DataCentre = TestConfiguration.dataCenter
  var baseUrl:String = null


if(DataCentre == "Stage")
  {
    baseUrl = "https://petstore.swagger.io"
  }

else if(DataCentre == "Test")
  {
    baseUrl = "https://petstore.swagger.io"
  }

  val Ids = Iterator.continually(Map("id" ->Random.nextInt(5)))

  val header = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json"
  )


  val addNewPet = scenario("Add a new pet to the store")
    .exec(
      http("Add a new pet to the store" + baseUrl)
        .post(baseUrl + "/v2/pet")
        .headers(header)
        .body(ElFileBody("jsonfile/AddPet.json"))
        .check(status.is(200))

        )

  val verifyNewPet = scenario("Verify pet to the store as per status")
    .exec(
      http("Verify pet to the store as per status" + baseUrl)
        .get(baseUrl + "/v2/pet/findByStatus?available")
        .headers(header)
        .check(status.is(200))

    )


val petStore = addNewPet.exec(verifyNewPet)

}
