package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.PurchaseRecord;
import cj.netos.gateway.wybank.model.PurchaseRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
}