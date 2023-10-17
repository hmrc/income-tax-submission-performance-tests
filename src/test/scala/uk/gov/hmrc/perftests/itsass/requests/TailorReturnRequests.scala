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
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object TailorReturnRequests extends ServicesConfiguration {

  def getTailorReturnSamplePage: HttpRequestBuilder = http("Get Tailor Return Sample Page")
    .get(s"${tailorReturnUrl}/sampleYesNoPage/${taxYearEOY}")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTailorReturnSamplePage: HttpRequestBuilder = http("Post Tailor Return Sample Page")
    .post(s"${tailorReturnUrl}/sampleYesNoPage/${taxYearEOY}")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTailorReturnFrontEndPage: HttpRequestBuilder = http("Get Tailor Return Frontend Page")
    .get(s"${tailorReturnUrl}/${taxYear}")
    .check(status.is(200))
}
