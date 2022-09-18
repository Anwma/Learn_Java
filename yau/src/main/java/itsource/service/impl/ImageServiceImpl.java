package itsource.service.impl;

import itsource.entity.Image;
import itsource.dao.ImageDao;
import itsource.service.ImageService;
import itsource.utils.ResponseCode;
import itsource.utils.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2022-09-15 15:32:32
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    /**
     * 根据图片类型查询图片信息
     *
     * @param imageType 图片类型
     * @return
     */
    @Override
    public ResponseData queryByImageType(String imageType) {
        Image image = new Image();
        image.setItype(imageType);
        image.setIstate(1);
        List<Image> images = null;

        try {
            //查询得到的所有图片信息
            images = imageDao.queryByImageType(image);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
//            throw new RuntimeException(e);
            return new ResponseData(ResponseCode.FAIL);
        }

        return new ResponseData(ResponseCode.SUCCESS, images);
//        return new ResponseData(ResponseCode.FAIL);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Image queryById(Long id) {
        return this.imageDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param image       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Image> queryByPage(Image image, PageRequest pageRequest) {
        long total = this.imageDao.count(image);
        return new PageImpl<>(this.imageDao.queryAllByLimit(image, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image insert(Image image) {
        this.imageDao.insert(image);
        return image;
    }

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image update(Image image) {
        this.imageDao.update(image);
        return this.queryById(image.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.imageDao.deleteById(id) > 0;
    }
}
