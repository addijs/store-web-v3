package br.edu.ifpb.padroes.storewebv3.service;

import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderFacade {

    @Autowired
    OrderService orderService;

    @Autowired
    ProductRepository productRepository;

    List<Product> listAvailableProducts() {
        return productRepository.getProductList();
    }

}
