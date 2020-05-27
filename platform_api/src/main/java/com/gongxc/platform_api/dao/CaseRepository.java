package com.gongxc.platform_api.dao;

import com.gongxc.platform_api.entity.Cases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CaseRepository extends JpaRepository<Cases,Long> {

    @Modifying
    @Transactional
    @Query("update cases set name=?1 where id=?2")
    void change(String name, Long id);

    @Modifying
    @Transactional
    @Query("update cases set case_type='1' where id=?1")
    void run(Long id);
}
