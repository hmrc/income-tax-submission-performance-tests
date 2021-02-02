/*
 * Copyright 2021 HM Revenue & Customs
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

import io.gatling.http.Predef._
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests.{personalIncomeBaseUrl, saveCsrfToken}

object InterestRequests extends ServicesConfiguration {
  val interestUrl: String = personalIncomeBaseUrl + "/income-through-software/return/personal-income/2022/interest"
  val untaxedAccountPattern = s"""/income-through-software/return/personal-income/2022/interest/untaxed-uk-interest-details/([^"]+)"""
  val taxedAccountPattern = s"""/income-through-software/return/personal-income/2022/interest/taxed-uk-interest-details/([^"]+)"""

  private def saveUntaxedAccountId() = headerRegex(
    "Location", untaxedAccountPattern).saveAs("untaxedAccountId")

  private def saveTaxedAccountId() = headerRegex(
    "Location", taxedAccountPattern).saveAs("taxedAccountId")

  def getUntaxedUKInterestStatusPage = http("Get Untaxed UK Interest Status Page")
    .get(s"$interestUrl/untaxed-uk-interest")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestStatusPage = http("Post Untaxed UK Interest Status Page")
    .post(s"$interestUrl/untaxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yes_no", "yes")
    .check(saveUntaxedAccountId())
    .check(status.is(303))

  def getUntaxedUKInterestDetailsPage = http("Get Untaxed UK Interest Details Page")
    .get(s"$interestUrl/untaxed-uk-interest-details/$${untaxedAccountId}": String)
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestDetailsPage = http("Post Untaxed UK Interest Details Page")
    .post(s"$interestUrl/untaxed-uk-interest-details/$${untaxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("untaxedAccountName", "Tesco")
    .formParam("untaxedAmount", "1000")
    .check(status.is(303))

  def getUntaxedUKInterestSummaryPage = http("Get Untaxed UK Interest Summary Page")
    .get(s"$interestUrl/untaxed-uk-interest-account-summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postUntaxedUKInterestSummaryPage = http("Post Untaxed UK Interest Summary Page")
    .post(s"$interestUrl/untaxed-uk-interest-account-summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getTaxedUKInterestStatusPage = http("Get Taxed UK Interest Status Page")
    .get(s"$interestUrl/taxed-uk-interest")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestStatusPage = http("Post Taxed UK Interest Status Page")
    .post(s"$interestUrl/taxed-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("yes_no", "yes")
    .check(saveTaxedAccountId())
    .check(status.is(303))

  def getTaxedUKInterestDetailsPage = http("Get Taxed UK Interest Details Page")
    .get(s"$interestUrl/taxed-uk-interest-details/$${taxedAccountId}": String)
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestDetailsPage = http("Post Taxed UK Interest Details Page")
    .post(s"$interestUrl/taxed-uk-interest-details/$${taxedAccountId}": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("taxedAccountName", "Tesco")
    .formParam("taxedAmount", "1000")
    .check(status.is(303))

  def getTaxedUKInterestSummaryPage = http("Get Taxed UK Interest Summary Page")
    .get(s"$interestUrl/taxed-uk-interest-account-summary")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postTaxedUKInterestSummaryPage = http("Post Taxed UK Interest Summary Page")
    .post(s"$interestUrl/taxed-uk-interest-account-summary")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getInterestCheckYourAnswersPage = http("Get Interest Check Your Answers Page")
    .get(s"$interestUrl/check-your-answers")
    .check(saveCsrfToken)
    .check(status.is(200))

  def postInterestCheckYourAnswersPage = http("Post Interest Check Your Answers Page")
    .post(s"$interestUrl/check-your-answers")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
