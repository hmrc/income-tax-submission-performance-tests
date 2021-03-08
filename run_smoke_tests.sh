#!/bin/bash

sh insert_perf_data.sh
sbt -Dperftest.runSmokeTest=true -DrunLocal=true gatling:test
curl -X DELETE http://localhost:9303/setup/all-data

