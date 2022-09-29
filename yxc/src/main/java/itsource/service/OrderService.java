package itsource.service;

import itsource.entity.Order;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
public interface OrderService {
    /**
     * 根据订单状态获取用户对应的订单信息
     *
     * @param token
     * @param ostate
     * @return
     */
    ResponseData queryOrder(String token, String ostate);
    /**
     * 根据token生成订单
     *
     * @param token
     * @return
     */
    ResponseData addOrder(String token);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Order queryById(Long id);

    /**
     * 分页查询
     *
     * @param order 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Order> queryByPage(Order order, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
