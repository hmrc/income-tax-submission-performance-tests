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
import uk.gov.hmrc.perftests.itsass.requests.PropertyPensionsInvestmentRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY

trait PropertyPensionsInvestmentSimSteps extends PerformanceTestRunner {

  def individualDividends(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPensionsPage(taxYearEOY),
    postPensionsPage(taxYearEOY),
    getChangePensionsPage(taxYearEOY),
    postChangePensionsPage(taxYearEOY),
    getRentalIncomePage(taxYearEOY),
    postRentalIncomePage(taxYearEOY),
    getChangeRentalIncomePage(taxYearEOY),
    postChangeRentalIncomePage(taxYearEOY),
    getUKDividendsSharesPageLoans(taxYearEOY),
    postUKDividendsSharesPageLoans(taxYearEOY),
    getChangeUKDividendsSharesLoansPage(taxYearEOY),
    postChangeUKDividendsSharesLoansPage(taxYearEOY),
    getUKInsuranceGainsPage(taxYearEOY),
    postUKInsuranceGainsPage(taxYearEOY),
    getChangeUKInsuranceGainsPage (taxYearEOY),
    postChangeUKInsuranceGainsPage(taxYearEOY),
    getPaymentsPensionsPage(taxYearEOY),
    postPaymentsPensionsPage(taxYearEOY),
    getChangePaymentsPensionsPage(taxYearEOY),
    postChangePaymentsPensionsPage(taxYearEOY),
    getUKInterestPage(taxYearEOY),
    postUKInterestPage(taxYearEOY),
    postChangeUKInterestPage(taxYearEOY),
    getChangeUKInterestPage(taxYearEOY),



  )

  def agentDividends(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", taxYearEOY),
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
    getDividendsCheckYourAnswersPage(taxYearEOY),
    postDividendsCheckYourAnswersPage(taxYearEOY)
  )
}
