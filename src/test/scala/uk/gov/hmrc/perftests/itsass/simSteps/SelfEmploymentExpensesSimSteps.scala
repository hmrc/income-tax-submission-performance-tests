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
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests._
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYearEOY
import uk.gov.hmrc.perftests.itsass.requests.SelfEmploymentTradingAllowanceRequests._
import uk.gov.hmrc.perftests.itsass.requests.SelfEmploymentExpensesRequests._

trait SelfEmploymentExpensesSimSteps extends PerformanceTestRunner{

  def selfEmploymentExpensesIndividualEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA000001C", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getTaskListPage(taxYearEOY),
    getSelfEmploymentSummary(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getTaskListPage(taxYearEOY),
    getSelfEmploymentAbroad(taxYearEOY),
    getCheckYourDetails(taxYearEOY),
    postCheckYourDetails(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getIncomeNotCountedAsTurnover(taxYearEOY),
    postIncomeNotCountedAsTurnover(taxYearEOY),
    getHowMuchNonTurnoverIncome(taxYearEOY),
    postHowMuchNonTurnoverIncome(taxYearEOY),
    getYourTurnover(taxYearEOY),
    postYourTurnover(taxYearEOY),
    getAnyOtherIncome(taxYearEOY),
    postAnyOtherIncome(taxYearEOY),
    getOtherSelfEmploymentIncome(taxYearEOY),
    postOtherSelfEmploymentIncome(taxYearEOY),
    getTurnoverExemptFromTax(taxYearEOY),
    postTurnoverExemptFromTax(taxYearEOY),
    getHowMuchTurnoverExemptFromTax(taxYearEOY),
    postHowMuchTurnoverExemptFromTax(taxYearEOY),
    getTradingAllowanceExpenses(taxYearEOY),
    postTradingAllowanceExpenses(taxYearEOY),
    getCheckYourIncome(taxYearEOY),
    postCheckYourIncome(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getTaskListPage(taxYearEOY),
//    getExpensesCategories(taxYearEOY),
//    postExpensesCategories(taxYearEOY),
//    getOfficeSupplies(taxYearEOY),
//    postOfficeSupplies(taxYearEOY),
//    getGoodsToSellOrUse(taxYearEOY),
//    postGoodsToSellOrUse(taxYearEOY),
//    getRepairsAndMaintenance(taxYearEOY),
//    postRepairsAndMaintenance(taxYearEOY),
//    getDidYouWorkFromHome(taxYearEOY),
//    postDidYouWorkFromHome(taxYearEOY),
//    getDidYouWorkFromOwnPremises(taxYearEOY),
//    postDidYouWorkFromOwnPremises(taxYearEOY),
//    getTravelAndAccommodationForWork(taxYearEOY),
//    postTravelAndAccommodationForWork(taxYearEOY)

  )
  def selfEmploymentExpensesAgentEOYYear(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postIndividualLoginPage("AA000001C", "1234567890", taxYearEOY),
    getStartPage(taxYearEOY),
    getEOYOverviewPage(taxYearEOY),
    getTaskListPage(taxYearEOY),
    getSelfEmploymentSummary(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getTaskListPage(taxYearEOY),
    getSelfEmploymentAbroad(taxYearEOY),
    getCheckYourDetails(taxYearEOY),
    postCheckYourDetails(taxYearEOY),
    getHaveYouFinishedSection (taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getIncomeNotCountedAsTurnover(taxYearEOY),
    postIncomeNotCountedAsTurnover(taxYearEOY),
    getHowMuchNonTurnoverIncome(taxYearEOY),
    postHowMuchNonTurnoverIncome(taxYearEOY),
    getYourTurnover(taxYearEOY),
    postYourTurnover(taxYearEOY),
    getAnyOtherIncome(taxYearEOY),
    postAnyOtherIncome(taxYearEOY),
    getOtherSelfEmploymentIncome(taxYearEOY),
    postOtherSelfEmploymentIncome(taxYearEOY),
    getTurnoverExemptFromTax(taxYearEOY),
    postTurnoverExemptFromTax(taxYearEOY),
    getHowMuchTurnoverExemptFromTax(taxYearEOY),
    postHowMuchTurnoverExemptFromTax(taxYearEOY),
    getTradingAllowanceExpenses(taxYearEOY),
    postTradingAllowanceExpenses(taxYearEOY),
    getCheckYourIncome(taxYearEOY),
    postCheckYourIncome(taxYearEOY),
    getHaveYouFinishedSection(taxYearEOY),
    postHaveYouFinishedSection(taxYearEOY),
    getTaskListPage(taxYearEOY),
    //    getExpensesCategories(taxYearEOY),
    //    postExpensesCategories(taxYearEOY),
    //    getOfficeSupplies(taxYearEOY),
    //    postOfficeSupplies(taxYearEOY),
    //    getGoodsToSellOrUse(taxYearEOY),
    //    postGoodsToSellOrUse(taxYearEOY),
    //    getRepairsAndMaintenance(taxYearEOY),
    //    postRepairsAndMaintenance(taxYearEOY),
    //    getDidYouWorkFromHome(taxYearEOY),
    //    postDidYouWorkFromHome(taxYearEOY),
    //    getDidYouWorkFromOwnPremises(taxYearEOY),
    //    postDidYouWorkFromOwnPremises(taxYearEOY),
    //    getTravelAndAccommodationForWork(taxYearEOY),
    //    postTravelAndAccommodationForWork(taxYearEOY),

  )
}
