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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.requests.RequestsHelper._

object BenefitsRequests extends ServicesConfiguration {

  def getReceivedBenefitsPage: HttpRequestBuilder = http("Get Received Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postReceivedBenefitsPage(hasBenefits: Boolean = true): HttpRequestBuilder = http("Post Received Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/company-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", hasBenefits)
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

  def getAccommodationRelocationBenefitsPage: HttpRequestBuilder = http("Get Accommodation Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/accommodation-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationRelocationBenefitsPage: HttpRequestBuilder = http("Post Accommodation Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/accommodation-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAccommodationBenefitsPage: HttpRequestBuilder = http("Get Accommodation Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/living-accommodation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationBenefitsPage: HttpRequestBuilder = http("Post Accommodation Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/living-accommodation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAccommodationAmountBenefitsPage: HttpRequestBuilder = http("Get Accommodation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/living-accommodation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAccommodationAmountBenefitsPage: HttpRequestBuilder = http("Post Accommodation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/living-accommodation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getQualifyingRelocationBenefitsPage: HttpRequestBuilder = http("Get Qualifying Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postQualifyingRelocationBenefitsPage: HttpRequestBuilder = http("Post Qualifying Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getQualifyingRelocationAmountBenefitsPage: HttpRequestBuilder = http("Get Qualifying Relocation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postQualifyingRelocationAmountBenefitsPage: HttpRequestBuilder = http("Post Qualifying Relocation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getNonQualifyingRelocationBenefitsPage: HttpRequestBuilder = http("Get Non Qualifying Relocation Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonQualifyingRelocationBenefitsPage: HttpRequestBuilder = http("Post Non Qualifying Relocation Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-qualifying-relocation?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonQualifyingRelocationAmountBenefitsPage: HttpRequestBuilder = http("Get Non Qualifying Relocation Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonQualifyingRelocationAmountBenefitsPage: HttpRequestBuilder = http("Post Non Qualifying Relocation Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-qualifying-relocation-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getTravelOrEntertainmentBenefitsPage: HttpRequestBuilder = http("Get Travel And Entertainment Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/travel-entertainment?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrEntertainmentBenefitsPage: HttpRequestBuilder = http("Post Travel And Entertainment Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/travel-entertainment?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelOrSubsistenceBenefitsPage: HttpRequestBuilder = http("Get Travel Or Subsistence Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/travel-subsistence?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrSubsistenceBenefitsPage: HttpRequestBuilder = http("Post Travel Or Subsistence Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/travel-subsistence?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTravelOrSubsistenceAmountBenefitsPage: HttpRequestBuilder = http("Get Travel Or Subsistence Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/travel-subsistence-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTravelOrSubsistenceAmountBenefitsPage: HttpRequestBuilder = http("Post Travel Or Subsistence Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/travel-subsistence-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getIncidentalOvernightCostsBenefitsPage: HttpRequestBuilder = http("Get Incidental Overnight Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/incidental-overnight-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncidentalOvernightCostsBenefitsPage: HttpRequestBuilder = http("Post Incidental Overnight Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/incidental-overnight-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncidentalOvernightCostsAmountBenefitsPage: HttpRequestBuilder = http("Get Incidental Overnight Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/incidental-overnight-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncidentalOvernightCostsAmountBenefitsPage: HttpRequestBuilder = http("Post Incidental Overnight Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/incidental-overnight-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getEntertainmentBenefitsPage: HttpRequestBuilder = http("Get Entertainment Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/entertainment-expenses?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEntertainmentBenefitsPage: HttpRequestBuilder = http("Post Entertainment Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/entertainment-expenses?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEntertainmentAmountBenefitsPage: HttpRequestBuilder = http("Get Entertainment Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/entertainment-expenses-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEntertainmentAmountBenefitsPage: HttpRequestBuilder = http("Post Entertainment Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/entertainment-expenses-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "500")
    .check(status.is(303))

  def getUtilitiesBenefitsPage: HttpRequestBuilder = http("Get Utilities Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/utility-general-service?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postUtilitiesBenefitsPage: HttpRequestBuilder = http("Post Utilities Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/utility-general-service?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTelephoneBenefitsPage: HttpRequestBuilder = http("Get Telephone Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/telephone?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTelephoneBenefitsPage: HttpRequestBuilder = http("Post Telephone Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/telephone?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTelephoneAmountBenefitsPage: HttpRequestBuilder = http("Get Telephone Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/telephone-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTelephoneAmountBenefitsPage: HttpRequestBuilder = http("Post Telephone Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/telephone-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "600")
    .check(status.is(303))

  def getEmployerServicesBenefitsPage: HttpRequestBuilder = http("Get Employer Services Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/employer-provided-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEmployerServicesBenefitsPage: HttpRequestBuilder = http("Post Employer Services Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/employer-provided-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEmployerServicesAmountBenefitsPage: HttpRequestBuilder = http("Get Employer Services Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/employer-provided-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEmployerServicesAmountBenefitsPage: HttpRequestBuilder = http("Post Employer Services Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/employer-provided-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getProfessionalFeesBenefitsPage: HttpRequestBuilder = http("Get Professional Fees Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/professional-fees-or-subscriptions?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postProfessionalFeesBenefitsPage: HttpRequestBuilder = http("Post Professional Fees Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/professional-fees-or-subscriptions?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getProfessionalFeesAmountBenefitsPage: HttpRequestBuilder = http("Get Professional Fees Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/professional-fees-or-subscriptions-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postProfessionalFeesAmountBenefitsPage: HttpRequestBuilder = http("Post Professional Fees Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/professional-fees-or-subscriptions-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "800")
    .check(status.is(303))

  def getOtherServicesBenefitsPage: HttpRequestBuilder = http("Get Other Services Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/other-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherServicesBenefitsPage: HttpRequestBuilder = http("Post Other Services Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/other-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherServicesAmountBenefitsPage: HttpRequestBuilder = http("Get Other Services Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/other-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherServicesAmountBenefitsPage: HttpRequestBuilder = http("Post Other Services Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/other-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getMedicalDentalChildcareBenefitsPage: HttpRequestBuilder = http("Get Medical Dental Childcare Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental-childcare-education-loans?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalChildcareBenefitsPage: HttpRequestBuilder = http("Post Medical Dental Childcare Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental-childcare-education-loans?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMedicalDentalBenefitsPage: HttpRequestBuilder = http("Get Medical Dental Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalBenefitsPage: HttpRequestBuilder = http("Post Medical Dental Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getMedicalDentalAmountBenefitsPage: HttpRequestBuilder = http("Get Medical Dental Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postMedicalDentalAmountBenefitsPage: HttpRequestBuilder = http("Post Medical Dental Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/medical-dental-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getChildcareBenefitsPage: HttpRequestBuilder = http("Get Childcare Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/childcare?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postChildcareBenefitsPage: HttpRequestBuilder = http("Post Childcare Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/childcare?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getChildcareAmountBenefitsPage: HttpRequestBuilder = http("Get Childcare Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/childcare-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postChildcareAmountBenefitsPage: HttpRequestBuilder = http("Post Childcare Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/childcare-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getEducationalServicesBenefitsPage: HttpRequestBuilder = http("Get Educational Services Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/educational-services?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEducationalServicesBenefitsPage: HttpRequestBuilder = http("Post Educational Services Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/educational-services?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getEducationalServicesAmountBenefitsPage: HttpRequestBuilder = http("Get Educational Services Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/educational-services-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postEducationalServicesAmountBenefitsPage: HttpRequestBuilder = http("Post Educational Services Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/educational-services-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getBeneficialLoansBenefitsPage: HttpRequestBuilder = http("Get Beneficial Loans Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/beneficial-loans?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postBeneficialLoansBenefitsPage: HttpRequestBuilder = http("Post Beneficial Loans Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/beneficial-loans?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getBeneficialLoansAmountBenefitsPage: HttpRequestBuilder = http("Get Beneficial Loans Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/beneficial-loans-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postBeneficialLoansAmountBenefitsPage: HttpRequestBuilder = http("Post Beneficial Loans Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/beneficial-loans-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "900")
    .check(status.is(303))

  def getIncomeTaxOrIncurredCostsBenefitsPage: HttpRequestBuilder = http("Get Income Tax of Incurred Costs Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax-or-incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxOrIncurredCostsBenefitsPage: HttpRequestBuilder = http("Post Income Tax of Incurred Costs Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax-or-incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncomeTaxBenefitsPage: HttpRequestBuilder = http("Get Income Tax Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxBenefitsPage: HttpRequestBuilder = http("Post Income Tax Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncomeTaxAmountBenefitsPage: HttpRequestBuilder = http("Get Income Tax Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncomeTaxAmountBenefitsPage: HttpRequestBuilder = http("Post Income Tax Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/employer-income-tax-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getIncurredCostsBenefitsPage: HttpRequestBuilder = http("Get Incurred Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncurredCostsBenefitsPage: HttpRequestBuilder = http("Post Incurred Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/incurred-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getIncurredCostsAmountBenefitsPage: HttpRequestBuilder = http("Get Incurred Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/incurred-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postIncurredCostsAmountBenefitsPage: HttpRequestBuilder = http("Post Incurred Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/incurred-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "700")
    .check(status.is(303))

  def getReimbursedCostsVouchersNonCashBenefitsPage: HttpRequestBuilder = http("Get Reimbursed Costs, Vouchers and Non Cash Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/reimbursed-costs-vouchers-non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postReimbursedCostsVouchersNonCashBenefitsPage: HttpRequestBuilder = http("Post Reimbursed Costs, Vouchers and Non Cash Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/reimbursed-costs-vouchers-non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonTaxableCostsBenefitsPage: HttpRequestBuilder = http("Get Non-Taxable Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonTaxableCostsBenefitsPage: HttpRequestBuilder = http("Post Non-Taxable Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonTaxableCostsAmountBenefitsPage: HttpRequestBuilder = http("Get Non-Taxable Costs Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonTaxableCostsAmountBenefitsPage: HttpRequestBuilder = http("Post Non-Taxable Costs Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getTaxableCostsBenefitsPage: HttpRequestBuilder = http("Get Taxable Costs Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTaxableCostsBenefitsPage: HttpRequestBuilder = http("Post Taxable Costs Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/taxable-costs?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getTaxableCostsAmountBenefitsPage: HttpRequestBuilder = http("Get Taxable Costs Amount Benefits Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postTaxableCostsAmountBenefitsPage: HttpRequestBuilder = http("Post Taxable Costs Amount Benefits Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/taxable-costs-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getVouchersOrCreditCardsBenefitsPage: HttpRequestBuilder = http("Get Vouchers or Credit Cards Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/vouchers-or-credit-cards?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postVouchersOrCreditCardsBenefitsPage: HttpRequestBuilder = http("Post Vouchers or Credit Cards Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/vouchers-or-credit-cards?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getVouchersOrCreditCardsAmountBenefitsPage: HttpRequestBuilder = http("Get Vouchers or Credit Cards Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/vouchers-or-credit-cards-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postVouchersOrCreditCardsAmountBenefitsPage: HttpRequestBuilder = http("Post Vouchers or Credit Cards Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/vouchers-or-credit-cards-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getNonCashBenefitsPage: HttpRequestBuilder = http("Get Non-Cash Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonCashBenefitsPage: HttpRequestBuilder = http("Post Non-Cash Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-cash-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getNonCashAmountBenefitsPage: HttpRequestBuilder = http("Get Non-Cash Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/non-cash-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postNonCashAmountBenefitsPage: HttpRequestBuilder = http("Post Non-Cash Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/non-cash-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getOtherBenefitsPage: HttpRequestBuilder = http("Get Other Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/other-benefits?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherBenefitsPage: HttpRequestBuilder = http("Post Other Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/other-benefits?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getOtherBenefitsAmountPage: HttpRequestBuilder = http("Get Other Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/other-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postOtherBenefitsAmountPage: HttpRequestBuilder = http("Post Other Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/other-benefits-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getAssetsOrAssetsTransferBenefitsPage: HttpRequestBuilder = http("Get Assets or Assets Transfer Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/assets?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsOrAssetsTransferBenefitsPage: HttpRequestBuilder = http("Post Assets or Assets Transfer Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/assets?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsBenefitsPage: HttpRequestBuilder = http("Get Assets Available for Use Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/assets-available-for-use?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsBenefitsPage: HttpRequestBuilder = http("Post Assets Available for Use Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/assets-available-for-use?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsBenefitsAmountPage: HttpRequestBuilder = http("Get Assets Available for Use Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/assets-available-for-use-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsBenefitsAmountPage: HttpRequestBuilder = http("Post Assets Available for Use Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/assets-available-for-use-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

  def getAssetsTransferBenefitsPage: HttpRequestBuilder = http("Get Assets Transfer Benefits Question Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/assets-to-keep?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsTransferBenefitsPage: HttpRequestBuilder = http("Post Assets Transfer Benefits Question Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/assets-to-keep?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("value", true)
    .check(status.is(303))

  def getAssetsTransferBenefitsAmountPage: HttpRequestBuilder = http("Get Assets Transfer Benefits Amount Page")
    .get(s"${employmentsUrl(taxYearEOY)}/benefits/assets-to-keep-amount?employmentId=$employmentIdWithNoBenefits")
    .check(status.is(200))

  def postAssetsTransferBenefitsAmountPage: HttpRequestBuilder = http("Post Assets Transfer Benefits Amount Page")
    .post(s"${employmentsUrl(taxYearEOY)}/benefits/assets-to-keep-amount?employmentId=$employmentIdWithNoBenefits")
    .formParam("""csrfToken""", """${csrfToken}""")
    .formParam("amount", "100")
    .check(status.is(303))

}
