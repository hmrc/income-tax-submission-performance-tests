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


object PropertyForeignRequests extends ServicesConfiguration {
  private val countryCode: String = "AGO"
  def getForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/about/start")
    .check(status.is(expected = 200))

 def getForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/total-income")
   .check(status.is(expected = 200))

 def postForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/total-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignTotalIncome" ,"under")
   .check(status.is(303))

 def getForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Get Foreign Property Report Income Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income-report")
   .check(status.is(expected = 200))

  def postForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Post Foreign Property Report Income Page")
    .post(s"${propertyUrl(taxYear)}/foreign-property/income-report")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

 def getWhichCountryDidYouReceiveIncomeFrom(taxYear: String): HttpRequestBuilder = http("Get Which Country Did You Receive Income From Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/about/0/select-income-country")
   .check(status.is(expected = 200))

 def postWhichCountryDidYouReceiveIncomeFrom(taxYear: String): HttpRequestBuilder = http("Post Which Country Did You Receive Income From Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/about/0/select-income-country")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("country-autocomplete", countryCode)
   .check(status.is(303))

  def getCountriesWhereRentedOutProperty(taxYear: String): HttpRequestBuilder = http("Get Countries Where You Rented Out Property Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/countries-rented-property")
    .check(status.is(expected = 200))

  def postCountriesWhereRentedOutProperty(taxYear: String): HttpRequestBuilder = http("Post Countries Where You Rented Out Property Page")
    .post(s"${propertyUrl(taxYear)}/foreign-property/countries-rented-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isCountriesRentedProperty", false)
    .check(status.is(303))

  def getClaimPropertyAllowanceOrExpenses(taxYear: String): HttpRequestBuilder = http("Get Claim Property Allowance Or Expenses Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/claim-property-income-allowance-or-expenses")
    .check(status.is(expected = 200))

 def postClaimPropertyAllowanceOrExpenses(taxYear: String, claimPIA: Boolean = false): HttpRequestBuilder = http("Post Claim Property Allowance Or Expenses Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/claim-property-income-allowance-or-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("claimPropertyIncomeAllowanceOrExpenses", claimPIA)
   .check(status.is(303))

 def getForeignCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Foreign Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Foreign Have You Finished Section Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Foreign Have You Finished Section Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignSelectCountriesComplete", "true")
   .check(status.is(303))

 //-------------------------------Foreign Tax----------------------------
 def getForeignTaxStartPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Tax Start Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/foreign-income-tax")
   .check(status.is(expected = 200))

 def postForeignTaxStartPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Tax Start Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/foreign-income-tax")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignIncomeTax", "true")
   .formParam("foreignTaxPaidOrDeducted", "200")
   .check(status.is(303))

 def getForeignTaxCreditReliefPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Tax Credit Relief Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/claim-foreign-tax-credit-relief")
   .check(status.is(expected = 200))

 def postForeignTaxCreditReliefPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Tax Credit Relief Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/claim-foreign-tax-credit-relief")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("claimForeignTaxCreditRelief", "true")
   .check(status.is(303))

 def getForeignTaxCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Tax Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignTaxCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Tax Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignTaxSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Tax Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/complete-yes-no")
   .check(status.is(200))

 def postForeignTaxSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Tax Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/foreign-tax/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignTaxSectionComplete", "true")
   .check(status.is(303))

 //-------------------------------Income----------------------------
 def getForeignIncomeStartPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Income Start Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/start")
   .check(status.is(expected = 200))

 def getForeignPropertyRentalIncomeStartPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Property Rental Income Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/foreign-property-rental-income")
   .check(status.is(expected = 200))

 def postForeignPropertyRentalIncomeStartPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Property Rental Income Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/foreign-property-rental-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("rentIncome", "100.10")
   .check(status.is(303))

 def getForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Did You Receive A Premium For Grant Of Lease Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/premiums-grant-lease-yn")
   .check(status.is(expected = 200))

 def postForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Did You Receive A Premium For Grant Of Lease Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/premiums-grant-lease-yn")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("premiumsGrantLeaseReceived", "true")
   .check(status.is(303))

 def getForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Have You Calculated The Amount For Premium Grant Of Lease Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/calculated-premium-lease-taxable")
   .check(status.is(expected = 200))

 def postForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Have You Calculated The Amount For Premium Grant Of Lease Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/calculated-premium-lease-taxable")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("calculatedPremiumLeaseTaxable", "false")
   .check(status.is(303))

 def getForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Get Foreign How Much Did Your Receive For Grant Of Lease Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/received-grant-lease-amount")
   .check(status.is(expected = 200))

 def postForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Post Foreign How Much Did Your Receive For Grant Of Lease Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/received-grant-lease-amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("receivedGrantLeaseAmount", "200")
   .check(status.is(303))

 def getForeignCompletePeriodsInTermOfLeasePage(taxYear: String): HttpRequestBuilder = http("Get Foreign How Much Did Your Receive For Grant Of Lease Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/twelve-month-periods")
   .check(status.is(expected = 200))

 def postForeignCompletePeriodsInTermOfLeasePage(taxYear: String): HttpRequestBuilder = http("Post Foreign How Much Did Your Receive For Grant Of Lease Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/twelve-month-periods")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("twelveMonthPeriodsInLease", "3")
   .check(status.is(303))

 def getForeignPremiumsForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Premiums For The Grant Of Lease Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/premiums-grant-lease")
   .check(status.is(expected = 200))

 def postForeignPremiumsForGrantOfLeasePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Premiums For The Grant Of Lease Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/premiums-grant-lease")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("premiumsOfLeaseGrantAgreed", "true")
   .check(status.is(303))

 def getForeignOtherPropertyIncomePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Other Income From Property Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/other-income-from-property")
   .check(status.is(expected = 200))

 def postForeignOtherPropertyIncomePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Other Income From Property Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/other-income-from-property")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("otherPropertyIncome", "99.99")
   .check(status.is(303))

 def getForeignIncomeCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Income Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignIncomeCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Income Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignIncomeSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Income Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignIncomeSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Income Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/income/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignIncomeSectionComplete", "true")
   .check(status.is(303))

 //-------------------------------Expenses----------------------------

 def getForeignExpensesStartPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Expenses Start Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/start")
   .check(status.is(expected = 200))

 def getForeignConsolidatedOrIndividualExpensesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Consolidated Or Individual Expenses Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/consolidated-or-individual-expenses")
   .check(status.is(expected = 200))

 def postForeignConsolidatedOrIndividualExpensesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Consolidated Or Individual Expenses Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/consolidated-or-individual-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("consolidatedOrIndividualExpenses", "false")
   .check(status.is(303))

 def getForeignRentsRatesAndInsurancePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Rents, Rates and Insurance Costs Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/rents-rates-and-insurance")
   .check(status.is(expected = 200))

 def postForeignRentsRatesAndInsurancePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Rents, Rates and Insurance Costs Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/rents-rates-and-insurance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignRentsRatesAndInsurance", "300")
   .check(status.is(303))

 def getForeignRepairsAndMaintenancePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Property Repairs And Maintenance Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-property-repairs-and-maintenance")
   .check(status.is(expected = 200))

 def postForeignRepairsAndMaintenancePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Property Repairs And Maintenance Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-property-repairs-and-maintenance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignPropertyRepairsAndMaintenanceAmount", "200")
   .check(status.is(303))

 def getForeignNonResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Non-Residential Property Finance Costs Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-non-residential-property-finance-costs")
   .check(status.is(expected = 200))

 def postForeignNonResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Non-Residential Property Finance Costs Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-non-residential-property-finance-costs")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignNonResidentialPropertyFinanceCostsAmount", "100.50")
   .check(status.is(303))

 def getForeignLegalManagementOtherFeesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Legal, Management or Other Professional Fees Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-professional-fees")
   .check(status.is(expected = 200))

 def postForeignLegalManagementOtherFeesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Legal, Management or Other Professional Fees Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/foreign-professional-fees")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignProfessionalFeesAmount", "50.55")
   .check(status.is(303))

 def getForeignCostOfServicesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Cost of Services Provided Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/costs-of-services-provided")
   .check(status.is(expected = 200))

 def postForeignCostOfServicesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Cost of Services Provided Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/costs-of-services-provided")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignCostsOfServicesProvided", "100")
   .check(status.is(303))

 def getForeignOtherExpensesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Other Allowable Expenses Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/other-allowable-property-expenses")
   .check(status.is(expected = 200))

 def postForeignOtherExpensesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Other Allowable Expenses Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/other-allowable-property-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("otherAllowablePropertyExpensesAmount", "200")
   .check(status.is(303))

 def getForeignExpensesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Expenses Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignExpensesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Expenses Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignExpensesSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Expenses Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignExpensesSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Expenses Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/expenses/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignExpensesSectionComplete", "true")
   .check(status.is(303))


 //-------------------------------Allowances----------------------------

 def getForeignAllowancesStartPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Allowances Start Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/start")
   .check(status.is(expected = 200))

 def getForeignZeroEmissionCarAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Zero-Emission Car Allowance Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/zero-emission-car-allowance")
   .check(status.is(expected = 200))

 def postForeignZeroEmissionCarAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Zero-Emission Car Allowance Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/zero-emission-car-allowance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("zeroEmissionsCarAllowance", "100.12")
   .check(status.is(303))

 def getForeignZeroEmissionGoodsVehiclePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Zero Emission Goods Vehicle Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/zero-emission-goods-vehicles")
   .check(status.is(expected = 200))

 def postForeignZeroEmissionGoodsVehiclePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Zero Emission Goods Vehicle Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/zero-emission-goods-vehicles")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("zeroEmissionsGoodsVehicleAllowance", "100.23")
   .check(status.is(303))

 def getForeignReplacementOfDomesticGoodsPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Replacement of Domestic Goods Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/replacement-of-domestic-goods")
   .check(status.is(expected = 200))

 def postForeignReplacementOfDomesticGoodsPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Replacement of Domestic Goods Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/replacement-of-domestic-goods")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("costOfReplacingDomesticItems", "200.34")
   .check(status.is(303))

 def getForeignOtherCapitalAllowancesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Other Capital Allowances Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/other-capital-allowances")
   .check(status.is(expected = 200))

 def postForeignOtherCapitalAllowancesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Other Capital Allowances Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/other-capital-allowances")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("otherCapitalAllowance", "300.45")
   .check(status.is(303))

 def getForeignAllowancesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Allowances Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignAllowancesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Allowances Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignAllowancesSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Allowances Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignAllowancesSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Allowances Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/allowances/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignAllowancesComplete", "true")
   .check(status.is(303))


 //-------------------------------Structures and Building Allowance----------------------------

 private val foreignSBAIndex: Int = 0

 def getForeignClaimSBAPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Claim SBA Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/claim-yes-no")
   .check(status.is(expected = 200))

 def postForeignSBAPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Claim SBA Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/claim-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignClaimStructureBuildingAllowance", "true")
   .check(status.is(303))

 def getForeignSBAAddClaimPage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Add Claim Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/add-claim")
   .check(status.is(expected = 200))

 def getForeignSBAQualifyingDatePage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Qualifying Date Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/qualifying-date")
   .check(status.is(expected = 200))

 def postForeignSBAQualifyingDatePage(taxYear: String): HttpRequestBuilder = http("Post Foreign SBA Qualifying Date Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/qualifying-date")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignStructureBuildingQualifyingDate.day", "25")
   .formParam("foreignStructureBuildingQualifyingDate.month", "4")
   .formParam("foreignStructureBuildingQualifyingDate.year", "2020")
   .check(status.is(303))

 def getForeignSBAQualifyingAmountPage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Qualifying Amount Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/qualifying-amount")
   .check(status.is(expected = 200))

 def postForeignSBAQualifyingAmountPage(taxYear: String): HttpRequestBuilder = http("Post Foreign SBA Qualifying Amount Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/qualifying-amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignStructureBuildingQualifyingAmount", "250")
   .check(status.is(303))

 def getForeignSBAHowMuchIsYourClaimPage(taxYear: String): HttpRequestBuilder = http("Get Foreign How Much is Your SBA Claim Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/claim-amount")
   .check(status.is(expected = 200))

 def postForeignSBAHowMuchIsYourClaimPage(taxYear: String): HttpRequestBuilder = http("Post Foreign How Much is Your SBA Claim Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/claim-amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignStructureBuildingAllowanceClaim", "123.45")
   .check(status.is(303))

 def getForeignSBAAddressPage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Address Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/address")
   .check(status.is(expected = 200))

 def postForeignSBAAddressPage(taxYear: String): HttpRequestBuilder = http("Post Foreign SBA Address Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/address")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("buildingName", "Building Name")
   .formParam("buildingNumber", "10")
   .formParam("postcode", "ex4 1pl")
   .check(status.is(303))

 def getForeignSBACheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/$foreignSBAIndex/check-your-answers")
   .check(status.is(expected = 200))

 def getForeignSBAClaimsPage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Claims Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/claims")
   .check(status.is(expected = 200))

 def postForeignSBAClaimsPage(taxYear: String): HttpRequestBuilder = http("Post Foreign SBA Claims Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/claims")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "false")
   .check(status.is(303))

 def getForeignSBASectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign SBA Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignSBASectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign SBA Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/structures-buildings-allowance/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignSbaComplete", "true")
   .check(status.is(303))

 //-------------------------------Adjustments----------------------------


 def getForeignAdjustmentsStartPage(taxYear: String, claimPIA: Boolean = false): HttpRequestBuilder = http("Get Foreign Adjustments Start Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/start?isPIA=$claimPIA")
   .check(status.is(expected = 200))

 def getForeignPrivateUseAdjustmentPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Private Use Adjustment Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/private-use-adjustment")
   .check(status.is(expected = 200))

 def postForeignPrivateUseAdjustmentPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Private Use Adjustment Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/private-use-adjustment")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("privateUseAdjustmentAmount", "100.50")
   .check(status.is(303))

 def getForeignBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Balancing Charge Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/balancing-charge")
   .check(status.is(expected = 200))

 def postForeignBalancingChargePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Balancing Charge Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/balancing-charge")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isBalancingCharge", "true")
   .formParam("balancingChargeAmount", "300")
   .check(status.is(303))

 def getForeignYourPIAClaimPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Your Property Income Allowance Claim Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/property-income-allowance-claim")
   .check(status.is(expected = 200))

 def postForeignYourPIAClaimPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Your Property Income Allowance Claim Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/property-income-allowance-claim")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("propertyIncomeAllowanceClaimAmount", "355.55")
   .check(status.is(303))

 def getForeignResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Residential Finance Costs Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/residential-finance-costs")
   .check(status.is(expected = 200))

 def postForeignResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Residential Finance Costs Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/residential-finance-costs")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("residentialFinanceCostsAmount", "200")
   .check(status.is(303))

 def getForeignUnusedResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Unused Residential Finance Costs Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/unused-residential-finance-cost")
   .check(status.is(expected = 200))

 def postForeignUnusedResidentialFinanceCostsPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Unused Residential Finance Costs Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/unused-residential-finance-cost")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignUnusedResidentialFinanceCost", "true")
   .formParam("foreignUnusedResidentialFinanceCostAmount", "100.10")
   .check(status.is(303))

 def getForeignUnusedLossesPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Unused Losses Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/unused-losses-previous-years")
   .check(status.is(expected = 200))

 def postForeignUnusedLossesPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Unused Losses Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/unused-losses-previous-years")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isUnusedLossesPreviousYears", "true")
   .formParam("unusedLossesPreviousYearsAmount", "333.33")
   .check(status.is(303))

 def getForeignWhenYouReportedTheLossPage(taxYear: String): HttpRequestBuilder = http("Get Foreign When You Reported The Loss Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/when-you-reported-the-loss")
   .check(status.is(expected = 200))

 def postForeignWhenYouReportedTheLossPage(taxYear: String): HttpRequestBuilder = http("Post Foreign When You Reported The Loss Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/when-you-reported-the-loss")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("whenYouReportedTheLoss", "y2021to2022")
   .check(status.is(303))

 def getForeignAdjustmentsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Foreign Ådjustments Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignAdjustmentsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Foreign Ådjustments Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignAdjustmentsSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Get Foreign Foreign Adjustments Section Complete Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignAdjustmentsSectionCompletePage(taxYear: String): HttpRequestBuilder = http("Post Foreign Foreign Adjustments Section Complete Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/adjustments/$countryCode/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignAdjustmentsComplete", "true")
   .check(status.is(303))
}





