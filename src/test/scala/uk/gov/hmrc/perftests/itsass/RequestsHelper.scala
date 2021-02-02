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
import io.gatling.http.Predef._
import io.gatling.http.check.HttpCheck
import uk.gov.hmrc.performance.conf.ServicesConfiguration

object RequestsHelper extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("income-tax-submission-frontend")
  val personalIncomeBaseUrl: String = baseUrlFor("personal-income-tax-submission-frontend")
  val authLoginUrl: String = baseUrlFor("auth-login")
  val serviceUrl: String = baseUrl + "/income-through-software/return"
  val dividendsUrl: String = personalIncomeBaseUrl + "/income-through-software/return/personal-income/2022/dividends"
  val interestUrl: String = personalIncomeBaseUrl + "/income-through-software/return/personal-income/2022/interest"

  val csrfPattern: String = """name="csrfToken" value="([^"]+)"""
  val untaxedAccountPattern: String = s"""/income-through-software/return/personal-income/2022/interest/untaxed-uk-interest-details/([^"]+)"""
  val taxedAccountPattern: String = s"""/income-through-software/return/personal-income/2022/interest/taxed-uk-interest-details/([^"]+)"""

  def saveUntaxedAccountId: CheckBuilder[HttpCheck, Response, Response, String] = headerRegex(
    "Location", untaxedAccountPattern).saveAs("untaxedAccountId")

  def saveTaxedAccountId: CheckBuilder[HttpCheck, Response, Response, String] = headerRegex(
    "Location", taxedAccountPattern).saveAs("taxedAccountId")

  def saveCsrfToken: CheckBuilder[HttpCheck, Response, CharSequence, String] = regex(_ => csrfPattern).saveAs("csrfToken")

}
