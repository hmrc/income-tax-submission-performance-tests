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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object DividendsRequests extends ServicesConfiguration {

  def getDividendsGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Gateway Page")
    .get(s"${dividendsUrl(taxYear)}/dividends-from-stocks-and-shares")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Dividends Gateway Page")
    .post(s"${dividendsUrl(taxYear)}/dividends-from-stocks-and-shares")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUKDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Get UK Dividends Status Page")
    .get(s"${dividendsUrl(taxYear)}/dividends-from-uk-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Post UK Dividends Status Page")
    .post(s"${dividendsUrl(taxYear)}/dividends-from-uk-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUKDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get UK Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/how-much-dividends-from-uk-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post UK Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/how-much-dividends-from-uk-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getCheckUKDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get UK Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/check-how-much-dividends-from-uk-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCheckUKDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post UK Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/check-how-much-dividends-from-uk-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getOtherDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Get Other Dividends Status Page")
    .get(s"${dividendsUrl(taxYear)}/dividends-from-uk-trusts-or-open-ended-investment-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Post Other Dividends Status Page")
    .post(s"${dividendsUrl(taxYear)}/dividends-from-uk-trusts-or-open-ended-investment-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Other Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Other Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getCheckOtherDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Other Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/check-how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCheckOtherDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Other Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/check-how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getStockDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Status Page")
    .get(s"${dividendsUrl(taxYear)}/stock-dividend-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendsStatusPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Status Page")
    .post(s"${dividendsUrl(taxYear)}/stock-dividend-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getStockDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/stock-dividend-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/stock-dividend-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getCheckStockDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Amount Page")
    .get(s"${dividendsUrl(taxYear)}/check-stock-dividend-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCheckStockDividendsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Amount Page")
    .post(s"${dividendsUrl(taxYear)}/check-stock-dividend-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getRedeemableSharesStatusPage(taxYear: String): HttpRequestBuilder = http("Get Redeemable Shares Status Page")
    .get(s"${dividendsUrl(taxYear)}/redeemable-shares-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRedeemableSharesStatusPage(taxYear: String): HttpRequestBuilder = http("Post Redeemable Shares Status Page")
    .post(s"${dividendsUrl(taxYear)}/redeemable-shares-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Get Redeemable Shares Amount Page")
    .get(s"${dividendsUrl(taxYear)}/redeemable-shares-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Post Redeemable Shares Amount Page")
    .post(s"${dividendsUrl(taxYear)}/redeemable-shares-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getCheckRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Get Redeemable Shares Amount Page")
    .get(s"${dividendsUrl(taxYear)}/check-redeemable-shares-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCheckRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Post Redeemable Shares Amount Page")
    .post(s"${dividendsUrl(taxYear)}/check-redeemable-shares-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getCloseCompanyLoanStatusPage(taxYear: String): HttpRequestBuilder = http("Get Close Company Loan Status Page")
    .get(s"${dividendsUrl(taxYear)}/close-company-loan-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCloseCompanyLoanStatusPage(taxYear: String): HttpRequestBuilder = http("Post Close Company Loan Status Page")
    .post(s"${dividendsUrl(taxYear)}/close-company-loan-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCloseCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Get Close Company Loan Amount Page")
    .get(s"${dividendsUrl(taxYear)}/close-company-loan-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCloseCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Post Close Company Loan Amount Page")
    .post(s"${dividendsUrl(taxYear)}/close-company-loan-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getCheckCloseCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Get Close Company Loan Amount Page")
    .get(s"${dividendsUrl(taxYear)}/check-close-company-loan-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCheckCloseCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Post Close Company Loan Amount Page")
    .post(s"${dividendsUrl(taxYear)}/check-close-company-loan-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Check Your Answers Page")
    .get(s"${dividendsUrl(taxYear)}/summary")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Dividends Check Your Answers Page")
    .post(s"${dividendsUrl(taxYear)}/summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getCashDividendSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${miniJourneyUrl(taxYear)}/cash-dividends/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCashDividendSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${miniJourneyUrl(taxYear)}/cash-dividends/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getStockDividendSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${miniJourneyUrl(taxYear)}/cash-dividends/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${miniJourneyUrl(taxYear)}/cash-dividends/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getOtherDividendsSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${miniJourneyUrl(taxYear)}/dividends-from-unit-trusts/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${miniJourneyUrl(taxYear)}/dividends-from-unit-trusts/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getRedeemableSharesSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${miniJourneyUrl(taxYear)}/free-redeemable-shares/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRedeemableSharesSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${miniJourneyUrl(taxYear)}/free-redeemable-shares/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getCloseCompanyLoanSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${miniJourneyUrl(taxYear)}/close-company-loans/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCloseCompanyLoanSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${miniJourneyUrl(taxYear)}/close-company-loans/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))
}
