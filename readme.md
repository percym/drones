H2 Database url
http://localhost:7676/drones/h2-console/
![img_5.png](img_5.png)
Database is pre-populated with drone and medication data  
![img_7.png](img_7.png)

![img_8.png](img_8.png)

to download dependencies run   
mvn clean install -DskipTests
![img_1.png](img_1.png)
to execute app
mvn spring-boot:rum
![img_2.png](img_2.png)
if duplicates error shown below
![img_3.png](img_3.png)

delete files under
C:\data
application uses in memory db with file storage
application base url is
localhost:7676/drones/dispatch/
localhost:7676/drones/dispatch/get-all-drones
![img_4.png](img_4.png)



