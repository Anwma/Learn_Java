package itsource.controller;

import itsource.entity.Cart;
import itsource.service.CartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2022-09-15 15:32:25
 */
@RestController
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    /**
     * 分页查询
     *
     * @param cart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Cart>> queryByPage(Cart cart, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cartService.queryByPage(cart, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Cart> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.cartService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cart 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Cart> add(Cart cart) {
        return ResponseEntity.ok(this.cartService.insert(cart));
    }

    /**
     * 编辑数据
     *
     * @param cart 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Cart> edit(Cart cart) {
        return ResponseEntity.ok(this.cartService.update(cart));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.cartService.deleteById(id));
    }

}

