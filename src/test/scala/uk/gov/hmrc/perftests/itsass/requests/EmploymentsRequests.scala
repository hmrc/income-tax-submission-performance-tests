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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object EmploymentsRequests extends ServicesConfiguration {

  def getEmploymentSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Employment Summary Page")
    .get(s"${employmentsUrl(taxYear)}/employment-summary")
    .check(status.is(200))

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

  def getAddEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Add Employment Page")
    .get(s"${employmentsUrl(taxYear)}/add-employment")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Add Employment Page")
    .post(s"${employmentsUrl(taxYear)}/add-employment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(saveEmploymentId)
    .check(status.is(303))

  def getSelectEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Select Employment Page")
    .get(s"${employmentsUrl(taxYear)}/select-employer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postSelectEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Select Employment Page")
    .post(s"${employmentsUrl(taxYear)}/select-employer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "00000000-5555-0000-0000-100000000001")
    .check(status.is(303))

  def getEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Get Employer Name Page")
    .get(s"${employmentsUrl(taxYear)}/employer-name?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Post Employer Name Page")
    .post(s"${employmentsUrl(taxYear)}/employer-name?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", "KFC")
    .check(status.is(303))

  def getPayeRefPage(taxYear: String): HttpRequestBuilder = http("Get Paye-Ref Page")
      .get(s"${employmentsUrl(taxYear)}/employer-paye-reference?employmentId=$${employmentId}": String)
      .check(status.is(200))

  def postPayeRefPage(taxYear: String): HttpRequestBuilder = http("Post Paye Ref Page")
    .post(s"${employmentsUrl(taxYear)}/employer-paye-reference?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("payeRef", "123/AB123")
    .check(status.is(303))

  def getEmploymentStartDatePage(taxYear: String): HttpRequestBuilder = http("Get Start Date Employment Page")
    .get(s"${employmentsUrl(taxYear)}/employment-start-date?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmploymentStartDate(taxYear: String): HttpRequestBuilder = http("Post Start Date Employment Page")
    .post(s"${employmentsUrl(taxYear)}/employment-start-date?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount-day", "11")
    .formParam("amount-month", "01")
    .formParam("amount-year", "2012")
    .check(status.is(303))

  def getEmploymentDatesPage(taxYear: String): HttpRequestBuilder = http("Get Employment Dates Page")
    .get(s"${employmentsUrl(taxYear)}/employment-dates?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postEmploymentDates(taxYear: String): HttpRequestBuilder = http("Post to Employment Dates Page")
    .post(s"${employmentsUrl(taxYear)}/employment-dates?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("startAmount-day", "11")
    .formParam("startAmount-month", "01")
    .formParam("startAmount-year", "2012")
    .formParam("endAmount-day", "11")
    .formParam("endAmount-month", "03")
    .formParam("endAmount-year", "2021")
    .check(status.is(303))

  def getAreYouStillWorkingAtEmployerPage(taxYear: String): HttpRequestBuilder = http("Get Are you still working for you employer Page")
    .get(s"${employmentsUrl(taxYear)}/still-working-for-employer?employmentId=$${employmentId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAreYouStillWorkingAtEmployerPage(taxYear: String): HttpRequestBuilder = http("Get Are you still working for you employer Page")
    .post(s"${employmentsUrl(taxYear)}/still-working-for-employer?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getPayrollIdPage(taxYear: String): HttpRequestBuilder = http("Get PayrollId Page")
    .get(s"${employmentsUrl(taxYear)}/payroll-id?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postPayrollIdPage(taxYear: String): HttpRequestBuilder = http("Post Payroll Id Page")
    .post(s"${employmentsUrl(taxYear)}/payroll-id?employmentId=$${employmentId}": String)
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
    .get(s"${employmentsUrl(taxYear)}/how-much-pay?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postPayEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Pay Employment Page")
    .post(s"${employmentsUrl(taxYear)}/how-much-pay?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Uk Tax Employment Page")
    .get(s"${employmentsUrl(taxYear)}/uk-tax?employmentId=$${employmentId}": String)
    .check(status.is(200))

  def postUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Uk Tax Employment Page")
    .post(s"${employmentsUrl(taxYear)}/uk-tax?employmentId=$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

}
