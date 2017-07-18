package common.dao.impl;

import common.dao.IQuartzService;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.BaseCalendar;
import org.quartz.impl.calendar.DailyCalendar;
import org.quartz.utils.Key;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Author: Tennyson
 * Date: 14-4-29 下午5:14
 * E-mail:fwx_love@sina.com
 * Description: 定时器实现类
 */
@SuppressWarnings("rawtypes")
@Service("quartzServiceImpl")
public class QuartzServiceImpl implements IQuartzService {

    private SchedulerFactory sf = null;
    private Scheduler sched = null;
    private DailyCalendar dailyCal = null;
    private Calendar cal = null;
    private String dailyName = "dailyName";
    private String jobNameS = "jobName";
    private String triggerNameS = "triggerName";
    private Key[] keyArry = null;
    private static final String quartzPre = IQuartzService.COMMON_CONFIG;

    @Override
    public Key[] dailyCalQuartz(String startTime, String endTime, String jobName, String triggerName, String jobGroup,
                                String triggerGroup, Job job, BaseCalendar baseCal, String baseCalName, String cron)
            throws SchedulerException {
        keyArry = new Key[2];
        sf = new StdSchedulerFactory(quartzPre);
        sched = sf.getScheduler();
        dailyCal = new DailyCalendar(startTime,endTime);
        dailyCal.setInvertTimeRange(true);
        /** 防止dailCal重名 */
        cal = Calendar.getInstance();
        cal.setTime(new Date());
        dailyName+=cal.getTimeInMillis();
        sched.addCalendar(dailyName,dailyCal,false,false);
        sched.addCalendar(baseCalName,baseCal,true,true); //向Scheduler注册日历

        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,jobGroup)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .modifiedByCalendar(baseCalName) //让Trigger应用指定的日历规则
                .modifiedByCalendar(dailyName)
                .withIdentity(triggerName,triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        sched.scheduleJob(jobDetail,trigger);
        sched.start();
        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();
        return keyArry;
    }

    @Override
    public Key[] dailyCalQuartz(String startTime, String endTime, String jobName, String triggerName, Job job,
                                String cron) throws SchedulerException {
        keyArry = new Key[2];
        sf = new StdSchedulerFactory(quartzPre);
        sched = sf.getScheduler();

        dailyCal = new DailyCalendar(startTime,endTime);
        dailyCal.setInvertTimeRange(true);

        /** 防止dailCal重名 */
        cal = Calendar.getInstance();
        cal.setTime(new Date());
        dailyName+=cal.getTimeInMillis();

        sched.addCalendar(dailyName,dailyCal,false,false);

        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,DEFAULT_JOB_GROUP_NAME)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .modifiedByCalendar(dailyName)
                .withIdentity(triggerName, DEFAULT_TRIGGER_GROUP_NAME)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();

        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();

        return new Key[0];
    }

    @Override
    public Key[] dailyCalQuartz(String jobName, String triggerName, Job job, BaseCalendar baseCal,
                                String baseCalName, String cron) throws SchedulerException {
        keyArry = new Key[2];
        sf = new StdSchedulerFactory(quartzPre);
        sched = sf.getScheduler();
        sched.addCalendar(baseCalName,baseCal,true,true);
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,DEFAULT_JOB_GROUP_NAME)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .modifiedByCalendar(baseCalName)
                .withIdentity(triggerName, DEFAULT_TRIGGER_GROUP_NAME)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();

        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();

        return new Key[0];
    }

    @Override
    public Key[] dailyCalQuartz(Object obj, Job job, String cron) throws SchedulerException {
        keyArry = new Key[2];
        /** 防止dailCal重名 */
        cal = Calendar.getInstance();
        cal.setTime(new Date());
        jobNameS+=cal.getTimeInMillis();
        triggerNameS+=cal.getTimeInMillis();

        sf = new StdSchedulerFactory(quartzPre);
        sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobNameS,DEFAULT_JOB_GROUP_NAME)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerNameS, DEFAULT_TRIGGER_GROUP_NAME)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();

        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();

        return keyArry;
    }

    @Override
    public Key[] dataJob(Date startTime, Date endTime, String jobName, String triggerName, String jobGroup,
                         String triggerGroup, Job job, BaseCalendar baseCal, String baseCalName, String cron)
            throws SchedulerException, ParseException {
        keyArry = new Key[2];

        sf = new StdSchedulerFactory(quartzPre);
        sched = sf.getScheduler();
        sched.addCalendar(baseCalName,baseCal,false,false);
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,jobGroup)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .modifiedByCalendar(baseCalName)
                .startAt(startTime)
                .endAt(endTime)
                .withIdentity(triggerName,triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();

        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();
        return keyArry;
    }

	@Override
    public Key[] dailyCalQuartz(String jobName, String triggerName, String jobGroup, String triggerGroup, Job job,
                                BaseCalendar baseCal, String baseCalName, String cron) throws SchedulerException {
        keyArry = new Key[2];
        sf = new StdSchedulerFactory(quartzPre);

        sched = sf.getScheduler();
        sched.addCalendar(baseCalName,baseCal,true,true);
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,jobGroup)
                .build();

        jobDetail.getJobDataMap().put("msg","值传递测试！");

        jobDetail.getJobBuilder().setJobData(jobDetail.getJobDataMap());

        Trigger trigger = TriggerBuilder.newTrigger()
                .modifiedByCalendar(baseCalName)
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();

        keyArry[0] = jobDetail.getKey();
        keyArry[1] = trigger.getKey();
        return keyArry;
    }

    @Override
    public void dailyCalQuartzS(String jobName, String triggerName, String jobGroup, String triggerGroup, Job job,
                                String cron) throws SchedulerException {
        sf = new StdSchedulerFactory();
        sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,jobGroup)
                .build();
        jobDetail.getJobDataMap().put("msg","值传递测试！");

        jobDetail.getJobBuilder().setJobData(jobDetail.getJobDataMap());

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName, triggerGroup)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
        sched.scheduleJob(jobDetail,trigger);
        sched.start();
    }

    @Override
    public boolean removeJob(JobKey jobKey, TriggerKey triggerKey) throws SchedulerException {
        sched = sf.getScheduler(DEFAULT_JOB_GROUP_NAME);
        sched.pauseTrigger(triggerKey);
        sched.unscheduleJob(triggerKey);
        return sched.deleteJob(jobKey);
    }

    @Override
    public void dailyCalQuartz(String jobName, String triggerName, Job job, String cron) throws SchedulerException {
        sf= new StdSchedulerFactory();
        sched = sf.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass())
                .withIdentity(jobName,DEFAULT_JOB_GROUP_NAME)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(triggerName,DEFAULT_TRIGGER_GROUP_NAME)
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();

        sched.scheduleJob(jobDetail,trigger);
        sched.start();
    }
}
