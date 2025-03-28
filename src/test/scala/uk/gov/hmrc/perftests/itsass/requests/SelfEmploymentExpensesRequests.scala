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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.selfEmploymentUrl


object SelfEmploymentExpensesRequests extends ServicesConfiguration {

 def getTradingAllowanceExpenses(taxYear: String): HttpRequestBuilder = http("Get Trading Allowance Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/income/trading-allowance")
   .check(status.is(expected = 200))

 def postTradingAllowanceExpenses(taxYear: String): HttpRequestBuilder = http("Post Trading Allowance Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/income/trading-allowance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "declareExpenses")
   .check(status.is(303))

  def getExpensesCategories(taxYear: String): HttpRequestBuilder = http("Get Expenses Categories Page")
    .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses")
    .check(status.is(expected = 200))

 def postExpensesCategories(taxYear: String): HttpRequestBuilder = http("Post Expenses Categories Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "individualCategories")
   .check(status.is(303))

 def getOfficeSupplies(taxYear: String): HttpRequestBuilder = http("Get Office supplies Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/office-supplies")
   .check(status.is(expected = 200))

 def postOfficeSupplies(taxYear: String): HttpRequestBuilder = http("Post Office supplies Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/office-supplies")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

 def getGoodsToSellOrUse(taxYear: String): HttpRequestBuilder = http("Get Goods to sell or use Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/goods-sell-use")
   .check(status.is(expected = 200))

 def postGoodsToSellOrUse(taxYear: String): HttpRequestBuilder = http("Post Goods to sell or use Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/goods-sell-use")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

 def getRepairsAndMaintenance(taxYear: String): HttpRequestBuilder = http("Get Repairs And Maintenance Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/repairs-maintenance")
   .check(status.is(expected = 200))

 def postRepairsAndMaintenance(taxYear: String): HttpRequestBuilder = http("Post Repairs And Maintenance Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/repairs-maintenance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

 def getDidYouWorkFromHome(taxYear: String): HttpRequestBuilder = http("Get Did You Work From Home Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/work-from-home")
   .check(status.is(expected = 200))

 def postDidYouWorkFromHome(taxYear: String): HttpRequestBuilder = http("Post Did You Work From Home Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/work-from-home")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getDidYouWorkFromOwnPremises(taxYear: String): HttpRequestBuilder = http("Get Did You Work From Own Premises Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/work-from-business-premises")
   .check(status.is(expected = 200))

 def postDidYouWorkFromOwnPremises(taxYear: String): HttpRequestBuilder = http("Post Did You Work From Own Premises Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/work-from-business-premises")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

 def getTravelAndAccommodationForWork(taxYear: String): HttpRequestBuilder = http("Get Did You Travel For Work Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/travel")
   .check(status.is(expected = 200))

 def postTravelAndAccommodationForWork(taxYear: String): HttpRequestBuilder = http("Post Did You Travel For Work Page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938001/expenses/travel")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

}
