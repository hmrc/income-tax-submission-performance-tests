val appName = "income-tax-submission-performance-tests"
val appVersion = "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(GatlingPlugin)
  .settings(
    name := appName,
    version := appVersion,
    scalaVersion := "2.13.12",
    //implicitConversions & postfixOps are Gatling recommended -language settings
    scalacOptions ++= Seq("-feature", "-language:implicitConversions", "-language:postfixOps"),
    // Enabling sbt-auto-build plugin provides DefaultBuildSettings with default `testOptions` from `sbt-settings` plugin.
    // These testOptions are not compatible with `sbt gatling:test`. So we have to override testOptions here.
    retrieveManaged := true,
    console / initialCommands := "import uk.gov.hmrc._",
    Test / parallelExecution := false,
    Test / publishArtifact := true,
    Test / testOptions := Seq.empty,
    libraryDependencies ++= Dependencies.test
  )
