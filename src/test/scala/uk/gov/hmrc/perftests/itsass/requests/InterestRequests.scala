/*
 * Copyright 2022 HM Revenue & Customs
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

  def getInterestSummaryPage: HttpRequestBuilder = http("Get Interest Summary Page")
    .get(s"$interestUrl/interest-summary")
    .check(saveCsrfToken())
    .check(status.is(200))

  def getInterestGatewayPage: HttpRequestBuilder = http("Get Interest Gateway Page")
    .get(s"$interestUrl/interest-from-UK")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestGatewayPage: HttpRequestBuilder = http("Post Interest Gateway Page")
    .post(s"$interestUrl/interest-from-UK")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedUKInterestStatusPage: HttpRequestBuilder = http("Get Untaxed UK Interest Status Page")
    .get(s"$interestUrl/untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestStatusPage: HttpRequestBuilder = http("Post Untaxed UK Interest Status Page")
    .post(s"$interestUrl/untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedChooseAccountRedirect: HttpRequestBuilder = http("Get ID for Untaxed Amount Controller")
    .get(s"$interestUrl/which-account-did-you-get-untaxed-interest-from")
    .check(saveUntaxedAccountId)
    .check(status.is(303))

  def getUntaxedUKInterestDetailsPage: HttpRequestBuilder = http("Get Untaxed UK Interest Details Page")
    .get(s"$interestUrl/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestDetailsPage(accountName: String): HttpRequestBuilder = http("Post Untaxed UK Interest Details Page")
    .post(s"$interestUrl/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("untaxedAccountName", s"$accountName")
    .formParam("untaxedAmount", "1000")
    .check(status.is(303))

  def getUntaxedUKInterestSummaryPage: HttpRequestBuilder = http("Get Untaxed UK Interest Summary Page")
    .get(s"$interestUrl/accounts-with-untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestSummaryPage(addAnotherAccount: Boolean): HttpRequestBuilder = http("Post Untaxed UK Interest Summary Page")
    .post(s"$interestUrl/accounts-with-untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getTaxedUKInterestStatusPage: HttpRequestBuilder = http("Get Taxed UK Interest Status Page")
    .get(s"$interestUrl/taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestStatusPage: HttpRequestBuilder = http("Post Taxed UK Interest Status Page")
    .post(s"$interestUrl/taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxedChooseAccountPage: HttpRequestBuilder = http("Get Choose Account Page")
    .get(s"$interestUrl/which-account-did-you-get-taxed-interest-from")
    .check(status.is(200))

  def postTaxedChooseAccountPage: HttpRequestBuilder = http("Post Choose Account Page")
    .post(s"$interestUrl/which-account-did-you-get-taxed-interest-from")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "eb687fc3-37fc-4b7d-8038-19aaf62f9681-111-eb687fc3-37fc-4b7d-8038-19aaf62f9681")
    .check(saveTaxedAccountId)
    .check(status.is(303))

  def getTaxedUKInterestDetailsPage: HttpRequestBuilder = http("Get Taxed UK Interest Details Page")
    .get(s"$interestUrl/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestDetailsPage(accountName: String): HttpRequestBuilder = http("Post Taxed UK Interest Details Page")
    .post(s"$interestUrl/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("taxedAccountName", s"$accountName")
    .formParam("taxedAmount", "1000")
    .check(status.is(303))

  def getTaxedUKInterestSummaryPage: HttpRequestBuilder = http("Get Taxed UK Interest Summary Page")
    .get(s"$interestUrl/accounts-with-taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestSummaryPage(addAnotherAccount: Boolean): HttpRequestBuilder = http("Post Taxed UK Interest Summary Page")
    .post(s"$interestUrl/accounts-with-taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getInterestCheckYourAnswersPage: HttpRequestBuilder = http("Get Interest Check Your Answers Page")
    .get(s"$interestUrl/check-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestCheckYourAnswersPage: HttpRequestBuilder = http("Post Interest Check Your Answers Page")
    .post(s"$interestUrl/check-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestFromSecuritiesPage: HttpRequestBuilder = http("Get Interest From Securities")
    .get(s"$interestUrl/interest-from-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestFromSecuritiesPage: HttpRequestBuilder = http("Post Interest From Securities")
    .post(s"$interestUrl/interest-from-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getTaxTakenFromInterestPage: HttpRequestBuilder = http("Get How Much Interest Did You Get Page")
    .get(s"$interestUrl/interest-from-securities/interest-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxTakenFromInterestPage: HttpRequestBuilder = http("Post How Much Interest Did You Get Page")
    .post(s"$interestUrl/interest-from-securities/interest-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestSecuritiesAmountPage: HttpRequestBuilder = http("Get Was Tax Taken Off Your Interest Page")
    .get(s"$interestUrl/interest-from-securities/tax-taken-from-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestSecuritiesAmountPage: HttpRequestBuilder = http("Post Was Tax Taken Off Your Interest Page")
    .post(s"$interestUrl/interest-from-securities/tax-taken-from-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getTaxSecuritiesAmountPage: HttpRequestBuilder = http("Get How Much Tax Was Taken Off Page")
    .get(s"$interestUrl/interest-from-securities/tax-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxSecuritiesAmountPage: HttpRequestBuilder = http("Get How Much Tax Was Taken Off Page")
    .post(s"$interestUrl/interest-from-securities/tax-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getSecuritiesCheckYourAnswersPage: HttpRequestBuilder = http("Get Check Your Interest From Gilt Edged Or Accrued Income Securities Page")
    .get(s"$interestUrl/interest-from-securities/check-interest-from-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def posttSecuritiesCheckYourAnswersPage: HttpRequestBuilder = http("Post Check Your Interest From Gilt Edged Or Accrued Income Securities Page")
    .post(s"$interestUrl/interest-from-securities/check-interest-from-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))


}
