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

  def getPropertySummaryPage(taxYear: String): HttpRequestBuilder = http("Get Property summary Page")
    .get(s"${propertyUrl(taxYear)}/summary")
    .check(status.is(expected = 200))

  def getPropertyDetailsPage(taxYear: String): HttpRequestBuilder = http("Get UK property details Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/start")
    .check(status.is(expected = 200))

  def getPropertyTotalIncome(taxYear: String): HttpRequestBuilder = http("Get Total income Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/total-income")
    .check(status.is(expected = 200))

  def postPropertyTotalIncome(taxYear: String): HttpRequestBuilder = http("Post Total income Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/total-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "over")
    .check(status.is(303))

  def getPropertyReportIncome(taxYear: String): HttpRequestBuilder = http("Get Property report income Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/report-property-income")
    .check(status.is(expected = 200))

  def postPropertyReportIncome(taxYear: String): HttpRequestBuilder = http("Post Property report income Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/report-property-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("reportPropertyIncome", true)
    .check(status.is(303))

  def getWhichRentalPropertyUK(taxYear: String): HttpRequestBuilder = http("Get Which rental property Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/rental-property")
    .check(status.is(expected = 200))

  def postWhichRentalPropertyUKProperty(taxYear: String): HttpRequestBuilder = http("Post Which rental property [Property] Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/rental-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[0]", "property.rentals")
    .check(status.is(303))

  def postWhichRentalPropertyUKPropertyRentARoom(taxYear: String): HttpRequestBuilder = http("Post Which rental property [Rent A room] Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/rental-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[1]", "rent.a.room")
    .check(status.is(303))

  def getCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .check(status.is(expected = 200))

  def postCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Have you finished section Page")
    .get(s"${propertyUrl(taxYear)}/uk-property/about/complete-yes-no")
    .check(status.is(expected = 200))

  def postHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Have You finished section Page")
    .post(s"${propertyUrl(taxYear)}/uk-property/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isAboutPropertyComplete", "true")
    .check(status.is(303))

  //-----------------------------UK Property Rent a room------------------------------------------------

  def getRentARoomAbout(taxYear: String): HttpRequestBuilder = http("Get Rent a room start Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/start")
    .check(status.is(expected = 200))

  def getJointlyLetRentARoom(taxYear: String): HttpRequestBuilder = http("Get Jointly let Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/jointly-let")
    .check(status.is(expected = 200))

  def postJointlyLetRentARoom(taxYear: String): HttpRequestBuilder = http("Post Jointly let Page")
    .post(s"${propertyUrl(taxYear)}/rent-a-room/about/jointly-let")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isJointlyLet", true)
    .check(status.is(303))

  def getTotalRentARoomIncome(taxYear: String): HttpRequestBuilder = http("Get Total rent a room income Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/total-income-amount")
    .check(status.is(expected = 200))

  def postTotalRentARoomIncome(taxYear: String): HttpRequestBuilder = http("Post Total rent a room income Page")
    .post(s"${propertyUrl(taxYear)}/rent-a-room/about/total-income-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("totalIncomeAmount", "10000")
    .check(status.is(303))

  def getClaimExpensesOrReliefRARfPage(taxYear: String): HttpRequestBuilder = http("Get Claim expenses or rent a room relief Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/claim-expenses-or-relief")
    .check(status.is(expected = 200))

  def postClaimExpensesOrReliefRARPage(taxYear: String): HttpRequestBuilder = http("Post Claim expenses or rent a room relief Page")
    .post(s"${propertyUrl(taxYear)}/rent-a-room/about/claim-expenses-or-relief")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("claimExpensesOrRelief", true)
    .formParam("rentARoomAmount", "100")
    .check(status.is(303))

  def getCheckYourAnswersRARfPage(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/check-your-answers")
    .check(status.is(expected = 200))

  def postCheckYourAnswersRARfPage(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rent-a-room/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getHaveYouFinishedRARfPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .get(s"${propertyUrl(taxYear)}/rent-a-room/about/complete-yes-no")
    .check(status.is(expected = 200))

  def postHaveYouFinishedRARPage(taxYear: String): HttpRequestBuilder = http("Post Have you finished Page")
    .post(s"${propertyUrl(taxYear)}/rent-a-room/about/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isRentARoomIsSectionComplete", true)
    .check(status.is(303))

  //-----------------------------UK Property Rentals About------------------------------------------------
  def getPropertyRentalsStartPage(taxYear: String): HttpRequestBuilder = http("Get Property rentals start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/start")
    .check(status.is(expected = 200))

  def getPropertyClaimPIAorExpensesProperty(taxYear: String): HttpRequestBuilder = http("Get claim PIA or expenses page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/claim-property-income-allowance")
    .check(status.is(expected = 200))

  def postClaimExpenses(taxYear: String): HttpRequestBuilder = http("Post Claim expenses Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/claim-property-income-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isClaimPropertyIncomeAllowance", "false")
    .check(status.is(303))

  def getRentalsCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .check(status.is(expected = 200))

  def postRentalsCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getRentalsHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Have you finished section Page")
    .get(s"${propertyUrl(taxYear)}/rentals/about/complete-yes-no")
    .check(status.is(expected = 200))

  def postRentalsHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/about/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isAboutPropertyRentalsSectionFinished", "true")
    .check(status.is(303))


//-----------------------------Income------------------------------------------------
  def getPropertyRentalsIncomeStartPage(taxYear: String): HttpRequestBuilder = http("Get Income start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/start")
    .check(status.is(expected = 200))

  def getPropertyRentalsIncomeNonUKResidentLandlordPage(taxYear: String): HttpRequestBuilder = http("Get Non-UK resident landlord Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/is-non-uk-landlord")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeNonUKResidentLandlordPage(taxYear: String): HttpRequestBuilder = http("Post Non-UK resident landlord Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/is-non-uk-landlord")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isNonUKLandlord", "true")
    .check(status.is(303))

  def getPropertyRentalsIncomeDeductingTaxPage(taxYear: String): HttpRequestBuilder = http("Get Deducting tax Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/deducting-tax")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeDeductingTaxPage(taxYear: String): HttpRequestBuilder = http("Post Deducting tax Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/deducting-tax")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isTaxDeducted", "true")
    .formParam("taxDeductedAmount", "800")
    .check(status.is(303))

  def getPropertyRentalsIncomePropertyRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Total income Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/property-rental-income")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomePropertyRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Total income Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/property-rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("propertyRentalIncome", "90000")
    .check(status.is(303))

  def getPropertyRentalsIncomePremiumsGrantLeasePage(taxYear: String): HttpRequestBuilder = http("Get Premiums grant lease Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/lease-premium-payment")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomePremiumsGrantLeasePage(taxYear: String): HttpRequestBuilder = http("Post Premiums grant lease Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/lease-premium-payment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isPremiumForLease", "true")
    .check(status.is(303))

  def getPropertyRentalsIncomeCalculatedFigureYourselfPage(taxYear: String): HttpRequestBuilder = http("Get Calculated figure yourself Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/calculated-figure-yourself")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeCalculatedFigureYourselfPage(taxYear: String): HttpRequestBuilder = http("Post Calculated figure yourself Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/calculated-figure-yourself")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("calculatedFigureYourself", "true")
    .formParam("calculatedFigureYourselfAmount", "7538")
    .check(status.is(303))

  def getPropertyRentalsIncomeReversePremiumsReceivedPage(taxYear: String): HttpRequestBuilder = http("Get Reverse premiums received Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/reverse-premiums-received")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeReversePremiumsReceivedPage(taxYear: String): HttpRequestBuilder = http("Post Reverse premiums received Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/reverse-premiums-received")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("reversePremiumsReceived", "true")
    .formParam("reversePremiums", "4365")
    .check(status.is(303))

  def getPropertyRentalsIncomeOtherIncomePage(taxYear: String): HttpRequestBuilder = http("Get Other income Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/other-income-from-property")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeOtherIncomePage(taxYear: String): HttpRequestBuilder = http("Post Other income Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/other-income-from-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("otherIncomeFromProperty", "6040")
    .check(status.is(303))

  def getPropertyRentalsIncomeCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/check-your-answers")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getPropertyRentalsIncomeHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished this section Page")
    .get(s"${propertyUrl(taxYear)}/rentals/income/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsIncomeHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Post Have you finished this section Page")
    .post(s"${propertyUrl(taxYear)}/rentals/income/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isIncomeSectionFinished", "true")
    .check(status.is(303))

//-----------------------------Expenses------------------------------------------------

  def getPropertyRentalsExpensesStartPage(taxYear: String): HttpRequestBuilder = http("Get Expenses start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/start")
    .check(status.is(expected = 200))

  def getPropertyRentalsExpensesRentsRatesAndInsurancePage(taxYear: String): HttpRequestBuilder = http("Get Rent rates and insurance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/rents-rates-and-insurance")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesRentsRatesAndInsurancePage(taxYear: String): HttpRequestBuilder = http("Post Rent rates and insurance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/rents-rates-and-insurance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("rentsRatesAndInsurance", "3230")
    .check(status.is(303))

  def getPropertyRentalsExpensesRepairsAndMaintenancePage(taxYear: String): HttpRequestBuilder = http("Get Property repairs and maintenance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/repairs-and-maintenance-costs")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesRepairsAndMaintenancePage(taxYear: String): HttpRequestBuilder = http("Post Property repairs and maintenance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/repairs-and-maintenance-costs")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("repairsAndMaintenanceCosts", "178")
    .check(status.is(303))

  def getPropertyRentalsExpensesLoanInterestPage(taxYear: String): HttpRequestBuilder = http("Get Property loan interest Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/loan-interest")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesLoanInterestPage(taxYear: String): HttpRequestBuilder = http("Post Property loan interest Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/loan-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("loanInterestOrOtherFinancialCost", "347")
    .check(status.is(303))

  def getPropertyRentalsExpensesLegalOrOtherProfessionalFeesPage(taxYear: String): HttpRequestBuilder = http("Get Legal or other professional fees Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/legal-or-other-professional-fees")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesLegalOrOtherProfessionalFeesPage(taxYear: String): HttpRequestBuilder = http("Post Legal or other professional fees Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/legal-or-other-professional-fees")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("otherProfessionalFees", "432")
    .check(status.is(303))

  def getPropertyRentalsExpensesCostOfServicesProvidedPage(taxYear: String): HttpRequestBuilder = http("Get Cost of services provided Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/costs-of-services-provided")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesCostOfServicesProvidedPage(taxYear: String): HttpRequestBuilder = http("Post Cost of services provided Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/costs-of-services-provided")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("costsOfServicesProvided", "432")
    .check(status.is(303))

  def getPropertyRentalsExpensesPropertyBusinessTravelCostsPage(taxYear: String): HttpRequestBuilder = http("Get Property business travel costs Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/property-business-travel-costs")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesPropertyBusinessTravelCostsPage(taxYear: String): HttpRequestBuilder = http("Post Property business travel costs Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/property-business-travel-costs")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("propertyBusinessTravelCosts", "6038")
    .check(status.is(303))

  def getPropertyRentalsExpensesOtherExpensesPage(taxYear: String): HttpRequestBuilder = http("Get Other expenses Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/other-allowable-property-expenses")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesOtherExpensesPage(taxYear: String): HttpRequestBuilder = http("Post Other expenses Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/other-allowable-property-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("otherAllowablePropertyExpenses", "2100")
    .check(status.is(303))

  def getPropertyRentalsExpensesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/check-your-answers")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getPropertyRentalsExpensesHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished this section Page")
    .get(s"${propertyUrl(taxYear)}/rentals/expenses/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsExpensesHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Post Have you finished this section Page")
    .post(s"${propertyUrl(taxYear)}/rentals/expenses/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isExpensesSectionFinished", "true")
    .check(status.is(303))


//-----------------------------Allowances------------------------------------------------

  def getPropertyRentalsAllowancesStartPage(taxYear: String): HttpRequestBuilder = http("Get Allowances start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/start")
    .check(status.is(expected = 200))

  def getPropertyRentalsAllowancesAnnualInvestmentAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Annual investment allowance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/annual-investment-allowance")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesAnnualInvestmentAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Annual investment allowance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/annual-investment-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("annualInvestmentAllowanceAmount", "400.23")
    .check(status.is(303))

  def getPropertyRentalsAllowancesZeroEmissionCarAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Zero-emission car allowance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/zero-emission-car-allowance")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesZeroEmissionCarAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Zero-emission car allowance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/zero-emission-car-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("zeroEmissionCarAllowanceAmount", "828")
    .check(status.is(303))

  def getPropertyRentalsAllowancesZeroEmissionGoodsVehicleAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Zero-emission goods vehicle allowance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/zero-emission-goods-vehicle-allowance")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesZeroEmissionGoodsVehicleAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Zero-emission goods vehicle allowance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/zero-emission-goods-vehicle-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("zeroEmissionGoodsVehicleAllowanceAmount", "245")
    .check(status.is(303))

  def getPropertyRentalsAllowancesBusinessPremisesRenovationAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Business premises renovation allowance Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/business-premises-renovation")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesBusinessPremisesRenovationAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Business premises renovation allowance Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/business-premises-renovation")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("businessPremisesRenovationAmount", "1030")
    .check(status.is(303))

  def getPropertyRentalsAllowancesReplacementOfDomesticGoodsPage(taxYear: String): HttpRequestBuilder = http("Get Replacement of domestic goods Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/replacement-of-domestic-goods")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesReplacementOfDomesticGoodsPage(taxYear: String): HttpRequestBuilder = http("Post Replacement of domestic goods Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/replacement-of-domestic-goods")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("replacementOfDomesticGoodsAmount", "800")
    .check(status.is(303))

  def getPropertyRentalsAllowancesOtherCapitalAllowancesPage(taxYear: String): HttpRequestBuilder = http("Get Other capital allowances Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/other-capital-allowance")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesOtherCapitalAllowancesPage(taxYear: String): HttpRequestBuilder = http("Post Other capital allowances Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/other-capital-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("otherCapitalAllowanceAmount", "140")
    .check(status.is(303))

  def getPropertyRentalsAllowancesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check your expenses Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/check-your-answers")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check your expenses Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getPropertyRentalsAllowancesHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .get(s"${propertyUrl(taxYear)}/rentals/allowances/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsAllowancesHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Post Have you finished Page")
    .post(s"${propertyUrl(taxYear)}/rentals/allowances/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isAllowancesSectionFinished", "true")
    .check(status.is(303))

//-----------------------------Structures and building allowance------------------------------------------------

  def getPropertyRentalsSBAClaimYesNoPage(taxYear: String): HttpRequestBuilder = http("Get SBA claim yes no Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/claim-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAClaimYesNoPage(taxYear: String): HttpRequestBuilder = http("Post SBA claims yes no Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/claim-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("claimStructureBuildingAllowance", "true")
    .check(status.is(303))

  def getPropertyRentalsSBAAddClaimPage(taxYear: String): HttpRequestBuilder = http("Get SBA add claim Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/add-claim")
    .check(status.is(expected = 200))

  def getPropertyRentalsSBAQualifyingDatePage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get Qualifying date Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/qualifying-date")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAQualifyingDatePage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Post Qualifying date Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/qualifying-date")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("structureBuildingQualifyingDate.day", "12")
    .formParam("structureBuildingQualifyingDate.month", "02")
    .formParam("structureBuildingQualifyingDate.year", "2021")
    .check(status.is(303))

  def getPropertyRentalsSBAQualifyingAmountPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get Qualifying amount Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/qualifying-amount")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAQualifyingAmountPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Post Qualifying amount Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/qualifying-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("structureBuildingQualifyingAmount", "2000")
    .check(status.is(303))

  def getPropertyRentalsSBAClaimAmountPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get Claim amount Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/claim-amount")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAClaimAmountPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Post Claim amount Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/claim-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("structureBuildingAllowanceClaim", "1300")
    .check(status.is(303))

  def getPropertyRentalsSBAAddressPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get address Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/address")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAAddressPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Post address Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/address")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("buildingName", "Mason House")
    .formParam("buildingNumber", "27a")
    .formParam("postcode", "SE1 2NB")
    .check(status.is(303))

  def getPropertyRentalsSBACheckYourAnswersPage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/$index/check-your-answers")
    .check(status.is(expected = 200))

  def getPropertyRentalsSBAClaimsPage(taxYear: String): HttpRequestBuilder = http("Get Claims Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/claims")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAClaimsPage(taxYear: String): HttpRequestBuilder = http("Post Claims Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/claims")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("anotherClaim", "false")
    .check(status.is(303))

  def getPropertyRentalsSBAHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .get(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsSBAHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .post(s"${propertyUrl(taxYear)}/rentals/structures-buildings-allowance/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isSbaSectionFinished", "true")
    .check(status.is(303))

//-----------------------------Enhanced structures and building allowance------------------------------------------------

  def getPropertyRentalsESBAClaimYesNoPage(taxYear: String): HttpRequestBuilder = http("Get ESBA claim yes no Page")
    .get(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/claim-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsESBAClaimYesNoPage(taxYear: String): HttpRequestBuilder = http("Post ESBA claim yes no Page")
    .post(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/claim-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("claimEnhancedStructureBuildingAllowance", "false")
    .check(status.is(303))

  def getPropertyRentalsESBACheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/claim-yes-no-check-your-answers")
    .check(status.is(expected = 200))

  def postPropertyRentalsESBACheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/claim-yes-no-check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getPropertyRentalsESBAHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .get(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsESBAHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .post(s"${propertyUrl(taxYear)}/rentals/enhanced-structures-buildings-allowance/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isEsbaSectionFinished", "true")
    .check(status.is(303))

  //-----------------------------Adjustments------------------------------------------------

  def getPropertyRentalsAdjustmentsStartPage(taxYear: String): HttpRequestBuilder = http("Get Adjustments start Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/start?expensesOrPIA=false")
    .check(status.is(expected = 200))

  def getPropertyRentalsAdjustmentsPrivateUseAdjustmentPage(taxYear: String): HttpRequestBuilder = http("Get Private use adjustment Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/private-use-adjustment")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsPrivateUseAdjustmentPage(taxYear: String): HttpRequestBuilder = http("Post Private use adjustment Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/private-use-adjustment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("privateUseAdjustmentAmount", "76")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Get Balancing charge Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/balancing-charge")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Post Balancing charge Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/balancing-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isBalancingCharge", "true")
    .formParam("balancingChargeAmount", "899")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsRenovationAllowanceBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Get Renovation allowance balancing charge Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/renovation-allowance-balancing-charge")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsRenovationAllowanceBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Post Renovation allowance balancing charge Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/renovation-allowance-balancing-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isRenovationAllowanceBalancingCharge", "true")
    .formParam("renovationAllowanceBalancingChargeAmount", "499")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsResidentialFinanceCostPage(taxYear: String): HttpRequestBuilder = http("Get Residential finance cost Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/residential-finance-cost")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsResidentialFinanceCostPage(taxYear: String): HttpRequestBuilder = http("Post Residential finance cost Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/residential-finance-cost")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("residentialFinanceCost", "599")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsUnusedResidentialFinanceCostPage(taxYear: String): HttpRequestBuilder = http("Get Unused residential finance cost Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/unused-residential-finance-cost")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsUnusedResidentialFinanceCostPage(taxYear: String): HttpRequestBuilder = http("Post Unused residential finance cost Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/unused-residential-finance-cost")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("unusedResidentialFinanceCost", "199")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsUnusedLossesPage(taxYear: String): HttpRequestBuilder = http("Get Unused losses Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/unused-losses-brought-fwd")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsUnusedLossesPage(taxYear: String): HttpRequestBuilder = http("Post Unused losses Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/unused-losses-brought-fwd")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isUnusedLossesBroughtForward", "true")
    .formParam("unusedLossesBroughtForwardAmount", "299")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsWhenYouReportedTheLossPage(taxYear: String): HttpRequestBuilder = http("Get When you reported the loss Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/when-you-reported-the-loss")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsWhenYouReportedTheLossPage(taxYear: String): HttpRequestBuilder = http("Post When you reported the loss Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/when-you-reported-the-loss")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("whenYouReportedTheLoss", "y2021to2022")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check your answers Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/check-your-answers")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check your answers Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getPropertyRentalsAdjustmentsHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Get Have you finished Page")
    .get(s"${propertyUrl(taxYear)}/rentals/adjustments/complete-yes-no")
    .check(status.is(expected = 200))

  def postPropertyRentalsAdjustmentsHaveYouFinishedPage(taxYear: String): HttpRequestBuilder = http("Post Have you finished Page")
    .post(s"${propertyUrl(taxYear)}/rentals/adjustments/complete-yes-no")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isRentalsAdjustmentsComplete", "true")
    .check(status.is(303))




}

