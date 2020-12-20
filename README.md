## Project
Intercash Switch

## Prerequisites
* Java 8
* Eclipse 2019-03
* Eclipse Plugins
    * lombok
    * STS 4

### Tech/frameworks used
* Spring-boot  
* Swagger: for REST API end-points documentation and self-service browser interface
* Log4J2: for logging with roll out configuration
* Lombok: It is a java library that automatically plugs into your editor and build tools, spicing up your java

## Setting up Dev
1. Clone the repository with SSH - git clone https://github.com/vpnmangalkar/intercashswitch.git 
2. Clone the repository with SSH - git clone https://github.com/vpnmangalkar/payment-processor.git 
3. Install Lombok, Refer lombok-plugin.md

### Build
Create a maven goal in eclipse using below steps.
	
1. Right click the project, select "Run as → Maven build..." (notice the "..." at the end)
2. Enter the Goals: clean install
3. Select Apply, then Run
4. The build output will be displayed in the Console.

### Run the application
Start the application from the Boot Dashboard (Window -> Show View -> Boot Dashboard)

## Database Scipts
1. Execute Create Sequence Commands from file db-scripts/sequences.sql

## OpenAPI Doc
Use Link after Application Started for the API docs : http://localhost:8060/swagger-ui/index.html 
