# Mappathon Validation Client 
This project provides a Java Client for the Mappathon Validator Service. There are two ways to integrate the client into your matching pipeline. 

## Install
### Manual Download
1. Download from the repository
2. Run ```mvn clean package```
3. Add as an external dependency to your project

### Maven Dependency with [Jitpack](https://jitpack.io/) 
1. Add the repository 
```maven
    	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
2. Add the dependency
```maven
   	<dependency>
	    <groupId>com.github.itcr-uni-luebeck</groupId>
	    <artifactId>MappathonValidatorClient</artifactId>
	    <version>1.0.0</version>
	</dependency>
```

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
