package com.zsx.api.controller;

import com.zsx.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/v1")
@EnableSwagger2
public class UserController {

    @ApiOperation(value = "根据id获取用户信息", notes = "id不能为空")
    @GetMapping("user/{id}")
    public User get(String id) {
        if ("123".equals(id)) {
            return new User("123", "zhangsan", 18);
        }
        return new User();
    }

    @PostMapping("user")
    public String insert(@RequestBody User user) {
        user.setId("1234");
        return user.getId();
    }

    @DeleteMapping("user/{id}")
    public String delete(@RequestBody User user) {
        user.setId("1234");
        return user.getId();
    }

    @PutMapping("user")
    public String update(@RequestBody User user) {
        user.setId("1234");
        return user.getId();
    }
}