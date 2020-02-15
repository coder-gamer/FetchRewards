package com.fetchrewards.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;
import com.fetchrewards.service.VersionService;
import com.fetchrewards.validator.VersionValidator;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/fetchrewards/versions")
public class VersionController {
    
    @Autowired
    private VersionValidator versionValidator;
    
    @Autowired
    private VersionService versionService;

    
    @ApiOperation(value = "Compare 2 versions")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "version1", value = "Value of version 1", required = true, dataType = "string", paramType = "query"),
        @ApiImplicitParam(name = "version2", value = "Value of version 2", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(method = RequestMethod.GET, value = "/compare")
    public VersionCompareResult compareVersions(
            @RequestParam(value = "version1", required = true) String version1,
            @RequestParam(value = "version2", required = true) String version2) {
        
        VersionCompare versionCompare = new VersionCompare();
        versionCompare.setVersion1(version1);
        versionCompare.setVersion2(version2);
        
        VersionCompareResult result = versionValidator.validateVersions(versionCompare);
        
        if(result.isValid())
        {
            result = versionService.compareVersions(versionCompare);
        }

        return result;
    }
}
