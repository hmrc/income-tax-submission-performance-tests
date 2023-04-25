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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.cisUrl

object CISRequests {

  def getCisSummaryPage(taxYear: String): HttpRequestBuilder = http("Get CIS Summary Page")
    .get(s"${cisUrl(taxYear)}/summary")
    .check(status.is(expected = 200))

  def getCisGatewayPage(taxYear: String): HttpRequestBuilder = http("Get CIS Gateway Page")
    .get(s"${cisUrl(taxYear)}/deductions-from-payments")
    .check(status.is(expected = 200))

  def postCisGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Interest Gateway Page")
    .post(s"${cisUrl(taxYear)}/deductions-from-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCisContractorPage(taxYear: String, contractorId: String): HttpRequestBuilder = http("Get CIS Contractor Page")
    .get(s"${cisUrl(taxYear)}/contractor?contractor=$contractorId")
    .check(status.is(expected = 200))

  def getCheckYourCisDeductionsPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http("Get Check Your CIS Deductions Page")
    .get(s"${cisUrl(taxYear)}/check-construction-industry-scheme-deductions?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def getWhenDidXMakeCisDeductionsPage(taxYear: String, contractorId: String): HttpRequestBuilder = http(requestName = "Get When did X make CIS deductions? Page")
    .get(url = s"${cisUrl(taxYear)}/when-deductions-made?contractor=$contractorId")
    .check(status.is(expected = 200))

  def postWhenDidXMakeCisDeductionsPage(taxYear: String, contractorId: String, month: String, isNewPeriod: Boolean = false): HttpRequestBuilder = http(requestName = "Post When did X make CIS deductions? Page")
    .post(url = s"${cisUrl(taxYear)}/when-deductions-made?contractor=$contractorId" + (if (isNewPeriod) "" else "&month=may"))
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("month", month)
    .check(status.is(expected = 303))

  def getLabourPayPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http(requestName = "Get Labour Pay Page")
    .get(s"${cisUrl(taxYear)}/labour-pay?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def postLabourPayPage(taxYear: String, month: String, contractorId: String, amount: BigDecimal): HttpRequestBuilder = http(requestName = "Post Labour Pay Page")
    .post(url = s"${cisUrl(taxYear)}/labour-pay?month=$month&contractor=$contractorId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", amount)
    .check(status.is(expected = 303))

  def getDeductionAmountPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http(requestName = "Get Deduction Amount Page")
    .get(s"${cisUrl(taxYear)}/deduction-amount?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def postDeductionAmountPage(taxYear: String, month: String, contractorId: String, amount: BigDecimal): HttpRequestBuilder = http(requestName = "Post Deduction Amount Page")
    .post(url = s"${cisUrl(taxYear)}/deduction-amount?month=$month&contractor=$contractorId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", amount)
    .check(status.is(expected = 303))

  def getDidYouPayForMaterialsPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http(requestName = "Get Did You Pay for Materials Page")
    .get(s"${cisUrl(taxYear)}/materials?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def postDidYouPayForMaterialsPage(taxYear: String, month: String, contractorId: String, value: Boolean): HttpRequestBuilder = http(requestName = "Post Did You Pay for Materials Page")
    .post(url = s"${cisUrl(taxYear)}/materials?month=$month&contractor=$contractorId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(expected = 303))

  def getCostOfMaterialsPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http(requestName = "Get Cost of Materials Page")
    .get(s"${cisUrl(taxYear)}/materials-amount?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def postCostOfMaterialsPage(taxYear: String, month: String, contractorId: String, amount: BigDecimal): HttpRequestBuilder = http(requestName = "Post Cost of Materials Page")
    .post(url = s"${cisUrl(taxYear)}/materials-amount?month=$month&contractor=$contractorId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", amount)
    .check(status.is(expected = 303))

  def getContractorDetailsPage(taxYear: String): HttpRequestBuilder = http(requestName = "Get Contractor Details Page")
    .get(s"${cisUrl(taxYear)}/contractor-details")
    .check(status.is(expected = 200))

  def postContractorDetailsPage(taxYear: String, contractorId: String): HttpRequestBuilder = http(requestName = "Post Contractor Details Page")
    .post(url = s"${cisUrl(taxYear)}/contractor-details")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("contractorName", "Homer Simpson Ltd")
    .formParam("employerReferenceNumber", contractorId)
    .check(status.is(expected = 303))

  def getRemoveDeductionPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http("Get Remove Deduction Page")
    .get(s"${cisUrl(taxYear)}/remove-deduction?month=$month&contractor=$contractorId")
    .check(status.is(expected = 200))

  def postRemoveDeductionPage(taxYear: String, month: String, contractorId: String): HttpRequestBuilder = http("Post Remove Deduction Page")
    .post(url = s"${cisUrl(taxYear)}/remove-deduction?month=$month&contractor=$contractorId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(expected = 303))
}
