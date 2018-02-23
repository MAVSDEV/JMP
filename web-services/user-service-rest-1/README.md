User Rest API

_To test rest api you can use local setup and Heroku:_
https://user-service-test.herokuapp.com

* Upload images works only in local setup. Due to Heroku has ephemeral filesystem.

**Get all users:**                  
`GET     /api/v1/user/all`
                
**Get user by id:**                    
`GET     /api/v1/user/:id`

**Download user image**     
`GET     /api/v1/user/:userId/image      `

**Update user information**         
`PUT     /api/v1/user/update      `       

**Save user information**  
`POST    /api/v1/user/save  `             

**Save user image**             
`POST    /api/v1/user/:userId/image/save `

**Delete user information**  
`DELETE  /api/v1/user/delete/:id    `     

**Upload user image page**     
`GET     /upload-image.html       `    
   
**Open user image**  
`GET     /assets/images/:imageName `


**Example of body to save user:**
`<?xml version="1.0" encoding="utf-8"?><user>
    <id>1</id>
    <login>redo</login>
    <firstName>Petya</firstName>
    <lastName>Petrovich</lastName>
    <email>bla@gmail.com</email>
</user>`

