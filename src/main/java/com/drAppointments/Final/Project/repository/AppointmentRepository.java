package com.drAppointments.Final.Project.repository;

import com.drAppointments.Final.Project.model.dao.AppointmentDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<AppointmentDao, Long> {

    Optional<AppointmentDao> getAllByPatient(PatientDao patient);

    Optional<AppointmentDao> getAllByDoctor(DoctorDao doctor);

}
