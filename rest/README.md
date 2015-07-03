# REST XML/JSON Response example

This example shows how to return XML or JSON responses depending on Accept typo or endpoint.

## Compiling and Running

To compile the application:

    mvn clean package

To run the application:

    java -jar target/rest-example.jar

## Test Cases
 
curl --header "Accept: application/json" http://localhost:8080/ | jq '.'

curl --header "Accept: application/xml" http://localhost:8080/ | xml fo

curl --header "Accept: application/json" http://localhost:8080/xml | jq '.'

curl --header "Accept: application/xml" http://localhost:8080/json | jq '.'

curl --header "Accept: application/json" http://localhost:8080/json | jq '.'

curl http://localhost:8080/json | jq '.'

curl --header "Accept: application/json" http://localhost:8080/xml | jq '.'

curl --header "Accept: application/xml" http://localhost:8080/xml | xml fo

curl http://localhost:8080/xml |  xml fo