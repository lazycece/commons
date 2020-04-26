package com.lazycece.commons.utils.ffmpeg;

import com.lazycece.commons.utils.cmd.CmdExecUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lazycece
 * @date 2019/10/9
 */

public class AudioCutUtils {

    private static final AudioCutUtils AUDIO_CUT_UTILS = new AudioCutUtils();
    private static String FFMPEG_DMD;

    public static AudioCutUtils getInstance(String ffmpegPath) {
        FFMPEG_DMD = ffmpegPath;
        return AUDIO_CUT_UTILS;
    }

    /**
     * Cut audio by time(second), and cmd as follow:
     * ${ffmpeg_path} -ss 00:00:00 -t 00:00:30 -i ${in_audio_path} -acodec copy ${out_audio_path}
     *
     * @param in    input audio path
     * @param out   output audio path
     * @param begin begin time
     * @param end   end time
     * @return success(true) or not
     * @throws IOException          IOException
     * @throws InterruptedException InterruptedException
     */
    public static boolean cut(String in, String out, int begin, int end) throws IOException, InterruptedException {
        String offset = timeFormat(end);
        String beginStr = timeFormat(begin);
        String cmd = FFMPEG_DMD
                + " -ss " + beginStr + " -t " + offset
//                + " -i " + in + " -acodec libmp3lame -ac 1 " + out;
                + " -i " + in + " " + out;
        return CmdExecUtils.execSuc(cmd);
    }

    /**
     * Concat audio, and cmd as follow:
     * ${ffmpeg_path} -i "concat:${in1_audio_path}|${in2_audio_path}" -acodec copy ${out_audio_path}
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
        return CmdExecUtils.execSuc(cmd, 5, TimeUnit.MINUTES);
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
