# features.togglz
Feature Toggles (often also refered to as Feature Flags) are a powerful technique, allowing teams to modify system behavior without changing code. They fall into various usage categories, and it's important to take that categorization into account when implementing and managing toggles. Toggles introduce complexity. We can keep that complexity in check by using smart toggle implementation practices and appropriate tools to manage our toggle configuration, but we should also aim to constrain the number of toggles in our system.

Getting Started
For Spring Boot 2.x support, add the Togglz Spring Boot Starter to your project packages file:

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


