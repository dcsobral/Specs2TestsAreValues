libraryDependencies += "org.specs2" %% "specs2-core" % "4.6.0" % "test"

scalacOptions in Test ++= Seq("-Yrangepos")
