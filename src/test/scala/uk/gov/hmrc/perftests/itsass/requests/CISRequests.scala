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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.cisUrl

object CISRequests {

  def getCisSummaryPage(taxYear: String): HttpRequestBuilder = http("Get CIS Summary Page")
    .get(s"${cisUrl(taxYear)}/summary")
    .check(status.is(200))

  def getCisContractorPage(taxYear: String, contractorId: String): HttpRequestBuilder = http("Get CIS Contractor Page")
    .get(s"${cisUrl(taxYear)}/contractor?contractor=$contractorId")
    .check(status.is(200))

  def getCheckYourCisDeductionsPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http("Get Check Your CIS Deductions Page")
    .get(s"${cisUrl(taxYear)}/check-construction-industry-scheme-deductions?month=$month&contractor=$contractorId")
    .check(status.is(200))

}
