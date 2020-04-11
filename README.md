# features.togglz
Togglz is an implementation of the Feature Toggles pattern for Java. Feature Toggles are a very common agile development practices in the context of continuous deployment and delivery. The basic idea is to associate a toggle with each new feature you are working on. This allows you to enable or disable these features at application runtime, even for individual users.

#Getting Started
For Spring Boot 2.x support, add the Togglz Spring Boot Starter to your project packages file:

#Feature API
1. GetAll Feature API
    Method : Get
    URL: http://localhost:8080/features

2. Feature Toggle Flag API
    Method : Post
    Url :http://localhost:8080/features/<featureName>/toggle
    requestBody:{}

3. Add and Update Feature Parameter API
    Method : Post
    URL : http://localhost:8080/features/<featureName>/parameters
    requestBody: {"parameters": { "secondProperties": "312.00" }}


#SQL TABLE (Auto Creation):
SELECT * FROM features;

#Disturbuted Server Cache:
-->Auto Enabled
-->ExpireTime set as 100000MS




