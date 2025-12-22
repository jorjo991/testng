package org.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${baseUrl}/repos/${owner}/${repos}/branches", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/branches/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetBranchesMethod extends AbstractApiMethodV2 {

    public GetBranchesMethod() {
        replaceUrlPlaceholder("baseUrl", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("owner", "jorjo991");
        replaceUrlPlaceholder("repos", "university");
    }
}
