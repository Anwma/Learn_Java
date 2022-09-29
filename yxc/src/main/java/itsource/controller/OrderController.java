package itsource.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itsource.entity.Order;
import itsource.service.OrderService;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2022-09-25 01:28:54
 */
@RestController
@RequestMapping("order")
@Api(tags = "订单接口")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 根据订单状态ostate获取用户对应的订单信息
     *
     * @param token
     * @param ostate
     * @return
     */
    @ApiOperation(value = "根据订单状态获取用户对应的订单信息", notes = "根据订单状态获取用户对应的订单信息")
    @GetMapping("queryOrder")
    public ResponseData queryOrder(String token, String ostate) {
        return orderService.queryOrder(token, ostate);
    }

    @ApiOperation(value = "根据token生成订单", notes = "根据token生成订单")
    @GetMapping("addOrder")
    public ResponseData addOrder(String token) {
        return orderService.addOrder(token);
    }

    /**
     * 分页查询
     *
     * @param order       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Order>> queryByPage(Order order, PageRequest pageRequest) {
        return ResponseEntity.ok(this.orderService.queryByPage(order, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Order> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.orderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param order 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Order> add(Order order) {
        return ResponseEntity.ok(this.orderService.insert(order));
    }

    /**
     * 编辑数据
     *
     * @param order 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Order> edit(Order order) {
        return ResponseEntity.ok(this.orderService.update(order));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.orderService.deleteById(id));
    }

}

