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

package uk.gov.hmrc.perftests.itsass

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.RequestsHelper._

object GiftAidRequests extends ServicesConfiguration {

  def getGiftAidStatusPage: HttpRequestBuilder = http("Get Did you Use Gift Aid to Donate to charity? Status Page")
    .get(s"$giftAidUrl/charity-donation-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidStatusPage: HttpRequestBuilder = http("Post Did you Use Gift Aid to Donate to charity? Status Page")
    .post(s"$giftAidUrl/charity-donation-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getGiftAidDetailsPage: HttpRequestBuilder = http("Get How Much did you donate to charity by using Gift Aid? Details Page")
    .get(s"$giftAidUrl/amount-donated-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidDetailsPage: HttpRequestBuilder = http("Post How Much did you donate to charity by using Gift Aid? Details Page")
    .post(s"$giftAidUrl/amount-donated-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOneOffDonationStatusPage: HttpRequestBuilder = http("Get Did you make one-off donations? Status Page")
    .get(s"$giftAidUrl/one-off-charity-donations")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOneOffDonationStatusPage: HttpRequestBuilder = http("Post Did you make one-off donations? Status Page")
    .post(s"$giftAidUrl/one-off-charity-donations")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOneOffDonationDetailsPage: HttpRequestBuilder = http("Get How much did you donate to charity as one-off payments? Details Page")
    .get(s"$giftAidUrl/amount-donated-as-one-off")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOneOffDonationDetailsPage: HttpRequestBuilder = http("Post How much did you donate to charity as one-off payments? Details Page")
    .post(s"$giftAidUrl/amount-donated-as-one-off")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getOverseasCharityDonationStatusPage: HttpRequestBuilder = http("Get Did you use Gift Aid to donate to an overseas charity? Status Page")
    .get(s"$giftAidUrl/overseas-charity-donations-using-gift-aid")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharityDonationStatusPage: HttpRequestBuilder = http("Post Did you use Gift Aid to donate to an overseas charity? Status Page")
    .post(s"$giftAidUrl/overseas-charity-donations-using-gift-aid")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOverseasCharityDonationDetailsPage: HttpRequestBuilder = http("Get How much did you donate to overseas charities by using Gift Aid? Details Page")
    .get(s"$giftAidUrl/amount-donated-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharityDonationDetailsPage: HttpRequestBuilder = http("Post How much did you donate to overseas charities by using Gift Aid? Details Page")
    .post(s"$giftAidUrl/amount-donated-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getNameOfOverseasCharityDetailsPage: HttpRequestBuilder = http("Get Name of overseas charity you used Gift AId to donate to Details Page")
    .get(s"$giftAidUrl/name-of-overseas-charity")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postNameOfOverseasCharityDetailsPage(charityName: String): HttpRequestBuilder = http("Post Name of overseas charity you used Gift Aid to donate to Details Page")
    .post(s"$giftAidUrl/name-of-overseas-charity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", charityName)
    .check(status.is(303))

  def getOverseasCharitiesDonatedToSummaryPage: HttpRequestBuilder = http("Get Overseas charities you used Gift Aid to donate to Summary Page")
    .get(s"$giftAidUrl/overseas-charities-donated-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity: Boolean): HttpRequestBuilder = http("Post Overseas charities you used Gift Aid to donate to Summary Page")
    .post(s"$giftAidUrl/overseas-charities-donated-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherCharity)
    .check(status.is(303))

  def getAddDonationsToLastTaxYearStatusPage: HttpRequestBuilder = http("Get Do you want to add any of your donations to the last tax year? Status Page")
    .get(s"$giftAidUrl/add-charity-donations-to-last-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsToLastTaxYearStatusPage: HttpRequestBuilder = http("Post Do you want to add any of your donations to the last tax year? Status Page")
    .post(s"$giftAidUrl/add-charity-donations-to-last-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAddDonationsToLastTaxYearDetailsPage: HttpRequestBuilder = http("Get How much of your donation do you want to add to the last tax year? Details Page")
    .get(s"$giftAidUrl/amount-added-to-last-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsToLastTaxYearDetailsPage: HttpRequestBuilder = http("Post How much of your donation do you want to add to the last tax year? Details Page")
    .post(s"$giftAidUrl/amount-added-to-last-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getAddDonationsCurrentTaxYearStatusPage: HttpRequestBuilder = http(s"Get Do you want to add any donations made after 5 April $taxYear to this tax year? Status Page")
    .get(s"$giftAidUrl/donations-after-5-april-$taxYear")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsCurrentTaxYearStatusPage: HttpRequestBuilder = http(s"Post Do you want to add any donations made after 5 April $taxYear to this tax year? Status Page")
    .post(s"$giftAidUrl/donations-after-5-april-$taxYear")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAddDonationsCurrentTaxYearDetailsPage: HttpRequestBuilder = http(s"Get How much of the donations you made after 5 April $taxYear do you want to add to this tax year? Details Page")
    .get(s"$giftAidUrl/amount-after-5-april-$taxYear-added-to-this-tax-year")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postAddDonationsCurrentTaxYearDetailsPage: HttpRequestBuilder = http(s"Post How much of the donations you made after 5 April $taxYear do you want to add to this tax year? Details Page")
    .post(s"$giftAidUrl/amount-after-5-april-$taxYear-added-to-this-tax-year")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfSharesOrSecuritiesStatusPage: HttpRequestBuilder = http(s"Get Did you donate qualifying shares or securities to charity? Status Page")
    .get(s"$giftAidUrl/donation-of-shares-or-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfSharesOrSecuritiesStatusPage: HttpRequestBuilder = http(s"Post Did you donate qualifying shares or securities to charity? Status Page")
    .post(s"$giftAidUrl/donation-of-shares-or-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfSharesOrSecuritiesDetailsPage: HttpRequestBuilder = http(s"Get What is the total value of shares or securities donated to charity? Details Page")
    .get(s"$giftAidUrl/value-of-shares-or-securities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfSharesOrSecuritiesDetailsPage: HttpRequestBuilder = http(s"Post What is the total value of shares or securities donated to charity? Details Page")
    .post(s"$giftAidUrl/value-of-shares-or-securities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfLandOrPropertyStatusPage: HttpRequestBuilder = http(s"Get Did you donate land or property to charity? Status Page")
    .get(s"$giftAidUrl/donation-of-land-or-property")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfLandOrPropertyStatusPage: HttpRequestBuilder = http(s"Post Did you donate land or property to charity? Status Page")
    .post(s"$giftAidUrl/donation-of-land-or-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfLandOrPropertyDetailsPage: HttpRequestBuilder = http(s"Get What is the value of land or property donated to charity? Details Page")
    .get(s"$giftAidUrl/value-of-land-or-property")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfLandOrPropertyDetailsPage: HttpRequestBuilder = http(s"Post What is the value of land or property donated to charity? Details Page")
    .post(s"$giftAidUrl/value-of-land-or-property")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage: HttpRequestBuilder = http(s"Get Did you donate shares, securities, land or property to overseas charities? Status Page")
    .get(s"$giftAidUrl/donation-of-shares-securities-land-or-property-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage: HttpRequestBuilder = http(s"Post Did you donate shares, securities, land or property to overseas charities? Status Page")
    .post(s"$giftAidUrl/donation-of-shares-securities-land-or-property-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage: HttpRequestBuilder = http(s"Get What is the value of shares, securities, land or property donated to overseas charities? Details Page")
    .get(s"$giftAidUrl/value-of-shares-securities-land-or-property-to-overseas-charities")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage: HttpRequestBuilder = http(s"Post What is the value of shares, securities, land or property donated to overseas charities? Details Page")
    .post(s"$giftAidUrl/value-of-shares-securities-land-or-property-to-overseas-charities")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "1000")
    .check(status.is(303))

  def getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage: HttpRequestBuilder = http("Get Name of overseas charity you donated shares, securities, land or property to Details Page")
    .get(s"$giftAidUrl/name-of-overseas-charities-donated-shares-securities-land-or-property-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName: String): HttpRequestBuilder = http("Post Name of overseas charity you donated shares, securities, land or property to Details Page")
    .post(s"$giftAidUrl/name-of-overseas-charities-donated-shares-securities-land-or-property-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("name", charityName)
    .check(status.is(303))

  def getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage: HttpRequestBuilder = http("Get Overseas charities you donated shares, securities, land or property to Summary Page")
    .get(s"$giftAidUrl/overseas-charities-donated-shares-securities-land-or-property-to")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity: Boolean): HttpRequestBuilder = http("Post Overseas charities you donated shares, securities, land or property to Summary Page")
    .post(s"$giftAidUrl/overseas-charities-donated-shares-securities-land-or-property-to")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", addAnotherCharity)
    .check(status.is(303))

  def getGiftAidCheckYourAnswersPage: HttpRequestBuilder = http("Get Gift Aid Check Your Answers Page")
    .get(s"$giftAidUrl/check-donations-to-charity")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postGiftAidCheckYourAnswersPage: HttpRequestBuilder = http("Post Gift Aid Check Your Answers Page")
    .post(s"$giftAidUrl/check-donations-to-charity")
    .formParam("""csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
