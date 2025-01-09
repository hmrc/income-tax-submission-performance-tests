/*
 * Copyright 2025 HM Revenue & Customs
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

object IncomeTaxSubmissionRequests extends ServicesConfiguration {

  def getStartPage(taxYear: String): HttpRequestBuilder = http("Get Start Page")
    .get(s"$serviceUrl/$taxYear/start")
    .check(status.is(303))

  def getInsertAdditionalParametersEndPoint(nino: String, mtditid: String, userTaxYear: String = taxYear): HttpRequestBuilder = http("Insert Additional Parameters End Point")
    .get(s"$serviceUrl/test-only/$userTaxYear/additional-parameters?ClientNino=$nino&ClientMTDID=$mtditid")
    .check(status.is(303))

  def getOverviewPage(taxYear: String): HttpRequestBuilder = http("Get Overview Page")
    .get(s"$serviceUrl/$taxYear/view")
    .check(saveCsrfToken())
    .check(status.is(200))

  def getEOYOverviewPage(taxYearEOY: String): HttpRequestBuilder = http("Get EOY Overview Page")
    .get(s"$serviceUrl/$taxYearEOY/income-tax-return-overview")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postEOYOverviewPage(taxYearEOY: String): HttpRequestBuilder = http("Post EOY Overview Page")
    .post(s"$serviceUrl/$taxYearEOY/final-calculation")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getClientUTRPage: HttpRequestBuilder = http("Get UTR Page")
    .get(s"$viewAndChangeUrl/view/agents/client-utr")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postClientUTRPage: HttpRequestBuilder = http("Post UTR Page")
    .post(s"$viewAndChangeUrl/view/agents/client-utr")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("utr", "1234567890")
    .check(status.is(303))

  def getConfirmClientUTRPage: HttpRequestBuilder = http(s"Get confirm client UTR Page")
    .get(s"$viewAndChangeUrl/view/agents/confirm-client-details")
    .check(status.is(200))

  def postConfirmClientUTRPage: HttpRequestBuilder = http(s"Post confirm client UTR Page")
    .post(s"$viewAndChangeUrl/view/agents/confirm-client-details")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
