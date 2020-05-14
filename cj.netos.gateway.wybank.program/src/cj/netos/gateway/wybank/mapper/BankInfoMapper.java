package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.BankInfo;
import cj.netos.gateway.wybank.model.BankInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BankInfoMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(BankInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(BankInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(BankInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(BankInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<BankInfo> selectByExample(BankInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BankInfo selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") BankInfo record, @Param("example") BankInfoExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(BankInfo record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(BankInfo record);

    List<BankInfo> pageWenyBank(@Param(value = "limit") int limit, @Param(value = "offset") int offset);

    void updateState(@Param(value = "banksn") String banksn, @Param(value = "state") int state);
}