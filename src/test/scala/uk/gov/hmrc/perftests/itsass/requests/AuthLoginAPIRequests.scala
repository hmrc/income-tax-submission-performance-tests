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

package uk.gov.hmrc.perftests.itsass.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import org.joda.time.DateTime
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.utils.NumberGenerator.{randomAlphanumeric, randomNumber}

object AuthLoginAPIRequests extends ServicesConfiguration {

  val authBaseUrl: String = baseUrlFor("auth-login-api")
  val authLoginApiUrl: String = s"$authBaseUrl/government-gateway/session/login"

  val Admin: String = "Admin"
  val User: String = "User"

  val Agent: String = "Agent"
  val Individual: String = "Individual"

  def insertAuthRecordInd(simNino: String, simMtditid: String): HttpRequestBuilder = http("Insert Auth Record Individual")
    .post(authLoginApiUrl)
    .body(StringBody(authPayload(Individual, simNino, simMtditid, None)))
    .headers(Map("Content-Type" -> "application/json"))
    .check(status.is(201))
    .check(header("Authorization").saveAs("bearerToken"))

  def insertAuthRecordAgent(simNino: String, simMtditid: String, simArn: Option[String]): HttpRequestBuilder = http("Insert Auth Record Agent")
    .post(authLoginApiUrl)
    .body(StringBody(authPayload(Agent, simNino, simMtditid, simArn)))
    .headers(Map("Content-Type" -> "application/json"))
    .check(status.is(201))
    .check(header("Authorization").saveAs("bearerToken"))

  def authPayload(affinityGroup: String, nino: String, mtditid: String, arn: Option[String]): String = {

    val credentialRole = if (affinityGroup == Agent) Admin else User
    val enrolments = if (affinityGroup == Agent) agentEnrolment(arn) else saEnrolment(mtditid)
    val delegatedEnrolments = if (affinityGroup == Agent) saDelegatedEnrolment(mtditid) else "[]"
    val ninoToUse = nino

    val itmpData: String =
      s""" {
         |    "givenName":"Testy",
         |    "middleName":"Gerald",
         |    "familyName":"McTestface",
         |    "birthdate":"1990-12-30",
         |    "address":{
         |       "line1":"line 1",
         |       "line2":"line 2",
         |       "line3":"line 3",
         |       "line4":"line 4",
         |       "line5":"line 5",
         |       "postCode":"TF3 4ER",
         |       "countryName":"United Kingdom",
         |       "countryCode":"UK"
         |    }
         |  } """.stripMargin

    def authPayload: String =
      s"""
         | {
         |  "internalId": "Int-${randomAlphanumeric(8)}-d983-472d-9971-ddca5f124641",
         |  "externalId": "Ext-${randomAlphanumeric(8)}-ac7a-4cc2-950a-19e6fac91f2a",
         |  "agentCode" : "",
         |  "credentials": {
         |    "providerId": "${randomNumber(100000, 999999)}3381064832",
         |    "providerType": "GovernmentGatewayTest"
         |  },
         |  "confidenceLevel": 250,
         |  "nino": "$ninoToUse",
         |  "usersName": "test",
         |  "agentInformation": {},
         |  "credentialRole": "$credentialRole",
         |  "affinityGroup": "$affinityGroup",
         |  "credentialStrength": "strong",
         |  "loginTimes": {
         |    "currentLogin": "${DateTime.now}",
         |    "previousLogin": "${DateTime.parse("2018-03-01T12:00:00.000Z")}"
         |  },
         |  "credId": "${randomAlphanumeric(16)}",
         |  "enrolments": $enrolments,
         |  "delegatedEnrolments": $delegatedEnrolments,
         |  "itmpData": $itmpData
         | }
     """.stripMargin

    authPayload
  }

  def saEnrolment(mtditidToUse: String): String =
    s""" [
       |   {
       |     "key": "HMRC-MTD-IT",
       |     "identifiers": [
       |       {
       |         "key": "MTDITID",
       |         "value": "$mtditidToUse"
       |       }
       |     ],
       |     "state": "Activated"
       |   }
       |  ] """.stripMargin

  def saDelegatedEnrolment(mtditidToUse: String): String =
    s""" [
       |    {
       |      "key": "HMRC-MTD-IT",
       |      "identifiers": [
       |        {
       |          "key": "MTDITID",
       |           "value": "$mtditidToUse"
       |        }
       |      ],
       |      "delegatedAuthRule": "mtd-it-auth"
       |    }
       |  ] """.stripMargin

  def agentEnrolment(arnToUse: Option[String]): String =
    s""" [
       |   {
       |     "key": "HMRC-AS-AGENT",
       |     "identifiers": [
       |       {
       |         "key": "AgentReferenceNumber",
       |         "value": "$arnToUse"
       |       }
       |     ],
       |     "state": "Activated"
       |   }
       |  ] """.stripMargin

}
