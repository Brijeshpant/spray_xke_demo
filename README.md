

Routes =>

Directive 


get
post
put 
delete

path
pathPrefix

path with /IntNumber /Segment 

parameters 


parameter convert to case classes 

entity to except json



Create

curl -XPOST -i 'http://localhost:8080/api/xke' -d '{"topic":"SPray","presenter":"Brij","xkeType":"Tech"}' -H Content-type:"application/json"

Get

curl -i 'http://localhost:8080/user' -d '["brij"]' -H Content-Type:"Application/Json"