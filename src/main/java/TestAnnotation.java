public class TestAnnotation {

    @Test(priority = 2)
    private void test1(){
        System.out.println("test1");
    }

    @Test(priority = 1)
    private void test2(){
        System.out.println("test2");
    }

    @Test(priority = 4)
    private void test3(){
        System.out.println("test3");
    }

    @Test(priority = 3)
    private void test4(){
        System.out.println("test4");
    }

    @BeforeSuite
    private void test5(){
        System.out.println("test5 BeforeSuite");
    }

    @AfterSuite
    private void test6(){
        System.out.println("test6 AfterSuite");
    }

}
