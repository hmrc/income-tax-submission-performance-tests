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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{selfEmploymentId, selfEmploymentUrl}


object SelfEmploymentExpensesRequests extends ServicesConfiguration {

 def getTradingAllowanceExpenses(taxYear: String): HttpRequestBuilder = http("Get Trading Allowance Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/income/trading-allowance")
   .check(status.is(expected = 200))

 def postTradingAllowanceExpenses(taxYear: String): HttpRequestBuilder = http("Post Trading Allowance Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/income/trading-allowance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "declareExpenses")
   .check(status.is(303))

  def getExpensesCategories(taxYear: String): HttpRequestBuilder = http("Get Expenses Categories Page")
    .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses")
    .check(status.is(expected = 200))

 def postExpensesCategories(taxYear: String): HttpRequestBuilder = http("Post Expenses Categories Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "individualCategories")
   .check(status.is(303))

 def getOfficeSupplies(taxYear: String): HttpRequestBuilder = http("Get Office supplies Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/office-supplies")
   .check(status.is(expected = 200))

 def postOfficeSupplies(taxYear: String): HttpRequestBuilder = http("Post Office supplies Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/office-supplies")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

 def getGoodsToSellOrUse(taxYear: String): HttpRequestBuilder = http("Get Goods to sell or use Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/goods-sell-use")
   .check(status.is(expected = 200))

 def postGoodsToSellOrUse(taxYear: String): HttpRequestBuilder = http("Post Goods to sell or use Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/goods-sell-use")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

 def getRepairsAndMaintenance(taxYear: String): HttpRequestBuilder = http("Get Repairs And Maintenance Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/repairs-maintenance")
   .check(status.is(expected = 200))

 def postRepairsAndMaintenance(taxYear: String): HttpRequestBuilder = http("Post Repairs And Maintenance Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/repairs-maintenance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

 def getDidYouWorkFromHome(taxYear: String): HttpRequestBuilder = http("Get Did You Work From Home Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/work-from-home")
   .check(status.is(expected = 200))

 def postDidYouWorkFromHome(taxYear: String): HttpRequestBuilder = http("Post Did You Work From Home Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/work-from-home")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "false")
   .check(status.is(303))

 def getDidYouWorkFromOwnPremises(taxYear: String): HttpRequestBuilder = http("Get Did You Work From Own Premises Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/work-from-business-premises")
   .check(status.is(expected = 200))

 def postDidYouWorkFromOwnPremises(taxYear: String): HttpRequestBuilder = http("Post Did You Work From Own Premises Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/work-from-business-premises")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

 def getTravelAndAccommodationForWork(taxYear: String): HttpRequestBuilder = http("Get Did You Travel For Work Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel")
   .check(status.is(expected = 200))

 def postTravelAndAccommodationForWork(taxYear: String): HttpRequestBuilder = http("Post Did You Travel For Work Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "yesDisallowable")
   .check(status.is(303))

 def getAdvertisingAndMarketing(taxYear: String): HttpRequestBuilder = http("Get Advertising And Marketing Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/advertising-marketing")
   .check(status.is(expected = 200))

 def postAdvertisingAndMarketing(taxYear: String): HttpRequestBuilder = http("Post Advertising And Marketing Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/advertising-marketing")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

 def getEntertainmentCosts(taxYear: String): HttpRequestBuilder = http("Get Entertainment Costs Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/entertainment")
   .check(status.is(expected = 200))

 def postEntertainmentCosts(taxYear: String): HttpRequestBuilder = http("Post Entertainment Costs Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/entertainment")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "false")
   .check(status.is(303))

 def getStaffConstructionIndustry(taxYear: String): HttpRequestBuilder = http("Get Staff Construction Industry Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/staff-construction-industry-professional-services")
   .check(status.is(expected = 200))

 def postStaffConstructionIndustry(taxYear: String): HttpRequestBuilder = http("Post Staff Construction Industry Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/staff-construction-industry-professional-services")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value[4]", "no")
   .check(status.is(303))

 def getFinancialExpenses(taxYear: String): HttpRequestBuilder = http("Get Financial Expenses Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/financial-expenses")
   .check(status.is(expected = 200))

 def postFinancialExpenses(taxYear: String): HttpRequestBuilder = http("Post Financial Expenses Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/financial-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value[4]", "noFinancialExpenses")
   .check(status.is(303))

 def getDepreciationOrProfit(taxYear: String): HttpRequestBuilder = http("Get Depreciation Or Profit Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/depreciation")
   .check(status.is(expected = 200))

 def postDepreciationOrProfit(taxYear: String): HttpRequestBuilder = http("Post Depreciation Or Profit Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/depreciation")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "false")
   .check(status.is(303))

 def getOtherExpenses(taxYear: String): HttpRequestBuilder = http("Get Other Expenses Page")
   .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/other-expenses")
   .check(status.is(expected = 200))

 def postOtherExpenses(taxYear: String): HttpRequestBuilder = http("Post Other Expenses Page")
   .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/other-expenses")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "no")
   .check(status.is(303))

  def getTravelAndAccomTotalExpenses(taxYear: String): HttpRequestBuilder = http("Get Travel And Accommodation Total Expenses Page")
    .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/travel-accommodation-total-expenses")
    .check(status.is(expected = 200))

  def postTravelAndAccomTotalExpenses(taxYear: String): HttpRequestBuilder = http("Post Travel And Accommodation Total Expenses Page")
    .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/travel-accommodation-total-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "100")
    .check(status.is(303))

  def getTravelAndAccomDisallowable(taxYear: String): HttpRequestBuilder = http("Get Travel And Accommodation Disallowable Expenses Page")
    .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/travel-accommodation-disallowable-expenses")
    .check(status.is(expected = 200))

  def postTravelAndAccomDisallowable(taxYear: String): HttpRequestBuilder = http("Post Travel And Accommodation Disallowable Expenses Page")
    .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/travel-accommodation-disallowable-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "87")
    .check(status.is(303))

  def getCheckYourTravelExpenses(taxYear: String): HttpRequestBuilder = http("Get Check Your Travel Expenses Page")
    .get(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/check-your-travel-expenses")
    .check(status.is(expected = 200))

  def postCheckYourTravelExpenses(taxYear: String): HttpRequestBuilder = http("Post Check Your Travel Expenses Page")
    .post(s"${selfEmploymentUrl(taxYear)}/$selfEmploymentId/expenses/travel/check-your-travel-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
