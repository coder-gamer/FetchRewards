package com.fetchrewards.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;
import com.fetchrewards.models.VersionCompareResult.Result;

@Component
public class VersionServiceImpl implements VersionService {
    
    private static Logger logger = Logger.getLogger(VersionServiceImpl.class);

    @Override
    public VersionCompareResult compareVersions(VersionCompare versionCompare) {
        
        

        VersionCompareResult result = new VersionCompareResult();

        String[] version1Split = versionCompare.getVersion1().split("\\.");
        String[] version2Split = versionCompare.getVersion2().split("\\.");

        int length = Math.max(version1Split.length, version2Split.length);
        
        try {
            for (int i = 0; i < length; i++) {
                Integer v1 = i < version1Split.length ? Integer.parseInt(version1Split[i]) : 0;
                Integer v2 = i < version2Split.length ? Integer.parseInt(version2Split[i]) : 0;
                int compare = v1.compareTo(v2);

                if (compare != 0) {
                    if (v1 < v2) {
                        result.setResult(Result.before);
                        result.getMessages().add(versionCompare.getVersion1() + " is before " + versionCompare.getVersion2());
                    } else {
                        result.setResult(Result.after);
                        result.getMessages().add(versionCompare.getVersion1() + " is after " + versionCompare.getVersion2());
                    }
                    break;
                }
            }

            if (result.getResult() == null) {
                result.setResult(Result.equal);
                result.getMessages().add(versionCompare.getVersion1() + " is equal to " + versionCompare.getVersion2());
            }
        } catch (NumberFormatException e) {
           logger.error("Error occurred while parsing the number. Single octet of the version number cannot be greater than " + Integer.MAX_VALUE);
           result.setValid(false);
           result.getMessages().add("Single octet of the version number cannot be greater than " + Integer.MAX_VALUE);
        }

        return result;
    }

}
