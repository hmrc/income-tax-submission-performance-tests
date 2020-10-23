/*
 * Copyright 2020 HM Revenue & Customs
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

import io.gatling.http.Predef._
import io.gatling.core.Predef._

import uk.gov.hmrc.performance.conf.ServicesConfiguration

object IncomeTaxSubmissionRequests extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("income-tax-submission-frontend")
  val serviceUrl: String = baseUrlFor(baseUrl + "/income-through-software/return")
  val authLoginUrl: String = baseUrlFor("auth-login")
  val csrfPattern: String = """name="csrfToken" value="([^"]+)"""

  def saveCsrfToken()= regex(_ => csrfPattern).saveAs("csrfToken")

  def getStartPage = http("Get Start Page")
    .get(s"$serviceUrl/start")
    .check(status.is(200))

  def getAgentTestOnlyEndPoint = http("Get Agent Test Only End Point")
    .get(s"$serviceUrl/test-only/agent-access/1234567890")
    .check(status.is(303))

  def getOverviewPage = http("Get Overview Page")
    .get(s"$serviceUrl/view")
    .check(status.is(200))

}
