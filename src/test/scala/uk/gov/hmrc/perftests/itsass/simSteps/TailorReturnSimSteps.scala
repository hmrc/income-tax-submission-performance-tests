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
import uk.gov.hmrc.perftests.itsass.requests.TailorReturnRequests._
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getEOYOverviewPage, getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait TailorReturnSimSteps extends PerformanceTestRunner {

  def aboutYouIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890",taxYear),
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
    postChangeTaxAvoidanceSchemesPage(taxYear),
    getTailorReturnFrontEndPage(taxYear)
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
    postIndividualLoginPage("AA123459A", "1234567890", taxYear),
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

  def individualPaymentsIntoPensions(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890", taxYear),
    getStartPage(taxYear),
    getTailorReturnStartPage(taxYear),
    getTailorReturnAddSectionsPage(taxYear),
    getPaymentsPensionsPage(taxYear),
    postPaymentsPensionsPage(taxYear),
    getChangePaymentsPensionsPage(taxYear),
    postChangePaymentsPensionsPage(taxYear),
  )

  def agentPaymentsIntoPensions(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890", taxYear),
    getStartPage(taxYear),
    getTailorReturnStartPage(taxYear),
    getTailorReturnAddSectionsPage(taxYear),
    getPaymentsPensionsPage(taxYear),
    postPaymentsPensionsPage(taxYear),
    getChangePaymentsPensionsPage(taxYear),
    postChangePaymentsPensionsPage(taxYear)
  )
  def propertyPensionsInvestmentsIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getPensionsPage(taxYear),
    postPensionsPage(taxYear),
    getChangePensionsPage(taxYear),
    postChangePensionsPage(taxYear),
    getRentalIncomePage(taxYear),
    postRentalIncomePage(taxYear),
    getChangeRentalIncomePage(taxYear),
    postChangeRentalIncomePage(taxYear),
    getUKDividendsSharesLoansPage(taxYear),
    postUKDividendsSharesLoansPage(taxYear),
    getChangeUKDividendsSharesLoansPage(taxYear),
    postChangeUKDividendsSharesLoansPage(taxYear),
    getUKInsuranceGainsPage(taxYear),
    postUKInsuranceGainsPage(taxYear),
    getChangeUKInsuranceGainsPage(taxYear),
    postChangeUKInsuranceGainsPage(taxYear),
    getUKInterestPage(taxYear),
    postUKInterestPage(taxYear),
    postChangeUKInterestPage(taxYear),
    getChangeUKInterestPage(taxYear)
  )

  def propertyPensionsInvestmentsAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getPensionsPage(taxYear),
    postPensionsPage(taxYear),
    getChangePensionsPage(taxYear),
    postChangePensionsPage(taxYear),
    getRentalIncomePage(taxYear),
    postRentalIncomePage(taxYear),
    getChangeRentalIncomePage(taxYear),
    postChangeRentalIncomePage(taxYear),
    getUKDividendsSharesLoansPage(taxYear),
    postUKDividendsSharesLoansPage(taxYear),
    getChangeUKDividendsSharesLoansPage(taxYear),
    postChangeUKDividendsSharesLoansPage(taxYear),
    getUKInsuranceGainsPage(taxYear),
    postUKInsuranceGainsPage(taxYear),
    getChangeUKInsuranceGainsPage(taxYear),
    postChangeUKInsuranceGainsPage(taxYear),
    getUKInterestPage(taxYear),
    postUKInterestPage(taxYear),
    postChangeUKInterestPage(taxYear),
    getChangeUKInterestPage(taxYear)
  )
}
