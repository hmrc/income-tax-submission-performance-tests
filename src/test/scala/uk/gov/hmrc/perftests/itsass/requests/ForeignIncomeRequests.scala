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


object ForeignIncomeRequests extends ServicesConfiguration {

//-----------------------------Foreign Dividends------------------------------------------------


 def getForeignDividendsDetailsPage(taxYear: String): HttpRequestBuilder =http("Get Foreign dividends start Page")
    .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/start")
    .check(status.is(expected = 200))

 def getCountryReceivedDividendIncomePage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Get Country received dividend income from page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$index/country-receive-dividend-income")
   .check(status.is(expected = 200))

 def postCountryReceivedDividendIncomePage(taxYear: String, index: Int = 0): HttpRequestBuilder = http("Post Country received dividend income from page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$index/country-receive-dividend-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("country-autocomplete", "ESP")
   .check(status.is(303))

 def getIncomeReceivedBeforeForeignTaxDeductedPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Get Income received before foreign tax deducted page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/income-received-before-foreign-tax-deducted")
   .check(status.is(expected = 200))

 def postIncomeReceivedBeforeForeignTaxDeductedPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Post Income received before foreign tax deducted page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/income-received-before-foreign-tax-deducted")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("incomeBeforeForeignTaxDeducted", "7542.60")
   .check(status.is(303))

 def getForeignTaxDeductedFromDividendIncomePage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Get Foreign tax deducted from foreign dividend income page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/foreign-tax-deducted-from-dividend-income")
   .check(status.is(expected = 200))

 def postForeignTaxDeductedFromDividendIncomeYesPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Post Foreign tax deducted from foreign dividend income yes page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/foreign-tax-deducted-from-dividend-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignTaxDeductedFromDividendIncome", true)
   .check(status.is(303))

 def postForeignTaxDeductedFromDividendIncomeNoPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Post Foreign tax deducted from foreign dividend income no page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/foreign-tax-deducted-from-dividend-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("foreignTaxDeductedFromDividendIncome", false)
   .check(status.is(303))

 def getHowMuchForeignTaxDeductedFromDividendIncomePage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Get How much foreign tax was deducted from foreign dividend income page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/how-much-foreign-tax-deducted-from-dividend-income")
   .check(status.is(expected = 200))

 def postHowMuchForeignTaxDeductedFromDividendIncomePage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Post How much foreign tax was deducted from foreign dividend income page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/how-much-foreign-tax-deducted-from-dividend-income")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("howMuchForeignTaxDeductedFromDividendIncome", 400)
   .check(status.is(303))

 def getClaimForeignTaxCreditReliefPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Get Claim foreign tax credit relief page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/claim-foreign-tax-credit-relief")
   .check(status.is(expected = 200))

 def postClaimForeignTaxCreditReliefPage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Post Claim foreign tax credit relief page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/claim-foreign-tax-credit-relief")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("claimForeignTaxCreditRelief", true)
   .check(status.is(303))

 def getCheckYourAnswersForeignIncomePage(taxYear: String, countryCode: String): HttpRequestBuilder = http("Get Check your answers page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/$countryCode/check-your-answers")
   .check(status.is(expected = 200))

 def postCheckYourAnswersForeignIncomePage(taxYear: String): HttpRequestBuilder = http("Post Check your answers page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/check-your-answers")
   .formParam("""csrfToken""", """${csrfToken}""")
   .check(status.is(303))

 def getYourForeignDividendsByCountryPage(taxYear: String): HttpRequestBuilder = http("Get Your foreign dividends by country page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/your-foreign-dividends-by-country")
   .check(status.is(expected = 200))

 def postYourForeignDividendsByCountryPage(taxYear: String): HttpRequestBuilder = http("Post Your foreign dividends by country page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/your-foreign-dividends-by-country")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("yourForeignDividendsByCountry", false)
   .check(status.is(303))

 def getHaveYouCompletedThisSectionForeignIncomePage(taxYear: String): HttpRequestBuilder = http("Get Have you completed this section page")
   .get(s"${propertyUrl(taxYear)}/foreign-income/dividends/section-finished")
   .check(status.is(expected = 200))

 def postHaveYouCompletedThisSectionForeignIncomePage(taxYear: String): HttpRequestBuilder = http("Post Have you completed this section page")
   .post(s"${propertyUrl(taxYear)}/foreign-income/dividends/section-finished")
   .formParam("""csrfToken""", """${csrfToken}""")
   .formParam("dividendsSectionFinished", true)
   .check(status.is(303))





}
