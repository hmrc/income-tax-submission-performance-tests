/*
 * Copyright 2024 HM Revenue & Customs
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
    .get(s"${tailorReturnUrl(taxYear)}/start")
    .check(status.is(200))

  def getTailorReturnAddSectionsPage(taxYear: String): HttpRequestBuilder = http("Get Tailor Return Add Sections Page")
    .get(s"${tailorReturnUrl(taxYear)}/add-sections")
    .check(status.is(200))

  def getUkResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Get Uk Residence Status")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUkResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Post Uk Residence Status")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "uk")
    .check(status.is(303))

  def getChangeUkResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Get Change Uk Residence Status")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-uk-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUkResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Post Change Uk Residence Status")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-uk-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonUK")
    .check(status.is(303))

  def getYourResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Get Your Residence Status Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postYourResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Post Your Residence Status Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "nonResident")
    .check(status.is(303))

  def getChangeYourResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Get Change Your Residence Status Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-your-residence-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeYourResidenceStatusPage(taxYear: String) : HttpRequestBuilder = http("Post Change Your Residence Status Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-your-residence-status")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "dualResident")
    .check(status.is(303))

  def getCharitableDonationsPage(taxYear: String) : HttpRequestBuilder = http("Get Charitable Donations Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/charitable-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postCharitableDonationsPage(taxYear: String) : HttpRequestBuilder = http("Post Charitable Donations Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/charitable-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "donationsUsingGiftAid")
    .check(status.is(303))

  def getChangeCharitableDonationsPage(taxYear: String) : HttpRequestBuilder = http("Get Change Charitable Donations Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-charitable-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeCharitableDonationsPage(taxYear: String) : HttpRequestBuilder = http("Post Change Charitable Donations Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-charitable-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "noDonations")
    .check(status.is(303))

  def getFosterCarerPage(taxYear: String) : HttpRequestBuilder = http("Get Foster Carer Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/foster-carer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postFosterCarerPage(taxYear: String) : HttpRequestBuilder = http("Post Foster Carer Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/foster-carer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeFosterCarerPage(taxYear: String) : HttpRequestBuilder = http("Get Change Foster Carer Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-foster-carer")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeFosterCarerPage(taxYear: String) : HttpRequestBuilder = http("Post Change Foster Carer Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-foster-carer")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefitPage(taxYear: String) : HttpRequestBuilder = http("Get Child Benefit Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/child-benefit")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChildBenefitPage(taxYear: String) : HttpRequestBuilder = http("Post Child Benefit Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/child-benefit")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefitPage(taxYear: String) : HttpRequestBuilder = http("Get Change Child Benefit Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-child-benefit")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeChildBenefitPage(taxYear: String) : HttpRequestBuilder = http("Post Change Child Benefit Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-child-benefit")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getChildBenefitIncomePage(taxYear: String) : HttpRequestBuilder = http("Get Child Benefit Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/child-benefit-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChildBenefitIncomePage(taxYear: String) : HttpRequestBuilder = http("Post Child Benefit Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/child-benefit-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeChildBenefitIncomePage(taxYear: String) : HttpRequestBuilder = http("Get Change Child Benefit Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-child-benefit-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeChildBenefitIncomePage(taxYear: String) : HttpRequestBuilder = http("Post Change Child Benefit Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-child-benefit-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getHighIncomeChildBenefitChargePage(taxYear: String) : HttpRequestBuilder = http("Get High Income Child Benefit Charge Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/high-income-child-benefit-charge")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postHighIncomeChildBenefitChargePage(taxYear: String) : HttpRequestBuilder = http("Post High Income Child Benefit Charge Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/high-income-child-benefit-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "selfIncome")
    .check(status.is(303))

  def getChangeHighIncomeChildBenefitChargePage(taxYear: String) : HttpRequestBuilder = http("Get Change High Income Child Benefit Charge Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-high-income-child-benefit-charge")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeHighIncomeChildBenefitChargePage(taxYear: String) : HttpRequestBuilder = http("Post Change High Income Child Benefit Charge Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-high-income-child-benefit-charge")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", "partnerIncome")
    .check(status.is(303))

  def getMarriageAllowancePage(taxYear: String) : HttpRequestBuilder = http("Get Marriage Allowance Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/marriage-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postMarriageAllowancePage(taxYear: String) : HttpRequestBuilder = http("Post Marriage Allowance Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/marriage-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeMarriageAllowancePage(taxYear: String) : HttpRequestBuilder = http("Get Change Marriage Allowance Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-marriage-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeMarriageAllowancePage(taxYear: String) : HttpRequestBuilder = http("Post Change Marriage Allowance Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-marriage-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getPatentRoyaltyPaymentsPage(taxYear: String) : HttpRequestBuilder = http("Get Patent Royalty Payments Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/patent-royalty-payments")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPatentRoyaltyPaymentsPage(taxYear: String) : HttpRequestBuilder = http("Post Patent Royalty Payments Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/patent-royalty-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangePatentRoyaltyPaymentsPage(taxYear: String) : HttpRequestBuilder = http("Get Change Patent Royalty Payments Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-patent-royalty-payments")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangePatentRoyaltyPaymentsPage(taxYear: String) : HttpRequestBuilder = http("Post Change Patent Royalty Payments Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-patent-royalty-payments")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getTaxAvoidanceSchemesPage(taxYear: String) : HttpRequestBuilder = http("Get Tax Avoidance Schemes Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/tax-avoidance-schemes")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postTaxAvoidanceSchemesPage(taxYear: String) : HttpRequestBuilder = http("Post Tax Avoidance Schemes Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/tax-avoidance-schemes")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "taxAvoidance")
    .check(status.is(303))

  def getChangeTaxAvoidanceSchemesPage(taxYear: String) : HttpRequestBuilder = http("Get Change Tax Avoidance Schemes Page")
    .get(s"${tailorReturnUrl(taxYear)}/about-you/change-tax-avoidance-schemes")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeTaxAvoidanceSchemesPage(taxYear: String) : HttpRequestBuilder = http("Post Change Tax Avoidance Schemes Page")
    .post(s"${tailorReturnUrl(taxYear)}/about-you/change-tax-avoidance-schemes")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "noAvoidance")
    .check(status.is(303))

  def getTailorReturnFrontEndPage(taxYear: String) : HttpRequestBuilder = http("Get Tailor Return Frontend Page")
    .get(s"${tailorReturnUrl(taxYear)}")
    .check(status.is(200))

  def getAboutYourWorkPage(taxYear: String): HttpRequestBuilder = http("Get About Your Work Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/about-your-work")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAboutYourWorkPage(taxYear: String): HttpRequestBuilder = http("Post About Your Work Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/about-your-work")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "employed")
    .check(status.is(303))

  def getChangeAboutYourWorkPage(taxYear: String): HttpRequestBuilder = http("Get Change About Your Work Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/change-about-your-work")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeAboutYourWorkPage(taxYear: String): HttpRequestBuilder = http("Post Change About Your Work Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/change-about-your-work")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "selfEmployed")
    .check(status.is(303))

  def getConstructionIndustrySchemePage(taxYear: String): HttpRequestBuilder = http("Get Construction Industry Scheme Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/construction-industry-scheme")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postConstructionIndustrySchemePage(taxYear: String): HttpRequestBuilder = http("Post Construction Industry Scheme Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/construction-industry-scheme")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChangeConstructionIndustrySchemePage(taxYear: String): HttpRequestBuilder = http("Get Change Construction Industry Scheme Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/construction-industry-scheme")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeConstructionIndustrySchemePage(taxYear: String): HttpRequestBuilder = http("Post Change Construction Industry Scheme Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/construction-industry-scheme")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", false)
    .check(status.is(303))

  def getJobseekersAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Jobseekers Allowance Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postJobseekersAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Jobseekers Allowance Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "jsa")
    .check(status.is(303))

  def getChangeJobseekersAllowancePage(taxYear: String): HttpRequestBuilder = http("Get Change Jobseekers Allowance Page")
    .get(s"${tailorReturnUrl(taxYear)}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeJobseekersAllowancePage(taxYear: String): HttpRequestBuilder = http("Post Change Jobseekers Allowance Page")
    .post(s"${tailorReturnUrl(taxYear)}/work-and-benefits/jobseekers-allowance-employment-and-support-allowance")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "none")
    .check(status.is(303))

  def getPaymentsPensionsPage(taxYear: String): HttpRequestBuilder = http("Get Payments Into Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/payments-pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPaymentsPensionsPage(taxYear: String): HttpRequestBuilder = http("Post Payments Into Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/payments-pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "ukPensions")
    .check(status.is(303))

  def getChangePaymentsPensionsPage(taxYear: String): HttpRequestBuilder = http("Get Change Payments Into Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/change-payments-pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangePaymentsPensionsPage(taxYear: String): HttpRequestBuilder = http("Post Change Payments Into Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/change-payments-pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "none")
    .check(status.is(303))

  def getPensionsPage(taxYear: String): HttpRequestBuilder = http("Get Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postPensionsPage(taxYear: String): HttpRequestBuilder = http("Post Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "statePension")
    .check(status.is(303))

  def getChangePensionsPage(taxYear: String): HttpRequestBuilder = http("Get Change Pensions Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-pensions")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangePensionsPage(taxYear: String): HttpRequestBuilder = http("Post Change Pensions Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-pensions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "nonUkPensions")
    .check(status.is(303))

  def getRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Rental Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/rental-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Rental Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "uk")
    .check(status.is(303))

  def getChangeRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Get Change Rental Income Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-rental-income")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeRentalIncomePage(taxYear: String): HttpRequestBuilder = http("Post Change Rental Income Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-rental-income")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "nonUk")
    .check(status.is(303))

  def getUKDividendsSharesLoansPage(taxYear: String): HttpRequestBuilder = http("Get UK Dividends Shares Loans Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-dividends-shares-loans")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsSharesLoansPage(taxYear: String): HttpRequestBuilder = http("Post UK Dividends Shares Loans Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-dividends-shares-loans")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "cashDividendsUkStocksAndShares")
    .check(status.is(303))

  def getChangeUKDividendsSharesLoansPage(taxYear: String): HttpRequestBuilder = http("Get Change UK Dividends Shares Loans Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-dividends-shares-loans")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUKDividendsSharesLoansPage(taxYear: String): HttpRequestBuilder = http("Post Change UK Dividends Shares Loans Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-dividends-shares-loans")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "stockDividendsUkCompanies")
    .check(status.is(303))

  def getUKInsuranceGainsPage(taxYear: String): HttpRequestBuilder = http("Get UK Insurance Gains Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-insurance-gains")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKInsuranceGainsPage(taxYear: String): HttpRequestBuilder = http("Post UK Insurance Gains Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-insurance-gains")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "lifeAnnuity")
    .check(status.is(303))

  def getChangeUKInsuranceGainsPage(taxYear: String): HttpRequestBuilder = http("Get Change UK Insurance Gains Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-insurance-gains")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUKInsuranceGainsPage(taxYear: String): HttpRequestBuilder = http("Post Change UK Insurance Gains Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-insurance-gains")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "lifeInsurance")
    .check(status.is(303))

  def getUKInterestPage(taxYear: String): HttpRequestBuilder = http("Get UK Interest Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKInterestPage(taxYear: String): HttpRequestBuilder = http("Post UK Interest Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "fromUkTrustFunds")
    .check(status.is(303))

  def getChangeUKInterestPage(taxYear: String): HttpRequestBuilder = http("Get Change UK Interest Page")
    .get(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-interest")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postChangeUKInterestPage(taxYear: String): HttpRequestBuilder = http("Post Change UK Interest Page")
    .post(s"${tailorReturnUrl(taxYear)}/property-pensions-investments/change-uk-interest")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value[]", "fromUkBanks")
    .check(status.is(303))
}