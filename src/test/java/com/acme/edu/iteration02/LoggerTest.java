package com.acme.edu.iteration02;

import com.acme.Logger.Logger;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion


//    TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogSequentIntegersAsSum() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log(1);
        Logger.log(2);
        Logger.flush();
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.getProperty("line.separator")
        );//endregion
        assertSysoutContains("3" + System.getProperty("line.separator")
        );
        assertSysoutContains("str 2" + System.getProperty("line.separator")
        );
        assertSysoutContains("0" + System.getProperty("line.separator")
        );
    }

    @Test
    public void shouldLogCorrectlyIntegerOverflowWhenSequentIntegers() {
        //region when
        Logger.log("str 1");
        Logger.log(10);
        Logger.log(Integer.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains("str 1" + System.getProperty("line.separator")
        );//endregion
        assertSysoutContains("10" + System.getProperty("line.separator")
        );
        assertSysoutContains(Integer.MAX_VALUE + System.getProperty("line.separator")
        );
        assertSysoutContains("str 2" + System.getProperty("line.separator")
        );
        assertSysoutContains("0" + System.getProperty("line.separator")
        );

        //endregion
    }

    @Test
    public void shouldLogCorrectlyByteOverflowWhenSequentBytes() {
        //region when
        Logger.log("str 1");
        Logger.log((byte)10);
        Logger.log((byte)Byte.MAX_VALUE);
        Logger.log("str 2");
        Logger.log(0);
        //endregion

        assertSysoutContains("str 1" + System.getProperty("line.separator")
        );//endregion
        assertSysoutContains("10" + System.getProperty("line.separator")
        );
        assertSysoutContains(Byte.MAX_VALUE + System.getProperty("line.separator")
        );
        assertSysoutContains("str 2" + System.getProperty("line.separator")
        );
        assertSysoutContains("0" + System.getProperty("line.separator")
        );
        /*
        //region then
        assertSysoutEquals(
            "str 1\n" +
            "10\n" +
            Byte.MAX_VALUE + "\n" +
            "str 2\n" +
            "0\n"
        );
        //endregion */
    }
/*
    @Test
    public void shouldLogSameSubsequentStringsWithoutRepeat() throws IOException {
        //region when
        Logger.log("str 1");
        Logger.log("str 2");
        Logger.log("str 2");
        Logger.log(0);
        Logger.log("str 2");
        Logger.log("str 3");
        Logger.log("str 3");
        Logger.log("str 3");
        //endregion

        //region then
  /*      assertSysoutEquals(
            "str 1\n" +
            "str 2 (x2)\n" +
            "0\n" +
            "str 2\n" +
            "str 3 (x3)\n"
        );
        assertSysoutContains("str 1" + System.getProperty("line.separator")
        );//endregion
        assertSysoutContains("str 2 (x2)" + System.getProperty("line.separator")
        );
        assertSysoutContains("0" + System.getProperty("line.separator")
        );
        assertSysoutContains("str 2" + System.getProperty("line.separator")
        );
        assertSysoutContains("str 3 (x3)" + System.getProperty("line.separator")
        );
        //endregion
    }
    */
}