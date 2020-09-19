package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.repository.AppointmentRepository;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class PatientService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public PatientService(PatientRepository patientRepository, DoctorRepository doctorRepository,
                          ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNameAndSurnameLoggedUser() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<PatientDao> userByLogin = patientRepository.getPatientByLogin(login);

        return userByLogin
                .map(userDao -> userDao.getName() + " " + userDao.getSurname())
                .orElse(login);
    }

    public List<DoctorDao> getDoctorByMedicalSpecialization(String medSpec){
        return doctorRepository.getDoctorByMedicalSpecialization(medSpec);
    }

    public Optional<DoctorDao> getDoctorByNameAndSurname(String name, String surname){
        return doctorRepository.getDoctorByNameAndSurname(name, surname);
    }
}
