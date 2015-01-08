Dropwizard Test
================

Intro
-------
Simple program to test Dropwizard  
Based on https://dropwizard.github.io/dropwizard/getting-started.html

Usage
-----
mvn clean package && java -jar target/dropwizard-1.0-SNAPSHOT.jar server target/classes/hello-world.yml  

URLs
----
* [Main page](http://localhost:8080)  
* [Api](http://localhost:8080/api/hello-world?name=Successful+Dropwizard+User)  
* [Admin page](http://localhost:8081)