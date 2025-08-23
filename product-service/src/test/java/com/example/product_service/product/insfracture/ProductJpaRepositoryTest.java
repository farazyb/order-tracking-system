package com.example.product_service.product.insfracture;

import com.example.product_service.product.domain.model.Product;
import com.example.product_service.product.infrastructure.entity.ProductEntity;
import com.example.product_service.product.infrastructure.repository.ProductJPARepository;
import com.example.product_service.product.infrastructure.repository.ProductJPARepositoryInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ProductJpaRepositoryTest {
    @Mock
    ProductJPARepositoryInterface productJPARepositoryInterface;
    @InjectMocks
    ProductJPARepository productJPARepository;

    @Test
    @DisplayName("findAll maps JPA entities to domain Products preserving order")
    void findAll_mapsEntitiesToDomain() {
        // Arrange: sample entities as JPA rows
        String e1UUID = UUID.randomUUID().toString();
        String e2UUID = UUID.randomUUID().toString();
        ProductEntity e1 = new ProductEntity();
        e1.setId(e1UUID);
        e1.setName("P1");
        e1.setDescription("D1");
        e1.setPrice(new BigDecimal("10.00"));

        ProductEntity e2 = new ProductEntity();
        e2.setId(e2UUID);
        e2.setName("P2");
        e2.setDescription("D2");
        e2.setPrice(new BigDecimal("20.00"));

        when(productJPARepositoryInterface.findAll()).thenReturn(List.of(e1, e2));

        //Act
        List<Product> result = productJPARepository.findAll();
        verify(productJPARepositoryInterface, times(1)).findAll();

        //assert
        assertThat(result).hasSize(2);
        Product p1 = result.getFirst();
        assertThat(p1.getProductId().value()).isEqualTo(e1UUID);
        assertThat(p1.getName()).isEqualTo("P1");
        assertThat(p1.getDescription()).isEqualTo("D1");
        assertThat(p1.getPrice().amount()).isEqualByComparingTo("10.00");
        assertThat(p1.getPrice().currency()).isEqualTo("EURO");

        Product p2 = result.get(1);
        assertThat(p2.getProductId().value()).isEqualTo(e2UUID);
        assertThat(p2.getName()).isEqualTo("P2");
        assertThat(p2.getDescription()).isEqualTo("D2");
        assertThat(p2.getPrice().amount()).isEqualByComparingTo("20.00");
        assertThat(p2.getPrice().currency()).isEqualTo("EURO");

    }

    @Test
    @DisplayName("findAll returns empty list when repository has no rows")
    void findAll_empty() {
        when(productJPARepositoryInterface.findAll()).thenReturn(List.of());

        List<Product> result = productJPARepository.findAll();

        verify(productJPARepositoryInterface).findAll();
        assertThat(result).isEmpty();
    }
}
