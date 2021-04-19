package com.franchise.qa.model;

import java.util.Date;

/**
 * Created by noravingal on 08/03/21.
 */

/**DAO class*/
public class FranchiseModel {

    private String applicantName;
    private String idNumber;
    private Date   birthDate;
    private String contactAddress;
    private String contactPhone;
    private String contactEmail;
    private String previousExperience;
    private String intrestBrand;
    private Double investment;
    private String geographicalArea;
    private String additionalNotes;

    public FranchiseModel() {
    }

    public FranchiseModel(String applicantName, String idNumber, Date birthDate,
                          String contactAddress, String contactPhone, String contactEmail,
                          String previousExperience, String intrestBrand, Double investment,
                          String geographicalArea, String additionalNotes) {
        this.applicantName = applicantName;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.contactAddress = contactAddress;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.previousExperience = previousExperience;
        this.intrestBrand = intrestBrand;
        this.investment = investment;
        this.geographicalArea = geographicalArea;
        this.additionalNotes = additionalNotes;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPreviousExperience() {
        return previousExperience;
    }

    public void setPreviousExperience(String previousExperience) {
        this.previousExperience = previousExperience;
    }

    public String getIntrestBrand() {
        return intrestBrand;
    }

    public void setIntrestBrand(String intrestBrand) {
        this.intrestBrand = intrestBrand;
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
    }

    public String getGeographicalArea() {
        return geographicalArea;
    }

    public void setGeographicalArea(String geographicalArea) {
        this.geographicalArea = geographicalArea;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
}
