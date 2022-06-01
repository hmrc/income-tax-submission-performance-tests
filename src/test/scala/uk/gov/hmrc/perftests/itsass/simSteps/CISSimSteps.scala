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
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests._
import uk.gov.hmrc.perftests.itsass.requests.CISRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}

trait CISSimSteps extends PerformanceTestRunner {

  def cisIndividualInYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC150000B", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getCisSummaryPage(taxYear),
    getCisContractorPage(taxYear, "111%2F11111"),
    getCheckYourCisDeductionsPage(taxYear, "may", "111%2F11111")
  )

  def cisAgentInYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC150000B", "1234567890"),
    getInsertAdditionalParametersEndPoint("AC150000B", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getCisSummaryPage(taxYear),
    getCisContractorPage(taxYear, "111%2F11111"),
    getCheckYourCisDeductionsPage(taxYear, "may", "111%2F11111")
  )

  def cisIndividualEndOfYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage(nino = "AC150000B", mtditid = "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getCisSummaryPage(taxYearEOY),
    getCisContractorPage(taxYearEOY, contractorId = "111%2F11111"),
    getCheckYourCisDeductionsPage(taxYearEOY, month = "may", contractorId = "111%2F11111"),
    getWhenDidXMakeCisDeductionsPage(taxYearEOY, contractorId = "111%2F11111"),
    postWhenDidXMakeCisDeductionsPage(taxYearEOY, contractorId = "111%2F11111", month = "may"),
    getLabourPayPage(taxYearEOY, month = "may", contractorId = "111%2F11111"),
    postLabourPayPage(taxYearEOY, month = "may", contractorId = "111%2F11111", amount = 200),
    getDeductionAmountPage(taxYearEOY, month = "may", contractorId = "111%2F11111"),
    postDeductionAmountPage(taxYearEOY, month = "may", contractorId = "111%2F11111", amount = 200),
    getDidYouPayForMaterialsPage(taxYearEOY, month = "may", contractorId = "111%2F11111"),
    postDidYouPayForMaterialsPage(taxYearEOY, month = "may", contractorId = "111%2F11111", value = true),
    getCostOfMaterialsPage(taxYearEOY, month = "may", contractorId = "111%2F11111"),
    postCostOfMaterialsPage(taxYearEOY, month = "may", contractorId = "111%2F11111", amount = 200),
    getRemoveDeductionPage(taxYearEOY, month = "june", contractorId = "111%2F11111"),
    postRemoveDeductionPage(taxYearEOY, month = "june", contractorId = "111%2F11111")
  )

  def cisAgentEndOfYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC150000B", "1234567890"),
    getInsertAdditionalParametersEndPoint("AC150000B", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getCisSummaryPage(taxYearEOY),
    getContractorDetailsPage(taxYearEOY),
    postContractorDetailsPage(taxYearEOY, contractorId = "123/45678"),
    postWhenDidXMakeCisDeductionsPage(taxYearEOY, contractorId = "123/45678", month = "may", isNewPeriod = true),
    postLabourPayPage(taxYearEOY, month = "may", contractorId = "123/45678", amount = 100),
    postDeductionAmountPage(taxYearEOY, month = "may", contractorId = "123/45678", amount = 200),
    postDidYouPayForMaterialsPage(taxYearEOY, month = "may", contractorId = "123/45678", value = true),
    postCostOfMaterialsPage(taxYearEOY, month = "may", contractorId = "123/45678", amount = 200)
  )
}
