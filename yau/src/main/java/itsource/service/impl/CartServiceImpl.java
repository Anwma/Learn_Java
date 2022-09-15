package itsource.service.impl;

import itsource.entity.Cart;
import itsource.dao.CartDao;
import itsource.service.CartService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2022-09-15 15:32:32
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cart queryById(Long id) {
        return this.cartDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cart 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cart> queryByPage(Cart cart, PageRequest pageRequest) {
        long total = this.cartDao.count(cart);
        return new PageImpl<>(this.cartDao.queryAllByLimit(cart, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart insert(Cart cart) {
        this.cartDao.insert(cart);
        return cart;
    }

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart update(Cart cart) {
        this.cartDao.update(cart);
        return this.queryById(cart.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.cartDao.deleteById(id) > 0;
    }
}
