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
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.{saveSessionDataId, stateBenefitsUrl}

object StateBenefitsRequests {

  def getStateBenefitsSummaryPage(taxYear: String): HttpRequestBuilder = http("Get State Benefits Summary Page")
    .get(s"${stateBenefitsUrl(taxYear)}/summary")
    .check(status.is(expected = 200))

  def getJobSeekersAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/claims")
    .check(status.is(expected = 200))

  def postCreateUserSessionData(taxYear: String, benefitType: String): HttpRequestBuilder = http("Create UserSessionData")
    .post(s"${stateBenefitsUrl(taxYear)}/session-data?benefitType=$benefitType")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(saveSessionDataId)
    .check(status.is(303))

  def getJobSeekersAllowanceStartDatePage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Start Date Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/start-date": String)
    .check(status.is(expected = 200))

  def postJobSeekersAllowanceStartDatePage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - Start Date Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/start-date": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value-for-day", "1")
    .formParam("value-for-month", "1")
    .formParam("value-for-year", taxYear)
    .check(status.is(303))

  def getDidClaimEndInTaxYearPage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - DidClaimEndInTaxYear Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/did-claim-end-in-tax-year": String)
    .check(status.is(expected = 200))

  def postDidClaimEndInTaxYearPage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - DidClaimEndInTaxYear Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/did-claim-end-in-tax-year": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getJobSeekersAllowanceEndDatePage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - End Date Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/end-date": String)
    .check(status.is(expected = 200))

  def postJobSeekersAllowanceEndDatePage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - End Date Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/end-date": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value-for-day", "1")
    .formParam("value-for-month", "2")
    .formParam("value-for-year", taxYear)
    .check(status.is(303))

  def getJobSeekersAllowanceAmountPage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Amount Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/amount": String)
    .check(status.is(expected = 200))

  def postJobSeekersAllowanceAmountPage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - Amount Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/amount": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "123")
    .check(status.is(303))

  def getTaxTakenOffPage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Was TaxTakenOff Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/tax-taken-off": String)
    .check(status.is(expected = 200))

  def postTaxTakenOffPage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - Was TaxTakenOff Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/tax-taken-off": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getTaxTakenOffAmountPage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Amount Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/tax-taken-off-amount": String)
    .check(status.is(expected = 200))

  def postTaxTakenOffAmountPage(taxYear: String): HttpRequestBuilder = http("Post Jobseeker's Allowance - Amount Page")
    .post(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/tax-taken-off-amount": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "34")
    .check(status.is(303))

  def getReviewJobSeekersAllowanceClaimPage(taxYear: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Review Claim Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/review-claim": String)
    .check(status.is(expected = 200))

  def postReviewJobSeekersAllowanceClaimSaveAndContinue(taxYear: String): HttpRequestBuilder = http("Post Save and Continue")
    .post(url = s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/review-claim/save": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(expected = 303))

  def getReviewJobSeekersAllowanceClaimPage(taxYear: String, benefitId: String): HttpRequestBuilder = http("Get Jobseeker's Allowance - Review Claim Page: Benefit ID")
    .get(s"${stateBenefitsUrl(taxYear)}/session-data?benefitType=jobSeekersAllowance&benefitId=$benefitId": String)
    .check(saveSessionDataId)
    .check(status.is(expected = 303))

  def postReviewJobSeekersAllowanceClaimRestoreContinue(taxYear: String): HttpRequestBuilder = http("Post Save and Continue")
    .post(url = s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/review-claim/restore": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(expected = 303))

  def getRemoveJobSeekersAllowanceClaimPage(taxYear: String): HttpRequestBuilder = http("Get Remove Jobseeker's Allowance Claim Page")
    .get(s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/remove": String)
    .check(status.is(expected = 200))

  def postRemoveJobSeekersAllowanceClaimPage(taxYear: String): HttpRequestBuilder = http("Post Remove Jobseeker's Allowance Claim Page")
    .post(url = s"${stateBenefitsUrl(taxYear)}/jobseekers-allowance/$${sessionDataId}/remove": String)
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(expected = 303))
}
