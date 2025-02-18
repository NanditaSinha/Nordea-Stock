package com.org.stock.controller;

import com.org.stock.entity.Stock;
import com.org.stock.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {
    private final StockService stockService;

    @PostMapping("/reduce")
    public ResponseEntity<String> reduceStock(@RequestParam String productId, @RequestParam int quantity) {
        boolean success = stockService.reduceStock(productId, quantity);
        return success ? ResponseEntity.ok("Stock reduced") : ResponseEntity.badRequest().body("Insufficient stock");
    }

    @GetMapping("/check")
    public ResponseEntity<Stock> checkStock(@RequestParam String productId) {
        Stock stock = stockService.getStock(productId);
        return stock != null ? ResponseEntity.ok(stock) : ResponseEntity.notFound().build();
    }
}
