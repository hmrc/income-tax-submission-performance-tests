package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests.{personalIncomeBaseUrl, saveCsrfToken}

object InterestRequests extends ServicesConfiguration {
  val interestUrl: String = personalIncomeBaseUrl + "/income-through-software/return/personal-income/2020/interest"

  def getUntaxedUKInterestStatusPage = http("Get Untaxed UK Interest Status Page")
    .get(s"$interestUrl/untaxed-uk-interest")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestStatusPage = http("Post Untaxed UK Interest Status Page")
    .post(s"$interestUrl/untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yes_no", "yes")
    .check(status.is(303))

  def getUntaxedUKInterestDetailsPage = http("Get Untaxed UK Interest Details Page")
    .get(s"$interestUrl/untaxed-uk-interest-details")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestDetailsPage = http("Post Untaxed UK Interest Details Page")
    .post(s"$interestUrl/untaxed-uk-interest-details")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getUntaxedUKInterestSummaryPage = http("Get Untaxed UK Interest Summary Page")
    .get(s"$interestUrl/untaxed-uk-interest-summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestSummaryPage = http("Post Untaxed UK Interest Summary Page")
    .post(s"$interestUrl/untaxed-uk-interest-summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getTaxedUKInterestStatusPage = http("Get Taxed UK Interest Status Page")
    .get(s"$interestUrl/taxed-uk-interest")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestStatusPage = http("Post Taxed UK Interest Status Page")
    .post(s"$interestUrl/taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yes_no", "yes")
    .check(status.is(303))

  def getTaxedUKInterestDetailsPage = http("Get Taxed UK Interest Details Page")
    .get(s"$interestUrl/taxed-uk-interest-details")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestDetailsPage = http("Post Taxed UK Interest Details Page")
    .post(s"$interestUrl/taxed-uk-interest-details")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getTaxedUKInterestSummaryPage = http("Get Taxed UK Interest Summary Page")
    .get(s"$interestUrl/taxed-uk-interest-summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestSummaryPage = http("Post Taxed UK Interest Summary Page")
    .post(s"$interestUrl/taxed-uk-interest-summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestCheckYourAnswersPage = http("Get Interest Check Your Answers Page")
    .get(s"$interestUrl/check-your-answers")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postInterestCheckYourAnswersPage = http("Post Interest Check Your Answers Page")
    .post(s"$interestUrl/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
