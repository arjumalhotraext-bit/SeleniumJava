package testng;

import org.testng.annotations.*;

public class TNG1 {
    @Test
    public void showHello() {
        System.out.println("Hello world");
    }

    @Test
    public void showBye() {
        System.out.println("Bye world");
    }

    @Test(enabled = false) // This test wont run now
    public void showDisableThing() {
        System.out.println("Disable world");
    }

    @BeforeTest
    public void thisTestBeforeEachTest() {
        System.out.println("This test Before Each Test");
    }

    @BeforeMethod
    public void thisTestBeforeMethod() {
        System.out.println("This test before Method");
    }

    @AfterMethod
    public void thisTestAfterMethod() {
        System.out.println("This test after Method");
    }

    @AfterSuite
    public void thisTestAfterSuite() {
        System.out.println("This test after Suite");
    }

    @BeforeSuite
    public void thisTestBeforeSuite() { System.out.println("This test before Suite"); }

    @AfterTest
    public void thisTestAfterEachTest() {
        System.out.println("This test After Each Test");
    }

    @Test(groups = {"smoke"})
    public void testSmoke() { System.out.println("Smoke Test things"); }

    @Test(dataProvider = "getData", groups = {"smoke"})
    public void loginTest(String username, String password) {
        System.out.println("Username: " + username + " | Password: " + password);
    }

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][] {
                {"firstusername", "firstpassword"},
                {"secondusername", "secondpassword"},
                {"thirdusername", "thirdpassword"}
        };
    }

    @Parameters({"URL", "username"})
    @Test
    public void parameterTest(String url, String user) {
        System.out.println("Opening URL: " + url);
        System.out.println("Logging in as: " + user);
    }
}
