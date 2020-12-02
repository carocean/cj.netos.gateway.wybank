package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.Incubator;
import cj.netos.gateway.wybank.model.IncubatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IncubatorMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(IncubatorExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(IncubatorExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String bank);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Incubator record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Incubator record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Incubator> selectByExample(IncubatorExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Incubator selectByPrimaryKey(String bank);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Incubator record, @Param("example") IncubatorExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Incubator record, @Param("example") IncubatorExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Incubator record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Incubator record);

    void updateState(@Param(value = "bank") String bank, @Param(value = "state") int state);
}