package Create.Request;

import lombok.Getter;

import java.util.UUID;

@Getter
public class SampleRequestBody{

    private int statusCode;
    private String status;
    private String mobile;

    public SampleRequestBody(Builder builder){

        this.statusCode = builder.statusCode;
        this.status = builder.status;
        this.mobile = builder.mobile;

    }


    public static class Builder{

        private int statusCode;
        private String status;
        private String mobile;


        public Builder(){
            this.statusCode = 9;
            this.status = "";
            this.mobile = "";
        }

        public Builder statusCode(){
            this.statusCode = 0;
            return this;
        }

        public Builder status(){
            this.status = "";
            return this;
        }

        public Builder mobile(){
            this.mobile = "";
            return this;
        }

        public SampleRequestBody build(){
            SampleRequestBody sampleRequestBody = new SampleRequestBody(this);
            return sampleRequestBody;
        }
    }

}