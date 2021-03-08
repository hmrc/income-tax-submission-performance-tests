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

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.RequestsHelper._

object IncomeTaxSubmissionRequests extends ServicesConfiguration {

  def getStartPage: HttpRequestBuilder = http("Get Start Page")
    .get(s"$serviceUrl/2022/start")
    .check(status.is(200))

  def getInsertAdditionalParametersEndPoint: HttpRequestBuilder = http("Insert Additional Parameters End Point")
    .get(s"$serviceUrl/test-only/2022/additional-parameters?ClientNino=AA111112A&ClientMTDID=1234567891")
    .check(status.is(303))

  def getOverviewPage: HttpRequestBuilder = http("Get Overview Page")
    .get(s"$serviceUrl/2022/view")
    .check(status.is(200))
}
