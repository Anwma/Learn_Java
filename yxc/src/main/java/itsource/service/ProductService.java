package itsource.service;

import itsource.entity.Product;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Product)表服务接口
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
public interface ProductService {

    /**
     * 根据产品分类id获取产品信息
     *
     * @param id type表的id
     * @return
     */
    ResponseData queryByProductType(Long id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Product queryById(Long id);

    /**
     * 分页查询
     *
     * @param product 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Product> queryByPage(Product product, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
