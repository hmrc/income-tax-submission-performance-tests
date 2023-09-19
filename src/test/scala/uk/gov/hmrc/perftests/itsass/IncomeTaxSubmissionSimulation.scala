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

package uk.gov.hmrc.perftests.itsass

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.itsass.simSteps._

class IncomeTaxSubmissionSimulation extends PerformanceTestRunner with DividendsSimSteps with InterestSimSteps with AdditionalInformationSimSteps with CISSimSteps with StateBenefitsSimSteps
  with GiftAidSimSteps with EmploymentsSimSteps with StudentLoansSimSteps with CrystallisationSimSteps with ViewEstimationSimSteps with NRSSimSteps with PensionsSimSteps {

  //Dividends
  individualDividends(id = "individual-dividends", description = "Individual Dividends Journey")
  agentDividends(id = "agent-dividends", description = "Agent Dividends Journey")

  //Interest
  interestIndividual(id = "individual-interest", description = "Individual Interest Journey")
  interestAgent(id = "agent-interest", description = "Agent Interest Journey")

  //AdditionalInformation
  interestSecuritiesIndividual(id = "individual-securities", description = "Individual Securities Journey")
  interestSecuritiesAgent(id = "agent-securities", description = "Agent Securities Journey")
  gainsIndividual(id = "individual-gains", description = "Individual Gains Journey")
  gainsAgent(id = "agent-gains", description = "Agent Gains Journey")
  gainsVoidedISAIndividual(id = "individual-gains-voided-ISA", description = "Individual Gains Voided ISA Journey")
  gainsVoidedISAAgent(id = "agent-gains-voided-ISA", description = "Agent Gains Voided ISA Journey")
  stockDividendsIndividual(id = "individual-stock-dividends", description = "Individual Stock dividends Journey")
  stockDividendsAgent(id = "agent-stock-dividends", description = "Agent Stock Dividends Journey")

  //GiftAid
  giftAidIndividual(id = "individual-gift-aid", description = "Individual Gift Aid Journey")
  giftAidAgent(id = "agent-gift-aid", description = "Agent Gift Aid Journey")

  //Employment
  employmentIndividualCurrentTaxYear(id = "individual-employment-current-taxYear", description = "Individual Single Employment Journey - Current Tax Year")
  employmentAgentCurrentTaxYear(id = "agent-employment-current-taxYear", description = "Agent Multiple Employments Journey - Current Tax Year")
  addEmploymentIndividual(id = "individual-add-employment", description = "Individual Add Employment - No Employments")
  addEmploymentAgent(id = "agent-add-employment", description = "Agent Add Employment - Prior Employments")
  employmentBenefitsIndividual(id = "individual-add-benefits", description = "Individual Multiple Employments - Adding benefits full flow")
  employmentExpensesIndividual(id = "individual-add-expenses", description = "Individual Expenses Journey - Single Employment")
  employmentExpensesAgent(id = "agent-add-expenses", description = "Agent Expenses Journey - Multiple Employments")
  addNewEmploymentIndividual(id = "individual-add-new-employment", description = "Individual Add New Employment - Prior Employments")
  addNewEmploymentAgent(id = "agent-add-new-employment", description = "Agent Add New Employment - Prior Employments")
  removeEmploymentIndividual(id = "individual-remove-employment", description = "Individual Remove Employment - Single Employment")
  removeEmploymentAgent(id = "agent-remove-employment", description = "Agent Remove Employment - Multiple Employments")

  //StudentLoans
  studentLoansIndividual(id = "individual-student-loans", description = "Individual Student Loans Journey")
  studentLoansAgent(id = "agent-student-loans", description = "Agent Student Loans Journey")

  //CIS
  cisIndividualInYear(id = "individual-cis-in-year", description = "Individual CIS in year Journey")
  cisAgentInYear(id = "agent-cis-in-year", description = "Agent CIS in year Journey")
  cisIndividualEndOfYear(id = "individual-cis-end-of-year", description = "Individual CIS end of year Journey")
  cisAgentEndOfYear(id = "agent-cis-end-of-year", description = "Agent CIS end of year Journey")

  //State Benefits
  stateBenefitsIndividualInYear(id = "individual-state-benefits-in-year", description = "Individual State Benefits in year Journey")
  stateBenefitsAgentInYear(id = "agent-state-benefits-in-year", description = "Agent State Benefits in year Journey")
  stateBenefitsIndividualEndOfYearNewClaimJSA(id = "individual-state-benefits-end-of-year-new-claim-jsa", description = "Individual State Benefits end of year new JSA claim journey")
  stateBenefitsIndividualEndOfYearExistingClaimJSA(id = "individual-state-benefits-end-of-year-existing-claim-jsa", description = "Individual State Benefits end of year existing JSA claim journey")

  //Pensions
  paymentsIntoPensionsIndividual(id = "individual-payments-into-pensions", description = "Individual Payments into Pensions")
  paymentsIntoPensionAgent(id = "agent-payments-into-pensions", description = "Agent Payments into Pensions")

  unauthorisedPaymentsFromPensionsIndividual(id = "individual-unauthorised-payments-from-pensions", description = "Individual Unauthorised Payments from pensions")
  unauthorisedPaymentsFromPensionsAgent(id = "agent-unauthorised-payments-from-pensions", description = "Agent Unauthorised Payments from pensions")

  //Crystallisation
  crystallisationIndividual(id = "individual-crystallisation", description = "Individual Crystallisation Journey")
  crystallisationAgent(id = "agent-crystallisation", description = "Agent Crystallisation Journey")

  //View Estimation
  viewEstimationIndividual(id = "individual-view-estimation", description = "Individual View Estimation Journey")
  viewEstimationAgent(id = "agent-view-estimation", description = "Agent View Estimation Journey")

  //NRS
  nrsJourney(id = "nrs-proxy-crystallisation", description = "NRS Crystallisation Downstream Request")

  runSimulation()
}
