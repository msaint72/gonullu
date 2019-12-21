package org.gonullu.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false)
    private String name;
    //private List<Cause> causes;
    private String summary;
    @OneToOne()
    private Address address;
    @Column(nullable = false)
    private String phone;
    private String web;
    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    private User adminUser;
    @ManyToMany()
    @JoinTable(name="ORGANIZATION_CAUSE",
    joinColumns = @JoinColumn(name="ORGANIZATION_ID"),
    inverseJoinColumns = @JoinColumn(name="CAUSE_ID"))
    private List<Cause> causes=new ArrayList<>();


    public Organization(String name, String summary, String phone, String web) {
        this.name = name;
        this.summary = summary;
        this.phone = phone;
        this.web = web;
    }

    // primary user
    // other users
    protected Organization(){}

    public long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void addCause(Cause cause) {
        this.causes.add(cause);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
