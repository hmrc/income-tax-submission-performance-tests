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
import uk.gov.hmrc.perftests.itsass.requests.AdditionalInfoRequests._
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.DividendsRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}

trait AdditionalInformationSimSteps extends PerformanceTestRunner {

  def interestSecuritiesIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestSummaryPage(taxYear),
    getInterestFromSecuritiesPage(taxYear),
    postInterestFromSecuritiesPage(taxYear),
    getTaxSecuritiesAmountPage(taxYear),
    postTaxSecuritiesAmountPage(taxYear),
    getInterestSecuritiesTaxTakenOffPage(taxYear),
    postInterestSecuritiesTaxTakenOffPage(taxYear),
    getTaxTakenFromInterestAmountPage(taxYear),
    postTaxTakenFromInterestAmountPage(taxYear),
    getSecuritiesCheckYourAnswersPage(taxYear),
    postSecuritiesCheckYourAnswersPage(taxYear)
  )

  def interestSecuritiesAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestSummaryPage(taxYear),
    getInterestFromSecuritiesPage(taxYear),
    postInterestFromSecuritiesPage(taxYear),
    getTaxSecuritiesAmountPage(taxYear),
    postTaxSecuritiesAmountPage(taxYear),
    getInterestSecuritiesTaxTakenOffPage(taxYear),
    postInterestSecuritiesTaxTakenOffPage(taxYear),
    getTaxTakenFromInterestAmountPage(taxYear),
    postTaxTakenFromInterestAmountPage(taxYear),
    getSecuritiesCheckYourAnswersPage(taxYear),
    postSecuritiesCheckYourAnswersPage(taxYear)
  )

  def gainsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage(taxYear),
    postGainsGatewayPage(taxYear),
    getPolicyTypePage(taxYear),
    postPolicyTypePage("lifeInsurance", taxYear),
    getPolicyNumberPage(taxYear),
    postPolicyNumberPage(taxYear),
    getGainsAmountPage(taxYear),
    postGainsAmountPage("193.34", taxYear),
    getGainsStatusPage(taxYear),
    postGainsStatusPage(taxYear),
    getPolicyHeldPreviousPage(taxYear),
    postPolicyHeldPreviousPage(taxYear),
    getPolicyEventPage(taxYear),
    postPolicyEventPage("Policy matured or a death"),
    getPolicyHeldPage(taxYear),
    postPolicyHeldPage(taxYear),
    getPaidTaxStatusPage(taxYear),
    postPaidTaxStatusPage(taxYear),
    getDeficiencyReliefStatusPage(taxYear),
    postDeficiencyReliefStatusPage("100", taxYear),
    getPolicySummaryPage(taxYear),
    postPolicySummaryPage(taxYear),
    getGainsSummaryPage(taxYear),
    getPoliciesRemoveConfirmationPage(taxYear),
    postPoliciesRemoveConfirmationPage(taxYear)
  )

  def gainsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage(taxYear),
    postGainsGatewayPage(taxYear),
    getPolicyTypePage(taxYear),
    postPolicyTypePage("lifeInsurance", taxYear),
    getPolicyNumberPage(taxYear),
    postPolicyNumberPage(taxYear),
    getGainsAmountPage(taxYear),
    postGainsAmountPage("193.34", taxYear),
    getGainsStatusPage(taxYear),
    postGainsStatusPage(taxYear),
    getPolicyHeldPreviousPage(taxYear),
    postPolicyHeldPreviousPage(taxYear),
    getPolicyEventPage(taxYear),
    postPolicyEventPage("Policy matured or a death"),
    getPolicyHeldPage(taxYear),
    postPolicyHeldPage(taxYear),
    getPaidTaxStatusPage(taxYear),
    postPaidTaxStatusPage(taxYear),
    getDeficiencyReliefStatusPage(taxYear),
    postDeficiencyReliefStatusPage("100", taxYear),
    getPolicySummaryPage(taxYear),
    postPolicySummaryPage(taxYear),
    getGainsSummaryPage(taxYear),
    getPoliciesRemoveConfirmationPage(taxYear),
    postPoliciesRemoveConfirmationPage(taxYear)
  )

  def gainsVoidedISAIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage(taxYear),
    postGainsGatewayPage(taxYear),
    getPolicyTypePage(taxYear),
    postPolicyTypePage("voidedIsa", taxYear),
    getPolicyNumberPage(taxYear),
    postPolicyNumberPage(taxYear),
    getGainsAmountPage(taxYear),
    postGainsAmountPage("193.34", taxYear),
    getPolicyEventPage(taxYear),
    postPolicyEventPage("Policy matured or a death"),
    getGainsStatusPage(taxYear),
    postGainsStatusPage(taxYear),
    getPolicyHeldPreviousPage(taxYear),
    postPolicyHeldPreviousPage(taxYear),
    getPolicyHeldPage(taxYear),
    postPolicyHeldPage(taxYear),
    getPaidTaxAmountPage(taxYear),
    postPaidTaxAmountPage(taxYear),
    getPolicySummaryPage(taxYear),
    postPolicySummaryPage(taxYear),
    getGainsSummaryPage(taxYear),
    getPoliciesRemoveConfirmationPage(taxYear),
    postPoliciesRemoveConfirmationPage(taxYear)
  )

  def gainsVoidedISAAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGainsGatewayPage(taxYear),
    postGainsGatewayPage(taxYear),
    getPolicyTypePage(taxYear),
    postPolicyTypePage("voidedIsa", taxYear),
    getPolicyNumberPage(taxYear),
    postPolicyNumberPage(taxYear),
    getGainsAmountPage(taxYear),
    postGainsAmountPage("193.34", taxYear),
    getPolicyEventPage(taxYear),
    postPolicyEventPage("Policy matured or a death"),
    getGainsStatusPage(taxYear),
    postGainsStatusPage(taxYear),
    getPolicyHeldPreviousPage(taxYear),
    postPolicyHeldPreviousPage(taxYear),
    getPolicyHeldPage(taxYear),
    postPolicyHeldPage(taxYear),
    getPaidTaxAmountPage(taxYear),
    postPaidTaxAmountPage(taxYear),
    getPolicySummaryPage(taxYear),
    postPolicySummaryPage(taxYear),
    getGainsSummaryPage(taxYear),
    getPoliciesRemoveConfirmationPage(taxYear),
    postPoliciesRemoveConfirmationPage(taxYear)
  )

  def stockDividendsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890", s"$taxYearEOY"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getDividendsGatewayPage(taxYearEOY),
    postDividendsGatewayPage(taxYearEOY),
    getUKDividendsStatusPage(taxYearEOY),
    postUKDividendsStatusPage(taxYearEOY),
    getUKDividendsAmountPage(taxYearEOY),
    postUKDividendsAmountPage(taxYearEOY),
    getOtherDividendsStatusPage(taxYearEOY),
    postOtherDividendsStatusPage(taxYearEOY),
    getOtherDividendsAmountPage(taxYearEOY),
    postOtherDividendsAmountPage(taxYearEOY),
    getStockDividendsStatusPage(taxYearEOY),
    postStockDividendsStatusPage(taxYearEOY),
    getStockDividendsAmountPage(taxYearEOY),
    postStockDividendsAmountPage(taxYearEOY),
    getDividendsRedeemableStatusPage(taxYearEOY),
    postDividendsRedeemableStatusPage(taxYearEOY),
    getDividendsRedeemableSharesAmountPage(taxYearEOY),
    postDividendsRedeemableSharesAmountPage(taxYearEOY),
    getStockDividendsCompanyLoanStatusPage(taxYearEOY),
    postStockDividendsCompanyLoanStatusPage(taxYearEOY),
    getStockDividendsCompanyLoanAmountPage(taxYearEOY),
    postStockDividendsCompanyLoanAmountPage(taxYearEOY),
    getStockDividendsSummaryPage(taxYearEOY),
    postStockDividendsSummaryPage(taxYearEOY)
  )

  def stockDividendsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", s"$taxYearEOY"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", s"$taxYearEOY"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getDividendsGatewayPage(taxYearEOY),
    postDividendsGatewayPage(taxYearEOY),
    getUKDividendsStatusPage(taxYearEOY),
    postUKDividendsStatusPage(taxYearEOY),
    getUKDividendsAmountPage(taxYearEOY),
    postUKDividendsAmountPage(taxYearEOY),
    getOtherDividendsStatusPage(taxYearEOY),
    postOtherDividendsStatusPage(taxYearEOY),
    getOtherDividendsAmountPage(taxYearEOY),
    postOtherDividendsAmountPage(taxYearEOY),
    getStockDividendsStatusPage(taxYearEOY),
    postStockDividendsStatusPage(taxYearEOY),
    getStockDividendsAmountPage(taxYearEOY),
    postStockDividendsAmountPage(taxYearEOY),
    getDividendsRedeemableStatusPage(taxYearEOY),
    postDividendsRedeemableStatusPage(taxYearEOY),
    getDividendsRedeemableSharesAmountPage(taxYearEOY),
    postDividendsRedeemableSharesAmountPage(taxYearEOY),
    getStockDividendsCompanyLoanStatusPage(taxYearEOY),
    postStockDividendsCompanyLoanStatusPage(taxYearEOY),
    getStockDividendsCompanyLoanAmountPage(taxYearEOY),
    postStockDividendsCompanyLoanAmountPage(taxYearEOY),
    getStockDividendsSummaryPage(taxYearEOY),
    postStockDividendsSummaryPage(taxYearEOY)
  )
}
