package com.delfosti.delgosti.service.impl;

import com.delfosti.delgosti.model.Movie;
import com.delfosti.delgosti.repo.IGenericRepo;
import com.delfosti.delgosti.repo.IMovieRepo;
import com.delfosti.delgosti.service.IMovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl extends CRUDImpl<Movie, Integer> implements IMovieService {
    private final IMovieRepo repo;


    @Override
    protected IGenericRepo<Movie, Integer> getRepo() {
        return repo;
    }
}
