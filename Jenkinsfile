userInput = params.serviceToDeploy

def options = [ 'sonarqube':true, 'checkmarx':false , 'cxPreset':'RCL-Commerce-All', 'tools':false,'reports':false, 
'jacoco':false, 'apigee':false, 'kafka':false,'perftest':false,'packpublish':true,'deploy':true, 'jenkinsVersioning':true]
def teamName = 'commerce-ive'
def serviceVersion = '1.0.0'

def serviceName = 'get-myitineraries'
def marathonJson = 'VacationItineraryService-impl/app-definition.json'
def serviceImplDir ='VacationItineraryService-impl'
        
if (userInput == 'ALL' || userInput == 'GET')        
	commonChassisBuild (teamName,serviceName,serviceVersion,marathonJson,serviceImplDir,options)

def serviceName2 = 'update-cruiseplannerevents'
def marathonJson2 = 'VacationItineraryStream-impl/app-definition.json'
def serviceImplDir2 ='VacationItineraryStream-impl'

if (userInput == 'ALL' || userInput == 'UPDATE')
	commonChassisBuild (teamName,serviceName2,serviceVersion,marathonJson2,serviceImplDir2,options)