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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.propertyUrl


object PropertyUKAndForeignRequests extends ServicesConfiguration {

  def getUKAndForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/uk-foreign-property/about/start")
    .check(status.is(expected = 200))

 def getUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/total-property-income")
   .check(status.is(expected = 200))

 def postUKAndForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/total-property-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "lessThan")
   .check(status.is(303))

 def getUKAndForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Get Property Report Income Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/report-income")
   .check(status.is(expected = 200))

  def postUKAndForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Post Property Report Income Page")
    .post(s"${propertyUrl(taxYear)}/uk-foreign-property/report-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "wantToReport")
    .check(status.is(303))

 def getWhichRentalTypeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Which Rental Property Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/rental-type-uk")
   .check(status.is(expected = 200))

 def postWhichRentalTypeUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Which Rental Property Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/rental-type-uk")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value[1]", "rentARoom")
   .check(status.is(303))

 def getWhichCountryUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Which Country Did You Receive Income From Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/countries/1")
   .check(status.is(expected = 200))

 def postWhichCountryUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Which Country Did You Receive Income From Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/countries/1")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("country", "CAF")
   .check(status.is(303))

 def getWhereRentedOutPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Get Countries Where You Rented Out Property Page")
   .get(s"${propertyUrl(taxYear)}/uk-foreign-property/countries")
   .check(status.is(expected = 200))

 def postWhereRentedOutPropertyUKAndForeign(taxYear: String): HttpRequestBuilder = http("Post Countries Where You Rented Out Property Page")
   .post(s"${propertyUrl(taxYear)}/uk-foreign-property/countries")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("addAnother", false)
   .check(status.is(303))
}
