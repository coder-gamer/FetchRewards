package com.fetchrewards.service;

import org.springframework.stereotype.Component;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;
import com.fetchrewards.models.VersionCompareResult.Result;

@Component
public class VersionServiceImpl implements VersionService {

    @Override
    public VersionCompareResult compareVersions(VersionCompare versionCompare) {

        VersionCompareResult result = new VersionCompareResult();

        String[] version1Split = versionCompare.getVersion1().split("\\.");
        String[] version2Split = versionCompare.getVersion2().split("\\.");

        int length = Math.max(version1Split.length, version2Split.length);
        
        for (int i = 0; i < length; i++) {
            Integer v1 = i < version1Split.length ? Integer.parseInt(version1Split[i]) : 0;
            Integer v2 = i < version2Split.length ? Integer.parseInt(version2Split[i]) : 0;
            int compare = v1.compareTo(v2);

            if (compare != 0) {
                if (v1 < v2) {
                    result.setResult(Result.before);
                } else {
                    result.setResult(Result.after);
                }
                break;
            }
        }

        if (result.getResult() == null) {
            result.setResult(Result.equal);
        }

        return result;
    }

}
