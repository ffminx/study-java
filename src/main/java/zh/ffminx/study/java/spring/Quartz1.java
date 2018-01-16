package zh.ffminx.study.java.spring;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author fengmin.xu E-mail: fengmin.xu@56qq.com
 * @since 2017-12-21 14:09
 */
public class Quartz1 implements Job {
    
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("1111");
        System.out.println(context.getJobDetail().toString());
        System.out.println(context.getCalendar().toString());
        try {
            Thread.sleep(1000 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
