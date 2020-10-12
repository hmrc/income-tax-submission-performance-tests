#!/bin/bash
sbt -Dperftest.runSmokeTest=true -DrunLocal=true gatling:test