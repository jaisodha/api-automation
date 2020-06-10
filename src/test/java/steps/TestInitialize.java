package steps;

import io.cucumber.java.Before;
import utilities.BaseUtil;
import java.io.IOException;

public class TestInitialize {
    @Before
    public void TestSetup() throws IOException {
        BaseUtil baseUtil = new BaseUtil();

    }

}
