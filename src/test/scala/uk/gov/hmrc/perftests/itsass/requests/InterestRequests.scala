/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object InterestRequests extends ServicesConfiguration {

  def getInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/interest-summary")
    .check(status.is(200))

  def getInterestGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Interest Gateway Page")
    .get(s"${interestUrl(taxYear)}/interest-from-UK")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Interest Gateway Page")
    .post(s"${interestUrl(taxYear)}/interest-from-UK")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Status Page")
    .get(s"${interestUrl(taxYear)}/untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Post Untaxed UK Interest Status Page")
    .post(s"${interestUrl(taxYear)}/untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedChooseAccountRedirect(taxYear: String): HttpRequestBuilder = http("Get ID for Untaxed Amount Controller")
    .get(s"${interestUrl(taxYear)}/which-account-did-you-get-untaxed-interest-from")
    .check(saveUntaxedAccountId)
    .check(status.is(303))

  def getUntaxedUKInterestDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Details Page")
    .get(s"${interestUrl(taxYear)}/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestDetailsPage(accountName: String,taxYear : String): HttpRequestBuilder = http("Post Untaxed UK Interest Details Page")
    .post(s"${interestUrl(taxYear)}/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("untaxedAccountName", s"$accountName")
    .formParam("untaxedAmount", "1000")
    .check(status.is(303))

  def getUntaxedUKInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/accounts-with-untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestSummaryPage(addAnotherAccount: Boolean,taxYear : String): HttpRequestBuilder = http("Post Untaxed UK Interest Summary Page")
    .post(s"${interestUrl(taxYear)}/accounts-with-untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getTaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Status Page")
    .get(s"${interestUrl(taxYear)}/taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Post Taxed UK Interest Status Page")
    .post(s"${interestUrl(taxYear)}/taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxedChooseAccountPage(taxYear: String): HttpRequestBuilder = http("Get Choose Account Page")
    .get(s"${interestUrl(taxYear)}/which-account-did-you-get-taxed-interest-from")
    .check(status.is(200))

  def postTaxedChooseAccountPage(taxYear: String): HttpRequestBuilder = http("Post Choose Account Page")
    .post(s"${interestUrl(taxYear)}/which-account-did-you-get-taxed-interest-from")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "eb687fc3-37fc-4b7d-8038-19aaf62f9681-111-eb687fc3-37fc-4b7d-8038-19aaf62f9681")
    .check(saveTaxedAccountId)
    .check(status.is(303))

  def getTaxedUKInterestDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Details Page")
    .get(s"${interestUrl(taxYear)}/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestDetailsPage(accountName: String,taxYear : String): HttpRequestBuilder = http("Post Taxed UK Interest Details Page")
    .post(s"${interestUrl(taxYear)}/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("taxedAccountName", s"$accountName")
    .formParam("taxedAmount", "1000")
    .check(status.is(303))

  def getTaxedUKInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/accounts-with-taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestSummaryPage(addAnotherAccount: Boolean,taxYear : String): HttpRequestBuilder = http("Post Taxed UK Interest Summary Page")
    .post(s"${interestUrl(taxYear)}/accounts-with-taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getInterestCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Interest Check Your Answers Page")
    .get(s"${interestUrl(taxYear)}/check-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Interest Check Your Answers Page")
    .post(s"${interestUrl(taxYear)}/check-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))


}
