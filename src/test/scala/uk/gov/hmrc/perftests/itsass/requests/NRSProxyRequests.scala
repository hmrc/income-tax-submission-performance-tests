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

import io.gatling.core.Predef.{StringBody, _}
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.perftests.itsass.Json.NRSRequest.submitCrystallisationNrsStatement
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object NRSProxyRequests {

  def nrsHeaders(mtditid: String): Map[String, String] =
    Map(
      "Accept" -> s"application/vnd.hmrc.1.0+json",
      "Authorization" -> s"$${bearerToken}",
      "Content-Type" -> "application/json",
      "mtditid" -> s"$mtditid"
    )

  def postNrsProxyStatement(identifier: String, notableEvent: String, simMtditid: String): HttpRequestBuilder = http("Post NRS request")
    .post(s"$nrsProxyBaseUrl/income-tax-nrs-proxy/$identifier/$notableEvent")
    .body(StringBody(submitCrystallisationNrsStatement))
    .headers(nrsHeaders(simMtditid))
    .check(status.in(200))

}
