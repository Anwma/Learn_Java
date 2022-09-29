package itsource.service.impl;

import itsource.entity.Productorder;
import itsource.dao.ProductorderDao;
import itsource.service.ProductorderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Productorder)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@Service("productorderService")
public class ProductorderServiceImpl implements ProductorderService {
    @Resource
    private ProductorderDao productorderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Productorder queryById(Long id) {
        return this.productorderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param productorder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Productorder> queryByPage(Productorder productorder, PageRequest pageRequest) {
        long total = this.productorderDao.count(productorder);
        return new PageImpl<>(this.productorderDao.queryAllByLimit(productorder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param productorder 实例对象
     * @return 实例对象
     */
    @Override
    public Productorder insert(Productorder productorder) {
        this.productorderDao.insert(productorder);
        return productorder;
    }

    /**
     * 修改数据
     *
     * @param productorder 实例对象
     * @return 实例对象
     */
    @Override
    public Productorder update(Productorder productorder) {
        this.productorderDao.update(productorder);
        return this.queryById(productorder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.productorderDao.deleteById(id) > 0;
    }
}
