package geekbrains.home.des.springleveltwo.service;

import geekbrains.home.des.springleveltwo.domain.Bucket;
import geekbrains.home.des.springleveltwo.domain.Product;
import geekbrains.home.des.springleveltwo.domain.User;
import geekbrains.home.des.springleveltwo.dto.BucketDTO;

import java.util.List;

public interface BucketService {
    Bucket createBucket(User user, List<Long> productsId);
    void addProduct(Bucket bucket, List<Long> productsId);
    BucketDTO getBucketByUser(String name);
    void deleteProduct(BucketDTO bucketDTO, Long id, String name);
}
