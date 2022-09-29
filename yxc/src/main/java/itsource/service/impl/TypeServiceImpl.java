package itsource.service.impl;

import itsource.entity.Type;
import itsource.dao.TypeDao;
import itsource.service.TypeService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Type)表服务实现类
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    /**
     * 根据状态获取分类信息
     *
     * @param state
     * @return
     */
    @Override
    public ResponseData getTypes(String state) {
        Type type = new Type();
        try {
            //因为tstate是Integer类型，所以我们传的参数应该也是Integer类型
            if (state != null && !"".equals(state)) {//如果state不为空或者空字符串
                //强制转换数据类型，并赋值给type对象的tstate
                type.setTstate(Integer.valueOf(state));

            }
            List<Type> types = typeDao.queryAll(type);
            return new ResponseData(ResponseCode.SUCCESS, types);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
//            throw new RuntimeException(e);
        }
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Type queryById(Long id) {
        return this.typeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param type 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Type> queryByPage(Type type, PageRequest pageRequest) {
        long total = this.typeDao.count(type);
        return new PageImpl<>(this.typeDao.queryAllByLimit(type, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type insert(Type type) {
        this.typeDao.insert(type);
        return type;
    }

    /**
     * 修改数据
     *
     * @param type 实例对象
     * @return 实例对象
     */
    @Override
    public Type update(Type type) {
        this.typeDao.update(type);
        return this.queryById(type.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.typeDao.deleteById(id) > 0;
    }
}
