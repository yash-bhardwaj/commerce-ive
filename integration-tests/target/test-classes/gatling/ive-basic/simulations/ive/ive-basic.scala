/**
 * Copyright 2011-2017 GatlingCorp (http://gatling.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rccl.commerce.ive

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class IVEBasicSimulation extends Simulation {

  final val requestTemplate = """
  {

  "cruiseBookingID": "${cruiseBookingId}",
  "guestID": "${guestId}",
  "shipSailDate": "${shipSailDate}",
  "eventGroupType": "COMMERCE",
  "eventGroupDescription": "Shore Excursion",
  "eventID": "0",
  "eventType": "SHOREX",
  "eventName": "Shore Excursion Test",
  "eventLocale": "en_US",
  "eventLocation": {
    "locationCode": "MIA",
    "locationType": "PORT",
    "locationName": "Miami"
  },
  "eventStartTime": {
    "eventDate": "2017-06-12",
    "eventTime": "09:00",
    "eventTimeZone": "GMT-5"
  },
  "eventEndTime": {
    "eventDate": "2017-06-12",
    "eventTime": "12:00",
    "eventTimeZone": "GMT-5"
  },
  "sourceDetail": {
    "sourceSystemApplicationID": "PCP",
    "sourceSystemReservationID": "100001",
    "sourceSystemOrderID": "11111",
    "sourceSystemExternalOrderID": "",
    "sourceSystemProductID": "12345",
    "sourceSystemOfferingID": "1234501",
    "sourceSystemProductName": "Beach Tour"
  },
  "attendees": [
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "${guestId}",
      "sailingID": "${shipSailDate}",
      "firstName": "${firstName}",
      "lastName": "${lastName}"
    },
    {
      "cruiseReservationID": "42793",
      "guestID": "202020",
      "sailingID": "${shipSailDate}",
      "firstName": "Shih-Chien",
      "lastName": "Lu"
    }
  ]

}"""

  object UpdateEvents {
    val headersWithKey = Map("Content-Type" -> "application/json", "api-key" -> "test")

    val feeder = csv("ive-basic.csv").random

    val updateCommerceEvent = feed(feeder).exec(http("Home")
      .post("/api/v1/events/commerce/${shipSailDate}")
      .headers(headersWithKey)
      .body(StringBody(requestTemplate))
      )
      .pause(1)

  }

  object GetMyItineraries {
    val headersWithKey = Map("Content-Type" -> "application/json", "api-key" -> "test")

    // repeat is a loop resolved at RUNTIME
    val browse = repeat(4, "i") { // Note how we force the counter name so we can reuse it
      exec(http("GetMyItineraries ${i}")
        .get("/api/v1/myItineraries/AL20170820/42793/191919?p=${i}")
        .headers(headersWithKey))
        .pause(1)
    }
  }

  val httpConf = http
    .baseURL("http://localhost:9000")
    .acceptHeader("application/json,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val users = scenario("Users").exec(UpdateEvents.updateCommerceEvent, GetMyItineraries.browse)

  setUp(
    users.inject(rampUsers(1000) over (5 seconds))
  ).protocols(httpConf)
}
