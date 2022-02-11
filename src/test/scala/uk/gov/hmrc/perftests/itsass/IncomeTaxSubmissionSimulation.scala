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

class IncomeTaxSubmissionSimulation extends PerformanceTestRunner with DividendsSimSteps with InterestSimSteps
  with GiftAidSimSteps with EmploymentsSimSteps with StudentLoansSimSteps with CrystallisationSimSteps with NRSSimSteps {

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
  employmentIndividual(id ="individual-employment", description = "Individual Single Employment Journey")
  employmentAgent(id ="agent-employment", description = "Agent Multiple Employments Journey")
  addEmploymentIndividual(id ="individual-add-employment", description = "Individual Add Employment-No Employments")
  addEmploymentAgent(id ="agent-add-employment", description = "Agent Add Employment - Prior Employments")
  removeEmploymentIndividual(id ="individual-remove-employment", description = "Individual Remove Employment - Single Employment")
  removeEmploymentAgent(id ="agent-remove-employment", description = "Agent Remove Employment - Multiple Employments")
  employmentDetailsIndividual(id ="individual-employment-details", description = "Individual Multiple Employments - Check Employment Details EOY")
  employmentBenefitsIndividual(id ="individual-add-benefits", description = "Individual Multiple Employments - Adding benefits full flow")
  employmentExpensesIndividual(id ="individual-add-expenses", description = "Individual Expenses Journey - Single Employment")
  employmentExpensesAgent(id ="agent-add-expenses", description = "Agent Expenses Journey - Multiple Employments")
  addNewEmploymentIndividual(id ="individual-add-new-employment", description = "Individual Add New Employment - Prior Employments")
  addNewEmploymentAgent(id ="agent-add-new-employment", description = "Agent Add New Employment - Prior Employments")

  //StudentLoans
  studentLoansIndividual(id ="individual-student-loans", description = "Individual Student Loans Journey")
  studentLoansAgent(id ="agent-student-loans", description = "Agent Student Loans Journey")

  //Crystallisation
  crystallisationIndividual(id ="individual-crystallisation", description = "Individual Crystallisation Journey")
  crystallisationAgent(id ="agent-crystallisation", description = "Agent Crystallisation Journey")

  //NRS
  nrsJourney(id ="nrs-proxy-crystallisation", description = "NRS Crystallisation Downstream Request")

  runSimulation()
}
