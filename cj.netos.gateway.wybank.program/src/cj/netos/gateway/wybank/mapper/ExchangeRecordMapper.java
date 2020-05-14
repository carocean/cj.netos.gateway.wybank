package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.ExchangeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExchangeRecordMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ExchangeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ExchangeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ExchangeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ExchangeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ExchangeRecord> selectByExample(ExchangeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ExchangeRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ExchangeRecord record, @Param("example") ExchangeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ExchangeRecord record, @Param("example") ExchangeRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ExchangeRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ExchangeRecord record);
}