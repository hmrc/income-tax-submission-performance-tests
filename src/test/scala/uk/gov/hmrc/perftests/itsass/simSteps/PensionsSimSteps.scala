/*
 * Copyright 2023 HM Revenue & Customs
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
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.PaymentsIntoPensionsRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear
import uk.gov.hmrc.perftests.itsass.requests.UnauthorisedPaymentsFromPensionsRequests.{getAmountThatDidNotResultInASurcharge, getAmountThatResultedInASurcharge, getCheckYourUnauthorisedPayments, getDidYouPayNonUkOnAmountSurcharge, getDidYouPayNonUkOnAmountThatDidNotSurcharge, getPensionSchemeTaxReference, getRemovePensionSchemeTaxReference, getUnauthorisedPayments, getUnauthorisedPaymentsFromUKPensionScheme, getWereAnyOfThePaymentFromAUKPension, postAmountThatDidNotResultInASurcharge, postAmountThatResultedInASurcharge, postDidYouPayNonUkOnAmountSurcharge, postDidYouPayNonUkOnAmountThatDidSurcharge, postPensionSchemeTaxReference, postRemovePensionSchemeTaxReference, postUnauthorisedPayments, postWereAnyOfThePaymentFromAUKPension}

trait PensionsSimSteps extends PerformanceTestRunner{

  def paymentsIntoPensionAgent (id: String, description: String): JourneyPart = setup(id, description) withRequests (
     getLoginPage,
     postAgentLoginPage("AA123459A", "1234567890"),
     getInsertAdditionalParametersEndPoint("AA123459A", "1234567890"),
     getStartPage(taxYear),
     getPensionsSummaryPage,
     getPensionsCYAPage,
     postPensionsCYAPage,
     getReliefAtSourcePensionsPage,
     postReliefAtSourcePensionsPage,
     getTotalPaymentsIntoReliefAtSourceAmountPage,
     postTotalPaymentsIntoReliefAtSourceAmountPage,
     getDidYouMakeOneOffPaymentsPage,
     postDidYouMakeOneOffPaymentsPage,
     getTotalOneOffPaymentsIntoReliefAtSourceAmountPage,
     postTotalOneOffPaymentsIntoReliefAtSourceAmountPage,
     getYourTotalPaymentsIntoReliefAtSourcePage,
     postYourTotalPaymentsIntoReliefAtSourcePage,
     getPensionsWhereTaxReliefIsNotClaimedPage,
     postPensionsWhereTaxReliefIsNotClaimedPage,
     getDidYouPayIntoRetirementAnnuityContractPage,
     postDidYouPayIntoRetirementAnnuityContractPage,
     getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage,
     postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage,
     getDidYouPayIntoWorkplacePensionPage,
     postDidYouPayIntoWorkplacePensionPage,
     getHowMuchDidYouPayIntoWorkPlacePensionAmountPage,
     postHowMuchDidYouPayIntoWorkPlacePensionAmountPage,
     getCheckYourPaymentsIntoPensions
   )

  def paymentsIntoPensionsIndividual (id: String, description: String): JourneyPart = setup(id, description) withRequests (
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890"),
    getStartPage(taxYear),
    getPensionsSummaryPage,
    getPensionsCYAPage,
    postPensionsCYAPage,
    getReliefAtSourcePensionsPage,
    postReliefAtSourcePensionsPage,
    getTotalPaymentsIntoReliefAtSourceAmountPage,
    postTotalPaymentsIntoReliefAtSourceAmountPage,
    getDidYouMakeOneOffPaymentsPage,
    postDidYouMakeOneOffPaymentsPage,
    getTotalOneOffPaymentsIntoReliefAtSourceAmountPage,
    postTotalOneOffPaymentsIntoReliefAtSourceAmountPage,
    getYourTotalPaymentsIntoReliefAtSourcePage,
    postYourTotalPaymentsIntoReliefAtSourcePage,
    getPensionsWhereTaxReliefIsNotClaimedPage,
    postPensionsWhereTaxReliefIsNotClaimedPage,
    getDidYouPayIntoRetirementAnnuityContractPage,
    postDidYouPayIntoRetirementAnnuityContractPage,
    getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage,
    postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage,
    getDidYouPayIntoWorkplacePensionPage,
    postDidYouPayIntoWorkplacePensionPage,
    getHowMuchDidYouPayIntoWorkPlacePensionAmountPage,
    postHowMuchDidYouPayIntoWorkPlacePensionAmountPage,
    getCheckYourPaymentsIntoPensions
  )

  def unauthorisedPaymentsFromPensionsAgent (id: String, description: String): JourneyPart = setup(id, description) withRequests (
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890"),
    getStartPage(taxYear),
    getPensionsSummaryPage,
    getUnauthorisedPayments,
    postUnauthorisedPayments,
    getAmountThatResultedInASurcharge,
    postAmountThatResultedInASurcharge,
    getDidYouPayNonUkOnAmountSurcharge,
    postDidYouPayNonUkOnAmountSurcharge,
    getAmountThatDidNotResultInASurcharge,
    postAmountThatDidNotResultInASurcharge,
    getDidYouPayNonUkOnAmountThatDidNotSurcharge,
    postDidYouPayNonUkOnAmountThatDidSurcharge,
    getWereAnyOfThePaymentFromAUKPension,
    postWereAnyOfThePaymentFromAUKPension,
    getPensionSchemeTaxReference,
    postPensionSchemeTaxReference,
    getUnauthorisedPaymentsFromUKPensionScheme,
    getRemovePensionSchemeTaxReference,
    postRemovePensionSchemeTaxReference,
    getCheckYourUnauthorisedPayments


  )

  def unauthorisedPaymentsFromPensionsIndividual (id: String, description: String): JourneyPart = setup(id, description) withRequests (
    getLoginPage,
    postIndividualLoginPage("AA370343B", "1234567890"),
    getStartPage(taxYear),
    getPensionsSummaryPage,
    getUnauthorisedPayments,
    postUnauthorisedPayments,
    getAmountThatResultedInASurcharge,
    postAmountThatResultedInASurcharge,
    getDidYouPayNonUkOnAmountSurcharge,
    postDidYouPayNonUkOnAmountSurcharge,
    getAmountThatDidNotResultInASurcharge,
    postAmountThatDidNotResultInASurcharge,
    getDidYouPayNonUkOnAmountThatDidNotSurcharge,
    postDidYouPayNonUkOnAmountThatDidSurcharge,
    getWereAnyOfThePaymentFromAUKPension,
    postWereAnyOfThePaymentFromAUKPension,
    getPensionSchemeTaxReference,
    postPensionSchemeTaxReference,
    getUnauthorisedPaymentsFromUKPensionScheme,
    getCheckYourUnauthorisedPayments

  )

}
