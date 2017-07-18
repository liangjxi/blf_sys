package common.dao;

import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.calendar.BaseCalendar;
import org.quartz.utils.Key;

import java.text.ParseException;
import java.util.Date;

/**
 * Author: Tennyson
 * Date: 14-4-29 下午5:14
 * E-mail:fwx_love@sina.com
 * Description:任务调度接口
 */
public interface IQuartzService {
	
    public static final String DEFAULT_JOB_GROUP_NAME = "DEFAULT_JOB_GROUP_NAME";
    public static final String DEFAULT_TRIGGER_GROUP_NAME = "DEFAULT_TRIGGER_GROUP_NAME";
    public static final String COMMON_CONFIG = "config/quartz.properties";
    public static final String DB_CONFIG = "config/jdbc.properties";
    
    /**
     * 添加一个每天以start时间开始，endTime时间结束的任务
     * @param startTime      开始时间  HH:mm:ss
     * @param endTime        结束时间  HH:mm:ss
     * @param jobName        任务名称
     * @param triggerName    触发器名
     * @param job            所执行的任务
     * @param jobGroup       任务名所属组
     * @param triggerGroup   触发器名所属组
     * @param baseCal        需要排除的日期
     * @param cron           运行间隔  cron表达式
     * @return  key[]   key[0]为jobkey  key[1]为triggerKey
     * @throws SchedulerException
     */
    public Key[] dailyCalQuartz(String startTime, String endTime, String jobName, String triggerName, String jobGroup, String triggerGroup,
                                Job job, BaseCalendar baseCal, String baseCalName, String cron)throws SchedulerException;
    /**
     * 添加一个每天以start时间开始，endTime时间结束的任务
     * @param startTime      开始时间  HH:mm:ss
     * @param endTime        结束时间  HH:mm:ss
     * @param jobName        任务名称
     * @param triggerName    触发器名
     * @param job            所执行的任务
     * @param cron           运行间隔  cron表达式
     * @return  key[]   key[0]为jobkey  key[1]为triggerKey
     * @throws SchedulerException
     */
    public Key[] dailyCalQuartz(String startTime, String endTime, String jobName, String triggerName, Job job, String cron)throws SchedulerException;
    /**
     *  添加一个以cron表达式描述 运行间隔，运行区间的任务
     * @param jobName         任务名称
     * @param triggerName     触发器名称
     * @param jobGroup        任务组别
     * @param triggerGroup    触发器组别
     * @param job             所执行任务
     * @param baseCal         所要排除的节假日（为当年）
     * @param cron            cron表达式，应包含运行间隔，运行区间
     * @return  key[]   key[0]为jobkey  key[1]为triggerKey
     * @throws SchedulerException
     */
    public Key[] dailyCalQuartz(String jobName, String triggerName, String jobGroup, String triggerGroup,
                                Job job, BaseCalendar baseCal, String baseCalName, String cron)throws SchedulerException;

    /**
     *
     * @param jobName
     * @param triggerName
     * @param jobGroup
     * @param triggerGroup
     * @param job
     * @param cron
     * @throws SchedulerException
     */
    public void dailyCalQuartzS(String jobName, String triggerName, String jobGroup, String triggerGroup, Job job,
                                String cron) throws SchedulerException;
    /**
     *  添加一个以cron表达式描述 运行间隔，运行区间的任务
     * @param jobName         任务名称
     * @param triggerName     触发器名称
     * @param job             所执行任务
     * @param baseCal         所要排除的节假日（为当年）  如果为空则不做排除处理
     * @param cron            cron表达式，应包含运行间隔，运行区间
     * @return  key[]   key[0]为jobkey  key[1]为triggerKey
     * @throws SchedulerException
     */
    public Key[] dailyCalQuartz(String jobName, String triggerName, Job job, BaseCalendar baseCal, String baseCalName,
                                String cron)throws SchedulerException;
    /**
     *
     * @param obj     需要参与处理的实体类
     * @param job     所调用的任务实体
     * @param cron    cron表达式，应包含运行间隔，运行区间
     * @return
     * @throws SchedulerException
     */
    public Key[] dailyCalQuartz(Object obj, Job job, String cron)throws SchedulerException;
    /**
     * 添加一个以startTime开始，由endTime结束的一次任务
     * @param startTime   开始日期
     * @param endTime     结束日期
     * @param jobName     任务名称
     * @param triggerName 触发器名称
     * @param job         所执行任务
     * @param jobGroup    任务所属组名
     * @param triggerGroup 触发器所属组名
     * @param baseCal     所要排除的日期
     * @param cron        运行间隔
     * @return  key[]   key[0]为jobkey  key[1]为triggerKey
     * @throws SchedulerException
     * @throws ParseException
     */
    public Key[] dataJob(Date startTime, Date endTime, String jobName, String triggerName, String jobGroup, String triggerGroup, Job job,
                         BaseCalendar baseCal, String baseCalName, String cron)throws SchedulerException, ParseException;
    /**
     * 移除一个定时任务
     * @param jobKey
     * @param triggerKey
     * @return
     * @throws SchedulerException
     */
    public boolean removeJob(JobKey jobKey, TriggerKey triggerKey) throws SchedulerException;

    /**
     *
     * @param jobName      任务名
     * @param triggerName  触犯器名
     * @param job          工作类
     * @param cron         cron表达式，应包含运行起始时间，运行周期，运行间隔
     * @throws SchedulerException
     */
    public void dailyCalQuartz(String jobName, String triggerName, Job job, String cron) throws SchedulerException;
}
