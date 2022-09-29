package itsource.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import itsource.entity.User;
import itsource.service.UserService;
import itsource.utils.ResponseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-09-25 01:28:55
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户接口")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 根据token获取用户信息
     * @param token
     * @return
     */
    @ApiOperation(value = "根据token获取用户信息", notes = "根据token获取用户信息")
    @GetMapping("queryUserInfo")
    public ResponseData queryUserInfo(String token) {
        System.out.println("token==" + token);
        return userService.queryUserInfo(token);
    }

    /**
     * 用户登录
     *
     * @return
     */
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("userLogin")
    public ResponseData userLogin(User user) {
        return userService.userLogin(user);
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @PostMapping("registerUtell")
    public ResponseData registerUtell(User user) {
        return userService.registerUtell(user);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

}

