# annuity


### Build Project:
```
$ mvn clean install
```


### Run CLI:
After building,
```
$ cd annuityCli/target
$ java -jar annuityCli-0.0.1-SNAPSHOT-jar-with-dependencies.jar <loanAmount> <percentRate> <months> <utcStartDateTime>
```


### Start Server:
After building,
```
$ cd annuityServer
$ mvn spring-boot:run
```
At this points POST requests can be made to `http://localhost:8080/generate-plan`.


### Project Organization
This project is split up into 3 modules. `annuityLib` is the core library which other developers would be able to include as a dependency for other projects. `annuityCli` provides a command line interface for quick access to the utility. Finally `annuityServer` provides a web server that could be accessed remotely by other developers were it to be hosted on the web. The concerns of each module are separated and both the CLI and Server depend on the Lib.
