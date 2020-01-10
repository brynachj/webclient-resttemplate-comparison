# webclient-resttemplate-comparison
A very basic spring boot web app to demonstrate the difference between RestTemplate and WebClient

Run the two services by executing the following commands in separate terminals:

`./gradlew api:bootRun`

`./gradlew tea-service:bootRun`


### Running Gatling Tests
cd into the gatlingtests folder and run the following command for testing the restTemplate:

`./mvnw clean gatling:test -Dgatling.simulationClass=com.brynachj.gatlingtests.api.ActuatorSimulation`

or for webClient:

`./mvnw clean gatling:test -Dgatling.simulationClass=com.brynachj.gatlingtests.api.ActuatorSimulation -DCLIENT=webClient`
