package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Rough {

String ex="apple";
String ac="greem";
    @Test
    public void test(){
        Assert.assertEquals(ex,ac);
    }
}
