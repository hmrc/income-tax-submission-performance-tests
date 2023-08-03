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

object AboutYourWorkRequests extends ServicesConfiguration {

  def getAboutYourWork: HttpRequestBuilder = http("Get About Your Work")
    .get(s"${tailorReturnUrl}/work-and-benefits/about-your-work")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAboutYourWork: HttpRequestBuilder = http("Post About Your Work")
    .post(s"${tailorReturnUrl}/work-and-benefits/about-your-work")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Employed")
    .check(status.is(303))

  def getChangeAboutYourWork: HttpRequestBuilder = http("Get Change About Your Work")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-about-your-work")
    .check(status.is(200))

  def postChangeAboutYourWork: HttpRequestBuilder = http("Post Change About Your Work")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-about-your-work")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Partnership")
    .check(status.is(303))

  def getEmploymentLumpSums: HttpRequestBuilder = http("Get Employment Lump Sums")
    .get(s"${tailorReturnUrl}/work-and-benefits/employment-lump-sums")
    .check(status.is(200))

  def postEmploymentLumpSums: HttpRequestBuilder = http("Post Employment Lump Sums")
    .post(s"${tailorReturnUrl}/work-and-benefits/employment-lump-sums")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeEmploymentLumpSums: HttpRequestBuilder = http("Get Change Employment Lump Sums")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-employment-lump-sums")
    .check(status.is(200))

  def postChangeEmploymentLumpSums: HttpRequestBuilder = http("Post Change Employment LumpSums")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-employment-lump-sums")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getShareSchemes: HttpRequestBuilder = http("Get Share Schemes")
    .get(s"${tailorReturnUrl}/work-and-benefits/share-schemes")
    .check(status.is(200))

  def postShareSchemes: HttpRequestBuilder = http("Post Share Schemes")
    .post(s"${tailorReturnUrl}/work-and-benefits/share-schemes")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeShareSchemes: HttpRequestBuilder = http("Get Change Share Schemes")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-share-schemes")
    .check(status.is(200))

  def postChangeShareSchemes: HttpRequestBuilder = http("Post Change Share Schemes")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-share-schemes")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getConstructionIndustryScheme: HttpRequestBuilder = http("Get Construction Industry Scheme")
    .get(s"${tailorReturnUrl}/work-and-benefits/construction-industry-scheme")
    .check(status.is(200))

  def postConstructionIndustryScheme: HttpRequestBuilder = http("Post Construction Industry Scheme")
    .post(s"${tailorReturnUrl}/work-and-benefits/construction-industry-scheme")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeConstructionIndustryScheme: HttpRequestBuilder = http("Get Change Construction Industry Scheme")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-constructionIndustryScheme")
    .check(status.is(200))

  def postChangeConstructionIndustryScheme: HttpRequestBuilder = http("Post Change Construction Industry Scheme")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-constructionIndustryScheme")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getJobseekersAllowanceEmploymentAndSupportAllowance: HttpRequestBuilder = http("Get Jobseekers Allowance Employment And Support Allowance")
    .get(s"${tailorReturnUrl}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .check(status.is(200))

  def postJobseekersAllowanceEmploymentAndSupportAllowance: HttpRequestBuilder = http("Post Jobseekers Allowance Employment And Support Allowance")
    .post(s"${tailorReturnUrl}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "JobseekersAllowance")
    .check(status.is(303))

  def getChangeJobseekersAllowanceEmploymentAndSupportAllowance: HttpRequestBuilder = http("Get Change Jobseekers Allowance Employment And Support Allowance")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-jobseekers-allowance-employment-and-support-allowance")
    .check(status.is(200))

  def postChangeJobseekersAllowanceEmploymentAndSupportAllowance: HttpRequestBuilder = http("Post Change Jobseekers Allowance Employment And Support Allowance")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-jobseekers-allowance-employment-and-support-allowance")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "ContributionBasedEmploymentAndSupportAllowance")
    .check(status.is(303))

  def getTaxableStateBenefits: HttpRequestBuilder = http("Get Taxable State Benefits")
    .get(s"${tailorReturnUrl}/work-and-benefits/taxable-state-benefits")
    .check(status.is(200))

  def postTaxableStateBenefits: HttpRequestBuilder = http("Post Taxable State Benefits")
    .post(s"${tailorReturnUrl}/work-and-benefits/taxable-state-benefits")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeTaxableStateBenefits: HttpRequestBuilder = http("Get Change Taxable State Benefits")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-taxable-state-benefits")
    .check(status.is(200))

  def postChangeTaxableStateBenefits: HttpRequestBuilder = http("Post Change Taxable State Benefits")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-taxable-state-benefits")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getStatutoryBenefits: HttpRequestBuilder = http("Get Statutory Benefits")
    .get(s"${tailorReturnUrl}/work-and-benefits/statutory-benefits")
    .check(status.is(200))

  def postStatutoryBenefits: HttpRequestBuilder = http("Post Statutory Benefits")
    .post(s"${tailorReturnUrl}/work-and-benefits/statutory-benefits")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeStatutoryBenefits: HttpRequestBuilder = http("Get Change Statutory Benefits")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-statutory-benefits")
    .check(status.is(200))

  def postChangeStatutoryBenefits: HttpRequestBuilder = http("Post Change Statutory Benefits")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-statutory-benefits")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getTaxRefunds: HttpRequestBuilder = http("Get Tax Refunds")
    .get(s"${tailorReturnUrl}/work-and-benefits/tax-refunds")
    .check(status.is(200))

  def postTaxRefunds: HttpRequestBuilder = http("Post Tax Refunds")
    .post(s"${tailorReturnUrl}/work-and-benefits/tax-refunds")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeTaxRefunds: HttpRequestBuilder = http("Get Change Tax Refunds")
    .get(s"${tailorReturnUrl}/work-and-benefits/change-tax-refunds")
    .check(status.is(200))

  def postChangeTaxRefunds: HttpRequestBuilder = http("Post Change Tax Refunds")
    .post(s"${tailorReturnUrl}/work-and-benefits/change-tax-refunds")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))
}
