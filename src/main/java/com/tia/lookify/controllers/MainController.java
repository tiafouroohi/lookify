package com.tia.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tia.lookify.models.Lookify;
import com.tia.lookify.services.LookifyService;

@RestController
public class MainController {
    private final LookifyService lookifyService;
    public MainController(LookifyService lookifyService){
        this.lookifyService = lookifyService;
    }
    @RequestMapping("/api/lookify")
    public List<Lookify> index() {
        return lookifyService.allSongs();
    }
    
    @RequestMapping(value="/api/lookify", method=RequestMethod.POST)
    public Lookify create(@RequestParam(value="title") String title, @RequestParam(value="artist") String artist, @RequestParam(value="rating") String rating ){
        Lookify lookify = new Lookify(title, artist, rating);
        return lookifyService.createSong(lookify);
    }
    
    @RequestMapping("/api/lookify/{id}")
    public Lookify show(@PathVariable("id") Long id) {
        Lookify lookify = lookifyService.findSong(id);
        return lookify;
    }
}