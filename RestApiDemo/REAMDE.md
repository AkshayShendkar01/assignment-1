RestApiDemo :

1) Building  and run the application use below 2 steps
   ------------------------------------------------------------------
        3.1) mvn clean install
    	3.2) goto target and run below 
        java -jar RestApiDemo-0.0.1-SNAPSHOT.jar
      -------------------------------------------------------------------	 

2)Sample Request - Response:

    Request: GET /greetapi/v1/hello
    Response: { Hello World!! }
    
    Request: GET /greetapi/v1/hello?name=Akshya
    Response: { Hello Akshya!! }

    Request: GET /greetapi/v1/hello?fname=Akshya
    Response: {
                timestamp : 2023-10-25T17: 01: 47.736,
                status : 400
                timestamp : Invalid Request Parameter
                path : http: //localhost:8080/greetapi/v1/hello
               }