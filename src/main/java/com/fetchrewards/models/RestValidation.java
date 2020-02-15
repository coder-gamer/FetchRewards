package com.fetchrewards.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class RestValidation {

    @JsonInclude(Include.NON_NULL)
    private boolean valid;
    
    @JsonInclude(Include.NON_NULL)
    private List<String> messages;

    public List<String> getMessages() {
        if (messages == null) {
            messages = new ArrayList<String>();
        }
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }


}
