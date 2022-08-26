package Base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DateChange {
    public static String getDateNowStr(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(d);
    }
    public static String getDateNowStrAddTime(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR,1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(cal.getTime());
    }
    /*获取当前时间的时间戳,*/
    public static String getTimestamp(){
        Long totalMilliSeconds = System.currentTimeMillis();
        long timestamp = totalMilliSeconds / 1L;
        return Long.toString(timestamp);
    }
    /*获取当前时间的时间戳,精确到秒*/
    public static String getTimestamp_sed(){
        Long totalMilliSeconds = System.currentTimeMillis();
        long timestamp = totalMilliSeconds / 1L;
        return Long.toString(timestamp);
    }

    public static String replaceStyle(String content,String regEx ) {
        if (content == null || content.length() == 0) {
            return content;
        }
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        if (m.find()) {
            content = m.group(1);
        }
        return content;
    }



    public static int[] find(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};

    }
    public int sum(int a,int b){
        int sum=a+b;
        return sum;
    }

}
