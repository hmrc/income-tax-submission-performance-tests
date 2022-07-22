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
import uk.gov.hmrc.perftests.itsass.requests.DividendsRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait DividendsSimSteps extends PerformanceTestRunner {

  def individualDividends(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
<<<<<<< HEAD
    getDividendsGatewayPage,
    postDividendsGatewayPage,
=======
//    ToDo - Uncomment once tailoring is enabled in staging
<<<<<<< HEAD
//    getDividendsGatewayPage,
//    postDividendsGatewayPage,
>>>>>>> SASS-2834 : Added dividends gateway step to dividends journeys
=======
    getDividendsGatewayPage,
    postDividendsGatewayPage,
>>>>>>> test update
    getUKDividendsStatusPage,
    postUKDividendsStatusPage,
    getUKDividendsAmountPage,
    postUKDividendsAmountPage,
    getOtherDividendsStatusPage,
    postOtherDividendsStatusPage,
    getOtherDividendsAmountPage,
    postOtherDividendsAmountPage,
    getDividendsCheckYourAnswersPage,
    postDividendsCheckYourAnswersPage
  )

  def agentDividends(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
<<<<<<< HEAD
    getDividendsGatewayPage,
    postDividendsGatewayPage,
=======
//    ToDo - Uncomment once tailoring is enabled in staging
<<<<<<< HEAD
//    getDividendsGatewayPage,
//    postDividendsGatewayPage,
>>>>>>> SASS-2834 : Added dividends gateway step to dividends journeys
=======
    getDividendsGatewayPage,
    postDividendsGatewayPage,
>>>>>>> test update
    getUKDividendsStatusPage,
    postUKDividendsStatusPage,
    getUKDividendsAmountPage,
    postUKDividendsAmountPage,
    getOtherDividendsStatusPage,
    postOtherDividendsStatusPage,
    getOtherDividendsAmountPage,
    postOtherDividendsAmountPage,
    getDividendsCheckYourAnswersPage,
    postDividendsCheckYourAnswersPage
  )
}
