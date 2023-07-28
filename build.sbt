enablePlugins(ScalaJSPlugin)

scalaJSUseMainModuleInitializer := false

lazy val root = project
    .in(file("."))
    .settings(
        name := "ToolboxUI",
        version := "0.1",
        scalaVersion := "2.13.10"
    )

libraryDependencies ++= Seq(
    "com.dedipresta" %%% "scala-crypto" % "1.0.0",
    "com.raquo"      %%% "laminar" % "16.0.0",
    "org.scala-js"   %%% "scalajs-java-securerandom" % "1.0.0",
)
