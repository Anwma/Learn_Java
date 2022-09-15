package itsource.service;

import itsource.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Type)表服务接口
 *
 * @author makejava
 * @since 2022-09-15 15:32:33
 */
public interface TypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Type queryById(Long id);

    /**
     * 分页查询
     *
     * @param type 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Type> queryByPage(Type type, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    Type insert(Type type);

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    Type update(Type type);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
