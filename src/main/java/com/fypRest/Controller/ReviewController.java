package com.fypRest.Controller;

import com.fypRest.DAO.ReviewRepository;
import com.fypRest.enitity.Review;
import com.fypRest.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping("/reviews")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/list")
    public Page<Review> getReviews(@RequestParam Optional<Integer> page)
    {
        return reviewRepository.findAll(PageRequest.of(page.orElse(0) , 5 ));
    }

    @PostMapping("/newReview")
    public Review newReview(@RequestBody Review theReview)
    {
        System.out.println(theReview);
        reviewService.save(theReview);
        System.out.println(theReview);
        return theReview;
    }
    @PutMapping("/updateReview")
    public Review updateReview(@RequestBody Review theReview)
    {
        System.out.println(theReview);
        reviewService.save(theReview);
        System.out.println(theReview);
        return theReview;
    }
    @DeleteMapping("/deleteReview/{reviewId}")
    public String deleteReview(@PathVariable int reviewId)
    {
        reviewService.deleteById(reviewId);
        return "Review id - " + reviewId + " is deleted.";
    }
}
