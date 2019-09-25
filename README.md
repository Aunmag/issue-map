# Issue Map

### Build
- Install JDK 10
    - Get it [here](https://www.azul.com/downloads/zulu-community) (you might need to enable "Older Zulu versions" option)
    - Extract the archive anywhere you want JDK to be
    - Set `JAVA_HOME` system variable with path to JDK (e.g. `export JAVA_HOME=/usr/lib/jvm/jdk-10-zulu` on Linux)
    - Add `${JAVA_HOME}/bin` to your system path (e.g. `export PATH=$JAVA_HOME/bin:$PATH` on Linux)
    - Verify that JDK is installed. Run `java --version` and you should see something like this:
        ```
        openjdk 10.0.2 2018-07-17
        OpenJDK Runtime Environment Zulu10.3+5 (build 10.0.2+13)
        OpenJDK 64-Bit Server VM Zulu10.3+5 (build 10.0.2+13, mixed mode)
        ```
- Install [SBT](https://scala-sbt.org/download)
- Clone this repository and go to its directory
- Run `sbt run` to launch the app in development mode
- Optional. For IntelliJ IDEA users:
    - Install [SBT plugin](https://plugins.jetbrains.com/plugin/5007-sbt)
    - Import the project following [instructions](https://www.jetbrains.com/help/idea/sbt-support.html)
