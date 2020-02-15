package com.fetchrewards.validator;

import org.springframework.stereotype.Component;
import com.fetchrewards.models.VersionCompare;
import com.fetchrewards.models.VersionCompareResult;

@Component
public class VersionValidatorImpl implements VersionValidator {

    @Override
    public VersionCompareResult validateVersions(VersionCompare versionCompare) {


        VersionCompareResult result = new VersionCompareResult();

        validateLength(versionCompare, result);

        validateOnlyDigitsAndDotsArePresent(versionCompare, result);

        if (!result.getMessages().isEmpty()) {
            result.setValid(false);
        } else {
            result.setValid(true);
        }

        return result;
    }

    private void validateOnlyDigitsAndDotsArePresent(VersionCompare versionCompare,
            VersionCompareResult result) {

        if (versionCompare.getVersion1() != null && versionCompare.getVersion2() != null) {
            if (!versionCompare.getVersion1().matches("^\\d+(\\.\\d+)*$")
                    || !versionCompare.getVersion2().matches("^\\d+(\\.\\d+)*$")) {
                result.getMessages().add(
                        "Version can contain only numbers and dots. Cannot start or end with a dot. Eg: 1.0, 1.1.0, 1.1.1, 1");
            }
        }

    }

    private void validateLength(VersionCompare versionCompare, VersionCompareResult result) {
        if (versionCompare.getVersion1() == null) {
            result.getMessages().add("Version 1 is a required field");
        } else if (versionCompare.getVersion1().length() > 32) {
            result.getMessages().add("Version 1 can not be greater than 32 characters");
        }


        if (versionCompare.getVersion2() == null) {
            result.getMessages().add("Version 2 is a required field");
        } else if (versionCompare.getVersion2().length() > 32) {
            result.getMessages().add("Version 2 can not be greater than 32 characters");
        }



    }


}
