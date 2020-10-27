/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._

object DividendsRequests extends ServicesConfiguration {
  val personalIncomeBaseUrl: String = baseUrlFor("personal-income-tax-submission-frontend")
  val personalIncomeServiceUrl: String = personalIncomeBaseUrl + "/income-through-software/return"

  def getUKDividendsStatusPage = http("get UK Dividends Status Page")
    .get(s"$personalIncomeServiceUrl/personal-income/dividends/uk-dividends")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsStatusPage = http("post UK Dividends Status Page")
    .post(s"$personalIncomeServiceUrl/personal-income/dividends/uk-dividends")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yesNoValue", "yes")
    .check(status.is(303))

  def getUKDividendsAmountPage = http("get UK Dividends Amount Page")
    .get(s"$personalIncomeServiceUrl/personal-income/dividends/uk-dividends-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUKDividendsAmountPage = http("post UK Dividends Amount Page")
    .post(s"$personalIncomeServiceUrl/personal-income/dividends/uk-dividends-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOtherDividendsStatusPage = http("get Other Dividends Status Page")
    .get(s"$personalIncomeServiceUrl/personal-income/dividends/other-dividends")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsStatusPage = http("post Other Dividends Status Page")
    .post(s"$personalIncomeServiceUrl/personal-income/dividends/other-dividends")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yesNoValue", "yes")
    .check(status.is(303))

  def getOtherDividendsAmountPage = http("get Other Dividends Amount Page")
    .get(s"$personalIncomeServiceUrl/personal-income/dividends/other-dividends-amount")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postOtherDividendsAmountPage = http("post Other Dividends Amount Page")
    .post(s"$personalIncomeServiceUrl/personal-income/dividends/other-dividends-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage = http("get Dividends Check Your Answers Page")
    .get(s"$personalIncomeServiceUrl/personal-income/dividends/check-your-answers")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage = http("post Dividends Check Your Answers Page")
    .post(s"$personalIncomeServiceUrl/personal-income/dividends/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
