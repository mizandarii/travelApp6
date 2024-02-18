package com.example.travel.service;


import com.example.travel.model.Place;
import com.example.travel.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

 @Service
 public class PlaceService {
 @Autowired
 private PlaceRepository placeRepository;

 public List<Place> getAllPlaces(){
 return placeRepository.findAll();
 }

 public Place getPlaceById(long id){
 return placeRepository.findById(id).orElse(null);
 }

 public Place createPlace(Place place){
 return placeRepository.save(place);
 }

 public void deletePlace (Long placeId){
 placeRepository.deleteById(placeId);
 }


 }
