/*
 * Copyright 2024 HM Revenue & Customs
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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{ taxYear, taxYearEOY}
import uk.gov.hmrc.perftests.itsass.requests.PropertyUKRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}


trait PropertyUKSimSteps extends PerformanceTestRunner{

  def propertyIndividualEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC180000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyDetailsPage(taxYearEOY),
    getPropertyTotalIncome(taxYearEOY),
    getPropertyUKSelect(taxYearEOY),
    getCheckYourAnswers(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyRentalsAbout(taxYearEOY),
    getExpensesLessThan1000(taxYearEOY),
    getClaimPropertyIncomeAllowance(taxYearEOY),
    getPropertyRentalsCYA(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyIncomeStart(taxYearEOY),
    getNonUkLandlord(taxYearEOY),
    getDeductingUKTax(taxYearEOY),
    getIncomePropertyRentals(taxYearEOY)

  )
  def propertyAgentEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC180000A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AC180000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyDetailsPage(taxYearEOY),
    getPropertyTotalIncome(taxYearEOY),
    getPropertyUKSelect(taxYearEOY),
    getCheckYourAnswers(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyRentalsAbout(taxYearEOY),
    getExpensesLessThan1000(taxYear),
    getClaimPropertyIncomeAllowance(taxYearEOY),
    getPropertyRentalsCYA(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),
    getPropertyIncomeStart(taxYearEOY),
    getNonUkLandlord(taxYearEOY),
    getDeductingUKTax(taxYearEOY),
    getIncomePropertyRentals(taxYearEOY)
  )
}
