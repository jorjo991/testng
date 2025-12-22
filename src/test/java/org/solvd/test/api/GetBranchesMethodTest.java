package org.solvd.test.api;

import org.solvd.api.GetBranchesMethod;
import org.testng.annotations.Test;

public class GetBranchesMethodTest {

    @Test
    public void getBranchesMethodTest() {

        GetBranchesMethod branchesAPI = new GetBranchesMethod();
        branchesAPI.callAPIExpectSuccess();
        branchesAPI.validateResponse();

    }
}
