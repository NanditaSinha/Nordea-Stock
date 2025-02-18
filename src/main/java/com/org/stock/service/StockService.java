package com.org.stock.service;

import com.org.stock.entity.Stock;
import com.org.stock.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StockService {
    private final StockRepository stockRepository;

    public boolean reduceStock(String productId, int quantity) {
        Stock stock = stockRepository.findByProductId(productId);
        if (stock != null && stock.getQuantity() >= quantity) {
            stock.setQuantity(stock.getQuantity() - quantity);
            stockRepository.save(stock);
            return true;
        }
        return false;
    }

    public Stock getStock(String productId) {
        return stockRepository.findByProductId(productId);
    }
}
