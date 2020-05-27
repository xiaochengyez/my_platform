package com.gongxc.platform_api.dao;

import com.gongxc.platform_api.entity.ApiObjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 接口dao层
 * </p>
 *
 * @author gongxc
 * @date 2020/5/25
 */
@Repository
public interface ApiRepository extends JpaRepository<ApiObjectModel,Long> {

//    @Modifying
//    @Transactional
//    @Query("update interfaces set name=?1 where id=?2")
//    void change(String name, Long id);
}
