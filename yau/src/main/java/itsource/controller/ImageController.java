package itsource.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itsource.entity.Image;
import itsource.service.ImageService;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Image)表控制层
 *
 * @author makejava
 * @since 2022-09-15 15:32:32
 */
@RestController
@RequestMapping("image")
@Api(tags = "图片接口")
public class ImageController {
    /**
     * 服务对象
     */
    @Resource
    private ImageService imageService;

    /**
     * 根据图片类型查询图片信息
     *
     * @param imageType 图片类型
     * @return
     */
    @ApiOperation(value = "根据图片类型查询图片信息", notes = "根据图片类型查询图片信息")
    @GetMapping("queryByImageType")
    public ResponseData queryByImageType(String imageType) {

//        ResponseData responseData = imageService.queryByImageType(imageType);
//        return responseData;

        return imageService.queryByImageType(imageType);
    }

    /**
     * 分页查询
     *
     * @param image       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Image>> queryByPage(Image image, PageRequest pageRequest) {
        return ResponseEntity.ok(this.imageService.queryByPage(image, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Image> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.imageService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param image 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Image> add(Image image) {
        return ResponseEntity.ok(this.imageService.insert(image));
    }

    /**
     * 编辑数据
     *
     * @param image 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Image> edit(Image image) {
        return ResponseEntity.ok(this.imageService.update(image));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.imageService.deleteById(id));
    }

}

