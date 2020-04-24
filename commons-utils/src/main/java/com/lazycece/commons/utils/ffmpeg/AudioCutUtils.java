package com.lazycece.commons.utils.ffmpeg;

import com.lazycece.commons.utils.cmd.CmdExecUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lazycece
 * @date 2019/10/9
 */

public class AudioCutUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AudioCutUtils.class);
    public static final int DURATION_LIMIT_SECOND = 20 * 60;
    public static final String SUFFIX = ".mp3";
    private static final String FFMPEG_DMD = "E:\\ffmpeg\\bin\\ffmpeg.exe";



    /**
     * example as follow:
     * <p>
     * E:\ffmpeg\bin\ffmpeg.exe -ss 00:00:00 -t 00:00:30 -i ${in_audio_path} -acodec copy ${out_audio_path}
     *
     * @param in    input audio path
     * @param out   output audio path
     * @param begin begin time
     * @return success(true) or not
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    public static boolean cut(String in, String out, int begin) throws IOException, InterruptedException {
        String offset = timeFormat(DURATION_LIMIT_SECOND / 2);
        String beginStr = timeFormat(begin);
        String cmd = FFMPEG_DMD
                + " -ss " + beginStr + " -t " + offset
//                + " -i " + in + " -acodec libmp3lame -ac 1 " + out;
                + " -i " + in + " " + out;

        return exec(cmd);
    }

    /**
     * example as follow:
     * <p>
     * E:\ffmpeg\bin\ffmpeg.exe -i "concat:${in1_audio_path}|${in2_audio_path}" -acodec copy ${out_audio_path}
     *
     * @param in1  input-1 audio path
     * @param int2 input-2 audio path
     * @param out  out put audio path
     * @return success(true) or not
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    public static boolean concat(String in1, String int2, String out) throws IOException, InterruptedException {
        String cmd = FFMPEG_DMD + " -i concat:" + in1 + "|" + int2 + " -acodec copy " + out;

        return exec(cmd);
    }

    private static boolean exec(String cmd) throws IOException, InterruptedException {
        Process process = null;
        try {
            process = CmdExecUtils.exec(cmd, 5, TimeUnit.MINUTES);
            int value = process.exitValue();
            LOGGER.info("exec result is {}", value);
            process.destroy();
            return value == 0;
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }

    private static String timeFormat(int second) {
        if (second < 0) {
            return "00:00:00";
        }
        String time = "";
        int hour = second / 3600;
        int min = (second / 60) % 60;
        int sec = second % 60;

        if (hour < 10) {
            time = "0";
        }
        time += hour + ":";
        if (min < 10) {
            time += "0";
        }
        time += min + ":";
        if (sec < 10) {
            time += "0";
        }
        time += sec;
        return time;
    }
}
