package io.theja.jwtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtServerApplication.class, args);
    }

}

/*

TODO 18: Run

http://localhost:8090/h2-console
jdbc:h2:mem:jwt_demo
==> 401

-----------------------------------------------------------------------------------------------------------------------
Register user
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8090/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"alice",
    "password":"P@ssw0rd"
}'
Response:
User registered

-----------------------------------------------------------------------------------------------------------------------
Login user
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8090/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "username":"alice",
    "password":"P@ssw0rd"
}'
Response:
{
    "token": "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3NjgyODc5NzEsImlhdCI6MTc2ODI4NDM3MSwicm9sZXMiOlsiUk9MRV9VU0VSIl19.ApGEpvOl7z7WF2SAU2etEJRgJFL932LpFa4r5h2CpNrclw6RCuN119Pd7ynlaTrlWKI-Iq90e1zRrLWzJPL2keTdtMzKZUDBdRa-LnHSdOUxxd8QIVSBNTBv3qZ3sdBb-MA6O50odjaFSxnIwIVAju-rxJZLL6omdSWu0QJZiRBIPp1ojih5sLqt6oVuK7FZsQYU1Ek-o6VaGV-29utOlEr78my1daiQimQZyGABJPlFeZTMC3ElRE6G_TE7zBRtu4fOCCDIMMN3zzD_Ug-XHEAKQcGrhUEPYZTXPei-ojE-g3b-uZdLvQNvGuoDTDqFKQckN1TLVg7FT3BMxA9_iw"
}

-----------------------------------------------------------------------------------------------------------------------
Access APIs
-----------------------------------------------------------------------------------------------------------------------
curl --location 'http://localhost:8090/api/hello' \
--header 'Authorization: Bearer eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3NjgyODc5NzEsImlhdCI6MTc2ODI4NDM3MSwicm9sZXMiOlsiUk9MRV9VU0VSIl19.ApGEpvOl7z7WF2SAU2etEJRgJFL932LpFa4r5h2CpNrclw6RCuN119Pd7ynlaTrlWKI-Iq90e1zRrLWzJPL2keTdtMzKZUDBdRa-LnHSdOUxxd8QIVSBNTBv3qZ3sdBb-MA6O50odjaFSxnIwIVAju-rxJZLL6omdSWu0QJZiRBIPp1ojih5sLqt6oVuK7FZsQYU1Ek-o6VaGV-29utOlEr78my1daiQimQZyGABJPlFeZTMC3ElRE6G_TE7zBRtu4fOCCDIMMN3zzD_Ug-XHEAKQcGrhUEPYZTXPei-ojE-g3b-uZdLvQNvGuoDTDqFKQckN1TLVg7FT3BMxA9_iw'
Response:
Hello World

-----------------------------------------------------------------------------------------------------------------------
From Browser - Login
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8090/auth/login
{"username":"alice","password":"P@ssw0rd"}
Response
set-cookie
token=eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3Njk3MTE4OTIsImlhdCI6MTc2OTcwODI5Miwicm9sZXMiOlsiUk9MRV9VU0VSIl19.vGB0_SAzCM5_ryoeTwEpslXQYYRcWbWdZ5LabWMOq1rRkxuPT5eNV9DJcGY7wPC9PX5vhyl7C-v7w4npJwomm3P8XQZ3CRAHJL14rw4rFee4Iukby5-Gl-9Ar6zmDNufL9R_evgPFEjFE1mJ-RCA-X67WRAMLdRKu8tv5rc6JEGRGD9h2dA2Ft3HNHQQdOi4AZZdKJqcm1bbIMCt-L35s-BYY7Og-MRBto0EVDseg_79fpCoxpi-JAB-zJa-6diZVQ-v9A4ydn_IHGyu6qpFVqxdbf9IU5GsTnF85jfehwLvGai5NQS9rptsHzjdsA8deGBrkwjfu7le_M-WyN6YIA; Path=/; Max-Age=36; Expires=Thu, 29 Jan 2026 17:38:48 GMT; Secure; HttpOnly; SameSite=Strict

-----------------------------------------------------------------------------------------------------------------------
From Browser - API
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8090/api/hello
Cookie: token=eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3Njk3MDk5NDksImlhdCI6MTc2OTcwNjM0OSwicm9sZXMiOlsiUk9MRV9VU0VSIl19.I3PoDfUVi642NBdj2HBSxQWyMOwlxsBBjgHWTMxPoAZ5gtX8e6qMzb7hM-TKm3KTv89__3QR_BJdP57_Dt63gcFwRfMtZuZl445JNMWo42Tne8pBxT5aSMbfrleW5-3wNAVA7TD2Ecr4ray7bKa0Ixd0-m2N6sMPs-b_tvALrL9Q8GJ8vlKwfGfe9i9tE9p0EBzZcpkBNpInf1FLfBxywBt7FaResugwNBToLvO5i2piy3WHDWS1dNrCBDhgFswKJrvqJaMSrbhGj4FvD4wKghWvyV4OWIG_EDrdgyaslHC_8cGmTausKbNVcRhB9ChrLpJg_7Q2hiyocT4pZzwDOQ

-----------------------------------------------------------------------------------------------------------------------
From Browser - Logout
-----------------------------------------------------------------------------------------------------------------------
http://localhost:8090/auth/logout
Cookie: token=eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJleGFtcGxlLmlvIiwic3ViIjoiYWxpY2UiLCJleHAiOjE3Njk3MDk5NDksImlhdCI6MTc2OTcwNjM0OSwicm9sZXMiOlsiUk9MRV9VU0VSIl19.I3PoDfUVi642NBdj2HBSxQWyMOwlxsBBjgHWTMxPoAZ5gtX8e6qMzb7hM-TKm3KTv89__3QR_BJdP57_Dt63gcFwRfMtZuZl445JNMWo42Tne8pBxT5aSMbfrleW5-3wNAVA7TD2Ecr4ray7bKa0Ixd0-m2N6sMPs-b_tvALrL9Q8GJ8vlKwfGfe9i9tE9p0EBzZcpkBNpInf1FLfBxywBt7FaResugwNBToLvO5i2piy3WHDWS1dNrCBDhgFswKJrvqJaMSrbhGj4FvD4wKghWvyV4OWIG_EDrdgyaslHC_8cGmTausKbNVcRhB9ChrLpJg_7Q2hiyocT4pZzwDOQ

 */