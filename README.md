# Mappathon Validation Client 
This project provides a Java Client for the Mappathon Validator. It is a simple JAR file which ease the connection to the Validation Service. 

## Install
1. Download from the repository
2. Add as an external dependency to your project
3. Integrate in our Matching Pipeline for the [Mappathon](https://www.mappathon.de) Challenge
4. Validate your results! 
## Usage

```java
// The Client is a Singleton Object 
MappathonValidatorClient client = MappathonValidatorClient.getInstance();
// all the needed parameters
String yourEmail = "";
TrainingSet set = TrainingSet.TS1;
ArrayList<String> data = new ArrayList<String>();
data.add("(S.0011_IG.4_I.18)-[:equivalent]->(S.0021_IG.1_I.4)");

// The client checks the inputs if the syntax is correct using regex statement 
// and throwns an InputExceptions if anything is incorrect.

try {
        ValidationResponse response = client.validate(email,set,data);
    } catch (Exception e) {
        e.printStackTrace();
    }
```
