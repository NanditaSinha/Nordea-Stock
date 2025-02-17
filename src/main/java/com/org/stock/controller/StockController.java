package com.org.stock.controller;

import com.org.stock.service.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.Entity;
import javax.persistence.Id;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestParam String productId, @RequestParam int quantity) {
        boolean success = stockService.reduceStock(productId, quantity);
        return success ? ResponseEntity.ok("Stock reduced") : ResponseEntity.badRequest().body("Insufficient stock");
    }
}
