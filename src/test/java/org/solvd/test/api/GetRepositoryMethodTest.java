package org.solvd.test.api;

import org.solvd.api.GetRepositoryMethod;
import org.testng.annotations.Test;

public class GetRepositoryMethodTest {

    @Test
    public void getRepositoryMethodTest() {
        GetRepositoryMethod repositoryApi = new GetRepositoryMethod();
        repositoryApi.callAPIExpectSuccess();
        repositoryApi.validateResponse();
    }
}
