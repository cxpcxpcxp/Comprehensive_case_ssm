package com.plantasun_ssm.dao;

import com.plantasun_ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface IMemberDAO {
    @Select("select * from member where id = #{id}")
    public Member findMemberById(String id);
}
