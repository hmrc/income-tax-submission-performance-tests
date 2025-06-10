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


object PropertyForeignRequests extends ServicesConfiguration {

  def getForeignPropertyDetailsPage(taxYear : String): HttpRequestBuilder =http("Get Foreign Property Details Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/about/start")
    .check(status.is(expected = 200))

 def getForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Get Total Income page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/total-income")
   .check(status.is(expected = 200))

 def postForeignPropertyTotalIncome(taxYear : String): HttpRequestBuilder = http("Post Total Income page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/total-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignTotalIncome" ,"under")
   .check(status.is(303))

 def getForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Get Foreign Property Report Income Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/income-report")
   .check(status.is(expected = 200))

  def postForeignPropertyReportIncome(taxYear : String): HttpRequestBuilder = http("Post Foreign Property Report Income Page")
    .post(s"${propertyUrl(taxYear)}/foreign-property/income-report")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

 def getWhichCountryDidYouReceiveIncomeFrom(taxYear: String): HttpRequestBuilder = http("Get Which Country Did You Receive Income From Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/about/0/select-income-country")
   .check(status.is(expected = 200))

 def postWhichCountryDidYouReceiveIncomeFrom(taxYear: String): HttpRequestBuilder = http("Post Which Country Did You Receive Income From Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/about/0/select-income-country")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("country-autocomplete", "AGO")
   .check(status.is(303))

  def getCountriesWhereRentedOutProperty(taxYear: String): HttpRequestBuilder = http("Get Countries Where You Rented Out Property Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/countries-rented-property")
    .check(status.is(expected = 200))

  def postCountriesWhereRentedOutProperty(taxYear: String): HttpRequestBuilder = http("Post Countries Where You Rented Out Property Page")
    .post(s"${propertyUrl(taxYear)}/foreign-property/countries-rented-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("isCountriesRentedProperty", false)
    .check(status.is(303))

  def getClaimPropertyAllowanceOrExpenses(taxYear: String): HttpRequestBuilder = http("Get Claim Property Allowance Or Expenses Page")
    .get(s"${propertyUrl(taxYear)}/foreign-property/claim-property-income-allowance-or-expenses")
    .check(status.is(expected = 200))

 def postClaimPropertyAllowanceOrExpenses(taxYear: String): HttpRequestBuilder = http("Post Claim Property Allowance Or Expenses Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/claim-property-income-allowance-or-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("claimPropertyIncomeAllowanceOrExpenses", false)
   .check(status.is(303))

 def getForeignCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check Your Answers Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/check-your-answers")
   .check(status.is(expected = 200))

 def postForeignCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Post Foreign Check Your Answers Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getForeignHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Foreign Have You Finished Section Page")
   .get(s"${propertyUrl(taxYear)}/foreign-property/select-country/complete-yes-no")
   .check(status.is(expected = 200))

 def postForeignHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Post Foreign Have You Finished Section Page")
   .post(s"${propertyUrl(taxYear)}/foreign-property/select-country/complete-yes-no")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("isForeignSelectCountriesComplete", "true")
   .check(status.is(303))
}



