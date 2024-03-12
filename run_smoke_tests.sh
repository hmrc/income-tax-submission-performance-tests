#!/bin/bash

sbt -Dperftest.runSmokeTest=true -DrunLocal=true -Dperftest.labels=journeyFlows gatling:test
