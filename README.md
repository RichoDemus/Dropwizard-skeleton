Dropwizard Skeleton
================

Intro
-------
Skeleton project for starting new dropwizard applications
Based on https://dropwizard.github.io/dropwizard/getting-started.html

Usage
-----
mvn clean package && java -jar target/dropwizard-1.0-SNAPSHOT.jar server target/classes/hello-world.yml  

URLs
----
* [Main page](http://localhost:8080)  
* [Api](http://localhost:8080/api/hello-world?name=Successful+Dropwizard+User)  
* [Admin page](http://localhost:8081)
* Run GC by doing a POST on [http://localhost:8081/tasks/gc](http://localhost:8081/tasks/gc)

Misc
----
* Banner created with [Taag](http://patorjk.com/software/taag)