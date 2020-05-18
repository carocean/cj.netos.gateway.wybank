package cj.netos.gateway.wybank.mapper;

import cj.netos.gateway.wybank.model.WithdrawRights;
import cj.netos.gateway.wybank.model.WithdrawRightsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WithdrawRightsMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WithdrawRightsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WithdrawRightsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WithdrawRights record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WithdrawRights record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WithdrawRights> selectByExample(WithdrawRightsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WithdrawRights selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WithdrawRights record, @Param("example") WithdrawRightsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WithdrawRights record, @Param("example") WithdrawRightsExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WithdrawRights record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WithdrawRights record);
}