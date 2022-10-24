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
import io.gatling.core.check.CheckBuilder
import io.gatling.core.check.regex.RegexCheckType
import io.gatling.http.Predef.{Response, headerRegex}
import io.gatling.http.check.header.HttpHeaderRegexCheckType
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.utils.TaxYearHelper

object RequestsHelper extends ServicesConfiguration with TaxYearHelper {

  val employmentIdWithNoBenefits: String = "f82f7d1d-61e2-45a0-8a1e-c515b7da81eb"
  val employmentIdWithNoStudentLoans: String = "3c891e58-9b21-4296-8ecd-76f771c5d079"

  val baseUrl: String = baseUrlFor("income-tax-submission-frontend")
  val personalIncomeBaseUrl: String = baseUrlFor("personal-income-tax-submission-frontend")
  val employmentFrontendBaseUrl: String = baseUrlFor("income-tax-employment-frontend")
  val viewAndChangeFrontendBaseUrl: String = baseUrlFor("income-tax-view-change-frontend")
  val nrsProxyBaseUrl: String = baseUrlFor("income-tax-nrs-proxy")
  val authLoginUrl: String = baseUrlFor("auth-login-stub")
  val cisBaseUrl: String = baseUrlFor("income-tax-cis-frontend")
  val stateBenefitsBaseUrl: String = baseUrlFor("income-tax-state-benefits-frontend")
  val pensionsFrontendBaseUrl: String = baseUrlFor("income-tax-pensions-frontend")
  val serviceUrl: String = baseUrl + "/update-and-submit-income-tax-return"
  val dividendsUrl: String = personalIncomeBaseUrl + s"/update-and-submit-income-tax-return/personal-income/$taxYear/dividends"
  val interestUrl: String = personalIncomeBaseUrl + s"/update-and-submit-income-tax-return/personal-income/$taxYear/interest"
  val giftAidUrl: String = personalIncomeBaseUrl + s"/update-and-submit-income-tax-return/personal-income/$taxYear/charity"
  val employmentsUrl: String => String = (taxYear: String) => employmentFrontendBaseUrl + s"/update-and-submit-income-tax-return/employment-income/$taxYear"
  val viewAndChangeUrl: String = viewAndChangeFrontendBaseUrl + s"/report-quarterly/income-and-expenses"
  val cisUrl: String => String = (taxYear: String) => cisBaseUrl + s"/update-and-submit-income-tax-return/construction-industry-scheme-deductions/$taxYear"
  val stateBenefitsUrl: String => String = (taxYear: String) => stateBenefitsBaseUrl + s"/update-and-submit-income-tax-return/state-benefits/$taxYear"
  val pensionsUrl: String => String = (taxYear: String) => pensionsFrontendBaseUrl + s"/update-and-submit-income-tax-return/pensions/$taxYear"

  val csrfPattern: String = """<input type="hidden" name="csrfToken" value="([^"]+)"/>"""
  val untaxedAccountPattern: String = s"""/update-and-submit-income-tax-return/personal-income/$taxYear/interest/add-untaxed-uk-interest-account/([^"]+)"""
  val taxedAccountPattern: String = s"""/update-and-submit-income-tax-return/personal-income/$taxYear/interest/add-taxed-uk-interest-account/([^"]+)"""
  val employmentIdPattern: String = s"""employmentId=([^"]+)"""
  val sessionDataIdPattern: String = s"""/jobseekers-allowance/([^"]+)/start-date"""

  def saveUntaxedAccountId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", untaxedAccountPattern).saveAs("untaxedAccountId")

  def saveTaxedAccountId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", taxedAccountPattern).saveAs("taxedAccountId")

  def saveEmploymentId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", employmentIdPattern).saveAs("employmentId")

  def saveSessionDataId: CheckBuilder[HttpHeaderRegexCheckType, Response, String] = headerRegex(
    "Location", sessionDataIdPattern).saveAs("sessionDataId")

  def saveCsrfToken(): CheckBuilder[RegexCheckType, String, String] = regex(_ => csrfPattern).saveAs("csrfToken")
}
