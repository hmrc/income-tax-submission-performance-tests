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
import uk.gov.hmrc.perftests.itsass.requests.TailorReturnRequests._
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{taxYear, taxYearEOY}

trait TailorReturnSimSteps extends PerformanceTestRunner {

  def aboutYouIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890",taxYearEOY),
    getStartPage(taxYearEOY),
    getTailorReturnStartPage(taxYearEOY),
    getTailorReturnAddSectionsPage(taxYearEOY),
    getUkResidenceStatusPage(taxYearEOY),
    postUkResidenceStatusPage(taxYearEOY),
    getChangeUkResidenceStatusPage(taxYearEOY),
    postChangeUkResidenceStatusPage(taxYearEOY),
    getYourResidenceStatusPage(taxYearEOY),
    postYourResidenceStatusPage(taxYearEOY),
    getChangeYourResidenceStatusPage(taxYearEOY),
    postChangeYourResidenceStatusPage(taxYearEOY),
    getCharitableDonationsPage(taxYearEOY),
    postCharitableDonationsPage(taxYearEOY),
    getChangeCharitableDonationsPage(taxYearEOY),
    postChangeCharitableDonationsPage(taxYearEOY),
    getFosterCarerPage(taxYearEOY),
    postFosterCarerPage(taxYearEOY),
    getChangeFosterCarerPage(taxYearEOY),
    postChangeFosterCarerPage(taxYearEOY),
    getChildBenefitPage(taxYearEOY),
    postChildBenefitPage(taxYearEOY),
    getChangeChildBenefitPage(taxYearEOY),
    postChangeChildBenefitPage(taxYearEOY),
    getChildBenefitIncomePage(taxYearEOY),
    postChildBenefitIncomePage(taxYearEOY),
    getChangeChildBenefitIncomePage(taxYearEOY),
    postChangeChildBenefitIncomePage(taxYearEOY),
    getHighIncomeChildBenefitChargePage(taxYearEOY),
    postHighIncomeChildBenefitChargePage(taxYearEOY),
    getChangeHighIncomeChildBenefitChargePage(taxYearEOY),
    postChangeHighIncomeChildBenefitChargePage(taxYearEOY),
    getMarriageAllowancePage(taxYearEOY),
    postMarriageAllowancePage(taxYearEOY),
    getChangeMarriageAllowancePage(taxYearEOY),
    postChangeMarriageAllowancePage(taxYearEOY),
    getTaxAvoidanceSchemesPage(taxYearEOY),
    postTaxAvoidanceSchemesPage(taxYearEOY),
    getChangeTaxAvoidanceSchemesPage(taxYearEOY),
    postChangeTaxAvoidanceSchemesPage(taxYearEOY),
    getTailorReturnFrontEndPage(taxYearEOY)
  )

  def aboutYouAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890",taxYear),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890",taxYear),
    getStartPage(taxYear),
    getTailorReturnStartPage(taxYear),
    getTailorReturnAddSectionsPage(taxYear),
    getUkResidenceStatusPage(taxYear),
    postUkResidenceStatusPage(taxYear),
    getChangeUkResidenceStatusPage(taxYear),
    postChangeUkResidenceStatusPage(taxYear),
    getYourResidenceStatusPage(taxYear),
    postYourResidenceStatusPage(taxYear),
    getChangeYourResidenceStatusPage(taxYear),
    postChangeYourResidenceStatusPage(taxYear),
    getCharitableDonationsPage(taxYear),
    postCharitableDonationsPage(taxYear),
    getChangeCharitableDonationsPage(taxYear),
    postChangeCharitableDonationsPage(taxYear),
    getFosterCarerPage(taxYear),
    postFosterCarerPage(taxYear),
    getChangeFosterCarerPage(taxYear),
    postChangeFosterCarerPage(taxYear),
    getChildBenefitPage(taxYear),
    postChildBenefitPage(taxYear),
    getChangeChildBenefitPage(taxYear),
    postChangeChildBenefitPage(taxYear),
    getChildBenefitIncomePage(taxYear),
    postChildBenefitIncomePage(taxYear),
    getChangeChildBenefitIncomePage(taxYear),
    postChangeChildBenefitIncomePage(taxYear),
    getHighIncomeChildBenefitChargePage(taxYear),
    postHighIncomeChildBenefitChargePage(taxYear),
    getChangeHighIncomeChildBenefitChargePage(taxYear),
    postChangeHighIncomeChildBenefitChargePage(taxYear),
    getMarriageAllowancePage(taxYear),
    postMarriageAllowancePage(taxYear),
    getChangeMarriageAllowancePage(taxYear),
    postChangeMarriageAllowancePage(taxYear),
    getTaxAvoidanceSchemesPage(taxYear),
    postTaxAvoidanceSchemesPage(taxYear),
    getChangeTaxAvoidanceSchemesPage(taxYear),
    postChangeTaxAvoidanceSchemesPage(taxYear)
  )

  def incomeFromWorkIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getTailorReturnStartPage(taxYearEOY),
    getTailorReturnAddSectionsPage(taxYearEOY),
    getAboutYourWorkPage(taxYearEOY),
    postAboutYourWorkPage(taxYearEOY),
    getChangeAboutYourWorkPage(taxYearEOY),
    postChangeAboutYourWorkPage(taxYearEOY),
    getConstructionIndustrySchemePage(taxYearEOY),
    postConstructionIndustrySchemePage(taxYearEOY),
    getChangeConstructionIndustrySchemePage(taxYearEOY),
    postChangeConstructionIndustrySchemePage(taxYearEOY),
    getJobseekersAllowancePage(taxYearEOY),
    postJobseekersAllowancePage(taxYearEOY),
    getChangeJobseekersAllowancePage(taxYearEOY),
    postChangeJobseekersAllowancePage(taxYearEOY),
  )

  def incomeFromWorkAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYear),
    getStartPage(taxYear),
    getTailorReturnStartPage(taxYear),
    getTailorReturnAddSectionsPage(taxYear),
    getAboutYourWorkPage(taxYear),
    postAboutYourWorkPage(taxYear),
    getChangeAboutYourWorkPage(taxYear),
    postChangeAboutYourWorkPage(taxYear),
    getConstructionIndustrySchemePage(taxYear),
    postConstructionIndustrySchemePage(taxYear),
    getChangeConstructionIndustrySchemePage(taxYear),
    postChangeConstructionIndustrySchemePage(taxYear),
    getJobseekersAllowancePage(taxYear),
    postJobseekersAllowancePage(taxYear),
    getChangeJobseekersAllowancePage(taxYear),
    postChangeJobseekersAllowancePage(taxYear),
  )
}
