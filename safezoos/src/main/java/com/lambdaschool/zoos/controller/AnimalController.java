package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Animal;
import com.lambdaschool.zoos.service.AnimalService;
import com.lambdaschool.zoos.view.CountAnimals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/animals")
public class AnimalController
{
    @Autowired
    private AnimalService animalService;

    @GetMapping(value = "/animals",
                produces = {"application/json"})
    public ResponseEntity<?> listAllAnimals()
    {
        return new ResponseEntity<>(animalService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{type}",
                produces = {"application/json"})
    public ResponseEntity<?> findAnimalByType(
            @PathVariable
                    String type)
    {
        Animal a = animalService.findAnimalByType(type);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    // GET /animals/count
    @GetMapping(value = "/count", produces = {"application/json"})
    public ResponseEntity<?> getAnimalsCount()
    {
        ArrayList<CountAnimals> myList = animalService.getCountAnimals();
        myList.sort((a1, a2) -> a1.getAnimaltype().compareToIgnoreCase(a2.getAnimaltype()));
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

}
