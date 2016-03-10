name := "sprayXKe"

version := "1.0"

scalaVersion := "2.11.7"
val akkaV = "2.3.6"
val sprayV = "1.3.2"

libraryDependencies ++= {

  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%   "spray-routing" % sprayV,
    "io.spray"            %%   "spray-json" % sprayV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV
      )
}

libraryDependencies += "io.spray" %% "spray-testkit" % sprayV % "test"

Revolver.settings