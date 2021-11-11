package uk.gov.hmrc.perftests.itsass.Json

object NRSRequest {

  val submitNrsStatement: String =
    s"""
       |{
       |  "typeOfBusiness": "self-employment",
       |  "businessId": "XAIS12345678910",
       |  "accountingPeriod" : {
       |     "startDate": "2021-04-06",
       |     "endDate": "2022-04-05"
       |  },
       |  "finalised": true
       |}
    """.stripMargin

}