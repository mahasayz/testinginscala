version := "1.0"

val ourDependencies = Seq(
  "org.apache.kafka" % "kafka-clients" % "0.11.0.1",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test"
)

val commonSettings = Seq(
  organization := "com.maha.testinginscala",
  scalaVersion := "2.11.12",
  crossScalaVersions := Seq(scalaVersion.value, "2.12.4"),
  crossVersion := CrossVersion.binary,
  scalacOptions ++= Seq(
    "-deprecation",
    "-encoding", "UTF-8",       // yes, this is 2 args
    "-feature",
    "-unchecked",
    "-Xlint",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Xfuture"
  )
)

lazy val root =
  project.in( file(".") )
    .settings(commonSettings)
    .settings(Seq(
      name := "testinginscala",
      libraryDependencies ++= ourDependencies
    ))