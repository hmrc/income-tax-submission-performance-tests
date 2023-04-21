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
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.AdditionalInfoRequests.{getInterestSummaryPage, _}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait AdditionalInformationSimSteps extends PerformanceTestRunner {

  def interestSecuritiesIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
     getOverviewPage(taxYear),
     getInterestSummaryPage,
     getInterestFromSecuritiesPage,
     postInterestFromSecuritiesPage,
     getTaxSecuritiesAmountPage,
     postTaxSecuritiesAmountPage,
     getInterestSecuritiesTaxTakenOffPage,
     postInterestSecuritiesTaxTakenOffPage,
     getTaxTakenFromInterestAmountPage,
     postTaxTakenFromInterestAmountPage,
     getSecuritiesCheckYourAnswersPage,
     posttSecuritiesCheckYourAnswersPage,

  )

  def interestSecuritiesAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
      getLoginPage,
       postAgentLoginPage("AA111112A", "1234567890"),
       getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
       getStartPage(taxYear),
       getOverviewPage(taxYear),
       getInterestSummaryPage,
       getInterestFromSecuritiesPage,
       postInterestFromSecuritiesPage,
       getTaxSecuritiesAmountPage,
       postTaxSecuritiesAmountPage,
       getInterestSecuritiesTaxTakenOffPage,
       postInterestSecuritiesTaxTakenOffPage,
       getTaxTakenFromInterestAmountPage,
      postTaxTakenFromInterestAmountPage,
      getSecuritiesCheckYourAnswersPage,
      posttSecuritiesCheckYourAnswersPage,

  )

  def gainsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage,
    postGainsGatewayPage,
    getPolicyTypePage,
    postPolicyTypePage("lifeInsurance"),
    getPolicyNumberPage,
    postPolicyNumberPage,
    getGainsAmountPage,
    postGainsAmountPage("193.34"),
    getGainsStatusPage,
    postGainsStatusPage,
    getPolicyHeldPreviousPage,
    postPolicyHeldPreviousPage,
    getPolicyEventPage,
    postPolicyEventPage("Policy matured or a death"),
    getPolicyHeldPage,
    postPolicyHeldPage,
    getPaidTaxStatusPage,
    postPaidTaxStatusPage,
    getDeficiencyReliefStatusPage,
    postDeficiencyReliefStatusPage("100"),
    getPolicySummaryPage,
    postPolicySummaryPage,
    getGainsSummaryPage,
    getPoliciesRemoveConfirmationPage,
    postPoliciesRemoveConfirmationPage

  )

  def gainsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage,
    postGainsGatewayPage,
    getPolicyTypePage,
    postPolicyTypePage("lifeInsurance"),
    getPolicyNumberPage,
    postPolicyNumberPage,
    getGainsAmountPage,
    postGainsAmountPage("193.34"),
    getGainsStatusPage,
    postGainsStatusPage,
    getPolicyHeldPreviousPage,
    postPolicyHeldPreviousPage,
    getPolicyEventPage,
    postPolicyEventPage("Policy matured or a death"),
    getPolicyHeldPage,
    postPolicyHeldPage,
    getPaidTaxStatusPage,
    postPaidTaxStatusPage,
    getDeficiencyReliefStatusPage,
    postDeficiencyReliefStatusPage("100"),
    getPolicySummaryPage,
    postPolicySummaryPage,
    getGainsSummaryPage,
    getPoliciesRemoveConfirmationPage,
    postPoliciesRemoveConfirmationPage

  )

  def gainsVoidedISAIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage,
    postGainsGatewayPage,
    getPolicyTypePage,
    postPolicyTypePage("voidedIsa"),
    getPolicyNumberPage,
    postPolicyNumberPage,
    getGainsAmountPage,
    postGainsAmountPage("193.34"),
    getPolicyEventPage,
    postPolicyEventPage("Policy matured or a death"),
    getGainsStatusPage,
    postGainsStatusPage,
    getPolicyHeldPreviousPage,
    postPolicyHeldPreviousPage,
    getPolicyHeldPage,
    postPolicyHeldPage,
    getPaidTaxAmountPage,
    postPaidTaxAmountPage,
    getPolicySummaryPage,
    postPolicySummaryPage,
    getGainsSummaryPage,
    getPoliciesRemoveConfirmationPage,
    postPoliciesRemoveConfirmationPage

  )

  def gainsVoidedISAAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage,
    postGainsGatewayPage,
    getPolicyTypePage,
    postPolicyTypePage("voidedIsa"),
    getPolicyNumberPage,
    postPolicyNumberPage,
    getGainsAmountPage,
    postGainsAmountPage("193.34"),
    getPolicyEventPage,
    postPolicyEventPage("Policy matured or a death"),
    getGainsStatusPage,
    postGainsStatusPage,
    getPolicyHeldPreviousPage,
    postPolicyHeldPreviousPage,
    getPolicyHeldPage,
    postPolicyHeldPage,
    getPaidTaxAmountPage,
    postPaidTaxAmountPage,
    getPolicySummaryPage,
    postPolicySummaryPage,
    getGainsSummaryPage,
    getPoliciesRemoveConfirmationPage,
    postPoliciesRemoveConfirmationPage

  )


}
