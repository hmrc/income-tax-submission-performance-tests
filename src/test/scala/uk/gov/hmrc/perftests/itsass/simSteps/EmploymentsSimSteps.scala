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

  def employmentIndividualCurrentTaxYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getCheckEmploymentDetailsPage(taxYear, "5e5271a9-4424-416b-8c7f-913811541375"),
    getCheckEmploymentBenefitsPage(taxYear, "5e5271a9-4424-416b-8c7f-913811541375"),
    getCheckEmploymentExpensesPage(taxYear)
  )

  def employmentAgentCurrentTaxYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getEmployerDetailsAndBenefitsPage(taxYear, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentDetailsPage(taxYear, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentBenefitsPage(taxYear, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentExpensesPage(taxYear)
  )

  def addEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123456A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getNewEmploymentUUID(taxYearEOY),
    getEmployerNamePage(taxYearEOY),
    postEmployerNamePage(taxYearEOY),
    getPayeRefPage(taxYearEOY),
    postPayeRefPage(taxYearEOY),
    getDidYouLeaveThisEmployerPage(taxYearEOY),
    postDidYouLeaveThisEmployerPage(taxYearEOY),
    getEmploymentDatesPage(taxYearEOY),
    postEmploymentDatesPage(taxYearEOY),
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
    getDidYouLeaveThisEmployerPage(taxYearEOY),
    postDidYouLeaveThisEmployerPage(taxYearEOY),
    getEmploymentDatesPage(taxYearEOY),
    postEmploymentDatesPage(taxYearEOY),
    getPayrollIdPage(taxYearEOY),
    postPayrollIdPage(taxYearEOY),
    getPayEmploymentPage(taxYearEOY),
    postPayEmploymentPage(taxYearEOY),
    getUkTaxEmploymentPage(taxYearEOY),
    postUkTaxEmploymentPage(taxYearEOY)
  )

  def employmentBenefitsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentBenefitsWithoutBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage(),
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
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb")
  )

  def employmentExpensesIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    getCheckEmploymentExpensesPage(taxYearEOY),
    getExpensesInterruptPage(taxYearEOY),
    postExpensesInterruptPage(taxYearEOY),
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
    getCheckEmploymentExpensesPage(taxYearEOY),
    getExpensesInterruptPage(taxYearEOY),
    postExpensesInterruptPage(taxYearEOY),
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
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    postCheckEmploymentDetailsPage(taxYearEOY, "0f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage(false),
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
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
    getSelectEmploymentPage(taxYearEOY),
    postSelectEmploymentPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    postCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage,
    postReceivedBenefitsPage(false),
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getClaimingExpensesPage,
    postClaimingExpensesPage,
    getEmploymentSummaryPage(taxYearEOY)
  )

  def removeEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    postRemoveEmploymentPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    getEmploymentSummaryPage(taxYearEOY) //TODO - change to EOY overview page once caching problem is resolved
  )

  def removeEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postRemoveEmploymentPage(taxYearEOY, "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentSummaryPage(taxYearEOY)
  )
}
