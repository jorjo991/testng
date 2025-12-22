package org.solvd.test.api;

import org.solvd.api.GetCommitsMethod;
import org.testng.annotations.Test;

public class GetCommitsMethodTest {

    @Test
    public void getCommitMethodTest() {

        GetCommitsMethod api = new GetCommitsMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();

    }

}
