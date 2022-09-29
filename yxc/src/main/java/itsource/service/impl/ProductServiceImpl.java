package itsource.service.impl;

import itsource.entity.Product;
import itsource.dao.ProductDao;
import itsource.service.ProductService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 根据产品分类id获取产品信息
     *
     * @param id type表的id
     * @return
     */
    @Override
    public ResponseData queryByProductType(Long id) {

        try {
            List<Product> products = productDao.queryByProductType(id);
            return new ResponseData(ResponseCode.SUCCESS, products);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Long id) {
        return this.productDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param product 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Product> queryByPage(Product product, PageRequest pageRequest) {
        long total = this.productDao.count(product);
        return new PageImpl<>(this.productDao.queryAllByLimit(product, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.productDao.deleteById(id) > 0;
    }
}
