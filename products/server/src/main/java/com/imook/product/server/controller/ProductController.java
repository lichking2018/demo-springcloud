package com.imook.product.server.controller;


import com.imook.product.server.dataobject.ProductCategory;
import com.imook.product.server.dataobject.ProductInfo;
import com.imook.product.server.dto.CartDto;
import com.imook.product.server.service.ProductCategoryService;
import com.imook.product.server.service.ProductService;
import com.imook.product.server.utils.ResultVoUtil;
import com.imook.product.server.vo.ProductInfoVo;
import com.imook.product.server.vo.ProductVo;
import com.imook.product.server.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @ProjectName: product
 * @Package: com.imooc.product.controller
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/5 6:49 PM
 * @Version: v1.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     *
     */
    @GetMapping("/list")
    @CrossOrigin(allowCredentials = "true")
    public ResultVo<ProductVo> list(){
        List<ProductInfo> productInfos = productService.findUpAll();

        List<Integer> categoryList = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());


        List<ProductCategory> byCategoryTypeIn = productCategoryService.findByCategoryTypeIn(categoryList);

        List<ProductVo> productVos = new ArrayList<>();

        for(ProductCategory productCategory:byCategoryTypeIn){
            ProductVo productVo = new ProductVo();

            productVo.setCategoryName(productCategory.getCategoryName());

            productVo.setCategoryType(productCategory.getCategoryType());

            List<ProductInfoVo> productInfoVos = new ArrayList<>();

            for(ProductInfo productInfo:productInfos){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVo productInfoVo = new ProductInfoVo();
                    BeanUtils.copyProperties(productInfo,productInfoVo);
                    productInfoVos.add(productInfoVo);
                }
            }
            productVo.setProductInfoVoList(productInfoVos);
            productVos.add(productVo);
        }

        return ResultVoUtil.getSuccessResult(productVos);
    }

    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDto> cartDtos){
        productService.decreaseStock(cartDtos);
    }
}
