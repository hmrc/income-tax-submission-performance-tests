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

  def getDividendsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Dividends Check Your Answers Page")
    .get(s"${dividendsUrl(taxYear)}/summary")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Dividends Check Your Answers Page")
    .post(s"${dividendsUrl(taxYear)}/summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))
}
