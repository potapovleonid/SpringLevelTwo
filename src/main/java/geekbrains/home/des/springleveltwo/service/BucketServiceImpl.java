package geekbrains.home.des.springleveltwo.service;

import geekbrains.home.des.springleveltwo.dao.BucketDAO;
import geekbrains.home.des.springleveltwo.dao.ProductDAO;
import geekbrains.home.des.springleveltwo.domain.Bucket;
import geekbrains.home.des.springleveltwo.domain.Product;
import geekbrains.home.des.springleveltwo.domain.User;
import geekbrains.home.des.springleveltwo.dto.BucketDTO;
import geekbrains.home.des.springleveltwo.dto.BucketDetailDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketDAO bucketDAO;
    private final ProductDAO productDAO;
    private final UserService userService;

    public BucketServiceImpl(BucketDAO bucketDAO, ProductDAO productDAO, UserService userService) {
        this.bucketDAO = bucketDAO;
        this.productDAO = productDAO;
        this.userService = userService;
    }

    @Override
    public Bucket createBucket(User user, List<Long> productsId) {
        Bucket bucket = new Bucket();
//        test
        user.setBucket(bucket);
        List<Product> products = getCollectRefProducts(productsId);
        bucket.setProducts(products);
        return bucketDAO.save(bucket);
    }

    private List<Product> getCollectRefProducts(List<Long> ids){
        return ids.stream()
                .map(productDAO::getOne)
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(Bucket bucket, List<Long> productsId) {
        List<Product> products = bucket.getProducts();
        if (products == null){
            products = new ArrayList<>();
        }
        products.addAll(getCollectRefProducts(productsId));
        bucket.setProducts(products);
        bucketDAO.save(bucket);
    }

    @Override
    public BucketDTO getBucketByUser(String name) {
        User user = userService.findByName(name);

        if (user == null || user.getBucket() == null){
            return new BucketDTO();
        }

        BucketDTO bucketDTO = new BucketDTO();
        Map<Long, BucketDetailDTO> mapByProduct = new HashMap<>();

        List<Product> products = user.getBucket().getProducts();
        for (Product product : products){
            BucketDetailDTO detailDTO = mapByProduct.get(product.getId());
            if (detailDTO == null){
                mapByProduct.put(product.getId(), new BucketDetailDTO(product));
            } else {
                detailDTO.setAmount(detailDTO.getAmount() + 1.0);
                detailDTO.setSum(detailDTO.getSum() + product.getPrice());
            }
        }

        bucketDTO.setBucketDetails(new ArrayList<>(mapByProduct.values()));
        bucketDTO.aggregate();

        return bucketDTO;
    }
}
