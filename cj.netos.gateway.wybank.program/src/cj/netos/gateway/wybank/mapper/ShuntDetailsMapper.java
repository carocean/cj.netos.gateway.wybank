package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.ShuntDetails;
import cj.netos.gateway.wybank.model.ShuntDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShuntDetailsMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ShuntDetailsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ShuntDetailsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ShuntDetails record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ShuntDetails record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ShuntDetails> selectByExample(ShuntDetailsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ShuntDetails selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ShuntDetails record, @Param("example") ShuntDetailsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ShuntDetails record, @Param("example") ShuntDetailsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ShuntDetails record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ShuntDetails record);
}