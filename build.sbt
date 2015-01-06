organization := "com.lunatech"

name := "specs2-mongo"

description := "Tools that allow specs2 tests to use their own MongoDB instance"

crossScalaVersions := Seq("2.10.0", "2.11.0")

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.13" % "provided",
  "de.flapdoodle.embed" % "de.flapdoodle.embed.mongo" % "1.43"
)

publishTo  := {
  val artifactory = "http://artifactory.lunatech.com/artifactory/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("releases" at artifactory + "snapshots-public")
  else
    Some("snapshots" at artifactory + "releases-public")
}

releaseSettings
