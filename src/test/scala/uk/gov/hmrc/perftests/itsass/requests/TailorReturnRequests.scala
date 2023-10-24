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

  def getTailorReturnStartPage(taxYear: String): HttpRequestBuilder = http("Get Tailor Return Start Page")
    .get(s"${tailorReturnUrl}/${taxYear}/start")
    .check(status.is(200))

  def getUkResidenceStatusPage: HttpRequestBuilder = http("Get Uk Residence Status")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUkResidenceStatusPage: HttpRequestBuilder = http("Post Uk Residence Status")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "uk")
    .check(status.is(303))

  def getChangeUkResidenceStatusPage: HttpRequestBuilder = http("Get Change Uk Residence Status")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUkResidenceStatusPage: HttpRequestBuilder = http("Post Change Uk Residence Status")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonUK")
    .check(status.is(303))

  def getYourResidenceStatusPage: HttpRequestBuilder = http("Get Your Residence Status Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postYourResidenceStatusPage: HttpRequestBuilder = http("Post Your Residence Status Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonResident")
    .check(status.is(303))

  def getChangeYourResidenceStatusPage: HttpRequestBuilder = http("Get Change Your Residence Status Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeYourResidenceStatusPage: HttpRequestBuilder = http("Post Change Your Residence Status Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "dualResident")
    .check(status.is(303))

  def getTailorReturnFrontEndPage: HttpRequestBuilder = http("Get Tailor Return Frontend Page")
    .get(s"${tailorReturnUrl}/${taxYear}")
    .check(status.is(200))
}