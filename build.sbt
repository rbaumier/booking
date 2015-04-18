name := "booking"

version := "1.0"

lazy val `booking` = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc ,
  javaEbean ,
  cache ,
  javaWs ,
  "org.mindrot" % "jbcrypt" % "0.3m"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )
