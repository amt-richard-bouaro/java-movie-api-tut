package dev.ghet.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {

    @Autowired
    ReviewServices reviewServices;

    @PostMapping
    public ResponseEntity<Review> createNewReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewServices.createReview(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
