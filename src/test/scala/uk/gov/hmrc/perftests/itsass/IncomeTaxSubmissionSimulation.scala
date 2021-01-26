/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.itsass.AuthLoginRequests._
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.DividendsRequests._
import uk.gov.hmrc.perftests.itsass.InterestRequests._

class IncomeTaxSubmissionSimulation extends PerformanceTestRunner {

  setup("individual-dividends", "Individual Dividends Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage,
    getStartPage,
    getOverviewPage,
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

  setup("agent-dividends", "Agent Dividends Journey") withRequests(
    getLoginPage,
    postAgentLoginPage,
    getAgentTestOnlyEndPoint,
    getInsertAdditionalParametersEndPoint,
    getStartPage,
    getOverviewPage,
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

  setup("individual-interest", "Individual Interest Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage,
    getStartPage,
    getOverviewPage,
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

  setup("agent-interest", "Agent Interest Journey") withRequests(
    getLoginPage,
    postAgentLoginPage,
    getAgentTestOnlyEndPoint,
    getInsertAdditionalParametersEndPoint,
    getStartPage,
    getOverviewPage,
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage,
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage,
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage,
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage,
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

  runSimulation()
}