package com.nxy.excel_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nxy.excel_demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Nilfie
 * @version 1.0
 * @date 2023/6/15 17:19
 * @description
 **/

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
