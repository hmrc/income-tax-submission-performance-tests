/*
 * Copyright 2025 HM Revenue & Customs
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

  def getPropertyDetailsPage(taxYear: String): HttpRequestBuilder = http("Get UK Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/start")
    .check(status.is(expected = 200))

  def getPropertyTotalIncome(taxYear: String): HttpRequestBuilder = http("Get Total Income page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/total-income")
    .check(status.is(expected = 200))

  def postPropertyTotalIncome(taxYear: String): HttpRequestBuilder = http("Post Total Income page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/total-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "over")
    .check(status.is(303))

  def getPropertyReportIncome(taxYear: String): HttpRequestBuilder = http("Get Property Report Income Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/report-property-income")
    .check(status.is(expected = 200))

  def postPropertyReportIncome(taxYear: String): HttpRequestBuilder = http("Post Property Report Income Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/report-property-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("reportPropertyIncome", true)
    .check(status.is(303))

  def getWhichRentalPropertyUK(taxYear: String): HttpRequestBuilder = http("Get Which Rental Property Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/rental-property")
    .check(status.is(expected = 200))

  def postWhichRentalPropertyUK(taxYear: String): HttpRequestBuilder = http("Post Which Rental Property Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/rental-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[0]", "property.rentals")
    .check(status.is(303))

  def getCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check Your Answers Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .check(status.is(expected = 200))

  def postCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Check Your Answers Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Have You Finished Section Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/complete-yes-no")
    .check(status.is(expected = 200))

  def postHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Have You Finished Section Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isAboutPropertyComplete", "true")
    .check(status.is(303))

  def getPropertyRentalsAbout(taxYear: String): HttpRequestBuilder = http("Get Property Rentals About Page")
    .get(s"${propertyUrl(taxYear)}/rentals-rent-a-room/start")
    .check(status.is(expected = 200))

  def getJointlyLetRentARoom(taxYear: String): HttpRequestBuilder = http("Get Jointly Let Rent A Room Page")
    .get(s"${propertyUrl(taxYear)}/rentals-rent-a-room/jointly-let")
    .check(status.is(expected = 200))

  def postJointlyLetRentARoom(taxYear: String): HttpRequestBuilder = http("Post Jointly Let Rent A Room Page")
    .post(s"${propertyUrl(taxYear)}/rentals-rent-a-room/jointly-let")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTotalRentARoomIncome(taxYear: String): HttpRequestBuilder = http("Get Total Rent A Room Income Page")
    .get(s"${propertyUrl(taxYear)}/rentals-rent-a-room/total-income-amount")
    .check(status.is(expected = 200))

  def postTotalRentARoomIncome(taxYear: String): HttpRequestBuilder = http("Post Total Rent A Room Income Page")
    .post(s"${propertyUrl(taxYear)}/rentals-rent-a-room/total-income-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("totalIncomeAmount", "1000")
    .check(status.is(303))

  //-----------------------------UK Property Rentals About------------------------------------------------
  def getPropertyRentalsStartPage(taxYear: String): HttpRequestBuilder = http("Get Property Rentals Start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/start")
    .check(status.is(expected = 200))

  def getPropertyClaimPIAorExpensesProperty(taxYear: String): HttpRequestBuilder = http("Get claim PIA or Expenses page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/claim-property-income-allowance")
    .check(status.is(expected = 200))

  def postClaimExpenses(taxYear: String): HttpRequestBuilder = http("Post Claim Expenses Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/claim-property-income-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isClaimPropertyIncomeAllowance", "false")
    .check(status.is(303))

  def getRentalsCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Rentals Check Your Answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .check(status.is(expected = 200))

  def postRentalsCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Rentals Check Your Answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getRentalsHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get RentalsHave You Finished Section Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/complete-yes-no")
    .check(status.is(expected = 200))

  def postRentalsHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Rentals Check Your Answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isAboutPropertyRentalsSectionFinished", "true")
    .check(status.is(303))


  //-----------------------------Income------------------------------------------------
  def getPropertyRentalsIncomeStartPage(taxYear: String): HttpRequestBuilder = http("Get Property Rentals Income Start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/start")
    .check(status.is(expected = 200))

  def getPropertyRentalsIncomeNonUKResidentLandlordPage(taxYear: String): HttpRequestBuilder = http("Get Property Rentals Non-UK Resident Landlord Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/is-non-uk-landlord")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeNonUKResidentLandlordPage(taxYear: String): HttpRequestBuilder = http("Post Property Rentals Non-UK Resident Landlord Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/is-non-uk-landlord")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isNonUKLandlord", "true")
    .check(status.is(303))

  def getPropertyRentalsIncomeDeductingTaxPage(taxYear: String): HttpRequestBuilder = http("Get Property Rentals Income Deducting Tax Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/deducting-tax")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeDeductingTaxPage(taxYear: String): HttpRequestBuilder = http("Post Property Rentals Income Deducting Tax Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/deducting-tax")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isTaxDeducted", "true")
    .formParam("taxDeductedAmount", "800")
    .check(status.is(303))

  def getPropertyRentalsIncomePropertyRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Property Rentals Total Income Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/property-rental-income")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomePropertyRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Property Rentals Total Income Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/property-rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("propertyRentalIncome", "90000")
    .check(status.is(303))

  def getPropertyRentalsIncomePremiumsGrantLeasePage(taxYear: String): HttpRequestBuilder = http("Get Premiums Grant Lease Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/lease-premium-payment")
    .check(status.is(expected = 200))


}

