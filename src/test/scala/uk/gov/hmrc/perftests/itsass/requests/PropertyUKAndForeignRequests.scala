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

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.propertyUrl


object PropertyUKAndForeignRequests extends ServicesConfiguration {

  def getUKAndForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-foreign-property")
    .check(status.is(expected = 200))

 def postUKAndForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Post Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-foreign-property")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", true)
   .check(status.is(303))

 def getUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/total-income")
   .check(status.is(expected = 200))

 def postUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .get(s"${propertyUrl(taxYear)}/total-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", true)
   .check(status.is(303))

 def getUKAndForeignPropertyUKSelect(taxYear : String): HttpRequestBuilder = http("Get Property Select Page")
   .get(s"${propertyUrl(taxYear)}/about/rental-property")
   .check(status.is(expected = 200))

  def postUKAndForeignPropertyUKSelect(taxYear : String): HttpRequestBuilder = http("Post Property Select Page")
    .get(s"${propertyUrl(taxYear)}/about/rental-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))
}