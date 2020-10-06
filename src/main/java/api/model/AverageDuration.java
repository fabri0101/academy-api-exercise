package api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageDuration {

    @JsonProperty("name")
    private String name;

    @JsonProperty("total")
    private String total;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
