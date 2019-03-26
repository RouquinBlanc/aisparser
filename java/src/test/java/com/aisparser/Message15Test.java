package com.aisparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link Message15}. */
@RunWith(JUnit4.class)
public class Message15Test {

    @Test
    public void testParse() {
        Message15 msg = new Message15();

        try {
            Vdm vdm_message = new Vdm();
            int result = vdm_message.add("!AIVDM,1,1,,A,?03OwpiGPmD0000,2*07\r\n");
            assertEquals("vdm add failed", 0, result);

            msg.parse(vdm_message.sixbit());
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals("msgid", 15, msg.msgid());
        assertEquals("repeat", 0, msg.repeat());
        assertEquals("userid", 3669987, msg.userid());
        assertEquals("num_reqs", 1, msg.num_reqs());
        assertEquals("spare1", 0, msg.spare1());
        assertEquals("destid1", 367056192, msg.destid1());
        assertEquals("msgid1_1", 0, msg.msgid1_1());
        assertEquals("offset1_1", 0, msg.offset1_1());
    }
}
