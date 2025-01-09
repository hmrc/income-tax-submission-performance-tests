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

object AdditionalInfoRequests extends ServicesConfiguration {

  def getInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/interest-summary")
    .check(status.is(200))

  def getInterestGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Interest Gateway Page")
    .get(s"${interestUrl(taxYear)}/interest-from-UK")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Interest Gateway Page")
    .post(s"${interestUrl(taxYear)}/interest-from-UK")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Status Page")
    .get(s"${interestUrl(taxYear)}/untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Post Untaxed UK Interest Status Page")
    .post(s"${interestUrl(taxYear)}/untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUntaxedChooseAccountRedirect: HttpRequestBuilder = http("Get ID for Untaxed Amount Controller")
    .get(s"${interestUrl(taxYear)}/which-account-did-you-get-untaxed-interest-from")
    .check(saveUntaxedAccountId)
    .check(status.is(303))

  def getUntaxedUKInterestDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Details Page")
    .get(s"${interestUrl(taxYear)}/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestDetailsPage(accountName: String): HttpRequestBuilder = http("Post Untaxed UK Interest Details Page")
    .post(s"${interestUrl(taxYear)}/add-untaxed-uk-interest-account/$${untaxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("untaxedAccountName", s"$accountName")
    .formParam("untaxedAmount", "1000")
    .check(status.is(303))

  def getUntaxedUKInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Untaxed UK Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/accounts-with-untaxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUntaxedUKInterestSummaryPage(addAnotherAccount: Boolean): HttpRequestBuilder = http("Post Untaxed UK Interest Summary Page")
    .post(s"${interestUrl(taxYear)}/accounts-with-untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getTaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Status Page")
    .get(s"${interestUrl(taxYear)}/taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestStatusPage(taxYear: String): HttpRequestBuilder = http("Post Taxed UK Interest Status Page")
    .post(s"${interestUrl(taxYear)}/taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxedChooseAccountPage(taxYear: String): HttpRequestBuilder = http("Get Choose Account Page")
    .get(s"${interestUrl(taxYear)}/which-account-did-you-get-taxed-interest-from")
    .check(status.is(200))

  def postTaxedChooseAccountPage(taxYear: String): HttpRequestBuilder = http("Post Choose Account Page")
    .post(s"${interestUrl(taxYear)}/which-account-did-you-get-taxed-interest-from")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "eb687fc3-37fc-4b7d-8038-19aaf62f9681-111-eb687fc3-37fc-4b7d-8038-19aaf62f9681")
    .check(saveTaxedAccountId)
    .check(status.is(303))

  def getTaxedUKInterestDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Details Page")
    .get(s"${interestUrl(taxYear)}/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestDetailsPage(accountName: String): HttpRequestBuilder = http("Post Taxed UK Interest Details Page")
    .post(s"${interestUrl(taxYear)}/add-taxed-uk-interest-account/$${taxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("taxedAccountName", s"$accountName")
    .formParam("taxedAmount", "1000")
    .check(status.is(303))

  def getTaxedUKInterestSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Taxed UK Interest Summary Page")
    .get(s"${interestUrl(taxYear)}/accounts-with-taxed-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxedUKInterestSummaryPage(addAnotherAccount: Boolean): HttpRequestBuilder = http("Post Taxed UK Interest Summary Page")
    .post(s"${interestUrl(taxYear)}/accounts-with-taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherAccount)
    .check(status.is(303))

  def getInterestCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Interest Check Your Answers Page")
    .get(s"${interestUrl(taxYear)}/check-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Interest Check Your Answers Page")
    .post(s"${interestUrl(taxYear)}/check-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestFromSecuritiesPage(taxYear: String): HttpRequestBuilder = http("Get Interest From Securities")
    .get(s"${interestUrl(taxYear)}/interest-from-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestFromSecuritiesPage(taxYear: String): HttpRequestBuilder = http("Post Interest From Securities")
    .post(s"${interestUrl(taxYear)}/interest-from-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxTakenFromInterestAmountPage(taxYear: String): HttpRequestBuilder = http("Get How Much Interest Did You Get Page")
    .get(s"${interestUrl(taxYear)}/tax-taken-off-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxTakenFromInterestAmountPage(taxYear: String): HttpRequestBuilder = http("Post How Much Interest Did You Get Page")
    .post(s"${interestUrl(taxYear)}/tax-taken-off-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "193.54")
    .check(status.is(303))

  def getInterestSecuritiesTaxTakenOffPage(taxYear: String): HttpRequestBuilder = http("Get Was Tax Taken Off Your Interest Page")
    .get(s"${interestUrl(taxYear)}/tax-taken-from-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestSecuritiesTaxTakenOffPage(taxYear: String): HttpRequestBuilder = http("Post Was Tax Taken Off Your Interest Page")
    .post(s"${interestUrl(taxYear)}/tax-taken-from-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxSecuritiesAmountPage(taxYear: String): HttpRequestBuilder = http("Get How Much Tax Was Taken Off Page")
    .get(s"${interestUrl(taxYear)}/interest-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxSecuritiesAmountPage(taxYear: String): HttpRequestBuilder = http("Get How Much Tax Was Taken Off Page")
    .post(s"${interestUrl(taxYear)}/interest-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "300")
    .check(status.is(303))

  def getSecuritiesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Check Your Interest From Gilt Edged Or Accrued Income Securities Page")
    .get(s"${interestUrl(taxYear)}/check-interest-from-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postSecuritiesCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Check Your Interest From Gilt Edged Or Accrued Income Securities Page")
    .post(s"${interestUrl(taxYear)}/check-interest-from-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  //Gains
  def getGainsGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Gains Gateway Page")
    .get(s"${gainsUrl(taxYear)}/gains-gateway")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGainsGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Gains Gateway Page")
    .post(s"${gainsUrl(taxYear)}/gains-gateway")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPolicyTypePage(taxYear: String): HttpRequestBuilder = http("Get Policy Type Page")
    .get(s"${gainsUrl(taxYear)}/policy-type/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPolicyTypePage(policyType: String, taxYear: String): HttpRequestBuilder = http("Post Policy Type Page")
    .post(s"${gainsUrl(taxYear)}/policy-type/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("policy-type", policyType)
    .check(status.is(303))

  def getPolicyNumberPage(taxYear: String): HttpRequestBuilder = http("Get Policy Number Page")
    .get(s"${gainsUrl(taxYear)}/policy-name/$gainsSessionId")
    .check(status.is(200))

  def postPolicyNumberPage(taxYear: String): HttpRequestBuilder = http("Post Policy Number Page")
    .post(s"${gainsUrl(taxYear)}/policy-name/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "P-89879-123")
    .check(status.is(303))

  def getGainsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Gains Amount Page")
    .get(s"${gainsUrl(taxYear)}/gains-amount/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGainsAmountPage(gainsAmount: String, taxYear: String): HttpRequestBuilder = http("Post Gains Amount Page")
    .post(s"${gainsUrl(taxYear)}/gains-amount/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", (gainsAmount))
    .check(status.is(303))

  def getGainsStatusPage(taxYear: String): HttpRequestBuilder = http("Get Gains Status Page")
    .get(s"${gainsUrl(taxYear)}/gains-status/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGainsStatusPage(taxYear: String): HttpRequestBuilder = http("Post Gains Status Page")
    .post(s"${gainsUrl(taxYear)}/gains-status/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPolicyHeldPreviousPage(taxYear: String): HttpRequestBuilder = http("Get Policy Held Previous Page")
    .get(s"${gainsUrl(taxYear)}/policy-held-previous/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPolicyHeldPreviousPage(taxYear: String): HttpRequestBuilder = http("Post Policy Held Previous Page")
    .post(s"${gainsUrl(taxYear)}/policy-held-previous/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("year", "99")
    .check(status.is(303))

  def getPolicyEventPage(taxYear: String): HttpRequestBuilder = http("Get Policy Event Page")
    .get(s"${gainsUrl(taxYear)}/policy-event/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPolicyEventPage(policyEvent: String, taxYear: String): HttpRequestBuilder = http("Post Policy Event Page")
    .post(s"${gainsUrl(taxYear)}/policy-event/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("policy-event", policyEvent)
    .check(status.is(303))

  def getPolicyHeldPage(taxYear: String): HttpRequestBuilder = http("Get Policy Held Page")
    .get(s"${gainsUrl(taxYear)}/policy-held/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPolicyHeldPage(taxYear: String): HttpRequestBuilder = http("Post Policy Held Page")
    .post(s"${gainsUrl(taxYear)}/policy-held/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("year", "99")
    .check(status.is(303))

  def getPaidTaxAmountPage(taxYear: String): HttpRequestBuilder = http("Get Paid Tax Amount Page")
    .get(s"${gainsUrl(taxYear)}/paid-tax-amount/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPaidTaxAmountPage(taxYear: String): HttpRequestBuilder = http("Post Paid Tax Amount Page")
    .post(s"${gainsUrl(taxYear)}/paid-tax-amount/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "10")
    .check(status.is(303))

  def getPaidTaxStatusPage(taxYear: String): HttpRequestBuilder = http("Get Paid Tax Status Page")
    .get(s"${gainsUrl(taxYear)}/paid-tax-status/$gainsSessionId")
    .check(status.is(200))

  def postPaidTaxStatusPage(taxYear: String): HttpRequestBuilder = http("Post Paid Tax Status Page")
    .post(s"${gainsUrl(taxYear)}/paid-tax-status/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    //.check(saveTaxedAccountId)
    .check(status.is(303))

  def getDeficiencyReliefStatusPage(taxYear: String): HttpRequestBuilder = http("Get Deficiency Relief Status Page")
    .get(s"${gainsUrl(taxYear)}/deficiency-relief-status/$gainsSessionId")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDeficiencyReliefStatusPage(amount: String, taxYear: String): HttpRequestBuilder = http("Post Deficiency Relief Status Page")
    .post(s"${gainsUrl(taxYear)}/deficiency-relief-status/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .formParam("amount", "100")
    .check(status.is(303))

  def getPolicySummaryPage(taxYear: String): HttpRequestBuilder = http("Get Policy Summary Page")
    .get(s"${gainsUrl(taxYear)}/policy-summary/$gainsSessionId")
    .check(status.is(200))

  def postPolicySummaryPage(taxYear: String): HttpRequestBuilder = http("Post Policy Summary Page")
    .post(s"${gainsUrl(taxYear)}/policy-summary/$gainsSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getGainsSummaryPage(taxYear: String, policyType: String): HttpRequestBuilder = {
    val formattedPolicyType = formatPolicyType(policyType)
    http("Get Gains Summary Page")
      .get(s"${gainsUrl(taxYear)}/summary?policyType=$formattedPolicyType")
      .check(status.is(200))
  }

  def getPoliciesRemoveConfirmationPage(taxYear: String): HttpRequestBuilder = http("Get Policies Remove Confirmation Page")
    .get(s"${gainsUrl(taxYear)}/policies-remove-confirmation/$gainsRemoveConfirmationSessionId")
    .check(status.is(200))

  def postPoliciesRemoveConfirmationPage(taxYear: String): HttpRequestBuilder = http("Post Policies Remove Confirmation Page")
    .post(s"${gainsUrl(taxYear)}/policies-remove-confirmation/$gainsRemoveConfirmationSessionId")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  //Stock Dividends
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

  def getDividendsRedeemableStatusPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Redeemable Status Page")
    .get(s"${dividendsUrl(taxYear)}/redeemable-shares-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsRedeemableStatusPage(taxYear: String): HttpRequestBuilder = http("Post Dividends Redeemable Status Page")
    .post(s"${dividendsUrl(taxYear)}/redeemable-shares-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getDividendsRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Redeemable Shares Amount Page")
    .get(s"${dividendsUrl(taxYear)}/redeemable-shares-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsRedeemableSharesAmountPage(taxYear: String): HttpRequestBuilder = http("Post Dividends Redeemable Shares Amount Page")
    .post(s"${dividendsUrl(taxYear)}/redeemable-shares-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getStockDividendsCompanyLoanStatusPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Company Loan Status Page")
    .get(s"${dividendsUrl(taxYear)}/close-company-loan-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendsCompanyLoanStatusPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Company Loan Status Page")
    .post(s"${dividendsUrl(taxYear)}/close-company-loan-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getStockDividendsCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Company Loan Amount Page")
    .get(s"${dividendsUrl(taxYear)}/close-company-loan-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendsCompanyLoanAmountPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Company Loan Amount Page")
    .post(s"${dividendsUrl(taxYear)}/close-company-loan-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getStockDividendsSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Stock Dividends Check Your Answers Page")
    .get(s"${dividendsUrl(taxYear)}/summary")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendsSummaryPage(taxYear: String): HttpRequestBuilder = http("Post Stock Dividends Check Your Answers Page")
    .post(s"${dividendsUrl(taxYear)}/summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Interest Section Completed Page")
    .get(s"${interestUrl(taxYear)}/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postInterestSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Interest Section Completed Page")
    .post(s"${interestUrl(taxYear)}/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getStockDividendSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Section Completed Page")
    .get(s"${dividendsUrl(taxYear)}/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postStockDividendSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Dividends Section Completed Page")
    .post(s"${dividendsUrl(taxYear)}/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))

  def getGainsSectionCompletedPage(taxYear: String): HttpRequestBuilder = http("Get Gains Section Completed Page")
    .get(s"${gainsUrl(taxYear)}/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGainsSectionCompletedPage(taxYear: String, value: String = "true"): HttpRequestBuilder = http("Post Gains Section Completed Page")
    .post(s"${gainsUrl(taxYear)}/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", value)
    .check(status.is(303))
}
