package jpa.buddy.stockmanagement.services;

import jpa.buddy.stockmanagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private ProductRepository productRepository;

    public long getQuantityByProductType(String name){
        return productRepository.countByProductType(name);
    }
}
