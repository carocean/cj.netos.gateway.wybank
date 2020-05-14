package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.TtmConfig;
import cj.netos.gateway.wybank.model.TtmConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TtmConfigMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(TtmConfigExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(TtmConfigExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(TtmConfig record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(TtmConfig record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<TtmConfig> selectByExample(TtmConfigExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    TtmConfig selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") TtmConfig record, @Param("example") TtmConfigExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") TtmConfig record, @Param("example") TtmConfigExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(TtmConfig record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(TtmConfig record);
}