name := "KeyCodex"

version := "1.0"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"

// https://mvnrepository.com/artifact/com.nulab-inc/zxcvbn
//https://github.com/nulab/zxcvbn4j
libraryDependencies += "com.nulab-inc" % "zxcvbn" % "1.2.3"