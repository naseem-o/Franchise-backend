package com.franchise.qa.persistance.entity;

/**
 * Entity class
 */

import com.franchise.qa.persistance.utility.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "franchise")
public class Franchise extends BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "Applicant name is mandatory.")
  @Column(name = "applicant_name")
  private String applicantName;

  @NotBlank(message = "Id number is mandatory.")
  @Column(name = "id_number")
  private String idNumber;

  @Temporal(TemporalType.DATE)
  @Column(name = "birth_date")
  private Date birthDate;

  @Column(name = "contact_address", columnDefinition = "mediumtext")
  private String contactAddress;

  @Column(name = "contact_phone")
  private String contactPhone;

  @Email(message = "Email address is not valid.")
  @Column(name = "contact_email")
  private String contactEmail;

  @Column(name = "previous_experience", columnDefinition = "mediumtext")
  private String previousExperience;

  @Column(name = "intrest_brand")
  private String intrestBrand;

  @Column(name = "investment")
  private Double investment;

  @Column(name = "geographical_area")
  private String geographicalArea;

  @Column(name = "additional_notes", columnDefinition = "mediumtext")
  private String additionalNotes;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
