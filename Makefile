fast:
	sbt fastOptJS
	cp target/scala-2.13/toolboxui-fastopt/main.js webroot/

opt:
	sbt fullOptJS
	cp target/scala-2.13/toolboxui-opt/main.js webroot/
