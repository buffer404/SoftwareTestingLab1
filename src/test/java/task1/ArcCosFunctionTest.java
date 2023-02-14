package task1;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.junit.Assert;
import org.apache.commons.math3.util.Precision;

@RunWith(DataProviderRunner.class)
public class ArcCosFunctionTest {
    double inaccuracy = 0.1;

    @DataProvider
    public static Object[][] data(){
        return new Object[][]{
                {0.5, 1.04},
                {0.6, 0.92}
        };
    }

    @Test
    @UseDataProvider("data")
    public void test(double x, double result){
        System.out.println(ArcCosFunction.arcCos(x));
        Assert.assertTrue(Math.abs(ArcCosFunction.arcCos(x) - Math.abs(result)) <= inaccuracy);
    }
}
