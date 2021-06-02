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

  def getEmploymentSummaryPage: HttpRequestBuilder = http("Get Employment Summary Page")
    .get(s"$employmentsUrl/employment-summary")
    .check(status.is(200))

  def getEmployerDetailsAndBenefitsPage(employmentId: String): HttpRequestBuilder = http("Get Employer Details And Benefits Page")
    .get(s"$employmentsUrl/employer-details-and-benefits?employmentId=$employmentId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def getEmploymentDetailsPage(employmentId: String): HttpRequestBuilder = http("Get Employment Details Page")
    .get(s"$employmentsUrl/check-employment-details?employmentId=$employmentId")
    .check(status.is(200))

  def getEmploymentBenefitsPage(employmentId: String): HttpRequestBuilder = http("Get Employment Benefits Page")
    .get(s"$employmentsUrl/check-employment-benefits?employmentId=$employmentId")
    .check(status.is(200))

  def getEmploymentExpensesPage: HttpRequestBuilder = http("Get Employment Expenses Page")
    .get(s"$employmentsUrl/check-employment-expenses")
    .check(status.is(200))
}
