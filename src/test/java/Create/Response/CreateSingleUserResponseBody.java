package Create.Response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateSingleUserResponseBody {

    @Setter
    private int statusCode;

    @JsonProperty("meta")
    private String meta;

    @JsonProperty("data")
    private Data data;

    @Getter
    public class Data{
        private int id;
        private String name;
        private String email;
        private String gender;
        private String status;
    }
}
