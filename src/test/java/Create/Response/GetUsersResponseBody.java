package Create.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

import java.util.List;

@Getter
public class GetUsersResponseBody {

@Setter
private int statusCode;


private Meta meta;

private List<Data> data;


public void assertGetUsers(int expectedStatuscode, int expectedLimitValue){

    Assert.assertEquals(getStatusCode(), expectedStatuscode);
    Assert.assertEquals(getMeta().getPagination().getLimit(), expectedLimitValue);

}

@Getter
public static class Data{
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;
}

@Getter
public static class Meta{
    private Pagination pagination;

@Getter
public static class Pagination{
        private int total;
        private int pages;
        private int page;
        private int limit;
        private Links links;

@Getter
public static class Links{
            private String previous;
            private String current;
            private String next;
        }
    }

}



}
