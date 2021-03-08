#!/bin/bash

#-----Interest POST Stub Data-----

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/nino/AA111111A/income-source/savings/annual/2022",
	"method":"POST",
	"status":200,
	"response": {
	    "transactionReference": "1111111111111111"
	}
}' \
http://localhost:9303/setup/data

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/income-sources/nino/AA111111A",
	"method":"POST",
	"status":200,
	"response": {
	    "incomeSourceId": "Tesco"
	}
}' \
http://localhost:9303/setup/data

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/nino/AA111112A/income-source/savings/annual/2022",
	"method":"POST",
	"status":200,
	"response": {
	    "transactionReference": "1111111111111112"
	}
}' \
http://localhost:9303/setup/data

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/income-sources/nino/AA111112A",
	"method":"POST",
	"status":200,
	"response": {
	    "incomeSourceId": "Tesco"
	}
}' \
http://localhost:9303/setup/data

#-----Dividends POST Stub Data-----

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/nino/AA111111A/income-source/dividends/annual/2022",
	"method":"POST",
	"status":200,
	"response": {
	    "transactionReference": "1111111111111113"
	}
}' \
http://localhost:9303/setup/data

curl -X POST -H "Content-Type: application/json" \
    -d '{
	"uri": "/income-tax/nino/AA111112A/income-source/dividends/annual/2022",
	"method":"POST",
	"status":200,
	"response": {
	    "transactionReference": "1111111111111113"
	}
}' \
http://localhost:9303/setup/data