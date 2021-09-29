package com.gepardec.training.microprofile.basic.openapi;

import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;

public class MyFilter implements OASFilter {
    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        if ("Missing description".equals(apiResponse.getDescription())) {
            apiResponse.setDescription("No Cheetah found");
        }
        return apiResponse;
    }
}
