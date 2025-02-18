package com.org.stock.controller;

import com.org.stock.entity.Stock;
import com.org.stock.service.StockService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StockControllerTest {

    @Mock
    private StockService stockService;

    @InjectMocks
    private StockController stockController;

    @Test
    public void testReduceStock_Success() {
        String productId = "123";
        int quantity = 10;

        when(stockService.reduceStock(productId, quantity)).thenReturn(true);

        ResponseEntity<String> response = stockController.reduceStock(productId, quantity);

        assertEquals(ResponseEntity.ok("Stock reduced"), response);
        verify(stockService).reduceStock(productId, quantity);
    }

    @Test
    public void testReduceStock_InsufficientStock() {
        String productId = "123";
        int quantity = 10;

        when(stockService.reduceStock(productId, quantity)).thenReturn(false);

        ResponseEntity<String> response = stockController.reduceStock(productId, quantity);

        assertEquals(ResponseEntity.badRequest().body("Insufficient stock"), response);
        verify(stockService).reduceStock(productId, quantity);
    }

    @Test
    public void testCheckStock_Found() {
        String productId = "123";
        Stock stock = new Stock(productId, 50);

        when(stockService.getStock(productId)).thenReturn(stock);

        ResponseEntity<Stock> response = stockController.checkStock(productId);

        assertEquals(ResponseEntity.ok(stock), response);
        verify(stockService).getStock(productId);
    }

    @Test
    public void testCheckStock_NotFound() {
        String productId = "123";

        when(stockService.getStock(productId)).thenReturn(null);

        ResponseEntity<Stock> response = stockController.checkStock(productId);

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(stockService).getStock(productId);
    }
}
