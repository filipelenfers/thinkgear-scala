name := "thinkgear-scala"

version := "0.1"

scalaVersion := "2.10.3"

scalacOptions ++= List("-deprecation","-feature")

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "net.liftweb" %% "lift-json" % "2.5"
)