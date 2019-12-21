package org.gonullu.backend.domain;


import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {
    //primary-key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String address;
    private String province;
    private String district;
    private String zipCode;

    public Address(String address, String province, String district, String zipCode) {
        this.address = address;
        this.province = province;
        this.district = district;
        this.zipCode = zipCode;
    }

    protected Address(){}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
