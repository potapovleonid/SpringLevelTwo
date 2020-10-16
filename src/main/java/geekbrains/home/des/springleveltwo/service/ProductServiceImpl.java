package geekbrains.home.des.springleveltwo.service;

import geekbrains.home.des.springleveltwo.dao.ProductDAO;
import geekbrains.home.des.springleveltwo.domain.Bucket;
import geekbrains.home.des.springleveltwo.domain.Product;
import geekbrains.home.des.springleveltwo.domain.User;
import geekbrains.home.des.springleveltwo.dto.ProductDTO;
import geekbrains.home.des.springleveltwo.mapper.ProductMapper;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductMapper mapper = ProductMapper.MAPPER;

    private final ProductDAO productDAO;
    private final UserService userService;
    private final BucketService bucketService;

    public ProductServiceImpl(ProductDAO productDAO, UserService userService, BucketService bucketService) {
        this.productDAO = productDAO;
        this.userService = userService;
        this.bucketService = bucketService;
//        initializeDB();
    }

//    private void initializeDB() {
//        productDAO.saveAll(Arrays.asList(
//                new Product(null, "Apple", 25.15),
//                new Product(null, "Peach", 35.70),
//                new Product(null, "Carrot", 5.25),
//                new Product(null, "Butter", 80.0),
//                new Product(null, "Jam", 100.20)
//        ));
//    }

    @Override
    public List<ProductDTO> getAll() {
        return mapper.fromProductList(productDAO.findAll());
    }

    @Override
    public ProductDTO getById(Long id) {
        return mapper.fromProduct(productDAO.findById(id).orElse(null));
    }

    @Override
    public void deleteById(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void addToUserBucket(Long productId, String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new RuntimeException("User not found. \nName: " + username);
        }

        Bucket bucket = user.getBucket();
        if (bucket == null){
            Bucket newBucket = bucketService.createBucket(user, Collections.singletonList(productId));
            user.setBucket(newBucket);
            userService.save(user);
        } else {
            bucketService.addProduct(bucket, Collections.singletonList(productId));
        }

    }
}
