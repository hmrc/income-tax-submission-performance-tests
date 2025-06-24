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


object PropertyUKAndForeignRequests extends ServicesConfiguration {

  def getUKAndForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-foreign-property/about/start")
    .check(status.is(expected = 200))

 def getUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/total-property-income")
   .check(status.is(expected = 200))

 def postUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/total-property-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "lessThan")
   .check(status.is(303))

 def getUKAndForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Get Property Report Income Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/report-income")
   .check(status.is(expected = 200))

  def postUKAndForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Post Property Report Income Page")
    .post(s"${propertyUrl(taxYear)}/uk-foreign-property/report-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "wantToReport")
    .check(status.is(303))

 def getWhichRentalTypeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Which Rental Property Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/rental-type-uk")
   .check(status.is(expected = 200))

 def postWhichRentalTypeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Which Rental Property Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/rental-type-uk")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value[0]", "propertyRentals")
   .formParam("value[1]", "rentARoom")
   .check(status.is(303))

 def getWhichCountryUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Which Country Did You Receive Income From Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/countries/1")
   .check(status.is(expected = 200))

 def postWhichCountryUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Which Country Did You Receive Income From Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/countries/1")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("country", "CAF")
   .check(status.is(303))

 def getWhereRentedOutPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Countries Where You Rented Out Property Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/countries")
   .check(status.is(expected = 200))

 def postWhereRentedOutPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Countries Where You Rented Out Property Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/countries")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("addAnother", false)
   .check(status.is(303))

 def getClaimExpensesOrReliefPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Claim expenses or rent a room relief Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/claim-expenses-or-relief")
   .check(status.is(expected = 200))

 def postClaimExpensesOrReliefPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Claim expenses or rent a room relief Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/claim-expenses-or-relief")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("ukAndForeignPropertyClaimExpensesOrRelief", true)
   .check(status.is(303))

 def getClaimAllowancePropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Claim property income allowance or expenses Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/claim-property-income-allowance-or-expenses")
   .check(status.is(expected = 200))

 def postClaimAllowancePropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Claim property income allowance or expenses Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/claim-property-income-allowance-or-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("ukAndForeignPropertyClaimPropertyIncomeAllowanceOrExpenses", true)
   .check(status.is(303))

 def getNonUKResidentPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Non-UK resident landlord Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/non-resident-landlord-uk")
   .check(status.is(expected = 200))

 def postNonUKResidentPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Non-UK resident landlord Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/non-resident-landlord-uk")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", true)
   .check(status.is(303))

 def getDeductingTaxFromNonUKResidentPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Deducting tax from non-UK resident landlord Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/deducting-tax-from-non-uk-resident-landlord")
   .check(status.is(expected = 200))

 def postDeductingTaxFromNonUKResidentPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Deducting tax from non-UK resident landlord Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/deducting-tax-from-non-uk-resident-landlord")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isDeductingTaxFromNonUkResidentLandlord", true)
   .formParam("deductingTaxFromNonUkResidentLandlordAmount", 2300)
   .check(status.is(303))

 def getUKPropertyRentalIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get UK property rental income Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/uk-rental-property-income")
   .check(status.is(expected = 200))

 def postUKPropertyRentalIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post UK property rental income Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/uk-rental-property-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("ukRentalPropertyIncomeAmount", 80000)
   .check(status.is(303))

 def getBalancingChargeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Balancing charge Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/balancing-charge")
   .check(status.is(expected = 200))

 def postBalancingChargeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Balancing charge Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/balancing-charge")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isBalancingCharge", true)
   .formParam("balancingChargeAmount", 240)
   .check(status.is(303))

 def getUKPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get UK premiums for the grant of a lease Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/lease-premium-payment")
   .check(status.is(expected = 200))

 def postUKPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post UK premiums for the grant of a lease Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/lease-premium-payment")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isUkAndForeignPropertyPremiumForLease", true)
   .check(status.is(303))

 def getCalculatedPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Calculated premiums for the grant of a lease Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/premium-grant-lease")
   .check(status.is(expected = 200))

 def postCalculatedPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Calculated premiums for the grant of a lease Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/premium-grant-lease")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isPremiumGrantLease", true)
   .formParam("premiumGrantLeaseAmount", 6500)
   .check(status.is(303))

 def getReversePremiumsReceivedUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Reverse premiums received Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/reverse-premiums-received")
   .check(status.is(expected = 200))

 def postReversePremiumsReceivedUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Reverse premiums received Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/reverse-premiums-received")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("reversePremiumsReceived", true)
   .formParam("reversePremiums", 5210)
   .check(status.is(303))

 def getOtherIncomeFromPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Other income from property Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/other-income-from-property")
   .check(status.is(expected = 200))

 def postOtherIncomeFromPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Other income from property Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/other-income-from-property")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("otherIncomeFromProperty", 5210)
   .check(status.is(303))

 def getForeignRentalPropertyIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Foreign property rental income Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-rental-property-income")
   .check(status.is(expected = 200))

 def postForeignRentalPropertyIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Foreign property rental income Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-rental-property-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignRentalPropertyIncomeAmount", 36400)
   .check(status.is(303))

 def getForeignBalancingChargeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Foreign balancing charge Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-balancing-charge")
   .check(status.is(expected = 200))

 def postForeignBalancingChargeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Foreign balancing charge Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-balancing-charge")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isBalancingCharge", true)
   .formParam("balancingChargeAmount", 1900)
   .check(status.is(303))

 def getForeignPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Foreign premiums for the grant of a lease Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-premiums-for-the-grant-of-a-lease")
   .check(status.is(expected = 200))

 def postForeignPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Foreign premiums for the grant of a lease Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/foreign-premiums-for-the-grant-of-a-lease")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("ukAndForeignForeignPremiumsGrantLease", true)
   .check(status.is(303))

 def getForeignCalculatedPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Foreign calculated premiums for the grant of a lease Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/calculated-foreign-premium-grant-lease-taxable")
   .check(status.is(expected = 200))

 def postForeignCalculatedPremiumsForTheGrantOfALeaseUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Foreign calculated premiums for the grant of a lease Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/calculated-foreign-premium-grant-lease-taxable")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("calculatedPremiumLeaseTaxable", true)
   .formParam("premiumsOfLeaseGrant", 3300)
   .check(status.is(303))

 def getForeignOtherIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Foreign other income Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/income/foreign-other-income-from-foreign-property")
   .check(status.is(expected = 200))

 def postForeignOtherIncomeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Foreign other income Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/income/foreign-other-income-from-foreign-property")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("otherPropertyIncome", 9800)
   .check(status.is(303))

 def getPropertyIncomeAllowanceClaimUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Property income allowance Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/property-income-allowance-claim")
   .check(status.is(expected = 200))

 def postPropertyIncomeAllowanceClaimUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Property income allowance Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/property-income-allowance-claim")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("propertyIncomeAllowanceClaimAmount", 1000)
   .check(status.is(303))

 def getCheckYourAnswersUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Check your answers UK and foreign Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/check-your-answers")
   .check(status.is(expected = 200))

 def postCheckYourAnswersUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Check your answers UK and foreign Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getHaveYouFinishedUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Have you finished UK and foreign Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/complete-yes-no")
   .check(status.is(expected = 200))

 def postHaveYouFinishedUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Have you finished UK and foreign Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("sectionComplete", true)
   .check(status.is(303))

}
