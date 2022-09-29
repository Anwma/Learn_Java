package itsource.service.impl;

import itsource.dao.CartDao;
import itsource.dao.ProductorderDao;
import itsource.dao.UserDao;
import itsource.entity.Cart;
import itsource.entity.Order;
import itsource.dao.OrderDao;
import itsource.entity.Productorder;
import itsource.entity.User;
import itsource.service.OrderService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private ProductorderDao productorderDao;

    @Resource
    private UserDao userDao;

    @Resource
    private CartDao cartDao;

    /**
     * 根据订单状态获取用户对应的订单信息
     *
     * @param token
     * @param ostate
     * @return
     */
    @Override
    public ResponseData queryOrder(String token, String ostate) {
        //1.根据token获取用户信息
        try {
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2.根据uid ostate 获取信息
            List<Order> orders = orderDao.queryOrderInfo(user.getId(), ostate);
            return new ResponseData(ResponseCode.SUCCESS, orders);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询订单错误: " + e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 根据token生成订单
     *
     * @param token
     * @return
     */
    @Override
    public ResponseData addOrder(String token) {

        try {
            //1、根据token，查询用户id(调用UserDao的queryUserByToken方法即可)
            User user = userDao.queryUserByToken(token);
            if (user == null) {
                return new ResponseData(ResponseCode.ERROR_6);
            }
            //2、根据用户id，获取目前购物车信息（调用CartDao的queryCartByUid方法即可）
            List<Cart> carts = cartDao.queryCartByUid(user.getId());
            //3、生成流水号
            String uuid = UUID.randomUUID().toString().replace("-", "");
            System.out.println("uuid==" + uuid);
            //4、生成订单，准备订单信息
            double totalPrice = createOrder(carts, user.getId(), uuid);
            //5、生成产品、订单中间表(通过流水号进行关联)
            createProductOrder(carts, uuid);
            //6、清除购物车数据（根据用户id删除，调用CartDao的deleteCartByUid方法即可）
            cartDao.deleteCartByUid(user.getId());
            //7、修改积分
            user.setUintegral(user.getUintegral() + totalPrice);
            userDao.update(user);

            return new ResponseData(ResponseCode.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("订单生成失败==" + e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 生成产品、订单中间表
     *
     * @param carts
     */
    public void createProductOrder(List<Cart> carts, String uuid) {
        List<Productorder> list = new ArrayList<>();
        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            Productorder po = new Productorder();
            po.setNumber(cart.getNumber());
            po.setOid(uuid); //需要修改
            po.setPid(cart.getPid());
            po.setPrice(String.valueOf(cart.getTprice()));
            list.add(po);
        }
        //插入数据(批量)
        productorderDao.insertBatch(list);
    }

    /**
     * 生成订单
     *
     * @param carts
     * @param uid
     */
    public double createOrder(List<Cart> carts, Long uid, String uuid) {
        Order order = new Order();
        order.setOtype(0); //自取
        order.setUid(uid);
        order.setPaystate(1);//已支付
        order.setOstate(0);  //预定中
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOtime(sdf.format(new Date()));
        double totalPrice = 0.0;
        for (int i = 0; i < carts.size(); i++) {
            Cart cart = carts.get(i);
            totalPrice += cart.getNumber() * cart.getTprice();
            System.out.println("总价格为：" + totalPrice);
        }
        order.setOnumber(uuid);  //订单流水号
        order.setOprice(String.valueOf(totalPrice)); //该订单的总价格

        orderDao.insert(order);
        return totalPrice;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long id) {
        return this.orderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param order       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Order> queryByPage(Order order, PageRequest pageRequest) {
        long total = this.orderDao.count(order);
        return new PageImpl<>(this.orderDao.queryAllByLimit(order, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.orderDao.deleteById(id) > 0;
    }
}
