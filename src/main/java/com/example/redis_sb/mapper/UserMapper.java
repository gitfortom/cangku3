package com.example.redis_sb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.redis_sb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
