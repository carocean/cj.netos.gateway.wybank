package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.ShunterRule;
import cj.netos.gateway.wybank.model.ShunterRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShunterRuleMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ShunterRuleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ShunterRuleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ShunterRule record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ShunterRule record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ShunterRule> selectByExample(ShunterRuleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ShunterRule selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ShunterRule record, @Param("example") ShunterRuleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ShunterRule record, @Param("example") ShunterRuleExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ShunterRule record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ShunterRule record);
}