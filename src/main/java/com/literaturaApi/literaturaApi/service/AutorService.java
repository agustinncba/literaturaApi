package com.literaturaApi.literaturaApi.service;

import com.literaturaApi.literaturaApi.model.Autor;
import com.literaturaApi.literaturaApi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    public List<Autor> listarAutores() {
        // a continuar
        return null;
    }
}
