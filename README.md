# annuity


### Build Project:
```
$ mvn clean install
```


### Run CLI:
After building,
```
$ cd annuityCli
$ java -jar annuityCli-0.0.1-SNAPSHOT-jar-with-dependencies.jar <loanAmount> <percentRate> <months> <utcStartDateTime>
```


#### Start Server:
After building,
```
$ cd annuityServer
$ mvn spring-boot:run
```
At this points POST requests can be made to `http://localhost:8080/generate-plan`.
