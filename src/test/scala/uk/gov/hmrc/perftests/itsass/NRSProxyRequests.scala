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
import io.gatling.core.structure.ChainBuilder
import io.gatling.http.Predef._
import uk.gov.hmrc.perftests.itsass.Json.NRSRequest.submitNrsStatement
import uk.gov.hmrc.perftests.itsass.RequestsHelper.nrsProxyBaseUrl

object NRSProxyRequests {

  private val nrsUrl = s"$nrsProxyBaseUrl/mtd-api-nrs-proxy/$${nino}/itsa-eops"

  val nrsHeaders: Map[String, String] =
    Map("Accept" -> s"application/vnd.hmrc.1.0+json",
      "Authorization" -> s"$${bearerToken}",
      "Content-Type" -> "application/json")

  val postNrsProxyStatement: ChainBuilder = exec(http("NRS request")
    .post(nrsUrl)
    .body(StringBody(submitNrsStatement))
    .headers(nrsHeaders)
    .check(status.in(200)))


}
