package org.solvd.test.api;

import org.solvd.api.GetIssuesMethod;
import org.testng.annotations.Test;

public class GetIssuesMethodTest {

    @Test
    public void getIssuesMethodTest() {
        GetIssuesMethod issuesAPI = new GetIssuesMethod();
        issuesAPI.callAPIExpectSuccess();
        issuesAPI.validateResponse();
    }
}
