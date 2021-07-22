package clients

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import requests.LogInRequests

class LogInSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://localhost:9008")
		.inferHtmlResources()

	val scn = scenario("LogInSimulation")
		.exec(LogInRequests.getStartPage)
		.exec(LogInRequests.getLoginPage)
		.exec(LogInRequests.submitLoginDetails)
		.exec(LogInRequests.getDashboardPage)
		.exec(LogInRequests.addAgent)
		.exec(LogInRequests.removeAgent)
		.exec(LogInRequests.submitLogout)

	val LogInSimulation =
		setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}
