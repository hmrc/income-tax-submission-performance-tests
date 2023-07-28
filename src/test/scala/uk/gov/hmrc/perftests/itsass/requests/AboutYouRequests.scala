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

object AboutYouRequests extends ServicesConfiguration {

  def getUkResidenceStatus: HttpRequestBuilder = http("Get Uk Residence Status")
    .get(s"${tailorReturnUrl}/about-you/uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUkResidenceStatus: HttpRequestBuilder = http("Post Uk Residence Status")
    .post(s"${tailorReturnUrl}/about-you/uk-residence-status")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Yes")
    .check(status.is(303))

  def getChangeUkResidenceStatus: HttpRequestBuilder = http("Get Change Uk Residence Status")
    .get(s"${tailorReturnUrl}/about-you/change-uk-residence-status")
    .check(status.is(200))

  def postChangeUkResidenceStatus: HttpRequestBuilder = http("Post Change Uk Residence Status")
    .post(s"${tailorReturnUrl}/about-you/change-uk-residence-status")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Yes")
    .check(status.is(303))

  def getYourResidenceStatus: HttpRequestBuilder = http("Get Your Residence Status")
    .get(s"${tailorReturnUrl}/about-you/your-residence-status")
    .check(status.is(200))

  def postYourResidenceStatus: HttpRequestBuilder = http("Post Your Residence Status")
    .post(s"${tailorReturnUrl}/about-you/your-residence-status")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "Was")
    .check(status.is(303))

  def getChangeYourResidenceStatus: HttpRequestBuilder = http("Get Change Your Residence Status")
    .get(s"${tailorReturnUrl}/about-you/change-your-residence-status")
    .check(status.is(200))

  def postChangeYourResidenceStatus: HttpRequestBuilder = http("Post Change Your Residence Status")
    .post(s"${tailorReturnUrl}/about-you/change-your-residence-status")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "WasNot")
    .check(status.is(303))

  def getCharitableDonations: HttpRequestBuilder = http("Get Charitable Donations")
    .get(s"${tailorReturnUrl}/about-you/charitable-donations")
    .check(status.is(200))

  def postCharitableDonations: HttpRequestBuilder = http("Post Charitable Donations")
    .post(s"${tailorReturnUrl}/about-you/charitable-donations")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value[0]", "DonationsUsingGiftAid")
    .check(status.is(303))

  def getChangeCharitableDonations: HttpRequestBuilder = http("Get Change Charitable Donations")
    .get(s"${tailorReturnUrl}/about-you/change-charitable-donations")
    .check(status.is(200))

  def postChangeCharitableDonations: HttpRequestBuilder = http("Post Change Charitable Donations")
    .post(s"${tailorReturnUrl}/about-you/change-charitable-donations")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value[1]", "GiftsOfSharesOrSecurities")
    .check(status.is(303))

  def getMarriageAllowance: HttpRequestBuilder = http("Get Marriage Allowance")
    .get(s"${tailorReturnUrl}/about-you/marriage-allowance")
    .check(status.is(200))

  def postMarriageAllowance: HttpRequestBuilder = http("Post Marriage Allowance")
    .post(s"${tailorReturnUrl}/about-you/marriage-allowance")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeMarriageAllowance: HttpRequestBuilder = http("Get Change Marriage Allowance")
    .get(s"${tailorReturnUrl}/about-you/change-marriage-allowance")
    .check(status.is(200))

  def postChangeMarriageAllowance: HttpRequestBuilder = http("Post Change Marriage Allowance")
    .post(s"${tailorReturnUrl}/about-you/change-marriage-allowance")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefit: HttpRequestBuilder = http("Get Child Benefit")
    .get(s"${tailorReturnUrl}/about-you/child-benefit")
    .check(status.is(200))

  def postChildBenefit: HttpRequestBuilder = http("Post Child Benefit")
    .post(s"${tailorReturnUrl}/about-you/child-benefit")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefit: HttpRequestBuilder = http("Get Change Child Benefit")
    .get(s"${tailorReturnUrl}/about-you/change-child-benefit")
    .check(status.is(200))

  def postChangeChildBenefit: HttpRequestBuilder = http("Post Change Child Benefit")
    .post(s"${tailorReturnUrl}/about-you/change-child-benefit")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefitHighIncomeCharge: HttpRequestBuilder = http("Get Child Benefit High Income Charge")
    .get(s"${tailorReturnUrl}/about-you/child-benefit-high-income-charge")
    .check(status.is(200))

  def postChildBenefitHighIncomeCharge: HttpRequestBuilder = http("Post Child Benefit High Income Charge")
    .post(s"${tailorReturnUrl}/about-you/child-benefit-high-income-charge")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "MyIncome")
    .check(status.is(303))

  def getChangeChildBenefitHighIncomeCharge: HttpRequestBuilder = http("Get Change Child Benefit High Income Charge")
    .get(s"${tailorReturnUrl}/about-you/change-child-benefit-high-income-charge")
    .check(status.is(200))

  def postChangeChildBenefitHighIncomeCharge: HttpRequestBuilder = http("Post Change Child Benefit High Income Charge")
    .post(s"${tailorReturnUrl}/about-you/change-child-benefit-high-income-charge")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", "NoPartner")
    .check(status.is(303))

  def getChildBenefitOver50k: HttpRequestBuilder = http("Get Child Benefit Over 50k")
    .get(s"${tailorReturnUrl}/about-you/child-benefit-over-50k")
    .check(status.is(200))

  def postChildBenefitOver50k: HttpRequestBuilder = http("Post Child Benefit Over 50k")
    .post(s"${tailorReturnUrl}/about-you/child-benefit-over-50k")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefitOver50k: HttpRequestBuilder = http("Get Change Child Benefit Over 50k")
    .get(s"${tailorReturnUrl}/about-you/change-child-benefit-over-50k")
    .check(status.is(200))

  def postChangeChildBenefitOver50k: HttpRequestBuilder = http("Post Change Child Benefit Over 50k")
    .post(s"${tailorReturnUrl}/about-you/change-child-benefit-over-50k")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getDonateToCharity: HttpRequestBuilder = http("Get Donate To Charity")
    .get(s"${tailorReturnUrl}/about-you/donate-to-charity")
    .check(status.is(200))

  def postDonateToCharity: HttpRequestBuilder = http("Post Donate To Charity")
    .post(s"${tailorReturnUrl}/about-you/donate-to-charity")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value[0]", "DonationsUsingGiftAid")
    .check(status.is(303))

  def getChangeDonateToCharity: HttpRequestBuilder = http("Get Change Donate To Charity")
    .get(s"${tailorReturnUrl}/about-you/change-donate-to-charity")
    .check(status.is(200))

  def postChangeDonateToCharity: HttpRequestBuilder = http("Post Change Donate To Charity")
    .post(s"${tailorReturnUrl}/about-you/change-donate-to-charity")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value[4]", "DidNotDonateToCharity")
    .check(status.is(303))

  def getFosterCarer: HttpRequestBuilder = http("Get Foster Carer")
    .get(s"${tailorReturnUrl}/about-you/foster-carer")
    .check(status.is(200))

  def postFosterCarer: HttpRequestBuilder = http("Post Foster Carer")
    .post(s"${tailorReturnUrl}/about-you/foster-carer")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeFosterCarer: HttpRequestBuilder = http("Get Change Foster Carer")
    .get(s"${tailorReturnUrl}/about-you/change-foster-carer")
    .check(status.is(200))

  def postChangeFosterCarer: HttpRequestBuilder = http("Post Change Foster Carer")
    .post(s"${tailorReturnUrl}/about-you/change-foster-carer")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", false)
    .check(status.is(303))

  def getPatentRoyaltyPayments: HttpRequestBuilder = http("Get Patent Royalty Payments")
    .get(s"${tailorReturnUrl}/about-you/patent-royalty-payments")
    .check(status.is(200))

  def postPatentRoyaltyPayments: HttpRequestBuilder = http("Post Patent Royalty Payments")
    .post(s"${tailorReturnUrl}/about-you/patent-royalty-payments")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))

  def getChangePatentRoyaltyPayments: HttpRequestBuilder = http("Get Change Patent Royalty Payments")
    .get(s"${tailorReturnUrl}/about-you/change-patent-royalty-payments")
    .check(status.is(200))

  def postChangePatentRoyaltyPayments: HttpRequestBuilder = http("Post Change Patent Royalty Payments")
    .post(s"${tailorReturnUrl}/about-you/change-patent-royalty-payments")
    .formParam("csrfToken", "${csrfToken}")
    .formParam("value", true)
    .check(status.is(303))
}
