package com.gongxc.common.testcase;

import com.gongxc.common.util.WireMockUtil;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * 测试
 * </p>
 *
 * @author gongxc
 * @date 2020/5/16
 */

public class WireMockTest {
    @Test
    void testMock(){
        WireMockUtil.mocking("{\"result\":\"success\",\"message\":\"成功！\"}");
    }
    @Test
    void testMoc(){
        WireMockUtil.mocking("hello");
    }
}
