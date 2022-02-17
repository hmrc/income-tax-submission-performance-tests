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

package uk.gov.hmrc.perftests.itsass.simSteps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.BenefitsRequests._
import uk.gov.hmrc.perftests.itsass.requests.EmploymentsRequests._
import uk.gov.hmrc.perftests.itsass.requests.ExpensesRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}

trait EmploymentsSimSteps extends PerformanceTestRunner {

  def employmentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getEmploymentDetailsPage(taxYear, "00000000-0000-1000-8000-000000000000"),
    getEmploymentBenefitsPage(taxYear, "00000000-0000-1000-8000-000000000000"),
    getEmploymentExpensesPage(taxYear)
  )

  def employmentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getEmployerDetailsAndBenefitsPage(taxYear, employmentId = "00000000-5555-0000-0000-000000000001"),
    getEmploymentDetailsPage(taxYear, employmentId = "00000000-5555-0000-0000-000000000001"),
    getEmploymentBenefitsPage(taxYear, employmentId = "00000000-5555-0000-0000-000000000001"),
    getEmploymentExpensesPage(taxYear)
  )

  def addEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123456A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getAddEmploymentPage(taxYearEOY),
    postAddEmploymentPage(taxYearEOY),
    getEmployerNamePage(taxYearEOY),
    postEmployerNamePage(taxYearEOY),
    getPayeRefPage(taxYearEOY),
    postPayeRefPage(taxYearEOY),
    getEmploymentStartDatePage(taxYearEOY),
    postEmploymentStartDate(taxYearEOY),
    getAreYouStillWorkingAtEmployerPage(taxYearEOY),
    postAreYouStillWorkingAtEmployerPage(taxYearEOY),
    getWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    postWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    getPayrollIdPage(taxYearEOY),
    postPayrollIdPage(taxYearEOY),
    getPayEmploymentPage(taxYearEOY),
    postPayEmploymentPage(taxYearEOY),
    getUkTaxEmploymentPage(taxYearEOY),
    postUkTaxEmploymentPage(taxYearEOY)
  )

  def addEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerNamePage(taxYearEOY),
    postEmployerNamePage(taxYearEOY),
    getPayeRefPage(taxYearEOY),
    postPayeRefPage(taxYearEOY),
    getEmploymentStartDatePage(taxYearEOY),
    postEmploymentStartDate(taxYearEOY),
    getAreYouStillWorkingAtEmployerPage(taxYearEOY),
    postAreYouStillWorkingAtEmployerPage(taxYearEOY),
    getWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    postWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    getPayrollIdPage(taxYearEOY),
    postPayrollIdPage(taxYearEOY),
    getPayEmploymentPage(taxYearEOY),
    postPayEmploymentPage(taxYearEOY),
    getUkTaxEmploymentPage(taxYearEOY),
    postUkTaxEmploymentPage(taxYearEOY)
  )

  def removeEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "00000000-0000-1000-8000-000000000004"),
    postRemoveEmploymentPage(taxYearEOY, "00000000-0000-1000-8000-000000000004"),
    getEmploymentSummaryPage(taxYearEOY) //TODO - change to EOY overview page once caching problem is resolved
  )

  def removeEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "00000000-5555-0000-0000-000000000001"),
    postRemoveEmploymentPage(taxYearEOY, "00000000-5555-0000-0000-000000000001"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def employmentDetailsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "00000000-5555-5555-0000-000000000002"),
    getEmploymentDetailsPage(taxYearEOY, "00000000-5555-5555-0000-000000000002"),
    postEmploymentDetailsPage(taxYearEOY, "00000000-5555-5555-0000-000000000002"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def employmentBenefitsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getEmploymentBenefitsWithoutBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage,
    getCarVanFuelBenefitsPage,
    postCarVanFuelBenefitsPage,
    getCompanyCarBenefitsPage,
    postCompanyCarBenefitsPage,
    getCompanyCarAmountBenefitsPage,
    postCompanyCarAmountBenefitsPage,
    getCompanyCarFuelBenefitsPage,
    postCompanyCarFuelBenefitsPage,
    getCompanyCarFuelAmountBenefitsPage,
    postCompanyCarFuelAmountBenefitsPage,
    getCompanyVanBenefitsPage,
    postCompanyVanBenefitsPage,
    getCompanyVanAmountBenefitsPage,
    postCompanyVanAmountBenefitsPage,
    getCompanyVanFuelBenefitsPage,
    postCompanyVanFuelBenefitsPage,
    getCompanyVanFuelAmountBenefitsPage,
    postCompanyVanFuelAmountBenefitsPage,
    getMileageBenefitsPage,
    postMileageBenefitsPage,
    getMileageBenefitsAmountPage,
    postMileageBenefitsAmountPage,
    getAccommodationRelocationBenefitsPage,
    postAccommodationRelocationBenefitsPage,
    getAccommodationBenefitsPage,
    postAccommodationBenefitsPage,
    getAccommodationAmountBenefitsPage,
    postAccommodationAmountBenefitsPage,
    getQualifyingRelocationBenefitsPage,
    postQualifyingRelocationBenefitsPage,
    getQualifyingRelocationAmountBenefitsPage,
    postQualifyingRelocationAmountBenefitsPage,
    getNonQualifyingRelocationBenefitsPage,
    postNonQualifyingRelocationBenefitsPage,
    getNonQualifyingRelocationAmountBenefitsPage,
    postNonQualifyingRelocationAmountBenefitsPage,
    getTravelOrEntertainmentBenefitsPage,
    postTravelOrEntertainmentBenefitsPage,
    getTravelOrSubsistenceBenefitsPage,
    postTravelOrSubsistenceBenefitsPage,
    getTravelOrSubsistenceAmountBenefitsPage,
    postTravelOrSubsistenceAmountBenefitsPage,
    getIncidentalOvernightCostsBenefitsPage,
    postIncidentalOvernightCostsBenefitsPage,
    getIncidentalOvernightCostsAmountBenefitsPage,
    postIncidentalOvernightCostsAmountBenefitsPage,
    getEntertainmentBenefitsPage,
    postEntertainmentBenefitsPage,
    getEntertainmentAmountBenefitsPage,
    postEntertainmentAmountBenefitsPage,
    getUtilitiesBenefitsPage,
    postUtilitiesBenefitsPage,
    getTelephoneBenefitsPage,
    postTelephoneBenefitsPage,
    getTelephoneAmountBenefitsPage,
    postTelephoneAmountBenefitsPage,
    getEmployerServicesBenefitsPage,
    postEmployerServicesBenefitsPage,
    getEmployerServicesAmountBenefitsPage,
    postEmployerServicesAmountBenefitsPage,
    getProfessionalFeesBenefitsPage,
    postProfessionalFeesBenefitsPage,
    getProfessionalFeesAmountBenefitsPage,
    postProfessionalFeesAmountBenefitsPage,
    getOtherServicesBenefitsPage,
    postOtherServicesBenefitsPage,
    getOtherServicesAmountBenefitsPage,
    postOtherServicesAmountBenefitsPage,
    getMedicalDentalChildcareBenefitsPage,
    postMedicalDentalChildcareBenefitsPage,
    getMedicalDentalBenefitsPage,
    postMedicalDentalBenefitsPage,
    getMedicalDentalAmountBenefitsPage,
    postMedicalDentalAmountBenefitsPage,
    getChildcareBenefitsPage,
    postChildcareBenefitsPage,
    getChildcareAmountBenefitsPage,
    postChildcareAmountBenefitsPage,
    getEducationalServicesBenefitsPage,
    postEducationalServicesBenefitsPage,
    getEducationalServicesAmountBenefitsPage,
    postEducationalServicesAmountBenefitsPage,
    getBeneficialLoansBenefitsPage,
    postBeneficialLoansBenefitsPage,
    getBeneficialLoansAmountBenefitsPage,
    postBeneficialLoansAmountBenefitsPage,
    getIncomeTaxOrIncurredCostsBenefitsPage,
    postIncomeTaxOrIncurredCostsBenefitsPage,
    getIncomeTaxBenefitsPage,
    postIncomeTaxBenefitsPage,
    getIncomeTaxAmountBenefitsPage,
    postIncomeTaxAmountBenefitsPage,
    getIncurredCostsBenefitsPage,
    postIncurredCostsBenefitsPage,
    getIncurredCostsAmountBenefitsPage,
    postIncurredCostsAmountBenefitsPage,
    getReimbursedCostsVouchersNonCashBenefitsPage,
    postReimbursedCostsVouchersNonCashBenefitsPage,
    getNonTaxableCostsBenefitsPage,
    postNonTaxableCostsBenefitsPage,
    getNonTaxableCostsAmountBenefitsPage,
    postNonTaxableCostsAmountBenefitsPage,
    getTaxableCostsBenefitsPage,
    postTaxableCostsBenefitsPage,
    getTaxableCostsAmountBenefitsPage,
    postTaxableCostsAmountBenefitsPage,
    getVouchersOrCreditCardsBenefitsPage,
    postVouchersOrCreditCardsBenefitsPage,
    getVouchersOrCreditCardsAmountBenefitsPage,
    postVouchersOrCreditCardsAmountBenefitsPage,
    getNonCashBenefitsPage,
    postNonCashBenefitsPage,
    getNonCashAmountBenefitsPage,
    postNonCashAmountBenefitsPage,
    getOtherBenefitsPage,
    postOtherBenefitsPage,
    getOtherBenefitsAmountPage,
    postOtherBenefitsAmountPage,
    getAssetsOrAssetsTransferBenefitsPage,
    postAssetsOrAssetsTransferBenefitsPage,
    getAssetsBenefitsPage,
    postAssetsBenefitsPage,
    getAssetsBenefitsAmountPage,
    postAssetsBenefitsAmountPage,
    getAssetsTransferBenefitsPage,
    postAssetsTransferBenefitsPage,
    getAssetsTransferBenefitsAmountPage,
    postAssetsTransferBenefitsAmountPage,
    getEmploymentBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002")
  )

  def employmentExpensesIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "00000000-0000-1000-8000-000000000004"),
    getEmploymentExpensesPage(taxYearEOY),
    getClaimingExpensesPage,
    postClaimingExpensesPage,
    getTravelAndOvernightExpensesPage,
    postTravelAndOvernightExpensesPage,
    getTravelAndOvernightExpensesAmountPage,
    postTravelAndOvernightExpensesAmountPage,
    getUniformsOrToolsExpensesPage,
    postUniformsOrToolsExpensesPage,
    getUniformsOrToolsExpensesAmountPage,
    postUniformsOrToolsExpensesAmountPage,
    getProfessionalSubscriptionsExpensesPage,
    postProfessionalSubscriptionsExpensesPage,
    getProfessionalSubscriptionsExpensesAmountPage,
    postProfessionalSubscriptionsExpensesAmountPage,
    getOtherEquipmentExpensesPage,
    postOtherEquipmentExpensesPage,
    getOtherEquipmentExpensesAmountPage,
    postOtherEquipmentExpensesAmountPage
  )

  def employmentExpensesAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmploymentExpensesPage(taxYearEOY),
    getClaimingExpensesPage,
    postClaimingExpensesPage,
    getTravelAndOvernightExpensesPage,
    postTravelAndOvernightExpensesPage,
    getTravelAndOvernightExpensesAmountPage,
    postTravelAndOvernightExpensesAmountPage,
    getUniformsOrToolsExpensesPage,
    postUniformsOrToolsExpensesPage,
    getUniformsOrToolsExpensesAmountPage,
    postUniformsOrToolsExpensesAmountPage,
    getProfessionalSubscriptionsExpensesPage,
    postProfessionalSubscriptionsExpensesPage,
    getProfessionalSubscriptionsExpensesAmountPage,
    postProfessionalSubscriptionsExpensesAmountPage,
    getOtherEquipmentExpensesPage,
    postOtherEquipmentExpensesPage,
    getOtherEquipmentExpensesAmountPage,
    postOtherEquipmentExpensesAmountPage
  )

  def addNewEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "XAIT00000888888"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getEmploymentDetailsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postEmploymentDetailsPage(taxYearEOY, "000000000-5555-0000-0000-000000000002"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage,
    getEmploymentBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getClaimingExpensesPage,
    postClaimingExpensesPage,
    getEmploymentSummaryPage(taxYearEOY)

  )

  def addNewEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getEmploymentDetailsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postEmploymentDetailsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage,
    getEmploymentBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getClaimingExpensesPage,
    postClaimingExpensesPage,
    getEmploymentSummaryPage(taxYearEOY)
  )
}
