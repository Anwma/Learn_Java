package itsource.controller;

import io.swagger.annotations.Api;
import itsource.entity.Productorder;
import itsource.service.ProductorderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Productorder)表控制层
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@RestController
@RequestMapping("productorder")
@Api(tags = "商品订单接口")
public class ProductorderController {
    /**
     * 服务对象
     */
    @Resource
    private ProductorderService productorderService;

    /**
     * 分页查询
     *
     * @param productorder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Productorder>> queryByPage(Productorder productorder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.productorderService.queryByPage(productorder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Productorder> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.productorderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param productorder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Productorder> add(Productorder productorder) {
        return ResponseEntity.ok(this.productorderService.insert(productorder));
    }

    /**
     * 编辑数据
     *
     * @param productorder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Productorder> edit(Productorder productorder) {
        return ResponseEntity.ok(this.productorderService.update(productorder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.productorderService.deleteById(id));
    }

}

