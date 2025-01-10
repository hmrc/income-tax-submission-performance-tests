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
import uk.gov.hmrc.perftests.itsass.requests.BenefitsRequests._
import uk.gov.hmrc.perftests.itsass.requests.EmploymentsRequests._
import uk.gov.hmrc.perftests.itsass.requests.ExpensesRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}

trait EmploymentsSimSteps extends PerformanceTestRunner {

  def employmentIndividualCurrentTaxYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getCheckEmploymentDetailsPage(taxYear, "5e5271a9-4424-416b-8c7f-913811541375"),
    getCheckEmploymentBenefitsPage(taxYear, "5e5271a9-4424-416b-8c7f-913811541375"),
    getCheckEmploymentExpensesPage(taxYear)
  )

  def employmentAgentCurrentTaxYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentDetailsPage(taxYearEOY, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentBenefitsPage(taxYearEOY, employmentId = "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getCheckEmploymentExpensesPage(taxYearEOY)
  )

  def addEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123456A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getNewEmploymentUUID(taxYearEOY),
    getEmployerNamePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmployerNamePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentStartDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmploymentStartDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getDidYouLeaveThisEmployerPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postDidYouLeaveThisEmployerPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentEndDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmploymentEndDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayeRefPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayeRefPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayrollIdPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayrollIdPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayEmploymentPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayEmploymentPage(taxYearEOY,1000,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getUkTaxEmploymentPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postUkTaxEmploymentPage(taxYearEOY,555,"1c09adb7-8bd7-48da-bc0c-f10108758d6a")
  )

  def addEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerNamePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmployerNamePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentStartDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmploymentStartDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getDidYouLeaveThisEmployerPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postDidYouLeaveThisEmployerPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentEndDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postEmploymentEndDatePage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayeRefPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayeRefPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayrollIdPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayrollIdPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getPayEmploymentPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postPayEmploymentPage(taxYearEOY,1000,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getUkTaxEmploymentPage(taxYearEOY,"1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postUkTaxEmploymentPage(taxYearEOY,555,"1c09adb7-8bd7-48da-bc0c-f10108758d6a")
  )

  def employmentBenefitsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentBenefitsWithoutBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage(taxYearEOY),
    postReceivedBenefitsPage(taxYearEOY),
    getCarVanFuelBenefitsPage(taxYearEOY),
    postCarVanFuelBenefitsPage(taxYearEOY),
    getCompanyCarBenefitsPage(taxYearEOY),
    postCompanyCarBenefitsPage(taxYearEOY),
    getCompanyCarAmountBenefitsPage(taxYearEOY),
    postCompanyCarAmountBenefitsPage(taxYearEOY),
    getCompanyCarFuelBenefitsPage(taxYearEOY),
    postCompanyCarFuelBenefitsPage(taxYearEOY),
    getCompanyCarFuelAmountBenefitsPage(taxYearEOY),
    postCompanyCarFuelAmountBenefitsPage(taxYearEOY),
    getCompanyVanBenefitsPage(taxYearEOY),
    postCompanyVanBenefitsPage(taxYearEOY),
    getCompanyVanAmountBenefitsPage(taxYearEOY),
    postCompanyVanAmountBenefitsPage(taxYearEOY),
    getCompanyVanFuelBenefitsPage(taxYearEOY),
    postCompanyVanFuelBenefitsPage(taxYearEOY),
    getCompanyVanFuelAmountBenefitsPage(taxYearEOY),
    postCompanyVanFuelAmountBenefitsPage(taxYearEOY),
    getMileageBenefitsPage(taxYearEOY),
    postMileageBenefitsPage(taxYearEOY),
    getMileageBenefitsAmountPage(taxYearEOY),
    postMileageBenefitsAmountPage(taxYearEOY),
    getAccommodationRelocationBenefitsPage(taxYearEOY),
    postAccommodationRelocationBenefitsPage(taxYearEOY),
    getAccommodationBenefitsPage(taxYearEOY),
    postAccommodationBenefitsPage(taxYearEOY),
    getAccommodationAmountBenefitsPage(taxYearEOY),
    postAccommodationAmountBenefitsPage(taxYearEOY),
    getQualifyingRelocationBenefitsPage(taxYearEOY),
    postQualifyingRelocationBenefitsPage(taxYearEOY),
    getQualifyingRelocationAmountBenefitsPage(taxYearEOY),
    postQualifyingRelocationAmountBenefitsPage(taxYearEOY),
    getNonQualifyingRelocationBenefitsPage(taxYearEOY),
    postNonQualifyingRelocationBenefitsPage(taxYearEOY),
    getNonQualifyingRelocationAmountBenefitsPage(taxYearEOY),
    postNonQualifyingRelocationAmountBenefitsPage(taxYearEOY),
    getTravelOrEntertainmentBenefitsPage(taxYearEOY),
    postTravelOrEntertainmentBenefitsPage(taxYearEOY),
    getTravelOrSubsistenceBenefitsPage(taxYearEOY),
    postTravelOrSubsistenceBenefitsPage(taxYearEOY),
    getTravelOrSubsistenceAmountBenefitsPage(taxYearEOY),
    postTravelOrSubsistenceAmountBenefitsPage(taxYearEOY),
    getIncidentalOvernightCostsBenefitsPage(taxYearEOY),
    postIncidentalOvernightCostsBenefitsPage(taxYearEOY),
    getIncidentalOvernightCostsAmountBenefitsPage(taxYearEOY),
    postIncidentalOvernightCostsAmountBenefitsPage(taxYearEOY),
    getEntertainmentBenefitsPage(taxYearEOY),
    postEntertainmentBenefitsPage(taxYearEOY),
    getEntertainmentAmountBenefitsPage(taxYearEOY),
    postEntertainmentAmountBenefitsPage(taxYearEOY),
    getUtilitiesBenefitsPage(taxYearEOY),
    postUtilitiesBenefitsPage(taxYearEOY),
    getTelephoneBenefitsPage(taxYearEOY),
    postTelephoneBenefitsPage(taxYearEOY),
    getTelephoneAmountBenefitsPage(taxYearEOY),
    postTelephoneAmountBenefitsPage(taxYearEOY),
    getEmployerServicesBenefitsPage(taxYearEOY),
    postEmployerServicesBenefitsPage(taxYearEOY),
    getEmployerServicesAmountBenefitsPage(taxYearEOY),
    postEmployerServicesAmountBenefitsPage(taxYearEOY),
    getProfessionalFeesBenefitsPage(taxYearEOY),
    postProfessionalFeesBenefitsPage(taxYearEOY),
    getProfessionalFeesAmountBenefitsPage(taxYearEOY),
    postProfessionalFeesAmountBenefitsPage(taxYearEOY),
    getOtherServicesBenefitsPage(taxYearEOY),
    postOtherServicesBenefitsPage(taxYearEOY),
    getOtherServicesAmountBenefitsPage(taxYearEOY),
    postOtherServicesAmountBenefitsPage(taxYearEOY),
    getMedicalDentalChildcareBenefitsPage(taxYearEOY),
    postMedicalDentalChildcareBenefitsPage(taxYearEOY),
    getMedicalDentalBenefitsPage(taxYearEOY),
    postMedicalDentalBenefitsPage(taxYearEOY),
    getMedicalDentalAmountBenefitsPage(taxYearEOY),
    postMedicalDentalAmountBenefitsPage(taxYearEOY),
    getChildcareBenefitsPage(taxYearEOY),
    postChildcareBenefitsPage(taxYearEOY),
    getChildcareAmountBenefitsPage(taxYearEOY),
    postChildcareAmountBenefitsPage(taxYearEOY),
    getEducationalServicesBenefitsPage(taxYearEOY),
    postEducationalServicesBenefitsPage(taxYearEOY),
    getEducationalServicesAmountBenefitsPage(taxYearEOY),
    postEducationalServicesAmountBenefitsPage(taxYearEOY),
    getBeneficialLoansBenefitsPage(taxYearEOY),
    postBeneficialLoansBenefitsPage(taxYearEOY),
    getBeneficialLoansAmountBenefitsPage(taxYearEOY),
    postBeneficialLoansAmountBenefitsPage(taxYearEOY),
    getIncomeTaxOrIncurredCostsBenefitsPage(taxYearEOY),
    postIncomeTaxOrIncurredCostsBenefitsPage(taxYearEOY),
    getIncomeTaxBenefitsPage(taxYearEOY),
    postIncomeTaxBenefitsPage(taxYearEOY),
    getIncomeTaxAmountBenefitsPage(taxYearEOY),
    postIncomeTaxAmountBenefitsPage(taxYearEOY),
    getIncurredCostsBenefitsPage(taxYearEOY),
    postIncurredCostsBenefitsPage(taxYearEOY),
    getIncurredCostsAmountBenefitsPage(taxYearEOY),
    postIncurredCostsAmountBenefitsPage(taxYearEOY),
    getReimbursedCostsVouchersNonCashBenefitsPage(taxYearEOY),
    postReimbursedCostsVouchersNonCashBenefitsPage(taxYearEOY),
    getNonTaxableCostsBenefitsPage(taxYearEOY),
    postNonTaxableCostsBenefitsPage(taxYearEOY),
    getNonTaxableCostsAmountBenefitsPage(taxYearEOY),
    postNonTaxableCostsAmountBenefitsPage(taxYearEOY),
    getTaxableCostsBenefitsPage(taxYearEOY),
    postTaxableCostsBenefitsPage(taxYearEOY),
    getTaxableCostsAmountBenefitsPage(taxYearEOY),
    postTaxableCostsAmountBenefitsPage(taxYearEOY),
    getVouchersOrCreditCardsBenefitsPage(taxYearEOY),
    postVouchersOrCreditCardsBenefitsPage(taxYearEOY),
    getVouchersOrCreditCardsAmountBenefitsPage(taxYearEOY),
    postVouchersOrCreditCardsAmountBenefitsPage(taxYearEOY),
    getNonCashBenefitsPage(taxYearEOY),
    postNonCashBenefitsPage(taxYearEOY),
    getNonCashAmountBenefitsPage(taxYearEOY),
    postNonCashAmountBenefitsPage(taxYearEOY),
    getOtherBenefitsPage(taxYearEOY),
    postOtherBenefitsPage(taxYearEOY),
    getOtherBenefitsAmountPage(taxYearEOY),
    postOtherBenefitsAmountPage(taxYearEOY),
    getAssetsOrAssetsTransferBenefitsPage(taxYearEOY),
    postAssetsOrAssetsTransferBenefitsPage(taxYearEOY),
    getAssetsBenefitsPage(taxYearEOY),
    postAssetsBenefitsPage(taxYearEOY),
    getAssetsBenefitsAmountPage(taxYearEOY),
    postAssetsBenefitsAmountPage(taxYearEOY),
    getAssetsTransferBenefitsPage(taxYearEOY),
    postAssetsTransferBenefitsPage(taxYearEOY),
    getAssetsTransferBenefitsAmountPage(taxYearEOY),
    postAssetsTransferBenefitsAmountPage(taxYearEOY),
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb")
  )

  def employmentExpensesIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    getCheckEmploymentExpensesPage(taxYearEOY),
    getExpensesInterruptPage(taxYearEOY),
    postExpensesInterruptPage(taxYearEOY),
    getClaimingExpensesPage(taxYearEOY),
    postClaimingExpensesPage(taxYearEOY),
    getTravelAndOvernightExpensesPage(taxYearEOY),
    postTravelAndOvernightExpensesPage(taxYearEOY),
    getTravelAndOvernightExpensesAmountPage(taxYearEOY),
    postTravelAndOvernightExpensesAmountPage(taxYearEOY),
    getUniformsOrToolsExpensesPage(taxYearEOY),
    postUniformsOrToolsExpensesPage(taxYearEOY),
    getUniformsOrToolsExpensesAmountPage(taxYearEOY),
    postUniformsOrToolsExpensesAmountPage(taxYearEOY),
    getProfessionalSubscriptionsExpensesPage(taxYearEOY),
    postProfessionalSubscriptionsExpensesPage(taxYearEOY),
    getProfessionalSubscriptionsExpensesAmountPage(taxYearEOY),
    postProfessionalSubscriptionsExpensesAmountPage(taxYearEOY),
    getOtherEquipmentExpensesPage(taxYearEOY),
    postOtherEquipmentExpensesPage(taxYearEOY),
    getOtherEquipmentExpensesAmountPage(taxYearEOY),
    postOtherEquipmentExpensesAmountPage(taxYearEOY),
  )

  def employmentExpensesAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getCheckEmploymentExpensesPage(taxYearEOY),
    getExpensesInterruptPage(taxYearEOY),
    postExpensesInterruptPage(taxYearEOY),
    getClaimingExpensesPage(taxYearEOY),
    postClaimingExpensesPage(taxYearEOY),
    getTravelAndOvernightExpensesPage(taxYearEOY),
    postTravelAndOvernightExpensesPage(taxYearEOY),
    getTravelAndOvernightExpensesAmountPage(taxYearEOY),
    postTravelAndOvernightExpensesAmountPage(taxYearEOY),
    getUniformsOrToolsExpensesPage(taxYearEOY),
    postUniformsOrToolsExpensesPage(taxYearEOY),
    getUniformsOrToolsExpensesAmountPage(taxYearEOY),
    postUniformsOrToolsExpensesAmountPage(taxYearEOY),
    getProfessionalSubscriptionsExpensesPage(taxYearEOY),
    postProfessionalSubscriptionsExpensesPage(taxYearEOY),
    getProfessionalSubscriptionsExpensesAmountPage(taxYearEOY),
    postProfessionalSubscriptionsExpensesAmountPage(taxYearEOY),
    getOtherEquipmentExpensesPage(taxYearEOY),
    postOtherEquipmentExpensesPage(taxYearEOY),
    getOtherEquipmentExpensesAmountPage(taxYearEOY),
    postOtherEquipmentExpensesAmountPage(taxYearEOY),
  )

  def addNewEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "XAIT00000888888", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    postCheckEmploymentDetailsPage(taxYearEOY, "0f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage(taxYearEOY),
    postReceivedBenefitsPage(taxYearEOY,false),
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getClaimingExpensesPage(taxYearEOY),
    postClaimingExpensesPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def addNewEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getSelectEmploymentPage(taxYearEOY),
    postSelectEmploymentPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    postCheckEmploymentDetailsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getReceivedBenefitsPage(taxYearEOY),
    postReceivedBenefitsPage(taxYearEOY,false),
    getCheckEmploymentBenefitsPage(taxYearEOY, "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"),
    getClaimingExpensesPage(taxYearEOY),
    postClaimingExpensesPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def removeEmploymentIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    postRemoveEmploymentPage(taxYearEOY, "516441e9-aac7-40fe-9444-2f2c7e4d165d"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def removeEmploymentAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentGatewayPage(taxYearEOY),
    postEmploymentGatewayPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY, "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    postRemoveEmploymentPage(taxYearEOY, "1c09adb7-8bd7-48da-bc0c-f10108758d6a"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  def employmentOPWIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getPayEmploymentPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postPayEmploymentPage(taxYearEOY,555,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerIncomeWarningPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getUkTaxEmploymentPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postUkTaxEmploymentPage(taxYearEOY, 600,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerTaxWarningPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerOffPayrollWorkingPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postEmployerOffPayrollWorkingPage(taxYearEOY,false,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerOffPayrollWorkingWarningPage(taxYearEOY,"3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079")
  )

  def employmentOPWAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getPayEmploymentPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postPayEmploymentPage(taxYearEOY, 555, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerIncomeWarningPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getUkTaxEmploymentPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postUkTaxEmploymentPage(taxYearEOY, 600, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerTaxWarningPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerOffPayrollWorkingPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postEmployerOffPayrollWorkingPage(taxYearEOY, true, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getEmployerOffPayrollWorkingWarningPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    getCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079"),
    postCheckEmploymentDetailsPage(taxYearEOY, "3c891e58-9b21-4296-8ecd-76f771c5d079")
  )
}
