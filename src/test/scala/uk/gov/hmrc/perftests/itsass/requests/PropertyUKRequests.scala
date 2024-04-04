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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.propertyUrl


object PropertyUKRequests extends ServicesConfiguration {

  def getPropertySummaryPage(taxYear: String): HttpRequestBuilder = http("Get Property Summary Page")
    .get(s"${propertyUrl(taxYear)}/summary")
    .check(status.is(expected = 200))

  def postPropertySummaryPage (taxYear: String): HttpRequestBuilder = http(" Post Property Summary Page")
    .get(s"${propertyUrl(taxYear)}/summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get UK Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-property-details")
    .check(status.is(expected = 200))

 def postPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Post UK Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-property-details")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", true)
   .check(status.is(303))

 def getPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/total-income")
   .check(status.is(expected = 200))

 def postPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .get(s"${propertyUrl(taxYear)}/total-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", true)
   .check(status.is(303))

 def getPropertyUKSelect(taxYear : String): HttpRequestBuilder = http("Get Property Select Page")
   .get(s"${propertyUrl(taxYear)}/uk-property-select")
   .check(status.is(expected = 200))

  def postPropertyUKSelect(taxYear : String): HttpRequestBuilder = http("Post Property Select Page")
    .get(s"${propertyUrl(taxYear)}/uk-property-select")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

 def getCheckYourAnswers(taxYear : String): HttpRequestBuilder = http("Get Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/check-your-answers")
   .check(status.is(expected = 200))

  def postCheckYourAnswers(taxYear : String): HttpRequestBuilder = http("Post Check Your Answers Page")
    .get(s"${propertyUrl(taxYear)}/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPropertyRentalsAbout(taxYear : String): HttpRequestBuilder = http("Get Property Rentals About Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/property-rentals-start")
    .check(status.is(expected = 200))

  def getExpensesLessThan1000(taxYear : String): HttpRequestBuilder = http ("Get Expenses Less Than 1000 Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/property-rentals-start")
    .check(status.is(expected = 200))

  def getClaimPropertyIncomeAllowance(taxYear : String): HttpRequestBuilder = http ("Get Claim Property Income Allowance Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/claim-property-income-allowance")
    .check(status.is(expected = 200))

  def getPropertyRentalsCYA(taxYear : String): HttpRequestBuilder = http ("Get Property Rentals CYA Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/check-your-answers")
    .check(status.is(expected = 200))

  def getPropertyIncomeStart(taxYear : String): HttpRequestBuilder = http ("Get Property Income Start Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/property-income-start")
    .check(status.is(expected = 200))

  def getNonUkLandlord(taxYear : String): HttpRequestBuilder = http ("Get Is Non-UK Landlord Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/is-non-uk-landlord")
    .check(status.is(expected = 200))

  def getDeductingUKTax(taxYear : String): HttpRequestBuilder = http ("Get Deducting Tax Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/deducting-tax")
    .check(status.is(expected = 200))

  def getIncomePropertyRentals(taxYear : String): HttpRequestBuilder = http ("Get Deducting Tax Page")
    .get(s"${propertyUrl(taxYear)}/property-rentals/income-from-property-rentals")
    .check(status.is(expected = 200))

}
