package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.WithdrawRecord;
import cj.netos.gateway.wybank.model.WithdrawRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawRecordMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WithdrawRecord> selectByExample(WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WithdrawRecord selectByPrimaryKey(String sn);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WithdrawRecord record, @Param("example") WithdrawRecordExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WithdrawRecord record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WithdrawRecord record);

    void ackSuccess(@Param(value = "sn") String sn, @Param(value = "realAmount") Long realAmount, @Param(value = "dtime") String dtime);

    void ackFailure(@Param(value = "sn") String sn, @Param(value = "status") String status, @Param(value = "message") String message, @Param(value = "dtime") String dtime);

    List<WithdrawRecord> page(@Param(value = "bankid") String bankid, @Param(value = "limit") int limit, @Param(value = "offset") long offset);
}