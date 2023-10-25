Calculator :

1) building  and run the application use below 2 steps
   ------------------------------------------------------------------
       3.1) mvn clean install
    	3.2) goto target and run below 
        java -jar Calculator-0.0.1-SNAPSHOT.jar

2)Sample Request - Response:

      Request: GET /calculatorapi/v1/addition?number1=12&number2=15 
      Response: { "answer": 27, "detail": "12 + 15 = 27" }

      Request: GET /calculatorapi/v1/subtraction?number1=12&number2=15
      Response: { "answer": -3, "detail": "12 - 15 = -3" }

      Request: GET /calculatorapi/v1/multiplication?number1=12&number2=15
      Response: { "answer": 180, "detail": "12 * 15 = 180" }

      Request: GET /calculatorapi/v1/division?number1=12&number2=15
      Response: { "answer": 0.8, "detail": "12 / 15 = 0.8" }

      Request: GET /calculatorapi/v1/square/{5}
      Response: { "answer": 25, "detail": "square of 5 = 25" }

      Request: GET /calculatorapi/v1/squareroot/{225}
      Response: { "answer": 15, "detail": "squareroot of 225 = 15" }

      Request: GET /calculatorapi/v1/factorial/{5}
      Response: { "answer": 120, "detail": "5! = 120" }

      Request: POST /calculatorapi/v1/min-max
      Body { "numbers" : [10,-5,7,15,-7,-6,16,19,-15,9] }
      Response: { "min": -15, "max": 19 }