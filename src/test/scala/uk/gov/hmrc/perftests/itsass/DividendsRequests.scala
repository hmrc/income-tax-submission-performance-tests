package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._

object DividendsRequests extends ServicesConfiguration {

  def getUKDividendsStatusPage = http("get UK Dividends Status Page")
    .get(s"$serviceUrl/personal-income/dividends/uk-dividends")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsStatusPage = http("post UK Dividends Status Page")
    .post(s"$serviceUrl/personal-income/dividends/uk-dividends")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yesNoValue", "yes")
    .check(status.is(303))

  def getUKDividendsAmountPage = http("get UK Dividends Amount Page")
    .get(s"$serviceUrl/personal-income/dividends/uk-dividends-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsAmountPage = http("post UK Dividends Amount Page")
    .post(s"$serviceUrl/personal-income/dividends/uk-dividends-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOtherDividendsStatusPage = http("get Other Dividends Status Page")
    .get(s"$serviceUrl/personal-income/dividends/other-dividends")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsStatusPage = http("post Other Dividends Status Page")
    .post(s"$serviceUrl/personal-income/dividends/other-dividends")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yesNoValue", "yes")
    .check(status.is(303))

  def getOtherDividendsAmountPage = http("get Other Dividends Amount Page")
    .get(s"$serviceUrl/personal-income/dividends/other-dividends-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsAmountPage = http("post Other Dividends Amount Page")
    .post(s"$serviceUrl/personal-income/dividends/other-dividends-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage = http("get Dividends Check Your Answers Page")
    .get(s"$serviceUrl/personal-income/dividends/check-your-answers")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage = http("post Dividends Check Your Answers Page")
    .post(s"$serviceUrl/personal-income/dividends/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
