package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.ExchangeRecord;
import cj.netos.gateway.wybank.model.ExchangeRecordExample;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

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

    void ackSuccess(@Param(value = "sn") String sn, @Param(value = "amount") long amount, @Param(value = "profit") long profit, @Param(value = "price") BigDecimal price, @Param(value = "dtime") String dtime);

    void ackFailure(@Param(value = "sn") String sn, @Param(value = "status") String status, @Param(value = "message") String message, @Param(value = "dtime") String dtime);

    List<ExchangeRecord> page(@Param(value = "bankid") String bankid, @Param(value = "limit") int limit, @Param(value = "offset") long offset);
}