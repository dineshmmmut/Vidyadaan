package com.example.sampleapp.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "userLogin")
@EntityListeners(AuditingEntityListener.class)
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "contactNo", length = 10, nullable = false)
    private String contactNo;

    @Column(name = "cAddress", nullable = false)
    private String cAddress;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "designation")
    private String designation;

    @Column(name = "cImage")
    private String cImage;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "loginAccess")
    private String loginAccess;

    @Column(name = "accountType")
    private String accountType;

    @Column(name = "crDate")
    private String crDate;

    @Column(name = "isActive")
    private String isActive;

    @Override
    public String toString() {
        return "UserLogin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", qualification='" + qualification + '\'' +
                ", designation='" + designation + '\'' +
                ", cImage='" + cImage + '\'' +
                ", remarks='" + remarks + '\'' +
                ", loginAccess='" + loginAccess + '\'' +
                ", accountType='" + accountType + '\'' +
                ", crDate='" + crDate + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }

    public UserLogin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getLoginAccess() {
        return loginAccess;
    }

    public void setLoginAccess(String loginAccess) {
        this.loginAccess = loginAccess;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCrDate() {
        return crDate;
    }

    public void setCrDate(String crDate) {
        this.crDate = crDate;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
