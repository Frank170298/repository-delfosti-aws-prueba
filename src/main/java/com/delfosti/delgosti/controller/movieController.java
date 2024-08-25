package com.delfosti.delgosti.controller;

import com.delfosti.delgosti.model.Movie;
import com.delfosti.delgosti.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class movieController {
    //@Autowired
    private final MovieServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable("id") Integer id){
        Movie obj = service.findById(id);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> save(@RequestBody Movie movie){
        Movie obj =  service.save(movie);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable("id") Integer id, @RequestBody Movie movie){
        movie.setId(id);
        Movie obj =  service.save(movie);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
