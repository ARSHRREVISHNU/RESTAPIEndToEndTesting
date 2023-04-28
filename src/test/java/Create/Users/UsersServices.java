package Create.Users;

import Create.Request.CreateUserRequestBody;
import Create.Response.CreateSingleUserResponseBody;
import Create.Response.GetUsersResponseBody;
import io.restassured.response.Response;

public class UsersServices {

    UsersClient usersClient = new UsersClient();
    public GetUsersResponseBody getUsers()
    {
        Response response = usersClient.getAll();

        GetUsersResponseBody getUsersResponseBody = response.as(GetUsersResponseBody.class);
        getUsersResponseBody.setStatusCode(response.getStatusCode());
        return getUsersResponseBody;
    }



    public CreateSingleUserResponseBody createUser(CreateUserRequestBody requestBody){

            Response response = usersClient.create(requestBody);
        CreateSingleUserResponseBody getSingleUserResponseBody = response.as(CreateSingleUserResponseBody.class);

        getSingleUserResponseBody.setStatusCode(response.statusCode());
        return getSingleUserResponseBody;
    }


    public CreateSingleUserResponseBody getSingleUser(int id){
        Response response = usersClient.getOneuser(id);

        CreateSingleUserResponseBody getUsersResponseBody = response.as(CreateSingleUserResponseBody.class);
        getUsersResponseBody.setStatusCode(response.getStatusCode());
        return getUsersResponseBody;
    }

}
