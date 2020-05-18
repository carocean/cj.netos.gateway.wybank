package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.Shunter;
import cj.netos.gateway.wybank.model.ShunterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShunterMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ShunterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ShunterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String code);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Shunter record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Shunter record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Shunter> selectByExample(ShunterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Shunter selectByPrimaryKey(String code);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Shunter record, @Param("example") ShunterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Shunter record, @Param("example") ShunterExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Shunter record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Shunter record);
}