package com.tia.lookify.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tia.lookify.models.Lookify;
import com.tia.lookify.repositories.LookifyRepository;
@Service
public class LookifyService {
    // adding the book repository as a dependency
    private final LookifyRepository lookifyRepository;
    
    public LookifyService(LookifyRepository lookifyRepository) {
        this.lookifyRepository = lookifyRepository;
    }
    // returns all the books
    public List<Lookify> allSongs() {
        return lookifyRepository.findAll();
    }
    // creates a book
    public Lookify createSong(Lookify b) {
        return lookifyRepository.save(b);
    }
    public void deleteSong(Long id) {
    	lookifyRepository.deleteById(id);
    }
    // retrieves a book
    public Lookify findSong(Long id) {
        Optional<Lookify> optionalLookify = lookifyRepository.findById(id);
        if(optionalLookify.isPresent()) {
            return optionalLookify.get();
        } else {
            return null;
        }
    }
 
    
}