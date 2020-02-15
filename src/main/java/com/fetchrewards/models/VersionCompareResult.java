package com.fetchrewards.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class VersionCompareResult extends RestValidation {


    public enum Result {
        before, after, equal
    }

    @JsonInclude(Include.NON_NULL)
    private Result result;

    @JsonInclude(Include.NON_NULL)
    private boolean valid = true;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

}
