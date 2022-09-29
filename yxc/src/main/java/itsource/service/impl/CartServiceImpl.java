package itsource.service.impl;

import itsource.dao.UserDao;
import itsource.entity.Cart;
import itsource.dao.CartDao;
import itsource.entity.User;
import itsource.service.CartService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:54
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;
    @Resource
    private UserDao userDao;

    /**
     * 改变购物车中单品的数量
     *
     * @param cmd   add--加法   sub---减法
     * @param token
     * @param id    cart表的id
     * @return
     */
    @Override
    public ResponseData changeNumber(String cmd, String token, Long id) {
        try {
            //1.根据token，查询用户id(调用UserDao的queryUserByToken方法即可)
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }

            //2.根据id(cart表的id)去获取对应的购物车信息
            Cart cart = cartDao.queryById(id);

            //3.计算器的加减法判定
            if (null != cmd && cmd.equals("add")) {
                cart.setNumber(cart.getNumber() + 1);
            } else if (null != cmd && cmd.equals("sub")) {
                Integer newNum = cart.getNumber() - 1;
                if (newNum <= 0) {//如果数量不足1时，删除购物车该单品的信息
                    cartDao.deleteById(id);
                }
                cart.setNumber(newNum);
            }

            //4.将修改后的数据更新到cart表中
            cartDao.update(cart);

            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("改变数量失败==" + e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData deleteCart(String token, Long id) {

        try {
            //1.根据token，查询用户id(调用UserDao的queryUserByToken方法即可)
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }

            //2.根据购物车id和用户id删除购物车商品信息
            cartDao.deleteCart(id, user.getId());
            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("删除数据失败==" + e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 根据token获取购物车信息
     *
     * @param token
     * @return
     */
    @Override
    public ResponseData queryCartInfo(String token) {

        try {
            //1、根据token，查询用户id(调用UserDao的queryUserByToken方法即可)
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }

            //2、根据用户id(uid)获取购物车商品信息（一个购物车对应多个商品，一对多）
            List<Cart> carts = cartDao.queryCartByUid(user.getId());

            //3、返回购物车数据
            return new ResponseData(ResponseCode.SUCCESS, carts);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("根据token获取购物车信息==" + e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 商品添加到购物车
     *
     * @param cart
     * @param token
     * @return
     */
    @Override
    public ResponseData addCart(Cart cart, String token) {
        try {
            //1、根据token，查询用户id(调用UserDao的queryUserByToken方法即可)
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2、更新cart的uid
            cart.setUid(user.getId());
            //3、校验是否已经存在于购物车  根据传入的用户id和商品id进行查询(购物车表)
            Long count = cartDao.queryCount(cart.getUid(), cart.getPid());
            if (count > 0) {
                return new ResponseData(ResponseCode.ERROR_5);
            }
            //4、执行新增操作(新增到购物车表)
            cartDao.insert(cart);
            return new ResponseData(ResponseCode.SUCCESS);
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
