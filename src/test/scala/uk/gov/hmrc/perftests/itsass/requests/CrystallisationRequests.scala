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

object CrystallisationRequests extends ServicesConfiguration {

  //Common

  def getDeclarationPage(taxYearEOY: String): HttpRequestBuilder = http(s"Get Declaration Page")
    .get(s"$serviceUrl/$taxYearEOY/declaration")
    .check(status.is(200))

  def postDeclarationPage(taxYearEOY: String): HttpRequestBuilder = http("Post Declaration Page")
    .post(s"$serviceUrl/$taxYearEOY/declaration")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getReceivedTaxCalculationPage(taxYearEOY: String): HttpRequestBuilder = http(s"Get We've received your Income Tax Return Page")
    .get(s"$serviceUrl/$taxYearEOY/income-tax-return-received")
    .check(status.is(200))

  //Individual

  def getFinalTaxCalculationEndpoint(taxYearEOY: String): HttpRequestBuilder = http(s"Get Final Tax Calculation Endpoint")
    .get(s"$viewAndChangeUrl/view/$taxYearEOY/final-tax-overview/calculate?origin=PTA")
    .check(status.is(303))

  def getFinalTaxCalculationPageOriginRedirect(taxYearEOY: String): HttpRequestBuilder = http(s"Get Your final tax overview Page origin redirect")
    .get(s"$viewAndChangeUrl/view/$taxYearEOY/final-tax-overview?origin=PTA")
    .check(status.is(303))
    .check(currentLocationRegex(s"(.*)/view/$taxYearEOY/final-tax-overview(.*)"))

  def getFinalTaxCalculationPage(taxYearEOY: String): HttpRequestBuilder = http(s"Get Your final tax overview Page")
    .get(s"$viewAndChangeUrl/view/$taxYearEOY/final-tax-overview")
    .check(status.is(200))
    .check(currentLocationRegex(s"(.*)/view/$taxYearEOY/final-tax-overview(.*)"))

  def postFinalTaxCalculationPage(taxYearEOY: String): HttpRequestBuilder = http(s"Post Your final tax overview Page")
    .post(s"$viewAndChangeUrl/view/$taxYearEOY/final-tax-overview")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  //Agent

  def getCitizenDetailsStubPage: HttpRequestBuilder = http("Get Citizen Details Stub Page")
    .get(s"$viewAndChangeUrl/view/test-only/stub-client")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCitizenDetailsStubPage: HttpRequestBuilder = http("Post Citizen Details Stub Page")
    .post(s"$viewAndChangeUrl/view/test-only/stub-client")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("nino", "AA000000A")
    .formParam("utr", "1234567890")
    .formParam("status", "200")
    .check(status.is(303))

  def getFinalTaxCalculationAgentEndpoint(taxYearEOY: String): HttpRequestBuilder = http(s"Get Final Tax Calculation Endpoint")
    .get(s"$viewAndChangeUrl/view/agents/$taxYearEOY/final-tax-overview/calculate")
    .check(status.is(303))

  def getFinalTaxCalculationAgentPage(taxYearEOY: String): HttpRequestBuilder = http(s"Get Your final tax overview Page")
    .get(s"$viewAndChangeUrl/view/agents/$taxYearEOY/final-tax-overview")
    .check(status.is(200))

  def postFinalTaxCalculationAgentPage(taxYearEOY: String): HttpRequestBuilder = http(s"Post Your final tax overview Page")
    .post(s"$viewAndChangeUrl/view/agents/$taxYearEOY/final-tax-overview")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
