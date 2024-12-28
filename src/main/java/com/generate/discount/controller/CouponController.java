package com.generate.discount.controller;

import com.generate.discount.model.Coupon;
import com.generate.discount.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/generate")
    public ResponseEntity<Coupon> generateCoupon(@RequestParam Long productId, @RequestParam String userId) {
        Coupon coupon = couponService.generateCoupon(productId, userId);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateCoupon(@RequestParam String couponCode, @RequestParam Long productId, @RequestParam String userId) {
        boolean isValid = couponService.validateCoupon(couponCode, productId, userId);
        return ResponseEntity.ok(isValid);
    }
}

