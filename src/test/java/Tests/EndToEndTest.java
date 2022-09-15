package Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EndToEndTest {

    @BeforeClass
    public void before(){

    }
    @Test
    public void endToEndTestOne(){
        System.out.println("Test 1");
        Assert.assertEquals(1,1);
    }
}
