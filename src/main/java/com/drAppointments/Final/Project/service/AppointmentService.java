package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.repository.AppointmentRepository;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentService {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;


}
