package com.cbond.dao.userinfo;

import com.cbond.base.UnitTestBase;
import com.cbond.dao.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;



/**
 * Passenger Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 14, 2018</pre>
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class PassengerTest extends UnitTestBase {


    public PassengerTest() {
        super("classpath*:spring-dao.xml");

    }
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void testSetter() {
        User user = super.getBean("passenger");
        String res = user.save("你好啊高天");
        Assert.assertEquals("你好啊高天", res);
    }


}
