organization := "ca.razorfish"

name := "sequence-match"

version := "0.1"

scalaVersion := "2.11.7"

scalacOptions := Seq(
  "-unchecked",
  "-Xlint",
  "-deprecation",
  "-target:jvm-1.7",
  "-encoding", "UTF-8",
  "-Ywarn-dead-code",
  "-language:_",
  "-feature"
)

javacOptions ++= Seq(
  "-XX:MaxPermSize", "128M"
)

resolvers ++= Seq(
  "Typesafe repository snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
  "Typesafe repository releases"  at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype repo"                 at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"             at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"            at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"              at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"    at "http://download.java.net/maven/2/"
)

libraryDependencies ++= {
  val scalaTestV    = "2.2.2"
  val nscalaTimeV   = "1.4.0"
  val jodaV         = "2.4"
  Seq(
    "com.github.nscala-time" %% "nscala-time" % nscalaTimeV 
    ,"joda-time"             %  "joda-time"    % jodaV
    ,"org.slf4j"             %  "slf4j-api"    % "1.7.7"
    ,"ch.qos.logback"        %  "logback-core" % "1.1.3"
    ,"ch.qos.logback"        %  "logback-classic" % "1.1.3"
    ,"org.scalaz"            %% "scalaz-core"  % "7.1.4"
    ,"org.scalatest"         %% "scalatest"    % scalaTestV  % "test"
    ,"org.scalacheck"        %% "scalacheck"   % "1.12.2"    % "test"
  )
}
