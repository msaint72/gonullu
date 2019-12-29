package org.gonullu.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 8321567738893922442L;
    // PrimaryKey
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,length = 50)
    private String firstName;
    @Column(nullable = false,length = 50)
    private String lastName;
    private String userId;
    private String encryptedPassword;
    private String profileImage;
    private String mobilePhone;
    @Column(nullable = false,unique = true)
    private String email;
    private Date dateOfBirth;
    private String tshirtSize;
    private String gender;
    @OneToOne()
    private Address address;
    private String emergencyContactNumber;
    private String emergencyContactName;
    private String motivation;
    private Boolean affiliation=false;
    private String schoolName;
    private String companyName;
    private Boolean getInfoMails=false;
    private Boolean invisible=false;
    @OneToOne(fetch=FetchType.LAZY,mappedBy = "adminUser")
    private Organization adminOf;

    @ManyToMany()
    @JoinTable(name="USER_CAUSE",
            joinColumns = @JoinColumn(name="USER_ID"),
            inverseJoinColumns = @JoinColumn(name="CAUSE_ID"))
    private List<Cause> causes=new ArrayList<>();

    public UserEntity()  {}

    public UserEntity(String firstName, String lastName, String profileImage, String mobilePhone, String email, Date dateOfBirth, String tshirtSize, String gender, String emergencyContactNumber, String emergencyContactName, String motivation, Boolean affiliation, String schoolName, String companyName, Boolean getInfoMails, Boolean invisible) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileImage = profileImage;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.tshirtSize = tshirtSize;
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

    public UserEntity(String firstName, String lastName) {
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTshirtSize() {
        return tshirtSize;
    }

    public void setTshirtSize(String tshirtSize) {
        this.tshirtSize = tshirtSize;
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
