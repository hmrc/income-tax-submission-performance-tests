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
import uk.gov.hmrc.perftests.itsass.EmploymentsRequests._
import uk.gov.hmrc.perftests.itsass.InterestRequests._

class IncomeTaxSubmissionSimulation extends PerformanceTestRunner {

  setup("individual-dividends", "Individual Dividends Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A"),
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
    postAgentLoginPage("AA111112A"),
    getInsertAdditionalParametersEndPoint("AA111112A"),
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
    postIndividualLoginPage("AA111111A"),
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
    postAgentLoginPage("AA111112A"),
    getInsertAdditionalParametersEndPoint("AA111112A"),
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

  setup("individual-employment", "Individual Single Employment Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A"),
    getStartPage,
    getOverviewPage,
    getEmploymentSummaryPage,
    getEmploymentDetailsPage("00000000-0000-1000-8000-000000000000"),
    getEmploymentBenefitsPage("00000000-0000-1000-8000-000000000000"),
    getEmploymentExpensesPage
  )

  setup("agent-employment", "Agent Multiple Employments Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A"),
    getInsertAdditionalParametersEndPoint("BB444444A"),
    getStartPage,
    getOverviewPage,
    getEmploymentSummaryPage,
    getEmployerDetailsAndBenefitsPage("00000000-5555-0000-0000-000000000001"),
    getEmploymentDetailsPage("00000000-5555-0000-0000-000000000001"),
    getEmploymentBenefitsPage("00000000-5555-0000-0000-000000000001"),
    getEmploymentExpensesPage
  )

  runSimulation()
}
