package com.gongxc.platform_api.dao;

import com.gongxc.platform_api.entity.ApiObjectModel;
import com.gongxc.platform_api.entity.ResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * dao层
 * </p>
 *
 * @author gongxc
 * @date 2020/5/26
 */
@Repository
public interface ResultRepository extends JpaRepository<ResponseData,Long> {
}
