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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object EmploymentsRequests extends ServicesConfiguration {

  def getEmploymentGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Employment Gateway Page")
    .get(s"${employmentsUrl(taxYear)}/income-from-employment")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postEmploymentGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Employment Gateway Page")
    .post(s"${employmentsUrl(taxYear)}/income-from-employment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEmploymentSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Employment Summary Page")
    .get(s"${employmentsUrl(taxYear)}/employment-summary")
    .check(status.is(200))

  def getNewEmploymentUUID(taxYear: String): HttpRequestBuilder = http("Get Add New Employment UUID")
    .get(s"${employmentsUrl(taxYear)}/employment-summary/add-employment")
    .check(saveEmploymentId)
    .check(status.is(303))

  def getEmployerDetailsAndBenefitsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Employer Details And Benefits Page")
    .get(s"${employmentsUrl(taxYear)}/employer-information?employmentId=$employmentId")
    .check(saveCsrfToken)
    .check(status.is(200))

  def getCheckEmploymentDetailsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Check Employment Details Page")
    .get(s"${employmentsUrl(taxYear)}/check-employment-details?employmentId=$employmentId")
    .check(status.is(200))

  def postCheckEmploymentDetailsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Check Employment Details Page")
    .post(s"${employmentsUrl(taxYear)}/check-employment-details?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getCheckEmploymentBenefitsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Check Employment Benefits Page")
    .get(s"${employmentsUrl(taxYear)}/check-employment-benefits?employmentId=$employmentId")
    .check(status.is(200))

  def getCheckEmploymentBenefitsWithoutBenefitsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Check Employment Benefits Without BenefitsPage")
    .get(s"${employmentsUrl(taxYear)}/check-employment-benefits?employmentId=$employmentId")
    .check(status.is(303))

  def getCheckEmploymentExpensesPage(taxYear: String): HttpRequestBuilder = http("Get Check Employment Expenses Page")
    .get(s"${employmentsUrl(taxYear)}/expenses/check-employment-expenses")
    .check(status.is(200))

  def getExpensesInterruptPage(taxYear: String): HttpRequestBuilder = http("Get Expenses Interrupt page")
    .get(s"${employmentsUrl(taxYear)}/employment/expenses/start-employment-expenses")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postExpensesInterruptPage(taxYear: String): HttpRequestBuilder = http("Post Expenses Interrupt page")
    .post(s"${employmentsUrl(taxYear)}/employment/expenses/start-employment-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getSelectEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Select Employment Page")
    .get(s"${employmentsUrl(taxYear)}/select-employer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postSelectEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Select Employment Page")
    .post(s"${employmentsUrl(taxYear)}/select-employer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "eb4425f4-1459-4fd5-b0c7-35476f4a5ea4")
    .check(status.is(303))

  def getEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Get Employer Name Page")
    .get(s"${employmentsUrl(taxYear)}/details/employer-name?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Post Employer Name Page")
    .post(s"${employmentsUrl(taxYear)}/details/employer-name?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", "KFC")
    .check(status.is(303))

  def getPayeRefPage(taxYear: String): HttpRequestBuilder = http("Get Paye-Ref Page")
      .get(s"${employmentsUrl(taxYear)}/details/employer-paye-reference?employmentId=$${employmentId}": String)
      .check(status.is(200))

  def postPayeRefPage(taxYear: String): HttpRequestBuilder = http("Post Paye Ref Page")
    .post(s"${employmentsUrl(taxYear)}/details/employer-paye-reference?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("payeRef", "123/AB123")
    .check(status.is(303))

  def getEmploymentStartDatePage(taxYear: String): HttpRequestBuilder = http("Get Start Date Employment Page")
    .get(s"${employmentsUrl(taxYear)}/details/employment-start-date?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmploymentStartDatePage(taxYear: String): HttpRequestBuilder = http("Post Start Date Employment Page")
    .post(s"${employmentsUrl(taxYear)}/details/employment-start-date?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount-day", "11")
    .formParam("amount-month", "01")
    .formParam("amount-year", "2012")
    .check(status.is(303))

  def getEmploymentEndDatePage(taxYear: String): HttpRequestBuilder = http("Get End Date Employment Page")
    .get(s"${employmentsUrl(taxYear)}/details/employment-end-date?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmploymentEndDatePage(taxYear: String): HttpRequestBuilder = http("Post End Date Employment Page")
    .post(s"${employmentsUrl(taxYear)}/details/employment-end-date?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount-day", "11")
    .formParam("amount-month", "03")
    .formParam("amount-year", s"$taxYearEOYValue")
    .check(status.is(303))

  def getEmploymentDatesPage(taxYear: String): HttpRequestBuilder = http("Get Employment Dates Page")
    .get(s"${employmentsUrl(taxYear)}/details/employment-dates?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmploymentDatesPage(taxYear: String): HttpRequestBuilder = http("Post Employment Dates Page")
    .post(s"${employmentsUrl(taxYear)}/details/employment-dates?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("startAmount-day", "11")
    .formParam("startAmount-month", "01")
    .formParam("startAmount-year", "2012")
    .formParam("endAmount-day", "11")
    .formParam("endAmount-month", "03")
    .formParam("endAmount-year", s"$taxYearEOYValue")
    .check(status.is(303))

  def getDidYouLeaveThisEmployerPage(taxYear: String): HttpRequestBuilder = http("Get Did you leave this employer in the tax year Page")
    .get(s"${employmentsUrl(taxYear)}/details/leave-employer?employmentId=$${employmentId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDidYouLeaveThisEmployerPage(taxYear: String): HttpRequestBuilder = http("Post Did you leave this employer in the tax year Page")
    .post(s"${employmentsUrl(taxYear)}/details/leave-employer?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPayrollIdPage(taxYear: String): HttpRequestBuilder = http("Get PayrollId Page")
    .get(s"${employmentsUrl(taxYear)}/details/payroll-id?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postPayrollIdPage(taxYear: String): HttpRequestBuilder = http("Post Payroll Id Page")
    .post(s"${employmentsUrl(taxYear)}/details/payroll-id?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("payrollId", "123456789")
    .check(status.is(303))

  def getRemoveEmploymentPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Remove Employment Page")
    .get(s"${employmentsUrl(taxYear)}/remove-employment?employmentId=$employmentId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRemoveEmploymentPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Post Remove Employment Page")
    .post(s"${employmentsUrl(taxYear)}/remove-employment?employmentId=$employmentId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPayEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Pay Employment Page")
    .get(s"${employmentsUrl(taxYear)}/details/how-much-pay?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postPayEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Pay Employment Page")
    .post(s"${employmentsUrl(taxYear)}/details/how-much-pay?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Uk Tax Employment Page")
    .get(s"${employmentsUrl(taxYear)}/details/uk-tax?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Uk Tax Employment Page")
    .post(s"${employmentsUrl(taxYear)}/details/uk-tax?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

}
