package commerce.ive

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._
import scala.util.Random


class Simulations extends Simulation {

 // val feeder = csv("input.csv").circular
  
  val feeder = Iterator.continually(
           Map("firstName" -> (Random.alphanumeric.take(20).mkString),
           "lastName" -> (Random.alphanumeric.take(20).mkString),
           "cruiseBookingId" -> (Random.nextInt(99999999)),
           "guestId" -> (Random.nextInt(99999999)),
           "shipSailDate" -> "AL20170820"))
  
  final val requestDiningTemplate : String = """
  {
  "cruiseBookingID": "${cruiseBookingId}",
  "guestID": "${guestId}",
  "shipSailDate": "${shipSailDate}",
  "eventGroupType": "DINING",
  "eventGroupDescription": "Dining Events",
  "eventID": "0",
  "eventType": "SPECIALTYDINING",
  "eventName": "Dinner at Chops Grill",
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
		"sourceSystemApplicationID" : "SILVERWHERE",
		"sourceSystemReservationID" : "3567890957807488",
		"sourceSystemOrderID" : "",
		"sourceSystemExternalOrderID": "3567890",
		"sourceSystemProductID" : "CHOPDINNER",
		"sourceSystemOfferingID" : "CHOPDNNER01",
		"sourceSystemProductName" : "Chops Grill"
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
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202021",
      "sailingID": "${shipSailDate}",
      "firstName": "Shih-Chien",
      "lastName": "Lu"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202022",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname2",
      "lastName": "lastname2"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202023",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname3",
      "lastName": "lastname3"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202024",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname4",
      "lastName": "lastname4"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202025",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname5",
      "lastName": "lastname5"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202026",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname6",
      "lastName": "lastname6"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202027",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname7",
      "lastName": "lastname7"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202028",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname8",
      "lastName": "lastname8"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202029",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname9",
      "lastName": "lastname9"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202010",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname10",
      "lastName": "lastname10"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202011",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname11",
      "lastName": "lastname11"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202012",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname12",
      "lastName": "lastname12"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202013",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname13",
      "lastName": "lastname13"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202014",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname14",
      "lastName": "lastname14"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202015",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname15",
      "lastName": "lastname15"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202016",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname16",
      "lastName": "lastname16"
    }
  ]

}"""
  
  
  final val requestCommerceTemplate : String = """
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
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202021",
      "sailingID": "${shipSailDate}",
      "firstName": "Shih-Chien",
      "lastName": "Lu"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202022",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname2",
      "lastName": "lastname2"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202023",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname3",
      "lastName": "lastname3"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202024",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname4",
      "lastName": "lastname4"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202025",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname5",
      "lastName": "lastname5"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202026",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname6",
      "lastName": "lastname6"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202027",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname7",
      "lastName": "lastname7"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202028",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname8",
      "lastName": "lastname8"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202029",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname9",
      "lastName": "lastname9"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202010",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname10",
      "lastName": "lastname10"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202011",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname11",
      "lastName": "lastname11"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202012",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname12",
      "lastName": "lastname12"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202013",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname13",
      "lastName": "lastname13"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202014",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname14",
      "lastName": "lastname14"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202015",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname15",
      "lastName": "lastname15"
    },
    {
      "cruiseReservationID": "${cruiseBookingId}",
      "guestID": "202016",
      "sailingID": "${shipSailDate}",
      "firstName": "firstname16",
      "lastName": "lastname16"
    }
  ]

}"""
  
  val headers_0 = Map(
		"Content-Type" -> "application/json",
		"api-key" -> "123")

	val headers_1 = Map("api-key" -> "123")
  
  object update {
    val dining = repeat(10) {
      feed(feeder).exec(http("Dining Update")
			.post("/api/v1/events/dining/${shipSailDate}")
			.headers(headers_0)
			.body(StringBody(requestDiningTemplate)))
		  .pause(1)
		  
      //exec(http("DiningUpdate").get("/v1/activities/en/mobile?sailingID=${sailingID}")).feed(feeder)
    }
    val commerce = repeat(10) {
       feed(feeder).exec(http("Cruise Planner Update")
			.post("/api/v1/events/commerce/${shipSailDate}")
			.headers(headers_0)
			.body(StringBody(requestCommerceTemplate)))
		  .pause(1)
		  
      //exec(http("Categories").get("/v1/categories/en/mobile?sailingID=${sailingID}")).feed(feeder)
    }
  }
  
  
  object delete {
      val dining = repeat(10) {
         exec(http("Dining Delete")
			  .delete("/api/v1/events/dining/HM20170309/191919/957807488/4967331/SILVERWHERE/CHOPDINNER01")
			  .headers(headers_1))
			  .pause(1)
      }
      
      val commerce = repeat(10) {
         exec(http("Cruise Planner Delete")
			  .delete("/api/v1/events/commerce/AL20170611/202020/191919/42793/PCP/1234501")
			  .headers(headers_1))
		    .pause(1)
      }
      
  }
  

  val httpConf = http
    .baseURL("http://localhost:9000")
    .acceptHeader("application/json; charset=utf-8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val diningUpdateScenario = scenario("DiningUpdate").exec(update.dining)
  val commerceUpdateScenario = scenario("CommerceUpdate").exec(update.commerce)
  
  val diningDeleteScenario = scenario("DiningDelete").exec(delete.dining)
  val commerceDeleteScenario = scenario("CommerceDelete").exec(delete.commerce)

  
   setUp(
       diningUpdateScenario.inject(rampUsers(25) over (10 seconds)),
       commerceUpdateScenario.inject(rampUsers(25) over (10 seconds)),
       diningDeleteScenario.inject(rampUsers(25) over (10 seconds)),
       commerceDeleteScenario.inject(rampUsers(25) over (10 seconds))
       ).protocols(httpConf)

}

