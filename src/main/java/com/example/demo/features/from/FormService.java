package com.example.demo.features.from;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public void registerForm(Form form) {
        formRepository.save(form);
    }
}
