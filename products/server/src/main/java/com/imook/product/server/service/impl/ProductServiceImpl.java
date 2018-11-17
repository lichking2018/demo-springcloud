package com.imook.product.server.service.impl;


import com.alibaba.fastjson.JSON;
import com.imooc.product.common.ProductInfoOutput;
import com.imook.product.server.dataobject.ProductInfo;
import com.imook.product.server.dto.CartDto;
import com.imook.product.server.enums.ProductStatus;
import com.imook.product.server.enums.ResultEnum;
import com.imook.product.server.exception.ProductException;
import com.imook.product.server.repository.ProductInfoRepository;
import com.imook.product.server.service.ProductService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ProjectName: product
 * @Package: com.imooc.product.service.impl
 * @Description:
 * @Author: lichking2017@aliyun.com
 * @CreateDate: 2018/11/6 12:44 PM
 * @Version: v1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override

    public void decreaseStock(List<CartDto> cartDtos) {
        List<ProductInfo> productInfoList = this.decreaseStockProcess(cartDtos);


        List<ProductInfoOutput> productInfoOutputs = productInfoList.stream().map(e->{
            ProductInfoOutput productInfoOutput = new ProductInfoOutput();
            BeanUtils.copyProperties(e,productInfoOutput);
            return productInfoOutput;
        }).collect(Collectors.toList());


        amqpTemplate.convertAndSend("myQueue", JSON.toJSONString(productInfoOutputs));


    }

    @Transactional
    private List<ProductInfo> decreaseStockProcess(List<CartDto> cartDtos){
        List<ProductInfo> productInfoList = new ArrayList<>();
        for(CartDto cartDto:cartDtos){
            Optional<ProductInfo> one = productInfoRepository.findById(cartDto.getProductId());
            if(!one.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = one.get();
            Integer result = productInfo.getProductStock()-cartDto.getProductQuantity();

            if(result<0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
            productInfoList.add(productInfo);
        }
        return productInfoList;
    }
}
