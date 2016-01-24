lazy val commonSettings = Seq(
  version := "0.0.1",
  scalaVersion := "2.11.7"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .enablePlugins(play.sbt.PlayScala)

libraryDependencies ++= Seq(
  "jp.t2v" %% "play2-auth" % "0.14.1",
  "jp.t2v" %% "play2-auth-test" % "0.14.1" % "test",
  play.sbt.Play.autoImport.cache
)
