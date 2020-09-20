package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.AppointmentDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<AppointmentDao, Long> {

    List<AppointmentDao> getAllByPatient(PatientDao patient);

    List<AppointmentDao> getAllByDoctor(DoctorDao doctor);

    List<AppointmentDao> getAllByDateAfter(LocalDate date);

}
