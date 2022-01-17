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

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.RequestsHelper._

object ExpensesRequests extends ServicesConfiguration{

  def getClaimingExpensesPage: HttpRequestBuilder = http("Get Claim Employment Expenses Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/claim-employment-expenses")
    .check(status.is(200))

  def postClaimingExpensesPage: HttpRequestBuilder = http("Post Claim Employment Expenses Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/claim-employment-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelAndOvernightExpensesPage: HttpRequestBuilder = http("Get Travel And Overnight Expenses Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/business-travel-and-overnight-expenses")
    .check(status.is(200))

  def postTravelAndOvernightExpensesPage: HttpRequestBuilder = http("Post Travel And Overnight Expenses Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/business-travel-and-overnight-expenses")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelAndOvernightExpensesAmountPage: HttpRequestBuilder = http("Get Travel And Overnight Expenses Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/travel-amount")
    .check(status.is(200))

  def postTravelAndOvernightExpensesAmountPage: HttpRequestBuilder = http("Post Travel And Overnight Expenses Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/travel-amount")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getUniformsOrToolsExpensesPage: HttpRequestBuilder = http("Get Uniform Or Tools Expenses Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/uniforms-work-clothes-or-tools")
    .check(status.is(200))

  def postUniformsOrToolsExpensesPage: HttpRequestBuilder = http("Post Uniform Or Tools Expenses Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/uniforms-work-clothes-or-tools")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getUniformsOrToolsExpensesAmountPage: HttpRequestBuilder = http("Get Uniform Or Tools Expenses Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-uniforms-work-clothes-or-tools")
    .check(status.is(200))

  def postUniformsOrToolsExpensesAmountPage: HttpRequestBuilder = http("Post Uniform Or Tools Expenses Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-uniforms-work-clothes-or-tools")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "200")
    .check(status.is(303))

  def getProfessionalSubscriptionsExpensesPage: HttpRequestBuilder = http("Get Professional Subscriptions Expenses Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/professional-fees-and-subscriptions")
    .check(status.is(200))

  def postProfessionalSubscriptionsExpensesPage: HttpRequestBuilder = http("Post Professional Subscriptions Expenses Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/professional-fees-and-subscriptions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getProfessionalSubscriptionsExpensesAmountPage: HttpRequestBuilder = http("Get Professional Subscriptions Expenses Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-professional-fees-and-subscriptions")
    .check(status.is(200))

  def postProfessionalSubscriptionsExpensesAmountPage: HttpRequestBuilder = http("Post Professional Subscriptions Expenses Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-professional-fees-and-subscriptions")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "300")
    .check(status.is(303))

  def getOtherEquipmentExpensesPage: HttpRequestBuilder = http("Get Other Equipment Expenses Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/other-equipment")
    .check(status.is(200))

  def postOtherEquipmentExpensesPage: HttpRequestBuilder = http("Post Other Equipment Expenses Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/other-equipment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherEquipmentExpensesAmountPage: HttpRequestBuilder = http("Get Other Equipment Expenses Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-other-equipment")
    .check(status.is(200))

  def postOtherEquipmentExpensesAmountPage: HttpRequestBuilder = http("Post Other Equipment Expenses Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/expenses/amount-for-other-equipment")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "400")
    .check(status.is(303))

}
