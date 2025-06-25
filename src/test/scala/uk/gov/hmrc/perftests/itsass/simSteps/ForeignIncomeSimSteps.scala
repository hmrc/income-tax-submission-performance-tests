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

package uk.gov.hmrc.perftests.itsass.simSteps

import uk.gov.hmrc.performance.simulation.{JourneyPart, PerformanceTestRunner}
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.ForeignIncomeRequests._
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.PropertyUKRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY


trait ForeignIncomeSimSteps extends PerformanceTestRunner{

  def foreignIncomeIndividualEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AC210000B", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //Foreign Income - Foreign Dividend
    getForeignDividendsDetailsPage(taxYearEOY),
    getCountryReceivedDividendIncomePage(taxYearEOY),
    postCountryReceivedDividendIncomePage(taxYearEOY),
    getIncomeReceivedBeforeForeignTaxDeductedPage(taxYearEOY, "ESP"),
    postIncomeReceivedBeforeForeignTaxDeductedPage(taxYearEOY, "ESP"),
    getForeignTaxDeductedFromDividendIncomePage(taxYearEOY, "ESP"),
    postForeignTaxDeductedFromDividendIncomeYesPage(taxYearEOY, "ESP"),
    getHowMuchForeignTaxDeductedFromDividendIncomePage(taxYearEOY, "ESP"),
    postHowMuchForeignTaxDeductedFromDividendIncomePage(taxYearEOY, "ESP"),
    getClaimForeignTaxCreditReliefPage(taxYearEOY, "ESP"),
    postClaimForeignTaxCreditReliefPage(taxYearEOY, "ESP"),
    getCheckYourAnswersForeignIncomePage(taxYearEOY, "ESP"),
    postCheckYourAnswersForeignIncomePage(taxYearEOY),
    getYourForeignDividendsByCountryPage(taxYearEOY),
    postYourForeignDividendsByCountryPage(taxYearEOY),
    getHaveYouCompletedThisSectionForeignIncomePage(taxYearEOY),
    postHaveYouCompletedThisSectionForeignIncomePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),


  )
  def foreignIncomeAgentEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AC210000A", "1234567890", taxYearEOY),
    getInsertAdditionalParametersEndPoint("AC210000A", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),

    //Foreign Income - Foreign Dividend
    getForeignDividendsDetailsPage(taxYearEOY),
    getCountryReceivedDividendIncomePage(taxYearEOY),
    postCountryReceivedDividendIncomePage(taxYearEOY),
    getIncomeReceivedBeforeForeignTaxDeductedPage(taxYearEOY, "ITA"),
    postIncomeReceivedBeforeForeignTaxDeductedPage(taxYearEOY, "ITA"),
    getForeignTaxDeductedFromDividendIncomePage(taxYearEOY, "ITA"),
    postForeignTaxDeductedFromDividendIncomeNoPage(taxYearEOY, "ITA"),
    getCheckYourAnswersForeignIncomePage(taxYearEOY, "ITA"),
    postCheckYourAnswersForeignIncomePage(taxYearEOY),
    getYourForeignDividendsByCountryPage(taxYearEOY),
    postYourForeignDividendsByCountryPage(taxYearEOY),
    getHaveYouCompletedThisSectionForeignIncomePage(taxYearEOY),
    postHaveYouCompletedThisSectionForeignIncomePage(taxYearEOY),
    getPropertySummaryPage(taxYearEOY),


  )
}
