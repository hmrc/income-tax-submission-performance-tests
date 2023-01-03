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

package uk.gov.hmrc.perftests.itsass.simSteps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.GiftAidRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getOverviewPage, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait GiftAidSimSteps extends PerformanceTestRunner {

  def giftAidIndividual(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGiftAidGatewayPage,
    postGiftAidGatewayPage,
    getGiftAidStatusPage,
    postGiftAidStatusPage,
    getGiftAidDetailsPage,
    postGiftAidDetailsPage,
    getOneOffDonationStatusPage,
    postOneOffDonationStatusPage,
    getOneOffDonationDetailsPage,
    postOneOffDonationDetailsPage,
    getOverseasCharityDonationStatusPage,
    postOverseasCharityDonationStatusPage,
    getOverseasCharityDonationDetailsPage,
    postOverseasCharityDonationDetailsPage,
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "French Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "Spanish Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "Italian Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = false),
    getAddDonationsToLastTaxYearStatusPage,
    postAddDonationsToLastTaxYearStatusPage,
    getAddDonationsToLastTaxYearDetailsPage,
    postAddDonationsToLastTaxYearDetailsPage,
    getAddDonationsCurrentTaxYearStatusPage,
    postAddDonationsCurrentTaxYearStatusPage,
    getAddDonationsCurrentTaxYearDetailsPage,
    postAddDonationsCurrentTaxYearDetailsPage,
    getDonationOfSharesOrSecuritiesStatusPage,
    postDonationOfSharesOrSecuritiesStatusPage,
    getValueOfSharesOrSecuritiesDetailsPage,
    postValueOfSharesOrSecuritiesDetailsPage,
    getDonationOfLandOrPropertyStatusPage,
    postDonationOfLandOrPropertyStatusPage,
    getValueOfLandOrPropertyDetailsPage,
    postValueOfLandOrPropertyDetailsPage,
    getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage,
    postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage,
    getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage,
    postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage,
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Angolan Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Nepalese Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Antarctican Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = false),
    getGiftAidCheckYourAnswersPage,
    postGiftAidCheckYourAnswersPage
  )

  def giftAidAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage  ("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGiftAidGatewayPage,
    postGiftAidGatewayPage,
    getGiftAidStatusPage,
    postGiftAidStatusPage,
    getGiftAidDetailsPage,
    postGiftAidDetailsPage,
    getOneOffDonationStatusPage,
    postOneOffDonationStatusPage,
    getOneOffDonationDetailsPage,
    postOneOffDonationDetailsPage,
    getOverseasCharityDonationStatusPage,
    postOverseasCharityDonationStatusPage,
    getOverseasCharityDonationDetailsPage,
    postOverseasCharityDonationDetailsPage,
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "French Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "Spanish Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage,
    postNameOfOverseasCharityDetailsPage(charityName = "Italian Charity"),
    getOverseasCharitiesDonatedToSummaryPage,
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = false),
    getAddDonationsToLastTaxYearStatusPage,
    postAddDonationsToLastTaxYearStatusPage,
    getAddDonationsToLastTaxYearDetailsPage,
    postAddDonationsToLastTaxYearDetailsPage,
    getAddDonationsCurrentTaxYearStatusPage,
    postAddDonationsCurrentTaxYearStatusPage,
    getAddDonationsCurrentTaxYearDetailsPage,
    postAddDonationsCurrentTaxYearDetailsPage,
    getDonationOfSharesOrSecuritiesStatusPage,
    postDonationOfSharesOrSecuritiesStatusPage,
    getValueOfSharesOrSecuritiesDetailsPage,
    postValueOfSharesOrSecuritiesDetailsPage,
    getDonationOfLandOrPropertyStatusPage,
    postDonationOfLandOrPropertyStatusPage,
    getValueOfLandOrPropertyDetailsPage,
    postValueOfLandOrPropertyDetailsPage,
    getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage,
    postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage,
    getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage,
    postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage,
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Angolan Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Nepalese Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage,
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Antarctican Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage,
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = false),
    getGiftAidCheckYourAnswersPage,
    postGiftAidCheckYourAnswersPage
  )
}
