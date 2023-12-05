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

object PropertyPensionsInvestmentRequests extends ServicesConfiguration {

  def getPensionsPage(taxYear: String): HttpRequestBuilder = http("Get Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPensionsPage(taxYear: String): HttpRequestBuilder = http("Post Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "statePension")
    .check(status.is(303))

  def getChangePensionsPage(taxYear: String): HttpRequestBuilder = http("Get Change Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangePensionsPage(taxYear: String): HttpRequestBuilder = http("Post Change Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "nonUkPensions")
    .check(status.is(303))

  /////////////////////////////////////////////////////////

  def getRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Rental Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/rental-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Rental Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "uk")
    .check(status.is(303))

  def getChangeRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Change Rental Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-rental-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Change Rental Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "nonUkPensions")
    .check(status.is(303))
}