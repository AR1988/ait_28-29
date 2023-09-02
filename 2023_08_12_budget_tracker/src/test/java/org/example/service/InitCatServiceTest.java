//package org.example.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.example.entity.EntityEnum;
//import org.example.repository.impl.CategoryRepository;
//import org.example.repository.impl.SubCategoryRepository;
//import org.example.utils.CategoryJson;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertIterableEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//class InitCatServiceTest {
//
//    private static InitCatService initCatService;
//
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @BeforeAll
//    static void beforeAll() throws IOException {
//        TestRunner.init();
//
//        SubCategoryRepository subCategoryRepository = new SubCategoryRepository(EntityEnum.SUB_CATEGORY_TEST);
//        SubCategoryService subCategoryService = new SubCategoryService(subCategoryRepository);
//
//        CategoryRepository categoryRepository = new CategoryRepository(EntityEnum.CATEGORY_TEST);
//        CategoryService categoryService = new CategoryService(categoryRepository, subCategoryService);
//        initCatService = new InitCatService(categoryService, subCategoryService);
//    }
//
//    @Test
//    void name() throws IOException {
//
//        String fileNameUnderTest = "category_init.json";
//        List<CategoryJson> result = initCatService.readJson(fileNameUnderTest);
//
//        List<CategoryJson> expectedResult = objectMapper.readValue(new FileReader(fileNameUnderTest), new TypeReference<List<CategoryJson>>() {
//        });
//
//        assertNotNull(result);
//        assertIterableEquals(expectedResult, result);
//    }
//}
