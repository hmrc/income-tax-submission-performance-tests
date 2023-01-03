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
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestGatewayPage,
    postInterestGatewayPage,
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedChooseAccountRedirect,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Tesco Bank"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Halifax"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Santander"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false),
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedChooseAccountPage,
    postTaxedChooseAccountPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Tesco Bank"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Halifax"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Santander"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = false),
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

  def interestAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getInterestGatewayPage,
    postInterestGatewayPage,
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedChooseAccountRedirect,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Tesco Bank"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Halifax"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Santander"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false),
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedChooseAccountPage,
    postTaxedChooseAccountPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Tesco Bank"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Halifax"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Santander"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = false),
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

}
