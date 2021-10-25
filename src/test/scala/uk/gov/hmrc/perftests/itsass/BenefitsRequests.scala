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

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.RequestsHelper._

object BenefitsRequests extends ServicesConfiguration {

  def getReceivedBenefitsPage: HttpRequestBuilder = http("Get Received Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postReceivedBenefitsPage: HttpRequestBuilder = http("Post Received Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCarVanFuelBenefitsPage: HttpRequestBuilder = http("Get Car Van Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/car-van-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCarVanFuelBenefitsPage: HttpRequestBuilder = http("Post Car Van Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/car-van-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarBenefitsPage: HttpRequestBuilder = http("Get Company Car Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-car?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarBenefitsPage: HttpRequestBuilder = http("Post Company Car Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-car?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarAmountBenefitsPage: HttpRequestBuilder = http("Get Company Car Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-car-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarAmountBenefitsPage: HttpRequestBuilder = http("Post Company Car Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-car-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getCompanyCarFuelBenefitsPage: HttpRequestBuilder = http("Get Company Car Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/car-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarFuelBenefitsPage: HttpRequestBuilder = http("Post Company Car Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/car-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarFuelAmountBenefitsPage: HttpRequestBuilder = http("Get Company Car Fuel Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/car-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarFuelAmountBenefitsPage: HttpRequestBuilder = http("Post Company Car Fuel Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/car-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "200")
    .check(status.is(303))

  def getCompanyVanBenefitsPage: HttpRequestBuilder = http("Get Company Van Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-van?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanBenefitsPage: HttpRequestBuilder = http("Post Company Van Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-van?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyVanAmountBenefitsPage: HttpRequestBuilder = http("Get Company Van Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-van-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanAmountBenefitsPage: HttpRequestBuilder = http("Post Company Van Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-van-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "300")
    .check(status.is(303))

  def getCompanyVanFuelBenefitsPage: HttpRequestBuilder = http("Get Company Van Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/van-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanFuelBenefitsPage: HttpRequestBuilder = http("Post Company Van Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/van-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyVanFuelAmountBenefitsPage: HttpRequestBuilder = http("Get Company Van Fuel Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/van-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanFuelAmountBenefitsPage: HttpRequestBuilder = http("Post Company Van Fuel Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/van-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "400")
    .check(status.is(303))

  def getMileageBenefitsPage: HttpRequestBuilder = http("Get Mileage Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/mileage?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMileageBenefitsPage: HttpRequestBuilder = http("Post Mileage Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/mileage?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMileageBenefitsAmountPage: HttpRequestBuilder = http("Get Mileage Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/mileage-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMileageBenefitsAmountPage: HttpRequestBuilder = http("Post Mileage Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/mileage-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

}
