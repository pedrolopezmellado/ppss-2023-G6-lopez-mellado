package ppss.ejercicio1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ppss.ejercicio1.MultipathExample;

public class MultipathExampleTest {

    @Test
    public void testMultipathTest1(){
        MultipathExample multi = new MultipathExample();
        int a = 6;
        int b = 6;
        int c = 0;
        int result = multi.multiPath1(a, b, c);
        Assert.assertEquals(12, result);
    }

    @Test
    public void testMultipathTest2(){
        MultipathExample multi = new MultipathExample();
        int a = 1;
        int b = 1;
        int c = 0;
        int result = multi.multiPath1(a, b, c);
        Assert.assertEquals(0, result);
    }

    @Test
    public void testMultipathTest3(){
        MultipathExample multi = new MultipathExample();
        int a = 7;
        int b = 7;
        int c = 7;
        int result = multi.multiPath1(a, b, c);
        Assert.assertEquals(21, result);
    }

    @Test
    public void testMultipath2Test1(){
        MultipathExample multi = new MultipathExample();
        int a = 6;
        int b = 4;
        int c = 6;
        int result = multi.multiPath2(a, b, c);
        Assert.assertEquals(16, result);
    }

    @Test
    public void testMultipath2Test2(){
        MultipathExample multi = new MultipathExample();
        int a = 4;
        int b = 6;
        int c = 4;
        int result = multi.multiPath2(a, b, c);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testMultipath2Test3(){
        MultipathExample multi = new MultipathExample();
        int a = 6;
        int b = 6;
        int c = 4;
        int result = multi.multiPath2(a, b, c);
        Assert.assertEquals(4, result);
    }

    @Test
    public void testMultipath3Test1(){
        MultipathExample multi = new MultipathExample();
        int a = 6;
        int b = 4;
        int c = 6;
        int result = multi.multiPath3(a, b, c);
        Assert.assertEquals(16, result);
    }

    @Test
    public void testMultipath3Test2(){
        MultipathExample multi = new MultipathExample();
        int a = 4;
        int b = 6;
        int c = 4;
        int result = multi.multiPath3(a, b, c);
        Assert.assertEquals(4, result);
    }

}
