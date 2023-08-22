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

object IncomeFromPropertyPensionsInvestmentsRequests extends ServicesConfiguration {

  def getRentalIncome: HttpRequestBuilder = http("Get Rental Income")
    .get(s"$tailorReturnUrl/property-pensions-investments/rental-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRentalIncome: HttpRequestBuilder = http("Post Rental Income")
    .post(s"$tailorReturnUrl/property-pensions-investments/rental-income")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "UkProperty")
    .check(status.is(303))

  def getChangeRentalIncome: HttpRequestBuilder = http("Get Change Rental Income")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-rental-income")
    .check(status.is(200))

  def postChangeRentalIncome: HttpRequestBuilder = http("Post Change Rental Income")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-rental-income")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "NonukProperty")
    .check(status.is(303))

  def getPensions: HttpRequestBuilder = http("Get Pensions")
    .get(s"$tailorReturnUrl/property-pensions-investments/pensions")
    .check(status.is(200))

  def postPensions: HttpRequestBuilder = http("Post Pensions")
    .post(s"$tailorReturnUrl/property-pensions-investments/pensions")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "StatePension")
    .check(status.is(303))

  def getChangePensions: HttpRequestBuilder = http("Get Change Pensions")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-pensions")
    .check(status.is(200))

  def postChangePensions: HttpRequestBuilder = http("Post Change Pensions")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-pensions")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "NonUkPensions")
    .check(status.is(303))

  def getUkInsuranceGains: HttpRequestBuilder = http("Get Uk Insurance Gains")
    .get(s"$tailorReturnUrl/property-pensions-investments/uk-insurance-gains")
    .check(status.is(200))

  def postUkInsuranceGains: HttpRequestBuilder = http("Post Uk Insurance Gains")
    .post(s"$tailorReturnUrl/property-pensions-investments/uk-insurance-gains")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "LifeInsurance")
    .check(status.is(303))

  def getChangeUkInsuranceGains: HttpRequestBuilder = http("Get Change Uk Insurance Gains")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-uk-insurance-gains")
    .check(status.is(200))

  def postChangeUkInsuranceGains: HttpRequestBuilder = http("Post Change Uk Insurance Gains")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-uk-insurance-gains")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "CapitalRedemption")
    .check(status.is(303))

  def getUkInterest: HttpRequestBuilder = http("Get Uk Interest")
    .get(s"$tailorReturnUrl/property-pensions-investments/uk-interest")
    .check(status.is(200))

  def postUkInterest: HttpRequestBuilder = http("Post Uk Interest")
    .post(s"$tailorReturnUrl/property-pensions-investments/uk-interest")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "InterestFromUkBanksAndBuildingSocieties")
    .check(status.is(303))

  def getChangeUkInterest: HttpRequestBuilder = http("Get Change Uk Interest")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-uk-interest")
    .check(status.is(200))

  def postChangeUkInterest: HttpRequestBuilder = http("Post Change Uk Interest")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-uk-interest")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "InterestFromUkTrustFundsOrBonds")
    .check(status.is(303))

  def getUkDividendsSharesLoans: HttpRequestBuilder = http("Get Uk Dividends Shares Loans")
    .get(s"$tailorReturnUrl/property-pensions-investments/uk-dividends-shares-loans")
    .check(status.is(200))

  def postUkDividendsSharesLoans: HttpRequestBuilder = http("Post Uk Dividends Shares Loans")
    .post(s"$tailorReturnUrl/property-pensions-investments/uk-dividends-shares-loans")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "CashDividendsFromUkStocksAndShares")
    .check(status.is(303))

  def getChangeUkDividendsSharesLoans: HttpRequestBuilder = http("Get Change Uk Dividends Shares Loans")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-uk-dividends-shares-loans")
    .check(status.is(200))

  def postChangeUkDividendsSharesLoans: HttpRequestBuilder = http("Post Change Uk Dividends Shares Loans")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-uk-dividends-shares-loans")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "FreeOrRedeemableShares")
    .check(status.is(303))

  def getNonUkInterestDividendsInsurancePolicies: HttpRequestBuilder = http("Get Non Uk Interest Dividends")
    .get(s"$tailorReturnUrl/property-pensions-investments/non-uk-interest-dividends-insurance-policies")
    .check(status.is(200))

  def postNonUkInterestDividendsInsurancePolicies: HttpRequestBuilder = http("Post Non Uk Interest Dividends")
    .post(s"$tailorReturnUrl/property-pensions-investments/non-uk-interest-dividends-insurance-policies")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "NonukInterest")
    .check(status.is(303))

  def getChangeNonUkInterestDividendsInsurancePolicies: HttpRequestBuilder = http("Get Change Non Uk Interest Dividends")
    .get(s"$tailorReturnUrl/property-pensions-investments/change-non-uk-interest-dividends-insurance-policies")
    .check(status.is(200))

  def postChangeNonUkInterestDividendsInsurancePolicies: HttpRequestBuilder = http("Post Change Non Uk Interest Dividends")
    .post(s"$tailorReturnUrl/property-pensions-investments/change-non-uk-interest-dividends-insurance-policies")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "NonukDividendsWhileLivingInTheUk")
    .check(status.is(303))
}
