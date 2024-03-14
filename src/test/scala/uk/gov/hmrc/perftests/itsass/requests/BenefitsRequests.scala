/*
 * Copyright 2024 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object BenefitsRequests extends ServicesConfiguration {

  def getReceivedBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Received Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postReceivedBenefitsPage(taxYear: String,hasBenefits: Boolean = true): HttpRequestBuilder = http("Post Received Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", hasBenefits)
    .check(status.is(303))

  def getCarVanFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Car Van Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/car-van-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCarVanFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Car Van Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/car-van-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Car Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/company-car?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Car Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/company-car?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Car Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/company-car-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Car Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/company-car-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getCompanyCarFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Car Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/car-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Car Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/car-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyCarFuelAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Car Fuel Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/car-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyCarFuelAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Car Fuel Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/car-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "200")
    .check(status.is(303))

  def getCompanyVanBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Van Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/company-van?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Van Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/company-van?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyVanAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Van Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/company-van-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Van Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/company-van-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "300")
    .check(status.is(303))

  def getCompanyVanFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Van Fuel Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/van-fuel?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanFuelBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Van Fuel Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/van-fuel?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getCompanyVanFuelAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Company Van Fuel Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/van-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postCompanyVanFuelAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Company Van Fuel Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/van-fuel-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "400")
    .check(status.is(303))

  def getMileageBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Mileage Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/mileage?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMileageBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Mileage Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/mileage?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMileageBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Mileage Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/mileage-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMileageBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Mileage Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/mileage-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getAccommodationRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Accommodation Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/accommodation-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Accommodation Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/accommodation-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAccommodationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Accommodation Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/living-accommodation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Accommodation Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/living-accommodation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAccommodationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Accommodation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/living-accommodation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Accommodation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/living-accommodation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getQualifyingRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Qualifying Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postQualifyingRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Qualifying Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getQualifyingRelocationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Qualifying Relocation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postQualifyingRelocationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Qualifying Relocation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getNonQualifyingRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non Qualifying Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonQualifyingRelocationBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non Qualifying Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonQualifyingRelocationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non Qualifying Relocation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonQualifyingRelocationAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non Qualifying Relocation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getTravelOrEntertainmentBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Travel And Entertainment Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/travel-entertainment?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrEntertainmentBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Travel And Entertainment Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/travel-entertainment?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelOrSubsistenceBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Travel Or Subsistence Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/travel-subsistence?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrSubsistenceBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Travel Or Subsistence Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/travel-subsistence?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelOrSubsistenceAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Travel Or Subsistence Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/travel-subsistence-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrSubsistenceAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Travel Or Subsistence Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/travel-subsistence-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getIncidentalOvernightCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Incidental Overnight Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/incidental-overnight-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncidentalOvernightCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Incidental Overnight Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/incidental-overnight-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncidentalOvernightCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Incidental Overnight Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/incidental-overnight-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncidentalOvernightCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Incidental Overnight Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/incidental-overnight-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getEntertainmentBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Entertainment Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/entertainment-expenses?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEntertainmentBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Entertainment Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/entertainment-expenses?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEntertainmentAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Entertainment Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/entertainment-expenses-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEntertainmentAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Entertainment Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/entertainment-expenses-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getUtilitiesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Utilities Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/utility-general-service?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postUtilitiesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Utilities Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/utility-general-service?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTelephoneBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Telephone Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/telephone?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTelephoneBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Telephone Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/telephone?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTelephoneAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Telephone Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/telephone-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTelephoneAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Telephone Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/telephone-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "600")
    .check(status.is(303))

  def getEmployerServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Employer Services Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/employer-provided-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEmployerServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Employer Services Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/employer-provided-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEmployerServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Employer Services Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/employer-provided-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEmployerServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Employer Services Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/employer-provided-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getProfessionalFeesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Professional Fees Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/professional-fees-or-subscriptions?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postProfessionalFeesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Professional Fees Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/professional-fees-or-subscriptions?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getProfessionalFeesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Professional Fees Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/professional-fees-or-subscriptions-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postProfessionalFeesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Professional Fees Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/professional-fees-or-subscriptions-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "800")
    .check(status.is(303))

  def getOtherServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Other Services Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/other-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Other Services Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/other-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Other Services Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/other-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Other Services Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/other-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getMedicalDentalChildcareBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Medical Dental Childcare Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/medical-dental-childcare-education-loans?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalChildcareBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Medical Dental Childcare Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/medical-dental-childcare-education-loans?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMedicalDentalBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Medical Dental Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/medical-dental?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Medical Dental Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/medical-dental?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMedicalDentalAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Medical Dental Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/medical-dental-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Medical Dental Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/medical-dental-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getChildcareBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Childcare Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/childcare?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postChildcareBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Childcare Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/childcare?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChildcareAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Childcare Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/childcare-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postChildcareAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Childcare Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/childcare-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getEducationalServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Educational Services Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/educational-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEducationalServicesBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Educational Services Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/educational-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEducationalServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Educational Services Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/educational-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEducationalServicesAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Educational Services Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/educational-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getBeneficialLoansBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Beneficial Loans Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/beneficial-loans?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postBeneficialLoansBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Beneficial Loans Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/beneficial-loans?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getBeneficialLoansAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Beneficial Loans Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/beneficial-loans-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postBeneficialLoansAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Beneficial Loans Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/beneficial-loans-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getIncomeTaxOrIncurredCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Income Tax of Incurred Costs Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax-or-incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxOrIncurredCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Income Tax of Incurred Costs Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax-or-incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncomeTaxBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Income Tax Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Income Tax Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncomeTaxAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Income Tax Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Income Tax Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/employer-income-tax-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getIncurredCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Incurred Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncurredCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Incurred Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncurredCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Incurred Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/incurred-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncurredCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Incurred Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/incurred-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getReimbursedCostsVouchersNonCashBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Reimbursed Costs, Vouchers and Non Cash Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/reimbursed-costs-vouchers-non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postReimbursedCostsVouchersNonCashBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Reimbursed Costs, Vouchers and Non Cash Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/reimbursed-costs-vouchers-non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonTaxableCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non-Taxable Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonTaxableCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non-Taxable Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonTaxableCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non-Taxable Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonTaxableCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non-Taxable Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getTaxableCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Taxable Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTaxableCostsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Taxable Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxableCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Taxable Costs Amount Benefits Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTaxableCostsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Taxable Costs Amount Benefits Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getVouchersOrCreditCardsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Vouchers or Credit Cards Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/vouchers-or-credit-cards?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postVouchersOrCreditCardsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Vouchers or Credit Cards Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/vouchers-or-credit-cards?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getVouchersOrCreditCardsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Vouchers or Credit Cards Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/vouchers-or-credit-cards-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postVouchersOrCreditCardsAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Vouchers or Credit Cards Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/vouchers-or-credit-cards-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getNonCashBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non-Cash Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonCashBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non-Cash Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonCashAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Non-Cash Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/non-cash-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonCashAmountBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Non-Cash Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/non-cash-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getOtherBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Other Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/other-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Other Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/other-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Other Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/other-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Other Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/other-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getAssetsOrAssetsTransferBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Assets or Assets Transfer Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/assets?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsOrAssetsTransferBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Assets or Assets Transfer Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/assets?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Assets Available for Use Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/assets-available-for-use?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Assets Available for Use Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/assets-available-for-use?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Assets Available for Use Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/assets-available-for-use-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Assets Available for Use Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/assets-available-for-use-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getAssetsTransferBenefitsPage(taxYear: String): HttpRequestBuilder = http("Get Assets Transfer Benefits Question Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/assets-to-keep?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsTransferBenefitsPage(taxYear: String): HttpRequestBuilder = http("Post Assets Transfer Benefits Question Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/assets-to-keep?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsTransferBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Get Assets Transfer Benefits Amount Page")
    .get(s"${employmentsUrl(taxYear)}/benefits/assets-to-keep-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsTransferBenefitsAmountPage(taxYear: String): HttpRequestBuilder = http("Post Assets Transfer Benefits Amount Page")
    .post(s"${employmentsUrl(taxYear)}/benefits/assets-to-keep-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

}
