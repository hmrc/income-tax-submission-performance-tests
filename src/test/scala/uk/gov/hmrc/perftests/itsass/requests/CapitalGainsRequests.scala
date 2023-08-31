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

object CapitalGainsRequests extends ServicesConfiguration {

  def getCapitalGains: HttpRequestBuilder = http("Get Capital Gains")
    .get(s"$tailorReturnUrl/capital-gains-trusts-estates/capital-gains")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCapitalGains: HttpRequestBuilder = http("Post Capital Gains")
    .post(s"$tailorReturnUrl/capital-gains-trusts-estates/capital-gains")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeCapitalGains: HttpRequestBuilder = http("Get Change Capital Gains")
    .get(s"$tailorReturnUrl/capital-gains-trusts-estates/change-capital-gains")
    .check(status.is(200))

  def postChangeCapitalGains: HttpRequestBuilder = http("Post Change Capital Gains")
    .post(s"$tailorReturnUrl/capital-gains-trusts-estates/change-capital-gains")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getTrustsSettlementsEstates: HttpRequestBuilder = http("Get Trusts Settlements Estates")
    .get(s"$tailorReturnUrl/capital-gains-trusts-estates/trusts-settlements-estates")
    .check(status.is(200))

  def postTrustsSettlementsEstates: HttpRequestBuilder = http("Post Trusts Settlements Estates")
    .post(s"$tailorReturnUrl/capital-gains-trusts-estates/trusts-settlements-estates")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Trusts")
    .check(status.is(303))

  def getChangeTrustsSettlementsEstates: HttpRequestBuilder = http("Get Change Trusts Settlements Estates")
    .get(s"$tailorReturnUrl/capital-gains-trusts-estates/change-trusts-settlements-estates")
    .check(status.is(200))

  def postChangeTrustsSettlementsEstates: HttpRequestBuilder = http("Post Change Trusts Settlements Estates")
    .post(s"$tailorReturnUrl/capital-gains-trusts-estates/change-trusts-settlements-estates")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Settlements")
    .check(status.is(303))
}
