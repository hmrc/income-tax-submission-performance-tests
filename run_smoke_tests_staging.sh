#!/bin/bash

sbt -Dperftest.runSmokeTest=true -DrunLocal=false -Dperftest.labels=journeyFlows gatling:test

