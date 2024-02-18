package com.example.travel.controller;

import com.example.travel.model.Place;
import com.example.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;

    @Autowired
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/list")
    public String getAllPlaces(Model model) {
        List<Place> places = placeService.getAllPlaces();
        model.addAttribute("places", places);
        return "places/list";
    }

    @GetMapping("/{id}")
    public String getPlaceById(@PathVariable String id, Model model) {
        try {
            Long placeId = Long.parseLong(id);
            Place place = placeService.getPlaceById(placeId);
            if (place != null) {
                model.addAttribute("place", place);
                return "places/details";
            } else {
                // Log a message or redirect to an error page if the place is not found
                System.err.println("Place not found for id: " + placeId);
                return "error";
            }
        } catch (NumberFormatException e) {
            // Log a message or redirect to an error page if the id is not a valid Long
            System.err.println("Invalid id format: " + id);
            return "error";
        }
    }



    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("place", new Place());
        return "places/create";
    }

    @PostMapping("/create")
    public String createPlace(@ModelAttribute Place place) {
        placeService.createPlace(place);
        return "redirect:/places/list";
    }

    @GetMapping("/{id}/delete")
    public String deletePlace(@PathVariable Long id) {
        placeService.deletePlace(id);
        return "redirect:/places";
    }
}