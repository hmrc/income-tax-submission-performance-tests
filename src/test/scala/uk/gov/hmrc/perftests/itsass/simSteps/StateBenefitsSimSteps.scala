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
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}
import uk.gov.hmrc.perftests.itsass.requests.StateBenefitsRequests._

trait StateBenefitsSimSteps extends PerformanceTestRunner {

  def stateBenefitsIndividualInYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC160000B", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getStateBenefitsSummaryPage(taxYear),
    getJobSeekersAllowancePage(taxYear)
  )

  def stateBenefitsAgentInYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC160000B", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AC160000B", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getStateBenefitsSummaryPage(taxYear)
  )

  def stateBenefitsIndividualEndOfYearNewClaimJSA(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage(nino = "AC160000B", mtditid = "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getStateBenefitsSummaryPage(taxYearEOY),
    getJobSeekersAllowancePage(taxYearEOY),
    postCreateUserSessionData(taxYearEOY, "jobSeekersAllowance"),
    getJobSeekersAllowanceStartDatePage(taxYearEOY),
    postJobSeekersAllowanceStartDatePage(taxYearEOY),
    getDidClaimEndInTaxYearPage(taxYearEOY),
    postDidClaimEndInTaxYearPage(taxYearEOY),
    getJobSeekersAllowanceEndDatePage(taxYearEOY),
    postJobSeekersAllowanceEndDatePage(taxYearEOY),
    getTaxTakenOffPage(taxYearEOY),
    postTaxTakenOffPage(taxYearEOY),
    getJobSeekersAllowanceAmountPage(taxYearEOY),
    postJobSeekersAllowanceAmountPage(taxYearEOY),
    getTaxTakenOffAmountPage(taxYearEOY),
    postTaxTakenOffAmountPage(taxYearEOY),
    getReviewJobSeekersAllowanceClaimPage(taxYearEOY),
    getRemoveJobSeekersAllowanceClaimPage(taxYearEOY),
    postRemoveJobSeekersAllowanceClaimPage(taxYearEOY)
  )

  def stateBenefitsIndividualEndOfYearExistingClaimJSA(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage(nino = "AC160000B", mtditid = "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getStateBenefitsSummaryPage(taxYearEOY),
    getJobSeekersAllowancePage(taxYearEOY),
    getReviewJobSeekersAllowanceClaimPage(taxYearEOY, "a1e8057e-fbbc-47a8-a8b4-78d9f015c938"),
    postReviewJobSeekersAllowanceClaimRestoreContinue(taxYearEOY)
  )
}
