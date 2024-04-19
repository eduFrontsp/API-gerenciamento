package br.com.apitest.placeservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apitest.placeservice.api.PlaceRequest;
import br.com.apitest.placeservice.api.PlaceResponse;
import br.com.apitest.placeservice.domain.PlaceService;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var PlaceResponse = placeService.create(request).map(PlaceMapper::fromPlaceResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(PlaceResponse);
    }

}
