# Commerce - Itinerary Vacation Engine (IVE)

Commerce IVE Service is a Reactive Java 8 application with Lagom framework.

## Setting up the development environment:

#### Prerequisites

    * Java 1.8
    * Maven 4.0
    * Eclipse 4.6 or later
    * DataStax DevCenter (free after registration)
    * Postman
    * Ubuntu Linux (optional, for docker)
    * Swagger Editor (optional, for *.yaml schema)
    

####Getting the Project

#####Clone project:  
`https://git@bitbucket.org/royal-digital/commerce-ive.git


#### Steps to setup Eclipse development environment 
 * Get the latest Eclipse (Neon.x for example, which comes with internal maven m2e) 
 * Go to Marketplace and install "m2e-apt" plugin 
 * After install, to to Preferences > Maven > Annotation Processing, select the first "Automatically..." 
 * Git clone the repository above, and use "develop" branch by default 
 * After pull the latest from develop branch, clean and build automatically 
 * To run the project, right lick on pom.xml in commerce-ive-poc project, Run As... > Maven build... > put the goal as "lagom:runAll"
This will start Cassandra, Kafka and all microservices. You can open http://localhost:9000 in browser to see available services
Find *.json samples in test folders 



#####Create executable jar:  
`mvn package -DskipTests`

#####Pull Request template:
PullRequest.md

#####Steps to setup Kafka and Cassandra
https://royal-digital.atlassian.net/wiki/display/MID/Steps+to+use+Kafka-Docker+and+Cassandra

#####Command to start the project

`mvn lagom:runAll`

#####Application runs on ports:

IVE-get-myitinerary:    	http://localhost:9001  
IVE-add-update-calendarr:	http://localhost:9002  

## Json Formats for different Rest services:
https://royal-digital.atlassian.net/wiki/display/MID/Json+Formats+for+different+Rest+services

## Tools Integrated:
https://royal-digital.atlassian.net/wiki/display/MID/Tools+integrated

## How to create build + docker image + push image to docker registry ##

### Trust the SSL certificate for DEV/TEST docker registry

* Remember sudo will ask you for your Linux box password for permission. This may not be your network password
* Save the e-mail attachment `aws_dev_test_crt.txt` into your Linux box, for example the Downloads directory
* Copy the actual certificate to /usr/share/ca-certificates
`sudo cp /home/<your_download_directory>/aws_dev_test.crt.txt /usr/share/ca-certificates/aws_dev_test.crt`
* Modify the index file to include the latest certificate
`sudo vi /etc/ca-certificates.conf`
(go to the end of the file and add the new file name)
`aws_dev_test.crt`
* `sudo update-ca-certificates`
You should see one certificate is updated
* `sudo service docker stop`
* `sudo service docker start`

### Push image to docker registry
* `sudo docker login -u <network id> rhldcmesboot711.na.rccl.com:5000`
* `sudo docker build -t "rhldcmesboot711.na.rccl.com:5000/<your-project>/<your-image-name>:latest" .`
* `sudo docker push "rhldcmesboot711.na.rccl.com:5000/<your-project>/<your-image-name>:latest"`
* `curl -k https://rhldcmesboot711.na.rccl.com:5000/v2/_catalog`

# DC/OS DEV
https://10.16.7.225/#/login

##Kafka testing
`./kafka-console-producer.sh --broker-list localhost:9092 --topic ive.topic.cruise.planner.event`
`./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ive.topic.cruise.planner.event --from-beginning`

##Splunk devtest
http://10.16.4.95:8000/en-US/account/login?return_to=%2Fen-US%2Fapp%2Flauncher%2Fhome


##integrating Taurus for local

## installation:
	* Follow the steps on `https://gettaurus.org/install/Installation/` to install Taurus at local
## Execution:
	* Create directory named `taurus`
	* cd taurus
	* create gatling_request.yml
	* $ bzt gatling_request.yml
## Check if  DIRETORY named by the current system time is made containing the Simlations for the Test Cases.
	* open index.html to view the test case report existing in the perticular test cases directory.
