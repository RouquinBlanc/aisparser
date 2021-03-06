package com.aisparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link Message24}. */
@RunWith(JUnit4.class)
public class Message24Test {

    @Test
    public void testParse() {
        Message24 msg = new Message24();

        try {
            Vdm vdm_message = new Vdm();

            // Part A
            int result = vdm_message.add("!AIVDM,1,1,,A,H52IRsP518Tj0l59D0000000000,2*45");
            assertEquals("vdm add failed", 0, result);
            msg.parse(vdm_message.sixbit());

            // Part B
            result = vdm_message.add("!AIVDM,1,1,,A,H52IRsTU000000000000000@5120,0*76");
            assertEquals("vdm add failed", 0, result);
            msg.parse(vdm_message.sixbit());
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertEquals("msgid", 24, msg.msgid());
        assertEquals("repeat", 0, msg.repeat());
        assertEquals("userid", 338060014, msg.userid());
        assertEquals("name", "APRIL MARU@@@@@@@@@@", msg.name());
        assertEquals("ship_type", 37, msg.ship_type());
        assertEquals("vendor_id", "@@@@@@@", msg.vendor_id());
        assertEquals("callsign", "@@@@@@@", msg.callsign());
        assertEquals("dim_bow", 2, msg.dim_bow());
        assertEquals("dim_stern", 5, msg.dim_stern());
        assertEquals("dim_port", 1, msg.dim_port());
        assertEquals("dim_starboard", 2, msg.dim_starboard());
        assertEquals("spare", 0, msg.spare());
        assertEquals("flags", 3, msg.flags());
    }
}
