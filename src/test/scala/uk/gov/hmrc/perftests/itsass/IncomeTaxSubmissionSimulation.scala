/*
 * Copyright 2021 HM Revenue & Customs
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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.itsass.AuthLoginRequests._
import uk.gov.hmrc.perftests.itsass.BenefitsRequests._
import uk.gov.hmrc.perftests.itsass.DividendsRequests._
import uk.gov.hmrc.perftests.itsass.EmploymentsRequests._
import uk.gov.hmrc.perftests.itsass.GiftAidRequests._
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.InterestRequests._
import uk.gov.hmrc.perftests.itsass.CrystallisationRequests._
import uk.gov.hmrc.perftests.itsass.RequestsHelper.{taxYear, taxYearEOY}


class IncomeTaxSubmissionSimulation extends PerformanceTestRunner {

  setup("individual-dividends", "Individual Dividends Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getUKDividendsStatusPage,
    postUKDividendsStatusPage,
    getUKDividendsAmountPage,
    postUKDividendsAmountPage,
    getOtherDividendsStatusPage,
    postOtherDividendsStatusPage,
    getOtherDividendsAmountPage,
    postOtherDividendsAmountPage,
    getDividendsCheckYourAnswersPage,
    postDividendsCheckYourAnswersPage
  )

  setup("agent-dividends", "Agent Dividends Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getUKDividendsStatusPage,
    postUKDividendsStatusPage,
    getUKDividendsAmountPage,
    postUKDividendsAmountPage,
    getOtherDividendsStatusPage,
    postOtherDividendsStatusPage,
    getOtherDividendsAmountPage,
    postOtherDividendsAmountPage,
    getDividendsCheckYourAnswersPage,
    postDividendsCheckYourAnswersPage
  )

  setup("individual-interest", "Individual Interest Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111111A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedChooseAccountRedirect,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Tesco Bank"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Halifax"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage(accountName = "Santander"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false),
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedChooseAccountPage,
    postTaxedChooseAccountPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Tesco Bank"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Halifax"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage(accountName = "Santander"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = false),
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

  setup("agent-interest", "Agent Interest Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getUntaxedUKInterestStatusPage,
    postUntaxedUKInterestStatusPage,
    getUntaxedChooseAccountRedirect,
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Tesco Bank"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Halifax"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = true),
    getUntaxedUKInterestDetailsPage,
    postUntaxedUKInterestDetailsPage("Santander"),
    getUntaxedUKInterestSummaryPage,
    postUntaxedUKInterestSummaryPage(addAnotherAccount = false),
    getTaxedUKInterestStatusPage,
    postTaxedUKInterestStatusPage,
    getTaxedChooseAccountPage,
    postTaxedChooseAccountPage,
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Tesco Bank"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Halifax"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = true),
    getTaxedUKInterestDetailsPage,
    postTaxedUKInterestDetailsPage("Santander"),
    getTaxedUKInterestSummaryPage,
    postTaxedUKInterestSummaryPage(addAnotherAccount = false),
    getInterestCheckYourAnswersPage,
    postInterestCheckYourAnswersPage
  )

  setup("individual-employment", "Individual Single Employment Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getEmploymentDetailsPage(taxYear, "00000000-0000-1000-8000-000000000000"),
    getEmploymentBenefitsPage(taxYear,"00000000-0000-1000-8000-000000000000"),
    getEmploymentExpensesPage(taxYear)
  )

  setup("agent-employment", "Agent Multiple Employments Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
    getEmploymentSummaryPage(taxYear),
    getEmployerDetailsAndBenefitsPage(taxYear, employmentId="00000000-5555-0000-0000-000000000001"),
    getEmploymentDetailsPage(taxYear, employmentId="00000000-5555-0000-0000-000000000001"),
    getEmploymentBenefitsPage(taxYear, employmentId="00000000-5555-0000-0000-000000000001"),
    getEmploymentExpensesPage(taxYear)
  )

  setup("individual-add-employment", "Individual Add Employment-No Employments") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA123456A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getAddEmploymentPage(taxYearEOY),
    postAddEmploymentPage(taxYearEOY),
    getEmployerNamePage(taxYearEOY),
    postEmployerNamePage(taxYearEOY),
    getPayeRefPage(taxYearEOY),
    postPayeRefPage(taxYearEOY),
    getEmploymentStartDatePage(taxYearEOY),
    postEmploymentStartDate(taxYearEOY),
    getAreYouStillWorkingAtEmployerPage(taxYearEOY),
    postAreYouStillWorkingAtEmployerPage(taxYearEOY),
    getWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    postWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    getPayrollIdPage(taxYearEOY),
    postPayrollIdPage(taxYearEOY),
    getPayEmploymentPage(taxYearEOY),
    postPayEmploymentPage(taxYearEOY),
    getUkTaxEmploymentPage(taxYearEOY),
    postUkTaxEmploymentPage(taxYearEOY)
  )

  setup("agent-add-employment", "Agent Add Employment - Prior Employments") withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    postEmploymentSummaryPage(taxYearEOY),
    getEmployerNamePage(taxYearEOY),
    postEmployerNamePage(taxYearEOY),
    getPayeRefPage(taxYearEOY),
    postPayeRefPage(taxYearEOY),
    getEmploymentStartDatePage(taxYearEOY),
    postEmploymentStartDate(taxYearEOY),
    getAreYouStillWorkingAtEmployerPage(taxYearEOY),
    postAreYouStillWorkingAtEmployerPage(taxYearEOY),
    getWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    postWhenDidYouLeaveYourEmployerPage(taxYearEOY),
    getPayrollIdPage(taxYearEOY),
    postPayrollIdPage(taxYearEOY),
    getPayEmploymentPage(taxYearEOY),
    postPayEmploymentPage(taxYearEOY),
    getUkTaxEmploymentPage(taxYearEOY),
    postUkTaxEmploymentPage(taxYearEOY)
  )

  setup("individual-remove-employment", "Individual Remove Employment - Single Employment") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA133742A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY,"00000000-0000-1000-8000-000000000004"),
    postRemoveEmploymentPage(taxYearEOY, "00000000-0000-1000-8000-000000000004"),
    getEmploymentSummaryPage(taxYearEOY) //TODO - change to EOY overview page once caching problem is resolved
  )

  setup("agent-remove-employment", "Agent Remove Employment - Multiple Employments") withRequests(
    getLoginPage,
    postAgentLoginPage("BB444444A", "1234567890"),
    getInsertAdditionalParametersEndPoint("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getRemoveEmploymentPage(taxYearEOY,"00000000-5555-0000-0000-000000000001"),
    postRemoveEmploymentPage(taxYearEOY, "00000000-5555-0000-0000-000000000001"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  setup("individual-employment-details", "Individual Multiple Employments - Check Employment Details EOY") withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY,"00000000-5555-5555-0000-000000000002"),
    getEmploymentDetailsPage(taxYearEOY, "00000000-5555-5555-0000-000000000002"),
    postEmploymentDetailsPage(taxYearEOY, "00000000-5555-5555-0000-000000000002"),
    getEmploymentSummaryPage(taxYearEOY)
  )

  setup("individual-add-benefits", "Individual Multiple Employments - Adding benefits full flow") withRequests(
    getLoginPage,
    postIndividualLoginPage("BB444444A", "1234567890"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getEmploymentSummaryPage(taxYearEOY),
    getEmployerDetailsAndBenefitsPage(taxYearEOY,"00000000-5555-0000-0000-000000000002"),
    getEmploymentBenefitsWithoutBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getReceivedBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postReceivedBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCarVanFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCarVanFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyCarBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyCarBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyCarAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyCarAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyCarFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyCarFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyCarFuelAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyCarFuelAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyVanBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyVanBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyVanAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyVanAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyVanFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyVanFuelBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getCompanyVanFuelAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postCompanyVanFuelAmountBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getMileageBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postMileageBenefitsPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    getMileageBenefitsAmountPage(taxYearEOY, "00000000-5555-0000-0000-000000000002"),
    postMileageBenefitsAmountPage(taxYearEOY, "00000000-5555-0000-0000-000000000002")
  )

  setup("individual-gift-aid", "Individual Gift Aid Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
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
    getDonationOfSharesSecuritiesLandPropertyStatusPage,
    postDonationOfSharesSecuritiesLandPropertyStatusPage,
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

  setup("agent-gift-aid", "Agent Gift Aid Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("AA111112A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA111112A", "1234567890"),
    getStartPage(taxYear),
    getOverviewPage(taxYear),
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
    getDonationOfSharesSecuritiesLandPropertyStatusPage,
    postDonationOfSharesSecuritiesLandPropertyStatusPage,
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

  setup("individual-crystallisation", "Individual Crystallisation Journey") withRequests(
    getLoginPage,
    postIndividualLoginPage("AA888888A", "XAIT00000888888"),
    getStartPage(taxYearEOY),
    getViewChangeTestHeadersPage,
    postViewChangeTestHeadersPage,
    getEOYOverviewPage(taxYearEOY),
    postEOYOverviewPage(taxYearEOY),
    getFinalTaxCalculationEndpoint(taxYearEOY),
    getFinalTaxCalculationPage(taxYearEOY),
    postFinalTaxCalculationPage(taxYearEOY),
    getDeclarationPage(taxYearEOY),
    getReceivedTaxCalculationPage(taxYearEOY)
  )

  setup("agent-crystallisation", "Agent Crystallisation Journey") withRequests(
    getLoginPage,
    postAgentLoginPage("AA888888A", "XAIT00000888888"),
    getInsertAdditionalParametersEndPoint("AA888888A", "XAIT00000888888"),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    postEOYOverviewPage(taxYearEOY),
    getCitizenDetailsStubPage,
    postCitizenDetailsStubPage,
    getClientUTRPage,
    postClientUTRPage,
    getConfirmClientUTRPage,
    postConfirmClientUTRPage,
    getViewChangeTestHeadersPage,
    postViewChangeTestHeadersPage,
    getFinalTaxCalculationAgentEndpoint(taxYearEOY),
    getFinalTaxCalculationAgentPage(taxYearEOY),
    postFinalTaxCalculationAgentPage(taxYearEOY),
    getDeclarationPage(taxYearEOY),
    getReceivedTaxCalculationPage(taxYearEOY)
  )

  runSimulation()
}
