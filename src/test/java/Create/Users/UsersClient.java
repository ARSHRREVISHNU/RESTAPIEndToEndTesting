package Create.Users;

import Create.Request.CreateUserRequestBody;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;

public class UsersClient {
    public Response getAll() {
        Response response =
                given().
                        when()
                        .get("https://gorest.co.in/public/v1/users");
        response.then().log().body();

        return response;
    }



    public Response create(CreateUserRequestBody body){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users/");
        response
        .then().log().body();

        System.out.println("The reponse body of create user.");
        System.out.println(response.getBody().asString());

        return response;

    }

    public Response getOneuser(int id){
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v1/users/{id}");
        response
                .then()
                .log().body();

        System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
        return response;
    }


    public Response getTwoUser(){

        RequestSpecification requestSpecification = given().accept(ContentType.JSON).contentType(ContentType.JSON);

        Response response = requestSpecification.pathParam("",78).when().get("");


        response.then().log().body();

        response.getBody().toString();

        return response;
    }


    public Response deleteUser(){

        RestAssured.baseURI = "";
        RequestSpecification requestSpecification = given().accept(ContentType.JSON).contentType(ContentType.JSON);

        Response response = requestSpecification.pathParam("id", 478).when().delete("https://gorest.co.in/public/v2/users/{id}");

        //response.then().log().body();

        response.then().log().ifValidationFails().assertThat().statusCode(200);
        System.out.println(response.getStatusCode());
        Headers headers = response.headers();
        Headers headers1 = response.getHeaders();
        String header = response.getHeader("");
        headers.get("");
        System.out.println(response.getBody().asString());

        return response;
    }


    public Response response(){
        RequestSpecification requestSpecification1 = given().accept(ContentType.JSON).contentType(ContentType.JSON).pathParam("id", 89);
        Response response = requestSpecification1.when().get("");
        response.then().log().body();
        response.then().log().ifValidationFails().assertThat().statusCode(200);
        response.then().log().ifValidationFails().assertThat().statusCode(200);
        System.out.println(response.getStatusCode());

        return response;
    }






}
