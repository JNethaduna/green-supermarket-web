package com.green.supermarketwebapp.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.DAOs.CustomerDAO;
import com.green.supermarketwebapp.DAOs.ManagerDAO;
import com.green.supermarketwebapp.Models.Customer;
import com.green.supermarketwebapp.Models.Manager;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final CustomerDAO customerRepository;
  private final ManagerDAO managerRepository;

  public UserDetailsServiceImpl(CustomerDAO customerRepository, ManagerDAO managerRepository) {
    this.customerRepository = customerRepository;
    this.managerRepository = managerRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    if (email.endsWith("@smmanager.green.com")) {
      Manager manager = managerRepository.findByEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("Email does not exist: " + email));

      List<GrantedAuthority> managerAuthorities = new ArrayList<>();
      managerAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));

      return new User(manager.getEmail(), manager.getPassword(), managerAuthorities);
    } else {
      Customer customer = customerRepository.findByEmail(email)
          .orElseThrow(() -> new UsernameNotFoundException("Email does not exist: " + email));

      List<GrantedAuthority> customerAuthorities = new ArrayList<>();
      customerAuthorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));

      return new User(customer.getEmail(), customer.getPassword(), customerAuthorities);
    }
  }
}
