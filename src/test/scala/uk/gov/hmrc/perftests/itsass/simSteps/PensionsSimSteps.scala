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
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.PaymentsIntoPensionsRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear
import uk.gov.hmrc.perftests.itsass.requests.UnauthorisedPaymentsFromPensionsRequests.{getAmountThatDidNotResultInASurcharge, getAmountThatResultedInASurcharge, getCheckYourUnauthorisedPayments, getDidYouPayNonUkOnAmountSurcharge, getDidYouPayNonUkOnAmountThatDidNotSurcharge, getPensionSchemeTaxReference, getRemovePensionSchemeTaxReference, getUnauthorisedPayments, getUnauthorisedPaymentsFromUKPensionScheme, getWereAnyOfThePaymentFromAUKPension, postAmountThatDidNotResultInASurcharge, postAmountThatResultedInASurcharge, postDidYouPayNonUkOnAmountSurcharge, postDidYouPayNonUkOnAmountThatDidSurcharge, postPensionSchemeTaxReference, postRemovePensionSchemeTaxReference, postUnauthorisedPayments, postWereAnyOfThePaymentFromAUKPension}

trait PensionsSimSteps extends PerformanceTestRunner {

  def paymentsIntoPensionAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getPensionsSummaryPage(taxYear),
    getReliefAtSourcePensionsPage(taxYear),
    postReliefAtSourcePensionsPage(taxYear),
    getTotalPaymentsIntoReliefAtSourceAmountPage(taxYear),
    postTotalPaymentsIntoReliefAtSourceAmountPage(taxYear),
    getDidYouMakeOneOffPaymentsPage(taxYear),
    postDidYouMakeOneOffPaymentsPage(taxYear),
    getTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear),
    postTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear),
    getYourTotalPaymentsIntoReliefAtSourcePage(taxYear),
    postYourTotalPaymentsIntoReliefAtSourcePage(taxYear),
    getPensionsWhereTaxReliefIsNotClaimedPage(taxYear),
    postPensionsWhereTaxReliefIsNotClaimedPage(taxYear),
    getDidYouPayIntoRetirementAnnuityContractPage(taxYear),
    postDidYouPayIntoRetirementAnnuityContractPage(taxYear),
    getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear),
    postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear),
    getDidYouPayIntoWorkplacePensionPage(taxYear),
    postDidYouPayIntoWorkplacePensionPage(taxYear),
    getHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear),
    postHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear),
    getCheckYourPaymentsIntoPensions(taxYear)
  )

  def paymentsIntoPensionsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getPensionsSummaryPage(taxYear),
    getReliefAtSourcePensionsPage(taxYear),
    postReliefAtSourcePensionsPage(taxYear),
    getTotalPaymentsIntoReliefAtSourceAmountPage(taxYear),
    postTotalPaymentsIntoReliefAtSourceAmountPage(taxYear),
    getDidYouMakeOneOffPaymentsPage(taxYear),
    postDidYouMakeOneOffPaymentsPage(taxYear),
    getTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear),
    postTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear),
    getYourTotalPaymentsIntoReliefAtSourcePage(taxYear),
    postYourTotalPaymentsIntoReliefAtSourcePage(taxYear),
    getPensionsWhereTaxReliefIsNotClaimedPage(taxYear),
    postPensionsWhereTaxReliefIsNotClaimedPage(taxYear),
    getDidYouPayIntoRetirementAnnuityContractPage(taxYear),
    postDidYouPayIntoRetirementAnnuityContractPage(taxYear),
    getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear),
    postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear),
    getDidYouPayIntoWorkplacePensionPage(taxYear),
    postDidYouPayIntoWorkplacePensionPage(taxYear),
    getHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear),
    postHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear),
    getCheckYourPaymentsIntoPensions(taxYear)
  )

  def unauthorisedPaymentsFromPensionsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYear),
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
    getRemovePensionSchemeTaxReference(taxYear),
    postRemovePensionSchemeTaxReference(taxYear),
    getCheckYourUnauthorisedPayments(taxYear),

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
