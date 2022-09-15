package itsource.controller;

import itsource.entity.Product;
import itsource.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2022-09-15 15:32:32
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 分页查询
     *
     * @param product 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Product>> queryByPage(Product product, PageRequest pageRequest) {
        return ResponseEntity.ok(this.productService.queryByPage(product, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Product> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.productService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param product 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Product> add(Product product) {
        return ResponseEntity.ok(this.productService.insert(product));
    }

    /**
     * 编辑数据
     *
     * @param product 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Product> edit(Product product) {
        return ResponseEntity.ok(this.productService.update(product));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.productService.deleteById(id));
    }

}

