package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class DoctorService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    public DoctorService(PatientRepository patientRepository, DoctorRepository doctorRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String getNameAndSurnameLoggedUser() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<DoctorDao> userByLogin = doctorRepository.getDoctorByLogin(login);

        return userByLogin
                .map(userDao -> userDao.getName() + " " + userDao.getSurname())
                .orElse(login);
    }

}
