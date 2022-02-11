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
import uk.gov.hmrc.perftests.itsass.requests.EmploymentsRequests._
import uk.gov.hmrc.perftests.itsass.requests.StudentLoansRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{employmentIdWithNoStudentLoans, taxYearEOY}

trait StudentLoansSimSteps extends PerformanceTestRunner {

  def studentLoansIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansCheckYourAnswersRedirect(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansStatusPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postStudentLoansStatusPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getUndergraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postUndergraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getPostgraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postPostgraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansCheckYourAnswersPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postStudentLoansCheckYourAnswersPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans)
  )

  def studentLoansAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansCheckYourAnswersRedirect(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansStatusPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postStudentLoansStatusPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getUndergraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postUndergraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getPostgraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postPostgraduateLoanAmountPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    getStudentLoansCheckYourAnswersPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans),
    postStudentLoansCheckYourAnswersPage(taxYearEOY, employmentId = employmentIdWithNoStudentLoans)
  )

}
