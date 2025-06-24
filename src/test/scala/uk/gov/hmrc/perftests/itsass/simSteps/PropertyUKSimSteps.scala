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

package uk.gov.hmrc.perftests.itsass.simSteps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.PropertyUKRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY


trait PropertyUKSimSteps extends PerformanceTestRunner{

  def propertyIndividualEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC210000B", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyDetailsPage(taxYearEOY),
    getPropertyTotalIncome(taxYearEOY),
    postPropertyTotalIncome(taxYearEOY),
    getWhichRentalPropertyUK(taxYearEOY),
    postWhichRentalPropertyUKProperty(taxYearEOY),
    getCheckYourAnswers(taxYearEOY),
    postCheckYourAnswers(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK property rentals - About
    getPropertyRentalsStartPage(taxYearEOY),
    getPropertyClaimPIAorExpensesProperty(taxYearEOY),
    postClaimExpenses(taxYearEOY),
    getRentalsCheckYourAnswers(taxYearEOY),
    postRentalsCheckYourAnswers(taxYearEOY),
    getRentalsHaveYouFinishedSection(taxYearEOY),
    postRentalsHaveYouFinishedSection(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Income
    getPropertyRentalsIncomeStartPage(taxYearEOY),
    getPropertyRentalsIncomeNonUKResidentLandlordPage(taxYearEOY),
    postPropertyRentalsIncomeNonUKResidentLandlordPage(taxYearEOY),
    getPropertyRentalsIncomeDeductingTaxPage(taxYearEOY),
    postPropertyRentalsIncomeDeductingTaxPage(taxYearEOY),
    getPropertyRentalsIncomePropertyRentalIncomePage(taxYearEOY),
    postPropertyRentalsIncomePropertyRentalIncomePage(taxYearEOY),
    getPropertyRentalsIncomePremiumsGrantLeasePage(taxYearEOY),
    postPropertyRentalsIncomePremiumsGrantLeasePage(taxYearEOY),
    getPropertyRentalsIncomeCalculatedFigureYourselfPage(taxYearEOY),
    postPropertyRentalsIncomeCalculatedFigureYourselfPage(taxYearEOY),
    getPropertyRentalsIncomeReversePremiumsReceivedPage(taxYearEOY),
    postPropertyRentalsIncomeReversePremiumsReceivedPage(taxYearEOY),
    getPropertyRentalsIncomeOtherIncomePage(taxYearEOY),
    postPropertyRentalsIncomeOtherIncomePage(taxYearEOY),
    getPropertyRentalsIncomeCheckYourAnswersPage(taxYearEOY),
    postPropertyRentalsIncomeCheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsIncomeHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsIncomeHaveYouFinishedPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Expenses
    getPropertyRentalsExpensesStartPage(taxYearEOY),
    getPropertyRentalsExpensesRentsRatesAndInsurancePage(taxYearEOY),
    postPropertyRentalsExpensesRentsRatesAndInsurancePage(taxYearEOY),
    getPropertyRentalsExpensesRepairsAndMaintenancePage(taxYearEOY),
    postPropertyRentalsExpensesRepairsAndMaintenancePage(taxYearEOY),
    getPropertyRentalsExpensesLoanInterestPage(taxYearEOY),
    postPropertyRentalsExpensesLoanInterestPage(taxYearEOY),
    getPropertyRentalsExpensesLegalOrOtherProfessionalFeesPage(taxYearEOY),
    postPropertyRentalsExpensesLegalOrOtherProfessionalFeesPage(taxYearEOY),
    getPropertyRentalsExpensesCostOfServicesProvidedPage(taxYearEOY),
    postPropertyRentalsExpensesCostOfServicesProvidedPage(taxYearEOY),
    getPropertyRentalsExpensesPropertyBusinessTravelCostsPage(taxYearEOY),
    postPropertyRentalsExpensesPropertyBusinessTravelCostsPage(taxYearEOY),
    getPropertyRentalsExpensesOtherExpensesPage(taxYearEOY),
    postPropertyRentalsExpensesOtherExpensesPage(taxYearEOY),
    getPropertyRentalsExpensesCheckYourAnswersPage(taxYearEOY),
    postPropertyRentalsExpensesCheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsExpensesHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsExpensesHaveYouFinishedPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Allowances
    getPropertyRentalsAllowancesStartPage(taxYearEOY),
    getPropertyRentalsAllowancesAnnualInvestmentAllowancePage(taxYearEOY),
    postPropertyRentalsAllowancesAnnualInvestmentAllowancePage(taxYearEOY),
    getPropertyRentalsAllowancesZeroEmissionCarAllowancePage(taxYearEOY),
    postPropertyRentalsAllowancesZeroEmissionCarAllowancePage(taxYearEOY),
    getPropertyRentalsAllowancesZeroEmissionGoodsVehicleAllowancePage(taxYearEOY),
    postPropertyRentalsAllowancesZeroEmissionGoodsVehicleAllowancePage(taxYearEOY),
    getPropertyRentalsAllowancesBusinessPremisesRenovationAllowancePage(taxYearEOY),
    postPropertyRentalsAllowancesBusinessPremisesRenovationAllowancePage(taxYearEOY),
    getPropertyRentalsAllowancesReplacementOfDomesticGoodsPage(taxYearEOY),
    postPropertyRentalsAllowancesReplacementOfDomesticGoodsPage(taxYearEOY),
    getPropertyRentalsAllowancesOtherCapitalAllowancesPage(taxYearEOY),
    postPropertyRentalsAllowancesOtherCapitalAllowancesPage(taxYearEOY),
    getPropertyRentalsAllowancesCheckYourAnswersPage(taxYearEOY),
    postPropertyRentalsAllowancesCheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsAllowancesHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsAllowancesHaveYouFinishedPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Structures and building allowance
    getPropertyRentalsSBAClaimYesNoPage(taxYearEOY),
    postPropertyRentalsSBAClaimYesNoPage(taxYearEOY),
    getPropertyRentalsSBAAddClaimPage(taxYearEOY),
    getPropertyRentalsSBAQualifyingDatePage(taxYearEOY),
    postPropertyRentalsSBAQualifyingDatePage(taxYearEOY),
    getPropertyRentalsSBAQualifyingAmountPage(taxYearEOY),
    postPropertyRentalsSBAQualifyingAmountPage(taxYearEOY),
    getPropertyRentalsSBAClaimAmountPage(taxYearEOY),
    postPropertyRentalsSBAClaimAmountPage(taxYearEOY),
    getPropertyRentalsSBAAddressPage(taxYearEOY),
    postPropertyRentalsSBAAddressPage(taxYearEOY),
    getPropertyRentalsSBACheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsSBAClaimsPage(taxYearEOY),
    postPropertyRentalsSBAClaimsPage(taxYearEOY),
    getPropertyRentalsSBAHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsSBAHaveYouFinishedPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Enhanced structures and building allowance
    getPropertyRentalsESBAClaimYesNoPage(taxYearEOY),
    postPropertyRentalsESBAClaimYesNoPage(taxYearEOY),
    getPropertyRentalsESBACheckYourAnswersPage(taxYearEOY),
    postPropertyRentalsESBACheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsESBAHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsESBAHaveYouFinishedPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //UK Property Rentals - Adjustments
    getPropertyRentalsAdjustmentsStartPage(taxYearEOY),
    getPropertyRentalsAdjustmentsPrivateUseAdjustmentPage(taxYearEOY),
    postPropertyRentalsAdjustmentsPrivateUseAdjustmentPage(taxYearEOY),
    getPropertyRentalsAdjustmentsBalancingChargePage(taxYearEOY),
    postPropertyRentalsAdjustmentsBalancingChargePage(taxYearEOY),
    getPropertyRentalsAdjustmentsRenovationAllowanceBalancingChargePage(taxYearEOY),
    postPropertyRentalsAdjustmentsRenovationAllowanceBalancingChargePage(taxYearEOY),
    getPropertyRentalsAdjustmentsResidentialFinanceCostPage(taxYearEOY),
    postPropertyRentalsAdjustmentsResidentialFinanceCostPage(taxYearEOY),
    getPropertyRentalsAdjustmentsUnusedResidentialFinanceCostPage(taxYearEOY),
    postPropertyRentalsAdjustmentsUnusedResidentialFinanceCostPage(taxYearEOY),
    getPropertyRentalsAdjustmentsUnusedLossesPage(taxYearEOY),
    postPropertyRentalsAdjustmentsUnusedLossesPage(taxYearEOY),
    getPropertyRentalsAdjustmentsWhenYouReportedTheLossPage(taxYearEOY),
    postPropertyRentalsAdjustmentsWhenYouReportedTheLossPage(taxYearEOY),
    getPropertyRentalsAdjustmentsCheckYourAnswersPage(taxYearEOY),
    postPropertyRentalsAdjustmentsCheckYourAnswersPage(taxYearEOY),
    getPropertyRentalsAdjustmentsHaveYouFinishedPage(taxYearEOY),
    postPropertyRentalsAdjustmentsHaveYouFinishedPage(taxYearEOY),


  )
  def propertyAgentEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC210000A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AC210000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyDetailsPage(taxYearEOY),
    getPropertyTotalIncome(taxYearEOY),
    postPropertyTotalIncome(taxYearEOY),
    getPropertyReportIncome(taxYearEOY),
    postPropertyReportIncome(taxYearEOY),
    getWhichRentalPropertyUK(taxYearEOY),
    postWhichRentalPropertyUKPropertyRentARoom(taxYearEOY),
    getCheckYourAnswers(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    getPropertySummaryPage (taxYearEOY),

    //UK rent a room - About
    getRentARoomAbout(taxYearEOY),
    getJointlyLetRentARoom(taxYearEOY),
    postJointlyLetRentARoom(taxYearEOY),
    getTotalRentARoomIncome(taxYearEOY),
    postTotalRentARoomIncome(taxYearEOY),
    getClaimExpensesOrReliefRARfPage(taxYearEOY),
    postClaimExpensesOrReliefRARPage(taxYearEOY),
    getCheckYourAnswersRARfPage(taxYearEOY),
    postCheckYourAnswersRARfPage(taxYearEOY),
    getHaveYouFinishedRARfPage(taxYearEOY),
    postHaveYouFinishedRARPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

  )
}
