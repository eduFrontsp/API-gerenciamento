package br.com.apitest.placeservice.web;

import br.com.apitest.placeservice.api.PlaceResponse;
import br.com.apitest.placeservice.domain.Place;

public class PlaceMapper {

    public static PlaceResponse fromPlaceResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
