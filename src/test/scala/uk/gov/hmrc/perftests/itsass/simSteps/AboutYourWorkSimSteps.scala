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
import uk.gov.hmrc.perftests.itsass.requests.AboutYouRequests._
import uk.gov.hmrc.perftests.itsass.requests.AboutYourWorkRequests._
import uk.gov.hmrc.perftests.itsass.requests.AuthLoginRequests.{getLoginPage, postAgentLoginPage, postIndividualLoginPage}
import uk.gov.hmrc.perftests.itsass.requests.IncomeTaxSubmissionRequests.{getInsertAdditionalParametersEndPoint, getStartPage}
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper.taxYear

trait AboutYourWorkSimSteps extends PerformanceTestRunner{

  def aboutYourWorkIndividual (id: String, description: String): JourneyPart = setup(id, description) withRequests (
    getLoginPage,
    postIndividualLoginPage("AA123459A", "1234567890"),
    // About you steps have to be completed in order for About your work steps to work
    getStartPage(taxYear),
    getUkResidenceStatus,
    postUkResidenceStatus,
    getChangeUkResidenceStatus,
    postChangeUkResidenceStatus,
    getYourResidenceStatus,
    postYourResidenceStatus,
    getChangeYourResidenceStatus,
    postChangeYourResidenceStatus,
    getCharitableDonations,
    postCharitableDonations,
    getChangeCharitableDonations,
    postChangeCharitableDonations,
    getMarriageAllowance,
    postMarriageAllowance,
    getChangeMarriageAllowance,
    postChangeMarriageAllowance,
    getChildBenefit,
    postChildBenefit,
    getChangeChildBenefit,
    postChangeChildBenefit,
    getChildBenefitHighIncomeCharge,
    postChildBenefitHighIncomeCharge,
    getChangeChildBenefitHighIncomeCharge,
    postChangeChildBenefitHighIncomeCharge,
    getChildBenefitOver50k,
    postChildBenefitOver50k,
    getChangeChildBenefitOver50k,
    postChangeChildBenefitOver50k,
    getDonateToCharity,
    postDonateToCharity,
    getChangeDonateToCharity,
    postChangeDonateToCharity,
    getFosterCarer,
    postFosterCarer,
    getChangeFosterCarer,
    postChangeFosterCarer,
    getPatentRoyaltyPayments,
    postPatentRoyaltyPayments,
    getChangePatentRoyaltyPayments,
    postChangePatentRoyaltyPayments,
    // About your Work steps
    getAboutYourWork,
    postAboutYourWork,
    getChangeAboutYourWork,
    postChangeAboutYourWork,
    getEmploymentLumpSums,
    postEmploymentLumpSums,
    getChangeEmploymentLumpSums,
    postChangeEmploymentLumpSums,
    getShareSchemes,
    postShareSchemes,
    getChangeShareSchemes,
    postChangeShareSchemes,
    getConstructionIndustryScheme,
    postConstructionIndustryScheme,
    getChangeConstructionIndustryScheme,
    postChangeConstructionIndustryScheme,
    getJobseekersAllowanceEmploymentAndSupportAllowance,
    postJobseekersAllowanceEmploymentAndSupportAllowance,
    getChangeJobseekersAllowanceEmploymentAndSupportAllowance,
    postChangeJobseekersAllowanceEmploymentAndSupportAllowance,
    getTaxableStateBenefits,
    postTaxableStateBenefits,
    getChangeTaxableStateBenefits,
    postChangeTaxableStateBenefits,
    getStatutoryBenefits,
    postStatutoryBenefits,
    getChangeStatutoryBenefits,
    postChangeStatutoryBenefits,
    getTaxRefunds,
    postTaxRefunds,
    getChangeTaxRefunds ,
    postChangeTaxRefunds
  )

  def aboutYourWorkAgent(id: String, description: String): JourneyPart = setup(id, description) withRequests(
    getLoginPage,
    postAgentLoginPage("AA123459A", "1234567890"),
    getInsertAdditionalParametersEndPoint("AA123459A", "1234567890"),
    getStartPage(taxYear),
    // About you steps have to be completed in order for About your work steps to work
    getUkResidenceStatus,
    postUkResidenceStatus,
    getChangeUkResidenceStatus,
    postChangeUkResidenceStatus,
    getYourResidenceStatus,
    postYourResidenceStatus,
    getChangeYourResidenceStatus,
    postChangeYourResidenceStatus,
    getCharitableDonations,
    postCharitableDonations,
    getChangeCharitableDonations,
    postChangeCharitableDonations,
    getMarriageAllowance,
    postMarriageAllowance,
    getChangeMarriageAllowance,
    postChangeMarriageAllowance,
    getChildBenefit,
    postChildBenefit,
    getChangeChildBenefit,
    postChangeChildBenefit,
    getChildBenefitHighIncomeCharge,
    postChildBenefitHighIncomeCharge,
    getChangeChildBenefitHighIncomeCharge,
    postChangeChildBenefitHighIncomeCharge,
    getChildBenefitOver50k,
    postChildBenefitOver50k,
    getChangeChildBenefitOver50k,
    postChangeChildBenefitOver50k,
    getDonateToCharity,
    postDonateToCharity,
    getChangeDonateToCharity,
    postChangeDonateToCharity,
    getFosterCarer,
    postFosterCarer,
    getChangeFosterCarer,
    postChangeFosterCarer,
    getPatentRoyaltyPayments,
    postPatentRoyaltyPayments,
    getChangePatentRoyaltyPayments,
    postChangePatentRoyaltyPayments,
/// About Your Work Steps
    getAboutYourWork,
    postAboutYourWork,
    getChangeAboutYourWork,
    postChangeAboutYourWork,
    getEmploymentLumpSums,
    postEmploymentLumpSums,
    getChangeEmploymentLumpSums,
    postChangeEmploymentLumpSums,
    getShareSchemes,
    postShareSchemes,
    getChangeShareSchemes,
    postChangeShareSchemes,
    getConstructionIndustryScheme,
    postConstructionIndustryScheme,
    getChangeConstructionIndustryScheme,
    postChangeConstructionIndustryScheme,
    getJobseekersAllowanceEmploymentAndSupportAllowance,
    postJobseekersAllowanceEmploymentAndSupportAllowance,
    getChangeJobseekersAllowanceEmploymentAndSupportAllowance,
    postChangeJobseekersAllowanceEmploymentAndSupportAllowance,
    getTaxableStateBenefits,
    postTaxableStateBenefits,
    getChangeTaxableStateBenefits,
    postChangeTaxableStateBenefits,
    getStatutoryBenefits,
    postStatutoryBenefits,
    getChangeStatutoryBenefits,
    postChangeStatutoryBenefits,
    getTaxRefunds,
    postTaxRefunds,
    getChangeTaxRefunds,
    postChangeTaxRefunds
  )
}
