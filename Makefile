fast:
	sbt fastOptJS
	cp target/scala-3.3.0/toolboxui-fastopt/main.js docs/

opt:
	sbt fullOptJS
	cp target/scala-3.3.0/toolboxui-opt/main.js docs/
