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


object SelfEmploymentTradingAllowanceRequests extends ServicesConfiguration {

  def getTaskListPage(taxYear : String): HttpRequestBuilder =http("Get TaskList Page")
    .get(s"${selfEmploymentUrl(taxYear)}/task-list")
    .check(status.is(expected = 200))

 def getSelfEmploymentSummary(taxYear : String): HttpRequestBuilder = http("Get Self Employment Summary Page")
   .get(s"${selfEmploymentUrl(taxYear)}/self-employment-summary")
   .check(status.is(expected = 200))

  def getHaveYouFinishedSection(taxYear: String): HttpRequestBuilder = http("Get Have you finished this section page")
    .get(s"${selfEmploymentUrl(taxYear)}/trade-details/trade-details/details/completed-section")
    .check(status.is(expected = 200))

 def postHaveYouFinishedSection(taxYear : String): HttpRequestBuilder = http("Post Have you finished this section page")
   .post(s"${selfEmploymentUrl(taxYear)}/trade-details/trade-details/details/completed-section")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

  def getSelfEmploymentAbroad(taxYear: String): HttpRequestBuilder = http("Get Carry out self employment abroad page")
    .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/details/change-self-employment-abroad")
    .check(status.is(expected = 200))

 def postSelfEmploymentAbroad(taxYear: String): HttpRequestBuilder = http("Post Carry out self employment abroad page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/details/change-self-employment-abroad")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(expected = 303))

  def getCheckYourDetails(taxYear: String): HttpRequestBuilder = http("Get Check your details page")
    .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/details/self-employment-abroad/check")
    .check(status.is(expected = 200))

  def postCheckYourDetails(taxYear: String): HttpRequestBuilder = http("1heck your details page")
    .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/details/self-employment-abroad/check")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

 def getIncomeNotCountedAsTurnover(taxYear: String): HttpRequestBuilder = http("Get Income not counted as turnover page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/not-counted-turnover")
   .check(status.is(expected = 200))

 def postIncomeNotCountedAsTurnover(taxYear: String): HttpRequestBuilder = http("Post Income not counted as turnover page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/not-counted-turnover")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getHowMuchNonTurnoverIncome(taxYear: String): HttpRequestBuilder = http("Get How much non-turnover income page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/not-counted-turnover/amount")
   .check(status.is(expected = 200))

 def postHowMuchNonTurnoverIncome(taxYear: String): HttpRequestBuilder = http("Post How much non-turnover income page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/not-counted-turnover/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "1000")
   .check(status.is(303))

 def getYourTurnover(taxYear: String): HttpRequestBuilder = http("Get Your turnover page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-amount")
   .check(status.is(expected = 200))

 def postYourTurnover(taxYear: String): HttpRequestBuilder = http("Post Your turnover page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "20000")
   .check(status.is(303))

 def getAnyOtherIncome(taxYear: String): HttpRequestBuilder = http("Get Is there any other income page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/other-income")
   .check(status.is(expected = 200))

 def postAnyOtherIncome(taxYear: String): HttpRequestBuilder = http("Post Is there any other income page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/other-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getOtherSelfEmploymentIncome(taxYear: String): HttpRequestBuilder = http("Get How much other self-employment income page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/other-income/amount")
   .check(status.is(expected = 200))

 def postOtherSelfEmploymentIncome(taxYear: String): HttpRequestBuilder = http("Post How much other self-employment income page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/other-income/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "1000")
   .check(status.is(303))

 def getTurnoverExemptFromTax(taxYear: String): HttpRequestBuilder = http("Get Turnover exempt from tax page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-exempt")
   .check(status.is(expected = 200))

 def postTurnoverExemptFromTax(taxYear: String): HttpRequestBuilder = http("Post Turnover exempt from tax page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-exempt")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getHowMuchTurnoverExemptFromTax(taxYear: String): HttpRequestBuilder = http("Get How much turnover is exempt from being taxed as profit page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-exempt/amount")
   .check(status.is(expected = 200))

 def postHowMuchTurnoverExemptFromTax(taxYear: String): HttpRequestBuilder = http("Post How much turnover is exempt from being taxed as profit page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/turnover-exempt/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "1000")
   .check(status.is(303))

 def getTradingAllowance(taxYear: String): HttpRequestBuilder = http("Get Trading Allowance page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance")
   .check(status.is(expected = 200))

 def postTradingAllowance(taxYear: String): HttpRequestBuilder = http("Post Trading Allowance page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "useTradingAllowance")
   .check(status.is(303))

 def getTradingAllowanceForLowIncome(taxYear: String): HttpRequestBuilder = http("Get Trading Allowance For Low Income page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance/under-1000")
   .check(status.is(expected = 200))

 def postTradingAllowanceForLowIncome(taxYear: String): HttpRequestBuilder = http("Post Trading Allowance For Low Income page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance/under-1000")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "lessThan")
   .check(status.is(303))

 def getHowMuchTradingAllowance(taxYear: String): HttpRequestBuilder = http("Get How Much Trading Allowance page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance/amount")
   .check(status.is(expected = 200))

 def postHowMuchTradingAllowance(taxYear: String): HttpRequestBuilder = http("Post How Much Trading Allowance page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/trading-allowance/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "900")
   .check(status.is(303))

 def getCheckYourIncome(taxYear: String): HttpRequestBuilder = http("Get Check your income page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/check-your-income")
   .check(status.is(expected = 200))

 def postCheckYourIncome(taxYear: String): HttpRequestBuilder = http("2heck your income page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/income/check-your-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getBalancingCharge(taxYear: String): HttpRequestBuilder = http("Get Balancing Charge page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge")
   .check(status.is(expected = 200))

 def postBalancingCharge(taxYear: String): HttpRequestBuilder = http("Post Balancing Charge page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getHowMuchIsTotalBalancingCharge(taxYear: String): HttpRequestBuilder = http("Get How much is the total Balancing Charge page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge/total-amount")
   .check(status.is(expected = 200))

 def postHowMuchIsTotalBalancingCharge(taxYear: String): HttpRequestBuilder = http("Post How much is the total Balancing Charge page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge/total-amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "100")
   .check(status.is(303))

 def getCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("Get Check your answers page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge/check")
   .check(status.is(expected = 200))

 def postCheckYourAnswers(taxYear: String): HttpRequestBuilder = http("3heck your answers page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/capital-allowances/balancing-charge/check")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getGoodsAndServicesForOwnUse(taxYear: String): HttpRequestBuilder = http("Get Goods And Services For Own Use page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/goods-services")
   .check(status.is(expected = 200))

 def postGoodsAndServicesForOwnUse(taxYear: String): HttpRequestBuilder = http("Post Goods And Services For Own Use page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/goods-services")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getGoodsAndServicesForOwnUseAmount(taxYear: String): HttpRequestBuilder = http("Get Goods And Services For Own Use Amount page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/goods-services/amount")
   .check(status.is(expected = 200))

 def postGoodsAndServicesForOwnUseAmount(taxYear: String): HttpRequestBuilder = http("Post Goods And Services For Own Use Amount page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/goods-services/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "1000")
   .check(status.is(303))

 def getNetBusinessProfit(taxYear: String): HttpRequestBuilder = http("Get Net Business Profit page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/net-business-profit-loss/calculation")
   .check(status.is(expected = 200))

 def getUnusedLosses(taxYear: String): HttpRequestBuilder = http("Get Unused Losses Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss?csrfToken=394a5de71d932b135d09119f03ce5a5d77108f4d-1737559159077-0e01de365f900d7aa9a1c76c")
   .check(status.is(expected = 200))

 def postUnusedLosses(taxYear: String): HttpRequestBuilder = http("Post Unused Losses page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "true")
   .check(status.is(303))

 def getTotalAmountUnusedLosses(taxYear: String): HttpRequestBuilder = http("Get Total Amount Unused Losses Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss/amount")
   .check(status.is(expected = 200))

 def postTotalAmountUnusedLosses(taxYear: String): HttpRequestBuilder = http("Post Total Amount Unused Losses page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss/amount")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "999.0")
   .check(status.is(303))

 def getWhenYouReportedLoss(taxYear: String): HttpRequestBuilder = http("Get When you reported the loss Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss/year")
   .check(status.is(expected = 200))

 def postWhenYouReportedLoss(taxYear: String): HttpRequestBuilder = http("Post When you reported the loss page")
   .post(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/previous-year-unused-loss/year")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("value", "2022to2023")
   .check(status.is(303))

 def getAdjustedTaxableProfit(taxYear: String): HttpRequestBuilder = http("Get Adjusted taxable profit Page")
   .get(s"${selfEmploymentUrl(taxYear)}/SJPR05893938000/adjustments/adjusted-taxable-profit-loss/calculation")
   .check(status.is(expected = 200))

}
