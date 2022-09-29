package itsource.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itsource.entity.Cart;
import itsource.service.CartService;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2022-09-25 01:28:49
 */
@RestController
@RequestMapping("cart")
@Api(tags = "购物车接口")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    /**
     * 改变购物车中单品的数量
     *
     * @return
     */
    @ApiOperation(value = "改变购物车中单品的数量", notes = "改变购物车中单品的数量")
    @GetMapping("changeNumber")
    public ResponseData changeNumber(String cmd, String token, Long id) {
        return cartService.changeNumber(cmd, token, id);
    }

    /**
     * 根据token和购物车id删除购物车商品信息
     *
     * @return
     */
    @ApiOperation(value = "根据token和购物车id删除购物车商品信息", notes = "根据token和购物车id删除购物车商品信息")
    @GetMapping("deleteCart")
    public ResponseData deleteCart(String token, Long id) {
        return cartService.deleteCart(token, id);
    }

    /**
     * 根据token获取购物车信息
     *
     * @param token
     * @return
     */
    @ApiOperation(value = "根据token获取购物车信息", notes = "根据token获取购物车信息")
    @GetMapping("queryCartInfo")
    public ResponseData queryCartInfo(String token) {
        return cartService.queryCartInfo(token);
    }

    /**
     * 商品添加到购物车
     *
     * @return
     */
    @ApiOperation(value = "商品添加到购物车", notes = "商品添加到购物车")
    @GetMapping("addCart")
    public ResponseData addCart(Cart cart, String token) {

        System.out.println("uid==" + cart.getUid());
        System.out.println("pid==" + cart.getPid());
        System.out.println("token==" + token);

        return cartService.addCart(cart, token);
    }

    /**
     * 分页查询
     *
     * @param cart        筛选条件
     * @param pageRequest 分页对象
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

