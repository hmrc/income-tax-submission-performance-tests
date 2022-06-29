/*
 * Copyright 2022 HM Revenue & Customs
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

  def getDividendsGatewayPage: HttpRequestBuilder = http("Get Dividends Gateway Page")
    .get(s"$interestUrl/interest-from-UK")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsGatewayPage: HttpRequestBuilder = http("Post Dividends Gateway Page")
    .post(s"$interestUrl/interest-from-UK")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUKDividendsStatusPage: HttpRequestBuilder = http("Get UK Dividends Status Page")
    .get(s"$dividendsUrl/dividends-from-uk-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsStatusPage: HttpRequestBuilder = http("Post UK Dividends Status Page")
    .post(s"$dividendsUrl/dividends-from-uk-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUKDividendsAmountPage: HttpRequestBuilder = http("Get UK Dividends Amount Page")
    .get(s"$dividendsUrl/how-much-dividends-from-uk-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsAmountPage: HttpRequestBuilder = http("Post UK Dividends Amount Page")
    .post(s"$dividendsUrl/how-much-dividends-from-uk-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOtherDividendsStatusPage: HttpRequestBuilder = http("Get Other Dividends Status Page")
    .get(s"$dividendsUrl/dividends-from-uk-trusts-or-open-ended-investment-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsStatusPage: HttpRequestBuilder = http("Post Other Dividends Status Page")
    .post(s"$dividendsUrl/dividends-from-uk-trusts-or-open-ended-investment-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherDividendsAmountPage: HttpRequestBuilder = http("Get Other Dividends Amount Page")
    .get(s"$dividendsUrl/how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsAmountPage: HttpRequestBuilder = http("Post Other Dividends Amount Page")
    .post(s"$dividendsUrl/how-much-dividends-from-uk-trusts-and-open-ended-investment-companies")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage: HttpRequestBuilder = http("Get Dividends Check Your Answers Page")
    .get(s"$dividendsUrl/check-income-from-dividends")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage: HttpRequestBuilder = http("Post Dividends Check Your Answers Page")
    .post(s"$dividendsUrl/check-income-from-dividends")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
