package com.drAppointments.Final.Project.model.dao;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class AppointmentDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private LocalTime time;

    @OneToOne
    private PatientDao patient;

    @OneToOne
    private DoctorDao doctor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public PatientDao getPatient() {
        return patient;
    }

    public void setPatient(PatientDao patient) {
        this.patient = patient;
    }

    public DoctorDao getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDao doctor) {
        this.doctor = doctor;
    }
}
