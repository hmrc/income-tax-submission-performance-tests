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

import io.gatling.core.Predef._
import io.gatling.core.check.CheckBuilder
import io.gatling.core.check.regex.RegexCheckType
import io.gatling.http.Predef._
import io.gatling.http.check.header.HttpHeaderRegexCheckType
import uk.gov.hmrc.performance.conf.ServicesConfiguration


object RequestsHelper extends ServicesConfiguration {

  val taxYear: String = "2022"
  val taxYearEOY: String = "2021"

  val baseUrl: String = baseUrlFor("income-tax-submission-frontend")
  val personalIncomeBaseUrl: String = baseUrlFor("personal-income-tax-submission-frontend")
  val employmentFrontendBaseUrl: String = baseUrlFor("income-tax-employment-frontend")
  val viewAndChangeFrontendBaseUrl: String = baseUrlFor("income-tax-view-change-frontend")
  val authLoginUrl: String = baseUrlFor("auth-login")
  val serviceUrl: String = baseUrl + "/income-through-software/return"
  val dividendsUrl: String = personalIncomeBaseUrl + s"/income-through-software/return/personal-income/$taxYear/dividends"
  val interestUrl: String = personalIncomeBaseUrl + s"/income-through-software/return/personal-income/$taxYear/interest"
  val giftAidUrl: String = personalIncomeBaseUrl + s"/income-through-software/return/personal-income/$taxYear/charity"
  val employmentsUrl: String => String =(taxYear:String) => employmentFrontendBaseUrl + s"/income-through-software/return/employment-income/$taxYear"
  val viewAndChangeUrl: String = viewAndChangeFrontendBaseUrl + s"/report-quarterly/income-and-expenses"

  val csrfPattern: String = """<input type="hidden" name="csrfToken" value="([^"]+)"/>"""
  val untaxedAccountPattern: String = s"""/income-through-software/return/personal-income/$taxYear/interest/add-untaxed-uk-interest-account/([^"]+)"""
  val taxedAccountPattern: String = s"""/income-through-software/return/personal-income/$taxYear/interest/add-taxed-uk-interest-account/([^"]+)"""
  val employmentIdPattern: String = s"""employmentId=([^"]+)"""

  def saveUntaxedAccountId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", untaxedAccountPattern).saveAs("untaxedAccountId")

  def saveTaxedAccountId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", taxedAccountPattern).saveAs("taxedAccountId")

  def saveEmploymentId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", employmentIdPattern).saveAs("employmentId")

  def saveCsrfToken(): CheckBuilder[RegexCheckType, String, String] = regex(_ => csrfPattern).saveAs("csrfToken")

}
