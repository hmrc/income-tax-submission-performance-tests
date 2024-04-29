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

package uk.gov.hmrc.perftests.itsass.simSteps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.PaymentsIntoPensionsRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}
import uk.gov.hmrc.perftests.itsass.requests.UnauthorisedPaymentsFromPensionsRequests.{getAmountThatDidNotResultInASurcharge, getAmountThatResultedInASurcharge, getCheckYourUnauthorisedPayments, getDidYouPayNonUkOnAmountSurcharge, getDidYouPayNonUkOnAmountThatDidNotSurcharge, getPensionSchemeTaxReference, getRemovePensionSchemeTaxReference, getUnauthorisedPayments, getUnauthorisedPaymentsFromUKPensionScheme, getWereAnyOfThePaymentFromAUKPension, postAmountThatDidNotResultInASurcharge, postAmountThatResultedInASurcharge, postDidYouPayNonUkOnAmountSurcharge, postDidYouPayNonUkOnAmountThatDidSurcharge, postPensionSchemeTaxReference, postRemovePensionSchemeTaxReference, postUnauthorisedPayments, postWereAnyOfThePaymentFromAUKPension}

trait PensionsSimSteps extends PerformanceTestRunner {

  def paymentsIntoPensionAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPensionsSummaryPage(taxYearEOY),
    getReliefAtSourcePensionsPage(taxYearEOY),
    postReliefAtSourcePensionsPage(taxYearEOY),
    getTotalPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    postTotalPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    getDidYouMakeOneOffPaymentsPage(taxYearEOY),
    postDidYouMakeOneOffPaymentsPage(taxYearEOY),
    getTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    postTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    getYourTotalPaymentsIntoReliefAtSourcePage(taxYearEOY),
    postYourTotalPaymentsIntoReliefAtSourcePage(taxYearEOY),
    getPensionsWhereTaxReliefIsNotClaimedPage(taxYearEOY),
    postPensionsWhereTaxReliefIsNotClaimedPage(taxYearEOY),
    getDidYouPayIntoRetirementAnnuityContractPage(taxYearEOY),
    postDidYouPayIntoRetirementAnnuityContractPage(taxYearEOY),
    getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYearEOY),
    postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYearEOY),
    getDidYouPayIntoWorkplacePensionPage(taxYearEOY),
    postDidYouPayIntoWorkplacePensionPage(taxYearEOY),
    getHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYearEOY),
    postHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYearEOY),
    getCheckYourPaymentsIntoPensions(taxYearEOY)
  )

  def paymentsIntoPensionsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPensionsSummaryPage(taxYearEOY),
    getReliefAtSourcePensionsPage(taxYearEOY),
    postReliefAtSourcePensionsPage(taxYearEOY),
    getTotalPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    postTotalPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    getDidYouMakeOneOffPaymentsPage(taxYearEOY),
    postDidYouMakeOneOffPaymentsPage(taxYearEOY),
    getTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    postTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYearEOY),
    getYourTotalPaymentsIntoReliefAtSourcePage(taxYearEOY),
    postYourTotalPaymentsIntoReliefAtSourcePage(taxYearEOY),
    getPensionsWhereTaxReliefIsNotClaimedPage(taxYearEOY),
    postPensionsWhereTaxReliefIsNotClaimedPage(taxYearEOY),
    getDidYouPayIntoRetirementAnnuityContractPage(taxYearEOY),
    postDidYouPayIntoRetirementAnnuityContractPage(taxYearEOY),
    getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYearEOY),
    postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYearEOY),
    getDidYouPayIntoWorkplacePensionPage(taxYearEOY),
    postDidYouPayIntoWorkplacePensionPage(taxYearEOY),
    getHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYearEOY),
    postHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYearEOY),
    getCheckYourPaymentsIntoPensions(taxYearEOY)
  )

  def unauthorisedPaymentsFromPensionsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPensionsSummaryPage(taxYearEOY),
    getUnauthorisedPayments(taxYearEOY),
    postUnauthorisedPayments(taxYearEOY),
    getAmountThatResultedInASurcharge(taxYearEOY),
    postAmountThatResultedInASurcharge(taxYearEOY),
    getDidYouPayNonUkOnAmountSurcharge(taxYearEOY),
    postDidYouPayNonUkOnAmountSurcharge(taxYearEOY),
    getAmountThatDidNotResultInASurcharge(taxYearEOY),
    postAmountThatDidNotResultInASurcharge(taxYearEOY),
    getDidYouPayNonUkOnAmountThatDidNotSurcharge(taxYearEOY),
    postDidYouPayNonUkOnAmountThatDidSurcharge(taxYearEOY),
    getWereAnyOfThePaymentFromAUKPension(taxYearEOY),
    postWereAnyOfThePaymentFromAUKPension(taxYearEOY),
    getPensionSchemeTaxReference(taxYearEOY),
    postPensionSchemeTaxReference(taxYearEOY),
    getUnauthorisedPaymentsFromUKPensionScheme(taxYearEOY),
    getRemovePensionSchemeTaxReference(taxYearEOY),
    postRemovePensionSchemeTaxReference(taxYearEOY),
    getCheckYourUnauthorisedPayments(taxYearEOY),

  )

  def unauthorisedPaymentsFromPensionsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA370343B", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getPensionsSummaryPage(taxYear),
    getUnauthorisedPayments(taxYear),
    postUnauthorisedPayments(taxYear),
    getAmountThatResultedInASurcharge(taxYear),
    postAmountThatResultedInASurcharge(taxYear),
    getDidYouPayNonUkOnAmountSurcharge(taxYear),
    postDidYouPayNonUkOnAmountSurcharge(taxYear),
    getAmountThatDidNotResultInASurcharge(taxYear),
    postAmountThatDidNotResultInASurcharge(taxYear),
    getDidYouPayNonUkOnAmountThatDidNotSurcharge(taxYear),
    postDidYouPayNonUkOnAmountThatDidSurcharge(taxYear),
    getWereAnyOfThePaymentFromAUKPension(taxYear),
    postWereAnyOfThePaymentFromAUKPension(taxYear),
    getPensionSchemeTaxReference(taxYear),
    postPensionSchemeTaxReference(taxYear),
    getUnauthorisedPaymentsFromUKPensionScheme(taxYear),
    getCheckYourUnauthorisedPayments(taxYear),

  )

}
