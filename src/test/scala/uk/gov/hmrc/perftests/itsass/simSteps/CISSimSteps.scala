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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait CISSimSteps extends PerformanceTestRunner {

  def cisIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC150000B", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getCisSummaryPage(taxYear),
    getCisContractorPage(taxYear, "111%252F11111"),
    getCheckYourCisDeductionsPage(taxYear, "may", "111%252F11111")
  )

  def cisAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC150000B", "1234567890"),
    getInsertAdditionalParametersEndPoint("AC150000B", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getCisSummaryPage(taxYear),
    getCisContractorPage(taxYear, "111%252F11111"),
    getCheckYourCisDeductionsPage(taxYear, "may", "111%252F11111")
  )

}
