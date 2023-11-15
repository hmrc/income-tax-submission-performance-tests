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
import uk.gov.hmrc.perftests.itsass.requests.InterestRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait InterestSimSteps extends PerformanceTestRunner {

  def interestIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestSummaryPage(taxYear),
    getInterestGatewayPage(taxYear),
    postInterestGatewayPage(taxYear),
    getUntaxedUKInterestStatusPage(taxYear),
    postUntaxedUKInterestStatusPage(taxYear),
    getUntaxedChooseAccountRedirect(taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage(accountName = "Tesco Bank", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage(accountName = "Halifax", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage(accountName = "Santander", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false, taxYear),
    getTaxedUKInterestStatusPage(taxYear),
    postTaxedUKInterestStatusPage(taxYear),
    getTaxedChooseAccountPage(taxYear),
    postTaxedChooseAccountPage(taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage(accountName = "Tesco Bank", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage(accountName = "Halifax", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage(accountName = "Santander", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = false, taxYear),
    getInterestCheckYourAnswersPage(taxYear),
    postInterestCheckYourAnswersPage(taxYear)
  )


  def interestAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890",taxYear),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890",taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestSummaryPage(taxYear),
    getInterestGatewayPage(taxYear),
    postInterestGatewayPage(taxYear),
    getUntaxedUKInterestStatusPage(taxYear),
    postUntaxedUKInterestStatusPage(taxYear),
    getUntaxedChooseAccountRedirect(taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage("Tesco Bank", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage("Halifax", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getUntaxedUKInterestDetailsPage(taxYear),
    postUntaxedUKInterestDetailsPage("Santander", taxYear),
    getUntaxedUKInterestSummaryPage(taxYear),
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false, taxYear),
    getTaxedUKInterestStatusPage(taxYear),
    postTaxedUKInterestStatusPage(taxYear),
    getTaxedChooseAccountPage(taxYear),
    postTaxedChooseAccountPage(taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage("Tesco Bank", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage("Halifax", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = true, taxYear),
    getTaxedUKInterestDetailsPage(taxYear),
    postTaxedUKInterestDetailsPage("Santander", taxYear),
    getTaxedUKInterestSummaryPage(taxYear),
    postTaxedUKInterestSummaryPage(addAnotherAccount = false, taxYear),
    getInterestCheckYourAnswersPage(taxYear),
    postInterestCheckYourAnswersPage(taxYear)
  )
}
