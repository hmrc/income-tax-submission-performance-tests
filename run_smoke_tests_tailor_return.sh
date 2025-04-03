#!/bin/bash

sbt -Dperftest.runSmokeTest=true -DrunLocal=true -Dperftest.labels=tailorReturnFlows gatling:test
