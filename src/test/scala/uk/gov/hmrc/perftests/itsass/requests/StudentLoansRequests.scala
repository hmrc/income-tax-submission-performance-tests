/*
 * Copyright 2025 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object StudentLoansRequests extends ServicesConfiguration {

  def getStudentLoansCheckYourAnswersRedirect(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Student Loans Check Your Answers Redirect")
    .get(s"${employmentsUrl(taxYear)}/student-loans/check-student-loans-repayments?employmentId=$employmentId")
    .check(status.is(303))

  def getStudentLoansStatusPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Student Loans Question Page")
    .get(s"${employmentsUrl(taxYear)}/student-loans/repayments?employmentId=$employmentId")
    .check(status.is(200))

  def postStudentLoansStatusPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Student Loans Question Page")
    .post(s"${employmentsUrl(taxYear)}/student-loans/repayments?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("studentLoans[]", "ugl")
    .formParam("studentLoans[]", "pgl")
    .check(status.is(303))

  def getUndergraduateLoanAmountPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Undergraduate Loans Page")
    .get(s"${employmentsUrl(taxYear)}/student-loans/student-loan-repayment-amount?employmentId=$employmentId")
    .check(status.is(200))

  def postUndergraduateLoanAmountPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Undergraduate Loans Page")
    .post(s"${employmentsUrl(taxYear)}/student-loans/student-loan-repayment-amount?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1500")
    .check(status.is(303))

  def getPostgraduateLoanAmountPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Postgraduate Loans Amount Page")
    .get(s"${employmentsUrl(taxYear)}/student-loans/postgraduate-loan-repayment-amount?employmentId=$employmentId")
    .check(status.is(200))

  def postPostgraduateLoanAmountPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Postgraduate Loans Amount Page")
    .post(s"${employmentsUrl(taxYear)}/student-loans/postgraduate-loan-repayment-amount?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1500")
    .check(status.is(303))

  def getStudentLoansCheckYourAnswersPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Student Loans Check Your Answers Page")
    .get(s"${employmentsUrl(taxYear)}/student-loans/check-student-loans-repayments?employmentId=$employmentId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStudentLoansCheckYourAnswersPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Student Loans Check Your Answers Page")
    .post(s"${employmentsUrl(taxYear)}/student-loans/check-student-loans-repayments?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
