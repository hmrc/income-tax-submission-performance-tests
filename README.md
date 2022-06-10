# income-tax-submission-performance-tests
Performance test suite for the Income Tax Submission Service, using [performance-test-runner](https://github.com/hmrc/performance-test-runner) under the hood.

## Running the tests

Prior to executing the tests ensure you have:

* A Mongo service or Docker container running
* Installed/configured service manager

Run the following command to start the services locally:
```

sm --start INCOME_TAX_SUBMISSION_ALL -r

```

## Logging

The template uses [logback.xml](src/test/resources) to configure log levels. The default log level is *WARN*. This can be updated to use a lower level for example *TRACE* to view the requests sent and responses received during the test.

#### Smoke test

It might be useful to try the journey with one user to check that everything works fine before running the full performance test
```
sbt -Dperftest.runSmokeTest=true -DrunLocal=true -Dperftest.labels=journeyFlows gatling:test

-------------------------------OR----------------------------

./run_smoke_tests.sh
```
This will run all the available journeys in the simulation except for the NRS Journey. 

If you just wish to run the NRS Requests, this is labelled as *"nrsProxy"*. You can do so with the following

```
sbt -Dperftest.runSmokeTest=true -DrunLocal=true -Dperftest.labels=nrsProxy gatling:test

-------------------------------OR----------------------------

./run_nrs_smoke_tests.sh
```

#### Running the performance test
```
sbt -DrunLocal=true -Dperftest.labels=journeyFlows gatling:test

-------------------------------OR----------------------------

sbt -DrunLocal=true -Dperftest.labels=nrsProxy gatling:test
```
### Run the test against staging environment

#### Smoke test
```
./run_smoke_tests_staging.sh

-------------------------------OR----------------------------

sbt -Dperftest.runSmokeTest=true -DrunLocal=false -Dperftest.labels=journeyFlows gatling:test

-------------------------------OR----------------------------

sbt -Dperftest.runSmokeTest=true -DrunLocal=false -Dperftest.labels=nrsProxy gatling:test
```

#### Run the performance test

To run a full performance test against staging environment, implement a job builder and run the test **only** from Jenkins.
