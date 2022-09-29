package itsource.service;

import itsource.entity.Productorder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Productorder)表服务接口
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
public interface ProductorderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Productorder queryById(Long id);

    /**
     * 分页查询
     *
     * @param productorder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Productorder> queryByPage(Productorder productorder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param productorder 实例对象
     * @return 实例对象
     */
    Productorder insert(Productorder productorder);

    /**
     * 修改数据
     *
     * @param productorder 实例对象
     * @return 实例对象
     */
    Productorder update(Productorder productorder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
