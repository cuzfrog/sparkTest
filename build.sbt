shellPrompt in ThisBuild := { state => Project.extract(state).currentRef.project + "> " }

resolvers ++= Seq(
  "Local Maven Repository" at """file:///""" + Path.userHome.absolutePath +"""\.m2\repository""",
  "bintray-cuzfrog-maven" at "http://dl.bintray.com/cuzfrog/maven"
)


lazy val root = (project in file("."))
  .settings(
    organization := "com.github.cuzfrog",
    name := "spark-test",
    version := Settings.version,
    scalaVersion := Settings.scalaVersion,
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "2.0.0" % "provided",
      "junit" % "junit" % "4.12" % "test",
      "com.novocode" % "junit-interface" % "0.11" % "test->default",
      "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
    ),
    assemblyJarName in assembly := "app.jar",
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)
  )


