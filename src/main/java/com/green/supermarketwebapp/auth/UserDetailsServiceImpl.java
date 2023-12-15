package com.green.supermarketwebapp.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.green.supermarketwebapp.customer.Customer;
import com.green.supermarketwebapp.customer.CustomerRepository;
import com.green.supermarketwebapp.manager.Manager;
import com.green.supermarketwebapp.manager.ManagerRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final CustomerRepository customerRepository;
  private final ManagerRepository managerRepository;

  public UserDetailsServiceImpl(CustomerRepository customerRepository, ManagerRepository managerRepository) {
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
