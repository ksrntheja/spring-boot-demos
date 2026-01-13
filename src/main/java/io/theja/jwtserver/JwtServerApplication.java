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

 */
