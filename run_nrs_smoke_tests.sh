#!/bin/bash

sbt -Dperftest.runSmokeTest=true -DrunLocal=true -Dperftest.labels=nrsProxy gatling:test
