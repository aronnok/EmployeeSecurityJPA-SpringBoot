package com.socita.Employee;

import com.socita.Employee.entities.Token;
import com.socita.Employee.repos.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    TokenRepo tokenRepo;

    public Token getTokenById(String employeeNumber){

         return tokenRepo.findById(employeeNumber).get();
    }

}
