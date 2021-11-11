#!/bin/bash

sbt -Dperftest.runSmokeTest=true -DrunLocal=true -DjourneyType=nrs-proxy-journey gatling:test

