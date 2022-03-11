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

object ViewEstimationRequests extends ServicesConfiguration {

  //Individual

  def getIncomeTaxPage: HttpRequestBuilder = http(s"Get Income Tax Page")
    .get(s"$viewAndChangeUrl/view")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(200))

  def getTaxOverviewPage: HttpRequestBuilder = http(s"Get Tax Overview Page")
    .get(s"$viewAndChangeUrl/view/tax-overview")
    .check(saveCsrfToken())
    .check(status.is(200))

  //Agent

  def getIncomeTaxAgentEndpoint: HttpRequestBuilder = http(s"Get Income Tax Agent Endpoint")
    .get(s"$viewAndChangeUrl/view/agents/tax-overview")
    .check(status.is(303))

  def getIncomeTaxAgentPage: HttpRequestBuilder = http(s"Get Income Tax Agent Page")
    .get(s"$viewAndChangeUrl/view/agents/income-tax-account")
    .check(status.is(200))

  def getTaxOverviewAgentsPage: HttpRequestBuilder = http(s"Get Tax Overview AgentsPage")
    .get(s"$viewAndChangeUrl/view/agents/tax-overview")
    .check(saveCsrfToken())
    .check(status.is(200))

}
