package requests

import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._

object LogInRequests {

	def getStartPage: ChainBuilder = {
		exec(http("Get start page")
			.get("/client/")
			.check(status.is(200))
		)
	}

	def getLoginPage = {
		exec(http("Get login page")
		.get("/client/login"))
	}

	def submitLoginDetails = {
		exec(http("Submit login details")
			.post("/client/login")
			.formParam("crn", "CRNFBBB5A55")
			.formParam("password", "123gatling")
			.disableFollowRedirect
			.check(status.is(303))
			.check(header("Location").is("/client/dashboard"))
		)
	}

	def addAgent = {
		exec(http("Submit agent")
			.post("/client/arn-submit")
			.formParam("arn", "ARN63D81410")
			.disableFollowRedirect
			.check(status.is(200))
		)
	}

	def removeAgent = {
		exec(http("Remove agent")
			.get("/client/arn-remove")
			.disableFollowRedirect
			.check(status.is(200))
		)
	}

	def signOut = {
		exec(http("Sign out")
			.get("/client/successful-logout")
			.disableFollowRedirect
			.check(status.is(200))
		)
	}
}
