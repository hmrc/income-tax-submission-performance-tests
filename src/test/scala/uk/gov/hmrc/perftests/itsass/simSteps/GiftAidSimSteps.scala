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
    getGiftAidGatewayPage(taxYear),
    postGiftAidGatewayPage(taxYear),
    getGiftAidStatusPage(taxYear),
    postGiftAidStatusPage(taxYear),
    getGiftAidDetailsPage(taxYear),
    postGiftAidDetailsPage(taxYear),
    getOneOffDonationStatusPage(taxYear),
    postOneOffDonationStatusPage(taxYear),
    getOneOffDonationDetailsPage(taxYear),
    postOneOffDonationDetailsPage(taxYear),
    getOverseasCharityDonationStatusPage(taxYear),
    postOverseasCharityDonationStatusPage(taxYear),
    getOverseasCharityDonationDetailsPage(taxYear),
    postOverseasCharityDonationDetailsPage(taxYear),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "French Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "Spanish Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "Italian Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = false),
    getAddDonationsToLastTaxYearStatusPage(taxYear),
    postAddDonationsToLastTaxYearStatusPage(taxYear),
    getAddDonationsToLastTaxYearDetailsPage(taxYear),
    postAddDonationsToLastTaxYearDetailsPage(taxYear),
    getAddDonationsCurrentTaxYearStatusPage(taxYear),
    postAddDonationsCurrentTaxYearStatusPage(taxYear),
    getAddDonationsCurrentTaxYearDetailsPage(taxYear),
    postAddDonationsCurrentTaxYearDetailsPage(taxYear),
    getDonationOfSharesOrSecuritiesStatusPage(taxYear),
    postDonationOfSharesOrSecuritiesStatusPage(taxYear),
    getValueOfSharesOrSecuritiesDetailsPage(taxYear),
    postValueOfSharesOrSecuritiesDetailsPage(taxYear),
    getDonationOfLandOrPropertyStatusPage(taxYear),
    postDonationOfLandOrPropertyStatusPage(taxYear),
    getValueOfLandOrPropertyDetailsPage(taxYear),
    postValueOfLandOrPropertyDetailsPage(taxYear),
    getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear),
    postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear),
    getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear),
    postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Angolan Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Nepalese Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Antarctican Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = false),
    getGiftAidCheckYourAnswersPage(taxYear),
    postGiftAidCheckYourAnswersPage(taxYear)
  )

  def giftAidAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890", taxYear),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890", taxYear),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getGiftAidGatewayPage(taxYear),
    postGiftAidGatewayPage(taxYear),
    getGiftAidStatusPage(taxYear),
    postGiftAidStatusPage(taxYear),
    getGiftAidDetailsPage(taxYear),
    postGiftAidDetailsPage(taxYear),
    getOneOffDonationStatusPage(taxYear),
    postOneOffDonationStatusPage(taxYear),
    getOneOffDonationDetailsPage(taxYear),
    postOneOffDonationDetailsPage(taxYear),
    getOverseasCharityDonationStatusPage(taxYear),
    postOverseasCharityDonationStatusPage(taxYear),
    getOverseasCharityDonationDetailsPage(taxYear),
    postOverseasCharityDonationDetailsPage(taxYear),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "French Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "Spanish Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharityDetailsPage(taxYear),
    postNameOfOverseasCharityDetailsPage(charityName = "Italian Charity"),
    getOverseasCharitiesDonatedToSummaryPage(taxYear),
    postOverseasCharitiesDonatedToSummaryPage(addAnotherCharity = false),
    getAddDonationsToLastTaxYearStatusPage(taxYear),
    postAddDonationsToLastTaxYearStatusPage(taxYear),
    getAddDonationsToLastTaxYearDetailsPage(taxYear),
    postAddDonationsToLastTaxYearDetailsPage(taxYear),
    getAddDonationsCurrentTaxYearStatusPage(taxYear),
    postAddDonationsCurrentTaxYearStatusPage(taxYear),
    getAddDonationsCurrentTaxYearDetailsPage(taxYear),
    postAddDonationsCurrentTaxYearDetailsPage(taxYear),
    getDonationOfSharesOrSecuritiesStatusPage(taxYear),
    postDonationOfSharesOrSecuritiesStatusPage(taxYear),
    getValueOfSharesOrSecuritiesDetailsPage(taxYear),
    postValueOfSharesOrSecuritiesDetailsPage(taxYear),
    getDonationOfLandOrPropertyStatusPage(taxYear),
    postDonationOfLandOrPropertyStatusPage(taxYear),
    getValueOfLandOrPropertyDetailsPage(taxYear),
    postValueOfLandOrPropertyDetailsPage(taxYear),
    getDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear),
    postDonationOfSharesSecuritiesLandPropertyOverseasStatusPage(taxYear),
    getValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear),
    postValueOfSharesSecuritiesLandPropertyOverseasDetailsPage(taxYear),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Angolan Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Nepalese Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = true),
    getNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(taxYear),
    postNameOfOverseasCharitySharesSecuritiesLandPropertyDetailsPage(charityName = "Antarctican Charity"),
    getOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(taxYear),
    postOverseasCharitiesSharesSecuritiesLandPropertyDonatedToSummaryPage(addAnotherCharity = false),
    getGiftAidCheckYourAnswersPage(taxYear),
    postGiftAidCheckYourAnswersPage(taxYear)
  )
}
