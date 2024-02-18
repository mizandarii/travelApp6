package com.example.travel.service;

import com.example.travel.model.Tour;
import com.example.travel.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours(){
        return tourRepository.findAll();
    }

    public Tour getTourById(long id){
        return tourRepository.findById(id).orElse(null);
    }

    public Tour createTour(Tour tour){
        return tourRepository.save(tour);
    }

    public void deleteTour (Long tourId){
        tourRepository.deleteById(tourId);
    }


}