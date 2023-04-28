package Tests;

import Create.Request.CreateUserRequestBody;
import Create.Users.UsersClient;
import Create.Users.UsersServices;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class EndToEndTest {
UsersServices usersServices;
UsersClient usersClient;
    @BeforeClass
    public void before(){
    usersServices = new UsersServices();
    usersClient = new UsersClient();

    }
    @Test
    //Get all users and asserts the status code and limit value
    public void getAllUsersAssertStatusCodeAndLimit(){
        usersServices.getUsers().assertGetUsers(200, 10);
    }

    @Test
    public void createGetDeleteAndGetUser(){
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
        int id = usersServices.createUser(createUserRequestBody).getData().getId();
        System.out.println("Id: "+id);
       Assert.assertEquals(usersServices.getSingleUser(id).getData().getId(), id);
    }


    @Test
    public void createUserTest(){
        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
        int id = usersServices.createUser(createUserRequestBody).getData().getId();
        System.out.println(id);

    }

    @Test
    public void returnUser(){
        usersServices.getSingleUser(2352).getData().getId();
    }


    @Test
    public void deleteUser(){
        usersClient.deleteUser();
    }


}
