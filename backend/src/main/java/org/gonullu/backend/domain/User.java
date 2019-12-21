package org.gonullu.backend.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {

    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String profileImage;
    private String mobilePhone;
    private String eMail;
    private Date dateOfBirth;
    private String tShirtSize;
    private String gender;
    @OneToOne()
    private Address address;
    private String emergencyContactNumber;
    private String emergencyContactName;
    private String motivation;
    private Boolean affiliation;
    private String schoolName;
    private String companyName;
    private Boolean getInfoMails;
    private Boolean invisible;
    @OneToOne(fetch=FetchType.LAZY,mappedBy = "adminUser")
    private Organization adminOf;

    @ManyToMany()
    @JoinTable(name="USER_CAUSE",
            joinColumns = @JoinColumn(name="USER_ID"),
            inverseJoinColumns = @JoinColumn(name="CAUSE_ID"))
    private List<Cause> causes=new ArrayList<>();

    protected User() {}

    public User(String firstName, String lastName, String profileImage, String mobilePhone, String eMail, Date dateOfBirth, String tShirtSize, String gender, String emergencyContactNumber, String emergencyContactName, String motivation, Boolean affiliation, String schoolName, String companyName, Boolean getInfoMails, Boolean invisible) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.mobilePhone = mobilePhone;
        this.eMail = eMail;
        this.dateOfBirth = dateOfBirth;
        this.tShirtSize = tShirtSize;
        this.gender = gender;
        this.emergencyContactNumber = emergencyContactNumber;
        this.emergencyContactName = emergencyContactName;
        this.motivation = motivation;
        this.affiliation = affiliation;
        this.schoolName = schoolName;
        this.companyName = companyName;
        this.getInfoMails = getInfoMails;
        this.invisible = invisible;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String gettShirtSize() {
        return tShirtSize;
    }

    public void settShirtSize(String tShirtSize) {
        this.tShirtSize = tShirtSize;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public Boolean getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Boolean affiliation) {
        this.affiliation = affiliation;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Boolean getGetInfoMails() {
        return getInfoMails;
    }

    public void setGetInfoMails(Boolean getInfoMails) {
        this.getInfoMails = getInfoMails;
    }

    public Boolean getInvisible() {
        return invisible;
    }

    public void setInvisible(Boolean invisible) {
        this.invisible = invisible;
    }
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Organization getAdminOf() {
        return adminOf;
    }

    public void setAdminOf(Organization adminOf) {
        this.adminOf = adminOf;
    }

    public List<Cause> getCauses() {
        return causes;
    }

    public void addCause(Cause cause) {
        this.causes.add(cause);
    }

}
