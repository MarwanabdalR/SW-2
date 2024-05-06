package com.example.springbootmovie.service;

import com.example.springbootmovie.model.Actor;
import com.example.springbootmovie.model.Movie;
import com.example.springbootmovie.repository.ActorRepository;
import com.example.springbootmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    public List<Actor> getActors(){
        return actorRepository.findAll();
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor getActorById(int id){
        Optional<Actor> optional = actorRepository.findById(id);
        Actor actor = null;
        if (optional.isPresent()){
            actor = optional.get();
        }else{
            throw new RuntimeException("Actor not found for id ::" + id);
        }
        return actor;
    }

    public void deleteActor(int id){
        actorRepository.deleteById(id);
    }
}
