name := """issue-map"""

version := "1.0"
lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.6"
crossScalaVersions := Seq("2.11.12", "2.12.4")

testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a", "-v"))

// Disable API documentation generation:
sources in (Compile, doc) := Seq.empty
publishArtifact in (Compile, packageDoc) := false

// Play:
libraryDependencies += guice
libraryDependencies += "com.h2database" % "h2" % "1.4.197"
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test
libraryDependencies += "javax.xml.bind" % "jaxb-api" % "2.3.0" // fixes `Error injecting constructor, java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException`
libraryDependencies += "com.lightbend.play" %% "play-file-watch" % "1.1.3"

// Tools:
libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.8.1"
libraryDependencies += "com.vividsolutions" % "jts" % "1.13"
libraryDependencies += "org.jetbrains" % "annotations" % "16.0.2"

// Web:
libraryDependencies += "org.webjars" % "bootstrap" % "4.1.3"
libraryDependencies += "org.webjars" % "vue" % "2.6.10"
libraryDependencies += "org.webjars" % "leaflet" % "1.5.1"
