package org.gonullu.backend.ws.model.request;

import org.gonullu.backend.domain.Address;
import org.gonullu.backend.domain.Cause;

import java.util.ArrayList;
import java.util.List;

public class OrganizationDetailsRequestModel {
    private String name;
    private String summary;
    private String address;
    // province ...
    private String phone;
    private String web;
    private List<Cause> causes=new ArrayList<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
