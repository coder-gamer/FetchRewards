package com.fetchrewards.validator;

import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;

public interface VersionValidator {
    
    VersionCompareResult validateVersions(VersionCompare versionCompare);

}
