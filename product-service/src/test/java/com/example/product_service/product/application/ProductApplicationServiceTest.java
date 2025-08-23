package com.example.product_service.product.application;

import com.example.product_service.product.application.service.ProductApplicationService;
import com.example.product_service.product.domain.model.Money;
import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.domain.model.ProductId;
import com.example.product_service.product.domain.repository.ProductRepository;
import com.example.product_service.product.rest.dto.ProductCreateRequest;
import com.example.product_service.product.rest.dto.ProductResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductApplicationServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductApplicationService productApplicationService;

    @Captor
    private ArgumentCaptor<Product> productCaptor;

    @Test
    @DisplayName("Should create and save a product when given a valid request")
    void createProduct_withValidRequest_shouldSaveProduct() {
        // Arrange
        var createRequest = new ProductCreateRequest(
                "Super Widget",
                "A widget that is super.",
                new BigDecimal("199.99")
        );

        // Act
        productApplicationService.createProduct(createRequest);

        // Assert
        verify(productRepository).save(productCaptor.capture());
        Product savedProduct = productCaptor.getValue();

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getProductId()).isNotNull();
        assertThat(savedProduct.getProductId().value()).isNotBlank();
        assertThat(savedProduct.getName()).isEqualTo("Super Widget");
        assertThat(savedProduct.getDescription()).isEqualTo("A widget that is super.");
        assertThat(savedProduct.getPrice().amount()).isEqualByComparingTo("199.99");
        assertThat(savedProduct.getPrice().currency()).isEqualTo("EURO");
    }

    @Test
    @DisplayName("Should throw NullPointerException when create request is null")
    void createProduct_withNullRequest_shouldThrowException() {
        // Act & Assert
        assertThatThrownBy(() -> productApplicationService.createProduct(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("Should return all products when getAllProducts is called")
    void getAllProduct_shouldReturnAllProducts() {
        // Arrange
        Product product1 = Product.builder()
                .productId
                        (new ProductId())
                .name("Product 1")
                .description("Description 1")
                .price(Money.of(new BigDecimal("10.00"), "EURO"))
                .build();
        Product product2 = Product.builder()
                .productId
                        (new ProductId())
                .name("Product 2")
                .description("Description 2")
                .price(Money.of(new BigDecimal("20.00"), "EURO"))
                .build();
        when(productRepository.findAll()).thenReturn(List.of(product1, product2));

        // Act
        List<ProductResponse> products = productApplicationService.getAllProducts();
        verify(productRepository, times(1)).findAll();
        // Assert
        assertThat(products).hasSize(2);
        assertThat(products.getFirst().name()).isEqualTo("Product 1");
        assertThat(products.getFirst().description()).isEqualTo("Description 1");
        assertThat(products.getFirst().price()).isEqualTo(10.0);


    }
}