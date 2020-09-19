package com.drAppointments.Final.Project.service;

//import com.sda.mvc.model.dao.UserDao;
//import com.sda.mvc.model.dto.UserDto;
//import com.sda.mvc.model.dto.UserSecDto;

import com.drAppointments.Final.Project.model.Role;
import com.drAppointments.Final.Project.model.dao.AdminDao;
import com.drAppointments.Final.Project.model.dao.DoctorDao;
import com.drAppointments.Final.Project.model.dao.PatientDao;
import com.drAppointments.Final.Project.repository.AdminRepository;
import com.drAppointments.Final.Project.repository.DoctorRepository;
import com.drAppointments.Final.Project.repository.PatientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.Optional;

@Service
public class UserService {

    private AdminRepository adminRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;

    private ModelMapper modelMapper;

    private PasswordEncoder passwordEncoder;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles;

    public UserService(AdminRepository adminRepository,
                       DoctorRepository doctorRepository, PatientRepository patientRepository,
                       ModelMapper modelMapper, PasswordEncoder passwordEncoder, Collection<Role> roles) {
        this.adminRepository = adminRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roles = roles;
    }

    public String getNameAndSurnameLoggedAdmin() {

        String login = SecurityContextHolder.getContext().getAuthentication().getName();

        Optional<AdminDao> adminByLogin = adminRepository.getAdminByLogin(login);

        return adminByLogin
                .map(adminDao -> adminDao.getName() + " " + adminDao.getSurname())
                .orElse(login);
    }

    public void addNewPatient(PatientDao user) {
        PatientDao patientDao = modelMapper.map(user, PatientDao.class);
        patientDao.setPassword(passwordEncoder.encode(user.getPassword()));
        patientRepository.save(patientDao);
    }

    public void addNewDoctor(DoctorDao user) {
        DoctorDao doctorDao = modelMapper.map(user, DoctorDao.class);
        doctorDao.setPassword(passwordEncoder.encode(user.getPassword()));
        doctorRepository.save(doctorDao);
    }

    public void addNewAdmin(AdminDao user) {
        AdminDao adminDao = modelMapper.map(user, AdminDao.class);
        adminDao.setPassword(passwordEncoder.encode(user.getPassword()));
        adminRepository.save(adminDao);
    }
}
