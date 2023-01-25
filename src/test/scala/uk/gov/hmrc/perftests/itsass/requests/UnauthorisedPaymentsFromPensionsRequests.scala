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

object UnauthorisedPaymentsFromPensionsRequests extends ServicesConfiguration{

  def getUnauthorisedPayments: HttpRequestBuilder = http("Get Unauthorised payments Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/unauthorised-payments")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUnauthorisedPayments: HttpRequestBuilder = http("Post Unauthorised payments Page")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/unauthorised-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("unauthorisedPayments[]", "yesSurchargeValue")
    .formParam("unauthorisedPayments[]", "yesNotSurchargeValue")
    .check(status.is(303))

  def getAmountThatResultedInASurcharge: HttpRequestBuilder = http("get Amount that resulted in a surcharge Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/amount-surcharged")
    .check(status.is(200))

  def postAmountThatResultedInASurcharge: HttpRequestBuilder = http("post Amount that resulted in a surcharge Page")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/amount-surcharged")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getDidYouPayNonUkOnAmountSurcharge: HttpRequestBuilder = http("get Did you pay non-UK tax on the amount that resulted in a surcharge")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/tax-on-amount-surcharged")
    .check(status.is(200))

  def postDidYouPayNonUkOnAmountSurcharge: HttpRequestBuilder = http("post Did you pay non-UK tax on the amount that resulted in a surcharge")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/tax-on-amount-surcharged")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .formParam("amount-2", "100")
    .check(status.is(303))

  def getAmountThatDidNotResultInASurcharge: HttpRequestBuilder = http("get Amount that did not result in a surcharge")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/amount-not-surcharged")
    .check(status.is(200))

  def postAmountThatDidNotResultInASurcharge: HttpRequestBuilder = http("post Amount that did not result in a surcharge")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/amount-not-surcharged")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getDidYouPayNonUkOnAmountThatDidNotSurcharge: HttpRequestBuilder = http("get Did you pay non-UK tax on the amount that did not result in a surcharge")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/tax-on-amount-not-surcharged")
    .check(status.is(200))

  def postDidYouPayNonUkOnAmountThatDidSurcharge: HttpRequestBuilder = http("post Did you pay non-UK tax on the amount that did not result in a surcharge")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/tax-on-amount-not-surcharged")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .formParam("amount-2", "100")
    .check(status.is(303))

  def getWereAnyOfThePaymentFromAUKPension: HttpRequestBuilder = http("Get Were any of the unauthorised payments from a UK pension scheme Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/uk-pension-scheme")
    .check(status.is(200))

  def postWereAnyOfThePaymentFromAUKPension: HttpRequestBuilder = http("Post Were any of the unauthorised payments from a UK pension scheme Page")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/uk-pension-scheme")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getPensionSchemeTaxReference: HttpRequestBuilder = http("Get Pension Scheme Tax Reference (PSTR) Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/pension-scheme-tax-reference")
    .check(status.is(200))

  def postPensionSchemeTaxReference: HttpRequestBuilder = http("Post Pension Scheme Tax Reference (PSTR) Page")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/pension-scheme-tax-reference")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("taxReferenceId", "12345678RA")
    .check(status.is(303))

  def getUnauthorisedPaymentsFromUKPensionScheme: HttpRequestBuilder = http("Get Unauthorised payments from UK pensions schemes Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/uk-pension-scheme-details")
    .check(status.is(200))

  def getRemovePensionSchemeTaxReference: HttpRequestBuilder = http("Get Do you want to remove this Pension Scheme Tax Reference Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/remove-pension-scheme-tax-reference?pensionSchemeIndex=0")
    .check(status.is(200))

  def postRemovePensionSchemeTaxReference: HttpRequestBuilder = http("post Do you want to remove this Pension Scheme Tax Reference Page")
    .post(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/remove-pension-scheme-tax-reference?pensionSchemeIndex=0")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getCheckYourUnauthorisedPayments: HttpRequestBuilder = http("Get Check your unauthorised payments Page")
    .get(s"${pensionsUrl(taxYear)}/unauthorised-payments-from-pensions/check-unauthorised-payments")
    .check(status.is(200))




}
