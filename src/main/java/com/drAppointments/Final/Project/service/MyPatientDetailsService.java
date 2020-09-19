package com.drAppointments.Final.Project.service;

import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.model.dao.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyPatientDetailsService implements UserDetails {

    private PatientDao patientDao;

    public MyPatientDetailsService(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = patientDao.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return patientDao.getPassword();
    }

    @Override
    public String getUsername() {
        return patientDao.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return patientDao.isEnabled();
    }
}
