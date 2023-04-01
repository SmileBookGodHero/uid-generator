package com.baidu.fsg.uid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author lilei
 * @date 2021-11-05 下午10:36
 * @apiNote
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:uid/default-uid-spring.xml"})
public class SequenceGenerateTest {

    @Resource
    private UidGenerator uidGenerator;

    @Test
    public void testSerialGenerate() {
        // Generate UID
        long uid = uidGenerator.getUID();

        // Parse UID into [Timestamp, WorkerId, Sequence]
        // {"UID":"180363646902239241","parsed":{    "timestamp":"2017-01-19 12:15:46",    "workerId":"4",    "sequence":"9"        }}
        System.out.println(uidGenerator.parseUID(uid));
    }
}
