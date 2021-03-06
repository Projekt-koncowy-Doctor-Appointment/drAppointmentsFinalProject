package com.drAppointments.Final.Project.model.dao;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctor_dao")
public class DoctorDao extends UserSec {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @Column
    String surname;

    @Column
    String pesel;

    @Column
    String gender;

    @Column
    String city;

    @ManyToOne
    SpecializationDao medicalSpecialization;

    @Column
    String phone;

    @Column
    String email;

    @OneToMany
    List<WorkDay> workingHours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SpecializationDao getMedicalSpecialization() {
        return medicalSpecialization;
    }

    public void setMedicalSpecialization(SpecializationDao medicalSpecialization) {
        this.medicalSpecialization = medicalSpecialization;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<WorkDay> getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(List<WorkDay> workingHours) {
        this.workingHours = workingHours;
    }

    @Override
    public String toString() {
        return id + name + surname + pesel + gender + city +
                medicalSpecialization + phone + email;
    }
}


