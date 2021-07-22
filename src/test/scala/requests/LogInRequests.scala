package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._


object LogInRequests {

	def getStartPage = {
		exec(http("Get start page")
			.get("/client/")
			.check(status.is(200))
		)
	}

	def getLoginPage = {
		exec(http("Get login page")
			.get("/client/login")
		)
	}

	def submitLoginDetails = {
		exec(http("Submit login details")
			.post("/client/login")
			.formParam("crn", "CRN0E64177C")
			.formParam("password", "password123")
			.disableFollowRedirect
			.check(status.is(303))
			.check(header("Location").is("/client/dashboard"))
		)
	}

	def getDashboardPage = {
		exec(http("Get dash page")
			.get("/client/dashboard")
			.check(status.is(200))
		)
	}

	def addAgent = {
		exec(http("Add an agent")
			.post("/client/arn-submit")
			.formParam("arn", "ARN63D81410")
			.disableFollowRedirect
			.check(status.is(200))
		)
	}

	def removeAgent = {
		exec(http("Remove an agent")
			.get("/client/arn-remove")
			.disableFollowRedirect
			.check(status.is(200))
		)
	}

	def submitLogout = {
		exec(http("Logout")
			.get("/client/successful-logout")
			.check(status.is(200))
		)
	}

}
