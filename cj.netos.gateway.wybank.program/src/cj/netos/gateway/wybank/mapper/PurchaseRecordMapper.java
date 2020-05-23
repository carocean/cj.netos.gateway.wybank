package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.PurchaseRecordExample;
import org.apache.ibatis.annotations.Param;
import java.math.BigDecimal;
import java.util.List;

public interface PurchaseRecordMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(PurchaseRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(PurchaseRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(PurchaseRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(PurchaseRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<PurchaseRecord> selectByExample(PurchaseRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    PurchaseRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(PurchaseRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(PurchaseRecord record);

    void ackSuccess(@Param(value = "sn") String sn, @Param(value = "stock") BigDecimal stock, @Param(value = "price") BigDecimal price, @Param(value = "dtime") String dtime);

    void ackFailure(@Param(value = "sn") String sn, @Param(value = "status") String status, @Param(value = "message") String message, @Param(value = "dtime") String dtime);

    void updateState(@Param(value = "sn") String sn, @Param(value = "state") int state, @Param(value = "dtime") String dtime);

    void ackExchangedFailure(@Param(value = "sn") String sn, @Param(value = "status") String status, @Param(value = "message") String message, @Param(value = "dtime") String dtime);

    List<PurchaseRecord> page(@Param(value = "bankid") String bankid, @Param(value = "limit") int limit, @Param(value = "offset") long offset);
}