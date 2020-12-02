package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.IncubatorEvents;
import cj.netos.gateway.wybank.model.IncubatorEventsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncubatorEventsMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(IncubatorEventsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(IncubatorEventsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(IncubatorEvents record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(IncubatorEvents record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<IncubatorEvents> selectByExample(IncubatorEventsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    IncubatorEvents selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") IncubatorEvents record, @Param("example") IncubatorEventsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") IncubatorEvents record, @Param("example") IncubatorEventsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(IncubatorEvents record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(IncubatorEvents record);
}