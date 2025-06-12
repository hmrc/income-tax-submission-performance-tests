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
import uk.gov.hmrc.perftests.itsass.requests.PropertyForeignRequests._
import uk.gov.hmrc.perftests.itsass.requests.PropertyUKRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY


trait PropertyForeignSimSteps extends PerformanceTestRunner{

  def foreignPropertyIndividualEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC180000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getForeignPropertyDetailsPage(taxYearEOY),
    getForeignPropertyTotalIncome(taxYearEOY),
    postForeignPropertyTotalIncome(taxYearEOY),
    getForeignPropertyReportIncome(taxYearEOY),
    postForeignPropertyReportIncome(taxYearEOY),
    getWhichCountryDidYouReceiveIncomeFrom(taxYearEOY),
    postWhichCountryDidYouReceiveIncomeFrom(taxYearEOY),
    getCountriesWhereRentedOutProperty(taxYearEOY),
    postCountriesWhereRentedOutProperty(taxYearEOY),
    getClaimPropertyAllowanceOrExpenses(taxYearEOY),
    postClaimPropertyAllowanceOrExpenses(taxYearEOY),
    getForeignCheckYourAnswers(taxYearEOY),
    postForeignCheckYourAnswers(taxYearEOY),
    getForeignHaveYouFinishedSection(taxYearEOY),
    postForeignHaveYouFinishedSection(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Foreign Tax
    getForeignTaxStartPage(taxYearEOY),
    postForeignTaxStartPage(taxYearEOY),
    getForeignTaxCreditReliefPage(taxYearEOY),
    postForeignTaxCreditReliefPage(taxYearEOY),
    getForeignTaxCheckYourAnswersPage(taxYearEOY),
    postForeignTaxCheckYourAnswersPage(taxYearEOY),
    getForeignTaxSectionCompletePage(taxYearEOY),
    postForeignTaxSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Income
    getForeignIncomeStartPage(taxYearEOY),
    getForeignPropertyRentalIncomeStartPage(taxYearEOY),
    postForeignPropertyRentalIncomeStartPage(taxYearEOY),
    getForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYearEOY),
    postForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYearEOY),
    getForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYearEOY),
    postForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYearEOY),
    getForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYearEOY),
    postForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYearEOY),
    getForeignCompletePeriodsInTermOfLeasePage(taxYearEOY),
    postForeignCompletePeriodsInTermOfLeasePage(taxYearEOY),
    getForeignPremiumsForGrantOfLeasePage(taxYearEOY),
    postForeignPremiumsForGrantOfLeasePage(taxYearEOY),
    getForeignOtherPropertyIncomePage(taxYearEOY),
    postForeignOtherPropertyIncomePage(taxYearEOY),
    getForeignIncomeCheckYourAnswersPage(taxYearEOY),
    postForeignIncomeCheckYourAnswersPage(taxYearEOY),
    getForeignIncomeSectionCompletePage(taxYearEOY),
    postForeignIncomeSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Expenses
    getForeignExpensesStartPage(taxYearEOY),
    getForeignConsolidatedOrIndividualExpensesPage(taxYearEOY),
    postForeignConsolidatedOrIndividualExpensesPage(taxYearEOY),
    getForeignRentsRatesAndInsurancePage(taxYearEOY),
    postForeignRentsRatesAndInsurancePage(taxYearEOY),
    getForeignRepairsAndMaintenancePage(taxYearEOY),
    postForeignRepairsAndMaintenancePage(taxYearEOY),
    getForeignNonResidentialFinanceCostsPage(taxYearEOY),
    postForeignNonResidentialFinanceCostsPage(taxYearEOY),
    getForeignLegalManagementOtherFeesPage(taxYearEOY),
    postForeignLegalManagementOtherFeesPage(taxYearEOY),
    getForeignCostOfServicesPage(taxYearEOY),
    postForeignCostOfServicesPage(taxYearEOY),
    getForeignOtherExpensesPage(taxYearEOY),
    postForeignOtherExpensesPage(taxYearEOY),
    getForeignExpensesCheckYourAnswersPage(taxYearEOY),
    postForeignExpensesCheckYourAnswersPage(taxYearEOY),
    getForeignExpensesSectionCompletePage(taxYearEOY),
    postForeignExpensesSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Allowances
    getForeignAllowancesStartPage(taxYearEOY),
    getForeignZeroEmissionCarAllowancePage(taxYearEOY),
    postForeignZeroEmissionCarAllowancePage(taxYearEOY),
    getForeignZeroEmissionGoodsVehiclePage(taxYearEOY),
    postForeignZeroEmissionGoodsVehiclePage(taxYearEOY),
    getForeignReplacementOfDomesticGoodsPage(taxYearEOY),
    postForeignReplacementOfDomesticGoodsPage(taxYearEOY),
    getForeignOtherCapitalAllowancesPage(taxYearEOY),
    postForeignOtherCapitalAllowancesPage(taxYearEOY),
    getForeignAllowancesCheckYourAnswersPage(taxYearEOY),
    postForeignAllowancesCheckYourAnswersPage(taxYearEOY),
    getForeignAllowancesSectionCompletePage(taxYearEOY),
    postForeignAllowancesSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Structures and Buildings Allowance
    getForeignClaimSBAPage(taxYearEOY),
    postForeignSBAPage(taxYearEOY),
    getForeignSBAAddClaimPage(taxYearEOY),
    getForeignSBAQualifyingDatePage(taxYearEOY),
    postForeignSBAQualifyingDatePage(taxYearEOY),
    getForeignSBAQualifyingAmountPage(taxYearEOY),
    postForeignSBAQualifyingAmountPage(taxYearEOY),
    getForeignSBAHowMuchIsYourClaimPage(taxYearEOY),
    postForeignSBAHowMuchIsYourClaimPage(taxYearEOY),
    getForeignSBAAddressPage(taxYearEOY),
    postForeignSBAAddressPage(taxYearEOY),
    getForeignSBACheckYourAnswersPage(taxYearEOY),
    getForeignSBAClaimsPage(taxYearEOY),
    postForeignSBAClaimsPage(taxYearEOY),
    getForeignSBASectionCompletePage(taxYearEOY),
    postForeignSBASectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Adjustments
    getForeignAdjustmentsStartPage(taxYearEOY),
    getForeignPrivateUseAdjustmentPage(taxYearEOY),
    postForeignPrivateUseAdjustmentPage(taxYearEOY),
    getForeignBalancingChargePage(taxYearEOY),
    postForeignBalancingChargePage(taxYearEOY),
    getForeignResidentialFinanceCostsPage(taxYearEOY),
    postForeignResidentialFinanceCostsPage(taxYearEOY),
    getForeignUnusedResidentialFinanceCostsPage(taxYearEOY),
    postForeignUnusedResidentialFinanceCostsPage(taxYearEOY),
    getForeignUnusedLossesPage(taxYearEOY),
    postForeignUnusedLossesPage(taxYearEOY),
    getForeignWhenYouReportedTheLossPage(taxYearEOY),
    postForeignWhenYouReportedTheLossPage(taxYearEOY),
    getForeignAdjustmentsCheckYourAnswersPage(taxYearEOY),
    postForeignAdjustmentsCheckYourAnswersPage(taxYearEOY),
    getForeignAdjustmentsSectionCompletePage(taxYearEOY),
    postForeignAdjustmentsSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
  )

  def foreignPropertyAgentEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC180000A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AC180000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getForeignPropertyDetailsPage(taxYearEOY),
    getForeignPropertyTotalIncome(taxYearEOY),
    postForeignPropertyTotalIncome(taxYearEOY),
    getForeignPropertyReportIncome(taxYearEOY),
    postForeignPropertyReportIncome(taxYearEOY),
    getWhichCountryDidYouReceiveIncomeFrom(taxYearEOY),
    postWhichCountryDidYouReceiveIncomeFrom(taxYearEOY),
    getCountriesWhereRentedOutProperty(taxYearEOY),
    postCountriesWhereRentedOutProperty(taxYearEOY),
    getClaimPropertyAllowanceOrExpenses(taxYearEOY),
    postClaimPropertyAllowanceOrExpenses(taxYearEOY, claimPIA = true),
    getForeignCheckYourAnswers(taxYearEOY),
    postForeignCheckYourAnswers(taxYearEOY),
    getForeignHaveYouFinishedSection(taxYearEOY),
    postForeignHaveYouFinishedSection(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),


    // Foreign Property - Foreign Tax
    getForeignTaxStartPage(taxYearEOY),
    postForeignTaxStartPage(taxYearEOY),
    getForeignTaxCreditReliefPage(taxYearEOY),
    postForeignTaxCreditReliefPage(taxYearEOY),
    getForeignTaxCheckYourAnswersPage(taxYearEOY),
    postForeignTaxCheckYourAnswersPage(taxYearEOY),
    getForeignTaxSectionCompletePage(taxYearEOY),
    postForeignTaxSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Income
    getForeignIncomeStartPage(taxYearEOY),
    getForeignPropertyRentalIncomeStartPage(taxYearEOY),
    postForeignPropertyRentalIncomeStartPage(taxYearEOY),
    getForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYearEOY),
    postForeignDidYouReceiveAPremiumForGrantOfLeasePage(taxYearEOY),
    getForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYearEOY),
    postForeignHaveYouCalculatedAmountForPremiumGrantOfLeasePage(taxYearEOY),
    getForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYearEOY),
    postForeignHowMuchDidYouReceiveForGrantOfLeasePage(taxYearEOY),
    getForeignCompletePeriodsInTermOfLeasePage(taxYearEOY),
    postForeignCompletePeriodsInTermOfLeasePage(taxYearEOY),
    getForeignPremiumsForGrantOfLeasePage(taxYearEOY),
    postForeignPremiumsForGrantOfLeasePage(taxYearEOY),
    getForeignOtherPropertyIncomePage(taxYearEOY),
    postForeignOtherPropertyIncomePage(taxYearEOY),
    getForeignIncomeCheckYourAnswersPage(taxYearEOY),
    postForeignIncomeCheckYourAnswersPage(taxYearEOY),
    getForeignIncomeSectionCompletePage(taxYearEOY),
    postForeignIncomeSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    // Foreign Property - Adjustments
    getForeignAdjustmentsStartPage(taxYearEOY),
    getForeignPrivateUseAdjustmentPage(taxYearEOY),
    postForeignPrivateUseAdjustmentPage(taxYearEOY),
    getForeignBalancingChargePage(taxYearEOY),
    postForeignBalancingChargePage(taxYearEOY),
    getForeignYourPIAClaimPage(taxYearEOY),
    postForeignYourPIAClaimPage(taxYearEOY),
    getForeignUnusedLossesPage(taxYearEOY),
    postForeignUnusedLossesPage(taxYearEOY),
    getForeignWhenYouReportedTheLossPage(taxYearEOY),
    postForeignWhenYouReportedTheLossPage(taxYearEOY),
    getForeignAdjustmentsCheckYourAnswersPage(taxYearEOY),
    postForeignAdjustmentsCheckYourAnswersPage(taxYearEOY),
    getForeignAdjustmentsSectionCompletePage(taxYearEOY),
    postForeignAdjustmentsSectionCompletePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
  )
}
