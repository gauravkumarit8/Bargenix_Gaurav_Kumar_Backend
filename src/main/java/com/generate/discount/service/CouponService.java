package com.generate.discount.service;

import com.generate.discount.model.Coupon;
import com.generate.discount.model.Product;
import com.generate.discount.model.Users;
import com.generate.discount.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public Coupon generateCoupon(Long productId, String userId) {
        Product product = productService.getProduct(productId);
        Users user = userService.getUser(userId);

        Coupon coupon = new Coupon();
        coupon.setCode(UUID.randomUUID().toString());
        coupon.setProductId(productId);
        coupon.setUserId(userId);
        coupon.setExpirationDate(LocalDateTime.now().plusDays(7)); // Coupon valid for 7 days
        coupon.setUsed(false);

        return couponRepository.save(coupon);
    }

    public boolean validateCoupon(String couponCode, Long productId, String userId) {
        Coupon coupon = couponRepository.findById(couponCode)
                .orElseThrow(() -> new RuntimeException("Invalid coupon"));

        if (coupon.isUsed()) {
            throw new RuntimeException("Coupon has already been used");
        }

        if (coupon.getExpirationDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Coupon has expired");
        }

        if (!coupon.getProductId().equals(productId)) {
            throw new RuntimeException("Coupon is not valid for this product");
        }

        if (!coupon.getUserId().equals(userId)) {
            throw new RuntimeException("Coupon is not valid for this user");
        }

        coupon.setUsed(true);
        couponRepository.save(coupon);

        return true;
    }
}

