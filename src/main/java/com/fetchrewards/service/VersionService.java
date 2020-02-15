package com.fetchrewards.service;

import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;

public interface VersionService {

    VersionCompareResult compareVersions(VersionCompare versionCompare);

}
