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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object ViewEstimationRequests extends ServicesConfiguration {

  //Individual

  def postOverviewPageInYearEstimate(taxYear: String): HttpRequestBuilder = http("Post In Year Estimate Request on Overview page")
    .post(s"$serviceUrl/$taxYear/inYear-estimate")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getTaxCalculationOverviewPageOriginRedirect: HttpRequestBuilder = http(s"Get Tax Overview Page origin redirect")
    .get(s"$viewAndChangeUrl/view/tax-overview?origin=PTA")
    .check(status.is(303))
    .check(currentLocationRegex("(.*)/view/tax-overview(.*)"))

  def getTaxCalculationOverviewPage: HttpRequestBuilder = http(s"Get Tax Overview Page")
    .get(s"$viewAndChangeUrl/view/tax-overview")
    .check(status.is(200))
    .check(currentLocationRegex("(.*)/view/tax-overview(.*)"))

  //Agent

  def getIncomeTaxAgentEndpoint: HttpRequestBuilder = http(s"Get Income Tax Agent Endpoint")
    .get(s"$viewAndChangeUrl/view/agents/tax-overview")
    .check(status.is(303))

  def getTaxCalculationOverviewAgentsPage: HttpRequestBuilder = http(s"Get Tax Overview AgentsPage")
    .get(s"$viewAndChangeUrl/view/agents/tax-overview")
    .check(saveCsrfToken())
    .check(status.is(200))

}
