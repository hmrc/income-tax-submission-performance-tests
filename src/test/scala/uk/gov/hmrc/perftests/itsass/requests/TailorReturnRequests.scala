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

object TailorReturnRequests extends ServicesConfiguration {

  def getTailorReturnStartPage(taxYear: String): HttpRequestBuilder = http("Get Tailor Return Start Page")
    .get(s"${tailorReturnUrl}/${taxYear}/start")
    .check(status.is(200))

  def getTailorReturnAddSectionsPage(taxYear: String): HttpRequestBuilder = http("Get Tailor Return Add Sections Page")
    .get(s"${tailorReturnUrl}/${taxYear}/add-sections")
    .check(status.is(200))

  def getUkResidenceStatusPage: HttpRequestBuilder = http("Get Uk Residence Status")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUkResidenceStatusPage: HttpRequestBuilder = http("Post Uk Residence Status")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "uk")
    .check(status.is(303))

  def getChangeUkResidenceStatusPage: HttpRequestBuilder = http("Get Change Uk Residence Status")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUkResidenceStatusPage: HttpRequestBuilder = http("Post Change Uk Residence Status")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonUK")
    .check(status.is(303))

  def getYourResidenceStatusPage: HttpRequestBuilder = http("Get Your Residence Status Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postYourResidenceStatusPage: HttpRequestBuilder = http("Post Your Residence Status Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonResident")
    .check(status.is(303))

  def getChangeYourResidenceStatusPage: HttpRequestBuilder = http("Get Change Your Residence Status Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeYourResidenceStatusPage: HttpRequestBuilder = http("Post Change Your Residence Status Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "dualResident")
    .check(status.is(303))

  def getCharitableDonationsPage: HttpRequestBuilder = http("Get Charitable Donations Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/charitable-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCharitableDonationsPage: HttpRequestBuilder = http("Post Charitable Donations Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/charitable-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "donationsUsingGiftAid")
    .check(status.is(303))

  def getChangeCharitableDonationsPage: HttpRequestBuilder = http("Get Change Charitable Donations Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-charitable-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeCharitableDonationsPage: HttpRequestBuilder = http("Post Change Charitable Donations Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-charitable-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "noDonations")
    .check(status.is(303))

  def getFosterCarerPage: HttpRequestBuilder = http("Get Foster Carer Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/foster-carer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postFosterCarerPage: HttpRequestBuilder = http("Post Foster Carer Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/foster-carer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeFosterCarerPage: HttpRequestBuilder = http("Get Change Foster Carer Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-foster-carer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeFosterCarerPage: HttpRequestBuilder = http("Post Change Foster Carer Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-foster-carer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefitPage: HttpRequestBuilder = http("Get Child Benefit Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/child-benefit")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChildBenefitPage: HttpRequestBuilder = http("Post Child Benefit Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/child-benefit")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefitPage: HttpRequestBuilder = http("Get Change Child Benefit Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-child-benefit")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeChildBenefitPage: HttpRequestBuilder = http("Post Change Child Benefit Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-child-benefit")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefitIncomePage: HttpRequestBuilder = http("Get Child Benefit Income Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/child-benefit-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChildBenefitIncomePage: HttpRequestBuilder = http("Post Child Benefit Income Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/child-benefit-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefitIncomePage: HttpRequestBuilder = http("Get Change Child Benefit Income Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-child-benefit-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeChildBenefitIncomePage: HttpRequestBuilder = http("Post Change Child Benefit Income Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-child-benefit-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getHighIncomeChildBenefitChargePage: HttpRequestBuilder = http("Get High Income Child Benefit Charge Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/high-income-child-benefit-charge")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postHighIncomeChildBenefitChargePage: HttpRequestBuilder = http("Post High Income Child Benefit Charge Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/high-income-child-benefit-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "selfIncome")
    .check(status.is(303))

  def getChangeHighIncomeChildBenefitChargePage: HttpRequestBuilder = http("Get Change High Income Child Benefit Charge Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-high-income-child-benefit-charge")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeHighIncomeChildBenefitChargePage: HttpRequestBuilder = http("Post Change High Income Child Benefit Charge Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-high-income-child-benefit-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "partnerIncome")
    .check(status.is(303))

  def getMarriageAllowancePage: HttpRequestBuilder = http("Get Marriage Allowance Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/marriage-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postMarriageAllowancePage: HttpRequestBuilder = http("Post Marriage Allowance Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/marriage-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeMarriageAllowancePage: HttpRequestBuilder = http("Get Change Marriage Allowance Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-marriage-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeMarriageAllowancePage: HttpRequestBuilder = http("Post Change Marriage Allowance Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-marriage-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getPatentRoyaltyPaymentsPage: HttpRequestBuilder = http("Get Patent Royalty Payments Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/patent-royalty-payments")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPatentRoyaltyPaymentsPage: HttpRequestBuilder = http("Post Patent Royalty Payments Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/patent-royalty-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangePatentRoyaltyPaymentsPage: HttpRequestBuilder = http("Get Change Patent Royalty Payments Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-patent-royalty-payments")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangePatentRoyaltyPaymentsPage: HttpRequestBuilder = http("Post Change Patent Royalty Payments Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-patent-royalty-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getTaxAvoidanceSchemesPage: HttpRequestBuilder = http("Get Tax Avoidance Schemes Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/tax-avoidance-schemes")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxAvoidanceSchemesPage: HttpRequestBuilder = http("Post Tax Avoidance Schemes Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/tax-avoidance-schemes")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "taxAvoidance")
    .check(status.is(303))

  def getChangeTaxAvoidanceSchemesPage: HttpRequestBuilder = http("Get Change Tax Avoidance Schemes Page")
    .get(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-tax-avoidance-schemes")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeTaxAvoidanceSchemesPage: HttpRequestBuilder = http("Post Change Tax Avoidance Schemes Page")
    .post(s"${tailorReturnUrl}/${taxYearEOY}/about-you/change-tax-avoidance-schemes")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "noAvoidance")
    .check(status.is(303))

  def getTailorReturnFrontEndPage: HttpRequestBuilder = http("Get Tailor Return Frontend Page")
    .get(s"${tailorReturnUrl}/${taxYear}")
    .check(status.is(200))
}