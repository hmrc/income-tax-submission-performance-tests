package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._

object DividendsRequests extends ServicesConfiguration {

  def getUKDividendsStatusPage = http("get UK Dividends Status Page")
    .get(s"$serviceUrl/dividends/dividend-uk-status")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsStatusPage = http("post UK Dividends Status Page")
    .post(s"$serviceUrl/dividends/dividend-uk-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getUKDividendsAmountPage = http("get UK Dividends Amount Page")
    .get(s"$serviceUrl/dividends/dividend-uk-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsAmountPage = http("post UK Dividends Amount Page")
    .post(s"$serviceUrl/dividends/dividend-uk-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "1000")
    .check(status.is(303))

  def getOtherDividendsStatusPage = http("get Other Dividends Status Page")
    .get(s"$serviceUrl/dividends/other-dividend-status")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsStatusPage = http("post Other Dividends Status Page")
    .post(s"$serviceUrl/dividends/other-dividend-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getOtherDividendsAmountPage = http("get Other Dividends Amount Page")
    .get(s"$serviceUrl/dividends/other-dividend-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsAmountPage = http("post Other Dividends Amount Page")
    .post(s"$serviceUrl/dividends/other-dividend-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "1000")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage = http("get Dividends Check Your Answers Page")
    .get(s"$serviceUrl/dividends/summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage = http("post Dividends Check Your Answers Page")
    .post(s"$serviceUrl/dividends/summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
