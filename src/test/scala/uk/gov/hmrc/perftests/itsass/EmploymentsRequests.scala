/*
 * Copyright 2021 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.RequestsHelper._

object EmploymentsRequests extends ServicesConfiguration {

  def getEmploymentSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Employment Summary Page")
    .get(s"${employmentsUrl(taxYear)}/employment-summary")
    .check(status.is(200))

  def getEOYEmploymentSummaryPage(taxYearEOY: String): HttpRequestBuilder = http("Get Employment Summary Page")
    .get(s"${employmentsUrl(taxYearEOY)}/employment-summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postEmploymentSummaryPage(taxYear: String): HttpRequestBuilder = http("Post Employment Summary Page")
    .post(s"${employmentsUrl(taxYear)}/employment-summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(saveEmploymentId)
    .check(status.is(303))

  def getEmployerDetailsAndBenefitsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Employer Details And Benefits Page")
    .get(s"${employmentsUrl(taxYear)}/employer-details-and-benefits?employmentId=$employmentId")
    .check(saveCsrfToken)
    .check(status.is(200))

  def getEmploymentDetailsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Employment Details Page")
    .get(s"${employmentsUrl(taxYear)}/check-employment-details?employmentId=$employmentId")
    .check(status.is(200))

  def getEmploymentBenefitsPage(taxYear: String, employmentId: String): HttpRequestBuilder = http("Get Employment Benefits Page")
    .get(s"${employmentsUrl(taxYear)}/check-employment-benefits?employmentId=$employmentId")
    .check(status.is(200))

  def getEmploymentExpensesPage(taxYear: String): HttpRequestBuilder = http("Get Employment Expenses Page")
    .get(s"${employmentsUrl(taxYear)}/check-employment-expenses")
    .check(status.is(200))

  def getAddEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Add Employment Page")
    .get(s"${employmentsUrl(taxYear)}/add-employment")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Add Employment Status Page")
    .post(s"${employmentsUrl(taxYear)}/add-employment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(saveEmploymentId)
    .check(status.is(303))

  def getEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Get Employer Name Page")
    .get(s"${employmentsUrl(taxYear)}/employer-name$${employmentId}": String)
    .check(status.is(200)
    )

  def postEmployerNamePage(taxYear: String): HttpRequestBuilder = http("Post Employer Name Page")
    .post(s"${employmentsUrl(taxYear)}/employer-name$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", "KFC")
    .check(status.is(303))

  def getPayeRefPage(taxYear: String): HttpRequestBuilder = http("Get Paye-Ref Page")
    .get(s"${employmentsUrl(taxYear)}/employer-paye-reference$${employmentId}": String)
    .check(status.is(200)
    )

  def postPayeRefPage(taxYear: String): HttpRequestBuilder = http("Post Paye Ref Page")
    .post(s"${employmentsUrl(taxYear)}/employer-paye-reference$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("payeRef", "123/AB123")
    .check(status.is(303))

  def getEmploymentStartDatePage(taxYear: String): HttpRequestBuilder = http("Get Start Date Employment Page")
    .get(s"${employmentsUrl(taxYear)}/employment-start-date$${employmentId}": String)
    .check(status.is(200)
    )

  def postEmploymentStartDate(taxYear: String): HttpRequestBuilder = http("Post Start Date Employment Page")
    .post(s"${employmentsUrl(taxYear)}/employment-start-date$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount-day", "11")
    .formParam("amount-month", "01")
    .formParam("amount-year", "2012")
    .check(status.is(303)
    )

  def getPayEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Pay Employment Page")
    .get(s"${employmentsUrl(taxYear)}/how-much-pay$${employmentId}": String)
    .check(status.is(200)
    )

  def postPayEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Pay Employment Page")
    .post(s"${employmentsUrl(taxYear)}/how-much-pay$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303)
    )

  def getUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Get Uk Tax Employment Page")
    .get(s"${employmentsUrl(taxYear)}/uk-tax$${employmentId}": String)
    .check(status.is(200)
    )

  def postUkTaxEmploymentPage(taxYear: String): HttpRequestBuilder = http("Post Uk Tax Employment Page")
    .post(s"${employmentsUrl(taxYear)}/uk-tax$${employmentId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303)
    )

}
