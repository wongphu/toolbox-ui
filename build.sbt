enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := false

lazy val root = project
  .in(file("."))
  .settings(
    name := "ToolboxUI",
    version := "0.1",
    scalaVersion := "3.3.0"
)

libraryDependencies ++= Seq(
  ("com.dedipresta" %%% "scala-crypto" % "1.0.0").cross(CrossVersion.for3Use2_13),
  "com.raquo" %%% "laminar" % "16.0.0",
  "io.github.cquiroz" %%% "scala-java-time" % "2.5.0",
  ("org.scala-js" %%% "scalajs-java-securerandom" % "1.0.0").cross(CrossVersion.for3Use2_13),
  "org.scala-js" %%% "scala-js-macrotask-executor" % "1.1.1",
)
