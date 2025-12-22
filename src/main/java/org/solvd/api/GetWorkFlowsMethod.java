package org.solvd.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${baseUrl}/repos/${owner}/${repos}/actions/workflows", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/workflows/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWorkFlowsMethod extends AbstractApiMethodV2 {

    public GetWorkFlowsMethod() {
        replaceUrlPlaceholder("baseUrl", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("owner", "jorjo991");
        replaceUrlPlaceholder("repos", "university");
    }
}
