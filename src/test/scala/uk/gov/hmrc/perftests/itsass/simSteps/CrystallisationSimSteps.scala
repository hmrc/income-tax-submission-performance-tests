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
import uk.gov.hmrc.perftests.itsass.requests.CrystallisationRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY

trait CrystallisationSimSteps extends PerformanceTestRunner {

  def crystallisationIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA888888A", "XAIT00000888888"),
    getStartPage(taxYearEOY),
    getViewChangeTestHeadersPage,
    postViewChangeTestHeadersPage,
    getEOYOverviewPage(taxYearEOY),
    postEOYOverviewPage(taxYearEOY),
    getFinalTaxCalculationEndpoint(taxYearEOY),
    getFinalTaxCalculationPage(taxYearEOY),
    postFinalTaxCalculationPage(taxYearEOY),
    getDeclarationPage(taxYearEOY),
    postDeclarationPage(taxYearEOY),
    getReceivedTaxCalculationPage(taxYearEOY)
  )

  def crystallisationAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA888888A", "XAIT00000888888"),
    getInsertAdditionalParametersEndPoint("AA888888A", "XAIT00000888888"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    postEOYOverviewPage(taxYearEOY),
    getCitizenDetailsStubPage,
    postCitizenDetailsStubPage,
    getClientUTRPage,
    postClientUTRPage,
    getConfirmClientUTRPage,
    postConfirmClientUTRPage,
    getViewChangeTestHeadersPage,
    postViewChangeTestHeadersPage,
    getFinalTaxCalculationAgentEndpoint(taxYearEOY),
    getFinalTaxCalculationAgentPage(taxYearEOY),
    postFinalTaxCalculationAgentPage(taxYearEOY),
    getDeclarationPage(taxYearEOY),
    postDeclarationPage(taxYearEOY),
    getReceivedTaxCalculationPage(taxYearEOY)
  )
}
