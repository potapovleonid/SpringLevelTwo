package geekbrains.home.des.springleveltwo.controllers;

import geekbrains.home.des.springleveltwo.domain.Bucket;
import geekbrains.home.des.springleveltwo.dto.BucketDTO;
import geekbrains.home.des.springleveltwo.dto.ProductDTO;
import geekbrains.home.des.springleveltwo.mapper.BucketMapper;
import geekbrains.home.des.springleveltwo.service.BucketService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/bucket")
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String aboutBucket(Model model, Principal principal){
        if (principal == null){
            model.addAttribute("bucket", new BucketDTO());
        } else {
            BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDTO);
        }
        return "bucket";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable Long productID, Principal principal) {
        if (principal == null) {
            return "redirect:/bucket";
        } else {
            BucketDTO bucket = bucketService.getBucketByUser(principal.getName());
            bucketService.deleteProduct(bucket, productID);
        }
        return "redirect:/bucket";
    }

}
