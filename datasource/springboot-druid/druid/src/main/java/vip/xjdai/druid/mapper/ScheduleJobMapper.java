package vip.xjdai.druid.mapper;

import org.apache.ibatis.annotations.Param;
import vip.xjdai.druid.model.ScheduleJob;

import java.util.List;

public interface ScheduleJobMapper
{
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    long countByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    int deleteByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    int insert(ScheduleJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    int insertSelective(ScheduleJob record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    List< ScheduleJob > selectByExample(ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    int updateByExampleSelective(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table schedule_job
     *
     * @mbg.generated Sun Jan 27 18:16:27 CST 2019
     */
    int updateByExample(@Param("record") ScheduleJob record, @Param("example") ScheduleJobExample example);
}