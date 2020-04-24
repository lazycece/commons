package com.lazycece.commons.utils.cmd;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lazycece
 * @date 2020/2/6
 */
public class CmdExecUtils {

    /**
     * exec cmd will be blocked until the subprocess exits.
     *
     * @param cmd cmd
     * @return Process Process
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    public static Process exec(String cmd) throws IOException, InterruptedException {
        return exec(cmd, -1, null);
    }

    /**
     * exec cmd
     *
     * @param cmd     cmd
     * @param timeout timeout value, <code>timeout=-1</code> indicates it will block
     * @param unit    ${@link TimeUnit} <code>unit==null</code> indicates it will block
     * @return Process
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    public static Process exec(String cmd, long timeout, TimeUnit unit) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(cmd);
        if (timeout != -1L && unit != null) {
            if (!process.waitFor(timeout, unit)) {
                process.destroy();
                throw new RuntimeException("exec cmd timeout, cmd =" + cmd);
            }
        } else {
            process.waitFor();
        }
        return process;
    }
}

