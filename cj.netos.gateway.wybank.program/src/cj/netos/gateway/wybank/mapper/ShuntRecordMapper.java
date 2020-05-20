package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.ShuntRecord;
import cj.netos.gateway.wybank.model.ShuntRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShuntRecordMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ShuntRecord> selectByExample(ShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ShuntRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ShuntRecord record, @Param("example") ShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ShuntRecord record, @Param("example") ShuntRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ShuntRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ShuntRecord record);

    void ackSuccess(@Param(value = "sn") String sn, @Param(value = "realAmount") Long realAmount, @Param(value = "source") int source, @Param(value = "dtime") String dtime);

    void ackFailure(@Param(value = "sn") String sn, @Param(value = "status") String status, @Param(value = "message") String message, @Param(value = "source") int source, @Param(value = "dtime") String dtime);

    List<ShuntRecord> page(@Param(value = "bankid") String bankid, @Param(value = "limit")int limit, @Param(value = "offset")long offset);

}