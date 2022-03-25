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
  with GiftAidSimSteps with EmploymentsSimSteps with StudentLoansSimSteps with CrystallisationSimSteps with ViewEstimationSimSteps with NRSSimSteps {

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

  addFullEmploymentIndividual(id ="individual-add-employment", description = "Individual Add Full Employment")
  addFullEmploymentAgent(id ="agent-add-employment", description = "Agent Add Full Employment")
  checkAndRemoveEmploymentIndividual(id ="individual-check-remove-employment", description = "Individual Check and Remove Employment")
  checkAndRemoveEmploymentAgent(id ="agent-check-remove-employment", description = "Agent Check And Remove Employment")

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

  runSimulation()
}
