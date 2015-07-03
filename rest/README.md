# REST XML/JSON Response example

This example shows how to return XML or JSON responses depending on Accept typo or endpoint.

The controller has three endpoints:
 
- `/json`: returns only json objects.
- `/xml`: returns only xml objects.
- `/`: returns either json or xml depending on the Accept header.

## Compiling and Running

To compile the application:

    mvn clean package

To run the application:

    java -jar target/rest-example.jar

## Test Cases
 
### 1. Testing /json endpoint with no header parameters

**Request:**

    curl http://localhost:8080/json | jq '.'

**Response:**

    {
      "code": "json-example",
      "message": "Hello World JSON!"
    }

### 2. Testing /json endpoint with "Accept: application/xml" header parameters

**Request:**

    curl -i --header "Accept: application/xml" http://localhost:8080/json

**Response:**

Should respond with a 406 error code.

    HTTP/1.1 406 Not Acceptable
    Server: Apache-Coyote/1.1
    Content-Length: 0
    Date: <date>

### 3. Testing /json endpoint with "Accept: application/json" header parameters

**Request:**

    curl --header "Accept: application/json" http://localhost:8080/json | jq '.'

**Response:**

    {
      "code": "json-example",
      "message": "Hello World JSON!"
    }
 
### 4. Testing /xml endpoint with no header parameters

**Request:**

    curl http://localhost:8080/xml |  xml fo

**Response:**

    <message>
      <code>xml-example</code>
      <message>Hello World XML!</message>
    </message>
 
### 5. Testing /xml endpoint with "Accept: application/json" header parameters

**Request:**

    curl --header "Accept: application/json" http://localhost:8080/xml | jq '.'

**Response:**

Should respond with a 406 error code.

    {
      "timestamp": 1435922830806,
      "status": 406,
      "error": "Not Acceptable",
      "exception": "org.springframework.web.HttpMediaTypeNotAcceptableException",
      "message": "Could not find acceptable representation",
      "path": "/xml"
    }
 
### 6. Testing /xml endpoint with "Accept: application/xml" header parameters

**Request:**

    curl --header "Accept: application/xml" http://localhost:8080/xml | xml fo

**Response:**

    <message>
      <code>xml-example</code>
      <message>Hello World XML!</message>
    </message>
 
### 7. Testing / endpoint with no header parameters

**Request:**

    curl http://localhost:8080/ | jq '.'

**Response:**

    {
      "code": "rest-example",
      "message": "Hello World!"
    } 

### 8. Testing / endpoint with "Accept: application/json" header parameters

**Request:**

    curl --header "Accept: application/json" http://localhost:8080/ | jq '.'

**Response:**

    {
      "code": "rest-example",
      "message": "Hello World!"
    }
 
### 9. Testing / endpoint with "Accept: application/xml" header parameters

**Request:**

    curl --header "Accept: application/xml" http://localhost:8080/ | xml fo

**Response:**

    <message>
      <code>rest-example</code>
      <message>Hello World!</message>
    </message>
 