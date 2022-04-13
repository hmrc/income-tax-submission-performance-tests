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

import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.itsass.simSteps._
import uk.gov.hmrc.perftests.itsass.simSteps.PensionsSimSteps



class IncomeTaxSubmissionSimulation extends PerformanceTestRunner with DividendsSimSteps with InterestSimSteps with CISSimSteps
  with GiftAidSimSteps with EmploymentsSimSteps with StudentLoansSimSteps with CrystallisationSimSteps with ViewEstimationSimSteps with NRSSimSteps with PensionsSimSteps {

  //Dividends
  individualDividends(id = "individual-dividends", description = "Individual Dividends Journey")
  agentDividends(id = "agent-dividends", description = "Agent Dividends Journey")

  //Interest
  interestIndividual(id = "individual-interest", description = "Individual Interest Journey")
  interestAgent(id = "agent-interest", description = "Agent Interest Journey")

  //GiftAid
  giftAidIndividual(id ="individual-gift-aid", description = "Individual Gift Aid Journey")
  giftAidAgent(id ="agent-gift-aid", description = "Agent Gift Aid Journey")

  //Employment
  employmentIndividualCurrentTaxYear(id ="individual-employment-current-taxYear", description = "Individual Single Employment Journey - Current Tax Year")
  employmentAgentCurrentTaxYear(id ="agent-employment-current-taxYear", description = "Agent Multiple Employments Journey - Current Tax Year")
  addEmploymentIndividual(id ="individual-add-employment", description = "Individual Add Employment - No Employments")
  addEmploymentAgent(id ="agent-add-employment", description = "Agent Add Employment - Prior Employments")
  employmentBenefitsIndividual(id ="individual-add-benefits", description = "Individual Multiple Employments - Adding benefits full flow")
  employmentExpensesIndividual(id ="individual-add-expenses", description = "Individual Expenses Journey - Single Employment")
  employmentExpensesAgent(id ="agent-add-expenses", description = "Agent Expenses Journey - Multiple Employments")
  addNewEmploymentIndividual(id ="individual-add-new-employment", description = "Individual Add New Employment - Prior Employments")
  addNewEmploymentAgent(id ="agent-add-new-employment", description = "Agent Add New Employment - Prior Employments")
  removeEmploymentIndividual(id ="individual-remove-employment", description = "Individual Remove Employment - Single Employment")
  removeEmploymentAgent(id ="agent-remove-employment", description = "Agent Remove Employment - Multiple Employments")

  //StudentLoans
  studentLoansIndividual(id ="individual-student-loans", description = "Individual Student Loans Journey")
  studentLoansAgent(id ="agent-student-loans", description = "Agent Student Loans Journey")

  //Crystallisation
  crystallisationIndividual(id ="individual-crystallisation", description = "Individual Crystallisation Journey")
  crystallisationAgent(id ="agent-crystallisation", description = "Agent Crystallisation Journey")

  //View Estimation
  viewEstimationIndividual(id = "individual-view-estimation", description = "Individual View Estimation Journey")
  viewEstimationAgent(id = "agent-view-estimation", description = "Agent View Estimation Journey")

  //NRS
  nrsJourney(id ="nrs-proxy-crystallisation", description = "NRS Crystallisation Downstream Request")

  //CIS
  cisIndividual(id = "individual-cis", description = "Individual CIS Journey")
  cisAgent(id = "agent-cis", description = "Agent CIS Journey")

   //Pensions
  paymentsIntoPensionsIndividual(id = "individual-payments-into-pensions", description = "Individual Payments into Pensions")
  paymentsIntoPensionAgent(id = "agent-payments-into-pensions", description = "Agent Payments into Pensions")

  runSimulation()
}
