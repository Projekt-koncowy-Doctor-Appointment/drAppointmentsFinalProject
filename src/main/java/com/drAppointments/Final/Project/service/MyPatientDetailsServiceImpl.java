package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyPatientDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    // patient = dla nas później "userDao"
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        PatientDao patientDao = patientRepository.getPatientByLogin(login)
                        .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        return new MyPatientDetailsService(patientDao);
    }
}
