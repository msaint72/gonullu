package org.gonullu.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "causes")
public class Cause {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "causes")
    private List<Organization> organizations=new ArrayList<>();
    @JsonIgnore
    @ManyToMany(mappedBy = "causes")
    private List<UserEntity> users=new ArrayList<>();

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void addOrganization(Organization organization) {
        this.organizations.add(organization);
    }

    protected Cause (){}
    public Cause(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void addUser(UserEntity user) {
        this.users.add( user);
    }
}
