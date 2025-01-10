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
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object GiftAidRequests extends ServicesConfiguration {

  def getGiftAidGatewayPage(taxYear: String): HttpRequestBuilder = http("Get Gift Aid Gateway Page")
    .get(s"${giftAidUrl(taxYear)}/charity-donations-to-charity")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidGatewayPage(taxYear: String): HttpRequestBuilder = http("Post Gift Aid Gateway Page")
    .post(s"${giftAidUrl(taxYear)}/charity-donations-to-charity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getGiftAidStatusPage(taxYear: String): HttpRequestBuilder = http("Get Did you Use Gift Aid to Donate to charity? Status Page")
    .get(s"${giftAidUrl(taxYear)}/charity-donation-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidStatusPage(taxYear: String): HttpRequestBuilder = http("Post Did you Use Gift Aid to Donate to charity? Status Page")
    .post(s"${giftAidUrl(taxYear)}/charity-donation-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getGiftAidDetailsPage(taxYear: String): HttpRequestBuilder = http("Get How Much did you donate to charity by using Gift Aid? Details Page")
    .get(s"${giftAidUrl(taxYear)}/amount-donated-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidDetailsPage(taxYear: String): HttpRequestBuilder = http("Post How Much did you donate to charity by using Gift Aid? Details Page")
    .post(s"${giftAidUrl(taxYear)}/amount-donated-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOneOffDonationStatusPage(taxYear: String): HttpRequestBuilder = http("Get Did you make one-off donations? Status Page")
    .get(s"${giftAidUrl(taxYear)}/one-off-charity-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOneOffDonationStatusPage(taxYear: String): HttpRequestBuilder = http("Post Did you make one-off donations? Status Page")
    .post(s"${giftAidUrl(taxYear)}/one-off-charity-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOneOffDonationDetailsPage(taxYear: String): HttpRequestBuilder = http("Get How much did you donate to charity as one-off payments? Details Page")
    .get(s"${giftAidUrl(taxYear)}/amount-donated-as-one-off")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOneOffDonationDetailsPage(taxYear: String): HttpRequestBuilder = http("Post How much did you donate to charity as one-off payments? Details Page")
    .post(s"${giftAidUrl(taxYear)}/amount-donated-as-one-off")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOverseasCharityDonationStatusPage(taxYear: String): HttpRequestBuilder = http("Get Did you use Gift Aid to donate to an overseas charity? Status Page")
    .get(s"${giftAidUrl(taxYear)}/overseas-charity-donations-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharityDonationStatusPage(taxYear: String): HttpRequestBuilder = http("Post Did you use Gift Aid to donate to an overseas charity? Status Page")
    .post(s"${giftAidUrl(taxYear)}/overseas-charity-donations-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOverseasCharityDonationDetailsPage(taxYear: String): HttpRequestBuilder = http("Get How much did you donate to overseas charities by using Gift Aid? Details Page")
    .get(s"${giftAidUrl(taxYear)}/amount-donated-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharityDonationDetailsPage(taxYear: String): HttpRequestBuilder = http("Post How much did you donate to overseas charities by using Gift Aid? Details Page")
    .post(s"${giftAidUrl(taxYear)}/amount-donated-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getNameOfOverseasCharityDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Name of overseas charity you used Gift AId to donate to Details Page")
    .get(s"${giftAidUrl(taxYear)}/name-of-overseas-charity")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postNameOfOverseasCharityDetailsPage(charityName: String): HttpRequestBuilder = http("Post Name of overseas charity you used Gift Aid to donate to Details Page")
    .post(s"${giftAidUrl(taxYear)}/name-of-overseas-charity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", charityName)
    .check(status.is(303))

  def getOverseasCharitiesDonatedToSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Overseas charities you used Gift Aid to donate to Summary Page")
    .get(s"${giftAidUrl(taxYear)}/overseas-charities-donated-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity: Boolean): HttpRequestBuilder = http("Post Overseas charities you used Gift Aid to donate to Summary Page")
    .post(s"${giftAidUrl(taxYear)}/overseas-charities-donated-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherCharity)
    .check(status.is(303))

  def getAddDonationsToLastTaxYearStatusPage(taxYear: String): HttpRequestBuilder = http("Get Do you want to add any of your donations to the last tax year? Status Page")
    .get(s"${giftAidUrl(taxYear)}/add-charity-donations-to-last-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsToLastTaxYearStatusPage(taxYear: String): HttpRequestBuilder = http("Post Do you want to add any of your donations to the last tax year? Status Page")
    .post(s"${giftAidUrl(taxYear)}/add-charity-donations-to-last-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAddDonationsToLastTaxYearDetailsPage(taxYear: String): HttpRequestBuilder = http("Get How much of your donation do you want to add to the last tax year? Details Page")
    .get(s"${giftAidUrl(taxYear)}/amount-added-to-last-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsToLastTaxYearDetailsPage(taxYear: String): HttpRequestBuilder = http("Post How much of your donation do you want to add to the last tax year? Details Page")
    .post(s"${giftAidUrl(taxYear)}/amount-added-to-last-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getAddDonationsCurrentTaxYearStatusPage(taxYear: String): HttpRequestBuilder = http(s"Get Do you want to add any donations made after 5 April $taxYear to this tax year? Status Page")
    .get(s"${giftAidUrl(taxYear)}/donations-after-5-april-$taxYear")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsCurrentTaxYearStatusPage(taxYear: String): HttpRequestBuilder = http(s"Post Do you want to add any donations made after 5 April $taxYear to this tax year? Status Page")
    .post(s"${giftAidUrl(taxYear)}/donations-after-5-april-$taxYear")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAddDonationsCurrentTaxYearDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Get How much of the donations you made after 5 April $taxYear do you want to add to this tax year? Details Page")
    .get(s"${giftAidUrl(taxYear)}/amount-after-5-april-$taxYear-added-to-this-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsCurrentTaxYearDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Post How much of the donations you made after 5 April $taxYear do you want to add to this tax year? Details Page")
    .post(s"${giftAidUrl(taxYear)}/amount-after-5-april-$taxYear-added-to-this-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfSharesOrSecuritiesStatusPage(taxYear: String): HttpRequestBuilder = http(s"Get Did you donate qualifying shares or securities to charity? Status Page")
    .get(s"${giftAidUrl(taxYear)}/donation-of-shares-or-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfSharesOrSecuritiesStatusPage(taxYear: String): HttpRequestBuilder = http(s"Post Did you donate qualifying shares or securities to charity? Status Page")
    .post(s"${giftAidUrl(taxYear)}/donation-of-shares-or-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfSharesOrSecuritiesDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Get What is the total value of shares or securities donated to charity? Details Page")
    .get(s"${giftAidUrl(taxYear)}/value-of-shares-or-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfSharesOrSecuritiesDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Post What is the total value of shares or securities donated to charity? Details Page")
    .post(s"${giftAidUrl(taxYear)}/value-of-shares-or-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfLandOrPropertyStatusPage(taxYear: String): HttpRequestBuilder = http(s"Get Did you donate land or property to charity? Status Page")
    .get(s"${giftAidUrl(taxYear)}/donation-of-land-or-property")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfLandOrPropertyStatusPage(taxYear: String): HttpRequestBuilder = http(s"Post Did you donate land or property to charity? Status Page")
    .post(s"${giftAidUrl(taxYear)}/donation-of-land-or-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfLandOrPropertyDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Get What is the value of land or property donated to charity? Details Page")
    .get(s"${giftAidUrl(taxYear)}/value-of-land-or-property")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfLandOrPropertyDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Post What is the value of land or property donated to charity? Details Page")
    .post(s"${giftAidUrl(taxYear)}/value-of-land-or-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear: String): HttpRequestBuilder = http(s"Get Did you donate shares, securities, land or property to overseas charities? Status Page")
    .get(s"${giftAidUrl(taxYear)}/donation-of-shares-securities-land-or-property-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear: String): HttpRequestBuilder = http(s"Post Did you donate shares, securities, land or property to overseas charities? Status Page")
    .post(s"${giftAidUrl(taxYear)}/donation-of-shares-securities-land-or-property-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Get What is the value of shares, securities, land or property donated to overseas charities? Details Page")
    .get(s"${giftAidUrl(taxYear)}/value-of-shares-securities-land-or-property-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear: String): HttpRequestBuilder = http(s"Post What is the value of shares, securities, land or property donated to overseas charities? Details Page")
    .post(s"${giftAidUrl(taxYear)}/value-of-shares-securities-land-or-property-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear: String): HttpRequestBuilder = http("Get Name of overseas charity you donated shares, securities, land or property to Details Page")
    .get(s"${giftAidUrl(taxYear)}/name-of-overseas-charities-donated-shares-securities-land-or-property-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName: String): HttpRequestBuilder = http("Post Name of overseas charity you donated shares, securities, land or property to Details Page")
    .post(s"${giftAidUrl(taxYear)}/name-of-overseas-charities-donated-shares-securities-land-or-property-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", charityName)
    .check(status.is(303))

  def getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear: String): HttpRequestBuilder = http("Get Overseas charities you donated shares, securities, land or property to Summary Page")
    .get(s"${giftAidUrl(taxYear)}/overseas-charities-donated-shares-securities-land-or-property-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity: Boolean): HttpRequestBuilder = http("Post Overseas charities you donated shares, securities, land or property to Summary Page")
    .post(s"${giftAidUrl(taxYear)}/overseas-charities-donated-shares-securities-land-or-property-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherCharity)
    .check(status.is(303))

  def getGiftAidCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Get Gift Aid Check Your Answers Page")
    .get(s"${giftAidUrl(taxYear)}/check-donations-to-charity")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidCheckYourAnswersPage(taxYear: String): HttpRequestBuilder = http("Post Gift Aid Check Your Answers Page")
    .post(s"${giftAidUrl(taxYear)}/check-donations-to-charity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

  def getGiftAidHaveYouCompletedSectionPage(taxYear: String): HttpRequestBuilder = http("Get Gift Aid Have You Completed Section Page")
    .get(s"${giftAidUrl(taxYear)}/section-completed")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidHaveYouCompletedSectionPage(taxYear: String): HttpRequestBuilder = http("Post Gift Aid Have You Completed Section Page")
    .post(s"${giftAidUrl(taxYear)}/section-completed")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
