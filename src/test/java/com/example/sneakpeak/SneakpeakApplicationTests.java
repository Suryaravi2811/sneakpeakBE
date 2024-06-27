package com.example.sneakpeak;

import com.example.sneakpeak.DTO.ProductDTO;
import com.example.sneakpeak.Entity.Product;

import com.example.sneakpeak.Repository.ProductRepository;
import com.example.sneakpeak.Service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SneakpeakApplicationTests {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductService productService;

    private final ProductService productServices = new ProductService();

	@Test
	public  void  getDataTest(){

		Product mockProduct = new Product();
		mockProduct.setId(1L);
		mockProduct.setName("Test Product");
		mockProduct.setImage("test.jpg");
		mockProduct.setType("Type");
		mockProduct.setPrice("100");
		mockProduct.setDelivery("Fast");
		mockProduct.setDescription("Description");
		mockProduct.setDetails("Details");
		mockProduct.setWater("Waterproof");
		mockProduct.setStyle("Style");
		mockProduct.setClosure("Closure");
		mockProduct.setHeel("Heel");
		mockProduct.setCountry("Country");
		mockProduct.setColor("Color");
		mockProduct.setBrand("Brand");
		mockProduct.setManufacturerDetails("Manufacturer Details");

		List<Product> mockProducts = List.of(mockProduct);
		when(productRepository.findAll()).thenReturn(mockProducts);
		List<ProductDTO> productDTOS = productService.getAllProducts();
		ProductDTO expectedProductDTO = new ProductDTO(1L, "Test Product", "test.jpg", "Type", "100", "Fast", "Description", "Details", "Waterproof", "Style", "Closure", "Heel", "Country", "Color", "Brand", "Manufacturer Details");
		assertEquals(List.of(expectedProductDTO), productDTOS);
	}

	@Test
	void postProductsTest() {
		// Create a mock Product entity
		Product mockProduct = new Product();
		mockProduct.setBrand("Brand");
		mockProduct.setClosure("Closure");
		mockProduct.setColor("Color");
		mockProduct.setDescription("Description");
		mockProduct.setDelivery("Fast");
		mockProduct.setCountry("Country");
		mockProduct.setHeel("Heel");
		mockProduct.setDetails("Details");
		mockProduct.setImage("image.jpg");
		mockProduct.setType("Type");
		mockProduct.setPrice("100");
		mockProduct.setWater("Waterproof");
		mockProduct.setStyle("Style");
		mockProduct.setName("Product Name");
		mockProduct.setManufacturerDetails("Manufacturer Details");

		// Mock the behavior of productRepository.save()
		when(productRepository.save(any(Product.class))).thenReturn(mockProduct);

		// Create a ProductDTO to save
		ProductDTO productDTO = new ProductDTO();
		productDTO.setName("Product Name");
		productDTO.setImage("image.jpg");
		productDTO.setType("Type");
		productDTO.setPrice("100");
		productDTO.setDelivery("Fast");
		productDTO.setDescription("Description");
		productDTO.setDetails("Details");
		productDTO.setWater("Waterproof");
		productDTO.setStyle("Style");
		productDTO.setClosure("Closure");
		productDTO.setHeel("Heel");
		productDTO.setCountry("Country");
		productDTO.setColor("Color");
		productDTO.setBrand("Brand");
		productDTO.setManufacturerDetails("Manufacturer Details");

		// Call the service method
		Product savedProduct = productService.postProducts(productDTO);

		// Verify the result
		assertEquals(mockProduct, savedProduct);
	}

    //using contoller class in mokito test


//parameterized test in below
    @ParameterizedTest
    @MethodSource("provideProductsForTesting")
    void testOfGetProducts(Product product,ProductDTO productDTO){
    ProductDTO actualProductDTO = productServices.convertToDTO(product);
    assertEquals(productDTO,actualProductDTO);
    }


    static Stream<Arguments> provideProductsForTesting() {
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setBrand("Brand");
        mockProduct.setClosure("Closure");
        mockProduct.setColor("Color");
        mockProduct.setDescription("Description");
        mockProduct.setDelivery("Fast");
        mockProduct.setCountry("Country");
        mockProduct.setHeel("Heel");
        mockProduct.setDetails("Details");
        mockProduct.setImage("image.jpg");
        mockProduct.setType("Type");
        mockProduct.setPrice("100");
        mockProduct.setWater("Waterproof");
        mockProduct.setStyle("Style");
        mockProduct.setName("Product Name");
        mockProduct.setManufacturerDetails("Manufacturer Details");


        Product mockProduct2 = new Product();
        mockProduct.setId(2L);
        mockProduct.setBrand("Brand");
        mockProduct.setClosure("Closure");
        mockProduct.setColor("Color");
        mockProduct.setDescription("Description");
        mockProduct.setDelivery("Fast");
        mockProduct.setCountry("Country");
        mockProduct.setHeel("Heel");
        mockProduct.setDetails("Details");
        mockProduct.setImage("image.jpg");
        mockProduct.setType("Type");
        mockProduct.setPrice("100");
        mockProduct.setWater("Waterproof");
        mockProduct.setStyle("Style");
        mockProduct.setName("Product Name");
        mockProduct.setManufacturerDetails("Manufacturer Details");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Product Name");
        productDTO.setImage("image.jpg");
        productDTO.setType("Type");
        productDTO.setPrice("100");
        productDTO.setDelivery("Fast");
        productDTO.setDescription("Description");
        productDTO.setDetails("Details");
        productDTO.setWater("Waterproof");
        productDTO.setStyle("Style");
        productDTO.setClosure("Closure");
        productDTO.setHeel("Heel");
        productDTO.setCountry("Country");
        productDTO.setColor("Color");
        productDTO.setBrand("Brand");
        productDTO.setManufacturerDetails("Manufacturer Details");

        ProductDTO productDTO2 = new ProductDTO();
        productDTO.setId(2L);
        productDTO.setName("Product Name");
        productDTO.setImage("image.jpg");
        productDTO.setType("Type");
        productDTO.setPrice("100");
        productDTO.setDelivery("Fast");
        productDTO.setDescription("Description");
        productDTO.setDetails("Details");
        productDTO.setWater("Waterproof");
        productDTO.setStyle("Style");
        productDTO.setClosure("Closure");
        productDTO.setHeel("Heel");
        productDTO.setCountry("Country");
        productDTO.setColor("Color");
        productDTO.setBrand("Brand");
        productDTO.setManufacturerDetails("Manufacturer Details");
        return Stream.of(
                Arguments.of(
                        mockProduct,productDTO
                ),
                Arguments.of(mockProduct2,productDTO2)
        );
    }

    @ParameterizedTest
    @MethodSource("postProductsTesting")
    void testPostProducts(ProductDTO productDTO,Product expectedProduct){
        Product actualProduct = productService.postProducts(productDTO);
        assertEquals(expectedProduct,actualProduct);
    }

    static Stream<Arguments> postProductsTesting(){

        Product mockProduct = new Product();
        mockProduct.setBrand("Brand");
        mockProduct.setClosure("Closure");
        mockProduct.setColor("Color");
        mockProduct.setDescription("Description");
        mockProduct.setDelivery("Fast");
        mockProduct.setCountry("Country");
        mockProduct.setHeel("Heel");
        mockProduct.setDetails("Details");
        mockProduct.setImage("image.jpg");
        mockProduct.setType("Type");
        mockProduct.setPrice("100");
        mockProduct.setWater("Waterproof");
        mockProduct.setStyle("Style");
        mockProduct.setName("Product Name");
        mockProduct.setManufacturerDetails("Manufacturer Details");

        Product mockProduct2 = new Product();
        mockProduct.setBrand("Brand");
        mockProduct.setClosure("Closure");
        mockProduct.setColor("Color");
        mockProduct.setDescription("Description");
        mockProduct.setDelivery("Fast");
        mockProduct.setCountry("Country");
        mockProduct.setHeel("Heel");
        mockProduct.setDetails("Details");
        mockProduct.setImage("image.jpg");
        mockProduct.setType("Type");
        mockProduct.setPrice("100");
        mockProduct.setWater("Waterproof");
        mockProduct.setStyle("Style");
        mockProduct.setName("Product Name");
        mockProduct.setManufacturerDetails("Manufacturer Details");

        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Product Name");
        productDTO.setImage("image.jpg");
        productDTO.setType("Type");
        productDTO.setPrice("100");
        productDTO.setDelivery("Fast");
        productDTO.setDescription("Description");
        productDTO.setDetails("Details");
        productDTO.setWater("Waterproof");
        productDTO.setStyle("Style");
        productDTO.setClosure("Closure");
        productDTO.setHeel("Heel");
        productDTO.setCountry("Country");
        productDTO.setColor("Color");
        productDTO.setBrand("Brand");
        productDTO.setManufacturerDetails("Manufacturer Details");

        ProductDTO productDTO2 = new ProductDTO();
        productDTO.setName("Product Name");
        productDTO.setImage("image.jpg");
        productDTO.setType("Type");
        productDTO.setPrice("100");
        productDTO.setDelivery("Fast");
        productDTO.setDescription("Description");
        productDTO.setDetails("Details");
        productDTO.setWater("Waterproof");
        productDTO.setStyle("Style");
        productDTO.setClosure("Closure");
        productDTO.setHeel("Heel");
        productDTO.setCountry("Country");
        productDTO.setColor("Color");
        productDTO.setBrand("Brand");
        productDTO.setManufacturerDetails("Manufacturer Details");
        return Stream.of(
               Arguments.of(
                    productDTO,mockProduct
               ),
                Arguments.of(
                        productDTO2,mockProduct2
                )
        );
    }
}
