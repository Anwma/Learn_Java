package itsource.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itsource.entity.Type;
import itsource.service.TypeService;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Type)表控制层
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@RestController
@RequestMapping("type")
@Api(tags = "类型接口")
public class TypeController {
    /**
     * 服务对象
     */
    @Resource
    private TypeService typeService;

    /**
     * 根据状态获取分类信息
     *
     * @param state
     * @return
     */
    @ApiOperation(value = "根据状态获取分类信息", notes = "根据状态获取分类信息")
    @GetMapping("getTypes")
    public ResponseData getTypes(String state) {
        return typeService.getTypes(state);
    }

    /**
     * 分页查询
     *
     * @param type 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Type>> queryByPage(Type type, PageRequest pageRequest) {
        return ResponseEntity.ok(this.typeService.queryByPage(type, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Type> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.typeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param type 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Type> add(Type type) {
        return ResponseEntity.ok(this.typeService.insert(type));
    }

    /**
     * 编辑数据
     *
     * @param type 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Type> edit(Type type) {
        return ResponseEntity.ok(this.typeService.update(type));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.typeService.deleteById(id));
    }

}

