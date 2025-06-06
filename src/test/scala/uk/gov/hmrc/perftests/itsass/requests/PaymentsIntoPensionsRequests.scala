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

object PaymentsIntoPensionsRequests extends ServicesConfiguration  {

  def getPensionsSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Pension Summary Page")
    .get(s"${pensionsUrl(taxYear)}/pensions-summary")
    .check(status.is(200))

  def getReliefAtSourcePensionsPage(taxYear: String): HttpRequestBuilder = http("Get Relief At Source Pensions Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/relief-at-source")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postReliefAtSourcePensionsPage(taxYear: String): HttpRequestBuilder = http("Post Relief At Source Pensions Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/relief-at-source")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTotalPaymentsIntoReliefAtSourceAmountPage(taxYear: String): HttpRequestBuilder = http("Get Total Payment into Relief at Source Amount Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/relief-at-source-amount")
    .check(status.is(200))

  def postTotalPaymentsIntoReliefAtSourceAmountPage(taxYear: String): HttpRequestBuilder = http("Post Total Payment into Relief at Source Amount Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/relief-at-source-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getDidYouMakeOneOffPaymentsPage(taxYear: String): HttpRequestBuilder = http("Get Did you make any one-off payments Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/one-off-payments")
    .check(status.is(200))

  def postDidYouMakeOneOffPaymentsPage(taxYear: String): HttpRequestBuilder = http("Post Did you make any one-off payments Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/one-off-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear: String): HttpRequestBuilder = http("Get Total one-off payments into relief at source Amount Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/one-off-payments-amount")
    .check(status.is(200))

  def postTotalOneOffPaymentsIntoReliefAtSourceAmountPage(taxYear: String): HttpRequestBuilder = http("Post Total one-off payments into relief at source Amount Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/one-off-payments-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getYourTotalPaymentsIntoReliefAtSourcePage(taxYear: String): HttpRequestBuilder = http("Get Your Total Payments Into Relief At Source Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/total-relief-at-source-check")
    .check(status.is(200))

  def postYourTotalPaymentsIntoReliefAtSourcePage(taxYear: String): HttpRequestBuilder = http("Post Your Total Payments Into Relief At Source Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/total-relief-at-source-check")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPensionsWhereTaxReliefIsNotClaimedPage(taxYear: String): HttpRequestBuilder = http("Get Pensions Where Tax Relief Is Not Claimed Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief")
    .check(status.is(200))

  def postPensionsWhereTaxReliefIsNotClaimedPage(taxYear: String): HttpRequestBuilder = http("Post Pensions Where Tax Relief Is Not Claimed Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

   def getDidYouPayIntoRetirementAnnuityContractPage(taxYear: String): HttpRequestBuilder = http("Get Did You Pay Into Retirement Annuity Contract Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/retirement-annuity")
    .check(status.is(200))

  def postDidYouPayIntoRetirementAnnuityContractPage(taxYear: String): HttpRequestBuilder = http("Post Did You Pay Into Retirement Annuity Contract Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/retirement-annuity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear: String): HttpRequestBuilder = http("Get How Much Did You Pay Into Retirement Annuity Contracts Amount Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/retirement-annuity-amount")
    .check(status.is(200))

  def postHowMuchDidYouPayIntoRetirementAnnuityContractsAmountPage(taxYear: String): HttpRequestBuilder = http("Post How Much Did You Pay Into Retirement Annuity Contracts Amount Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/retirement-annuity-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .formParam("amount", "100")
    .check(status.is(303))

  def getDidYouPayIntoWorkplacePensionPage(taxYear: String): HttpRequestBuilder = http("Get Did You Pay Into Workplace Pension Question Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/workplace")
    .check(status.is(200))

  def postDidYouPayIntoWorkplacePensionPage(taxYear: String): HttpRequestBuilder = http("Post Did You Pay Into Workplace Pension Question Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/workplace")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear: String): HttpRequestBuilder = http("Get How Much Did You Pay Into Work Place" +
    "Pension Amount Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/workplace-amount")
    .check(status.is(200))

  def postHowMuchDidYouPayIntoWorkPlacePensionAmountPage(taxYear: String): HttpRequestBuilder = http("Post How Much Did You Pay Into Work Place Pension Amount Page")
    .post(s"${pensionsUrl(taxYear)}/payments-into-pensions/no-tax-relief/workplace-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getCheckYourPaymentsIntoPensions(taxYear: String): HttpRequestBuilder = http("Get Check Your Payments into Pensions Page")
    .get(s"${pensionsUrl(taxYear)}/payments-into-pensions/check-payments-into-pensions")
    .check(status.is(200))

}
