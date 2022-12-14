ThisBuild / scalaVersion     := "2.13.9"
ThisBuild / version          := "0.1.1"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"
ThisBuild / name             := "OpenBankingAuthService"

lazy val root = (project in file("."))
    .settings(
        name := "auth",
        libraryDependencies ++= Seq(
            "dev.zio"              %% "zio"            % "2.0.2",
            "dev.zio"              %% "zio-test"       % "2.0.2" % Test,
            "com.github.jwt-scala" %% "jwt-core"       % "9.1.1",
            "dev.zio"              %% "zio-json"       % "0.3.0-RC11",
            "io.d11"               %% "zhttp"          % "2.0.0-RC10",
            "io.getquill"          %% "quill-zio"      % "4.3.0",
            "io.getquill"          %% "quill-jdbc-zio" % "4.3.0",
            "com.h2database"        % "h2"             % "2.1.214",
            "com.github.t3hnar"    %% "scala-bcrypt"   % "4.3.0"
        ),
        testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
    )

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

Docker / packageName        := "openbanking-auth-service"
Docker / dockerExposedPorts := Seq(8070)
