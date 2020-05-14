package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PurchaseRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public PurchaseRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andPurchaserIsNull() {
            addCriterion("purchaser is null");
            return (Criteria) this;
        }

        public Criteria andPurchaserIsNotNull() {
            addCriterion("purchaser is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaserEqualTo(String value) {
            addCriterion("purchaser =", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotEqualTo(String value) {
            addCriterion("purchaser <>", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserGreaterThan(String value) {
            addCriterion("purchaser >", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserGreaterThanOrEqualTo(String value) {
            addCriterion("purchaser >=", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLessThan(String value) {
            addCriterion("purchaser <", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLessThanOrEqualTo(String value) {
            addCriterion("purchaser <=", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserLike(String value) {
            addCriterion("purchaser like", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotLike(String value) {
            addCriterion("purchaser not like", value, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserIn(List<String> values) {
            addCriterion("purchaser in", values, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotIn(List<String> values) {
            addCriterion("purchaser not in", values, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserBetween(String value1, String value2) {
            addCriterion("purchaser between", value1, value2, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPurchaserNotBetween(String value1, String value2) {
            addCriterion("purchaser not between", value1, value2, "purchaser");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNull() {
            addCriterion("person_name is null");
            return (Criteria) this;
        }

        public Criteria andPersonNameIsNotNull() {
            addCriterion("person_name is not null");
            return (Criteria) this;
        }

        public Criteria andPersonNameEqualTo(String value) {
            addCriterion("person_name =", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotEqualTo(String value) {
            addCriterion("person_name <>", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThan(String value) {
            addCriterion("person_name >", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameGreaterThanOrEqualTo(String value) {
            addCriterion("person_name >=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThan(String value) {
            addCriterion("person_name <", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLessThanOrEqualTo(String value) {
            addCriterion("person_name <=", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameLike(String value) {
            addCriterion("person_name like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotLike(String value) {
            addCriterion("person_name not like", value, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameIn(List<String> values) {
            addCriterion("person_name in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotIn(List<String> values) {
            addCriterion("person_name not in", values, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameBetween(String value1, String value2) {
            addCriterion("person_name between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andPersonNameNotBetween(String value1, String value2) {
            addCriterion("person_name not between", value1, value2, "personName");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNull() {
            addCriterion("currency is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyIsNotNull() {
            addCriterion("currency is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyEqualTo(String value) {
            addCriterion("currency =", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotEqualTo(String value) {
            addCriterion("currency <>", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThan(String value) {
            addCriterion("currency >", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyGreaterThanOrEqualTo(String value) {
            addCriterion("currency >=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThan(String value) {
            addCriterion("currency <", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLessThanOrEqualTo(String value) {
            addCriterion("currency <=", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyLike(String value) {
            addCriterion("currency like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotLike(String value) {
            addCriterion("currency not like", value, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyIn(List<String> values) {
            addCriterion("currency in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotIn(List<String> values) {
            addCriterion("currency not in", values, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyBetween(String value1, String value2) {
            addCriterion("currency between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andCurrencyNotBetween(String value1, String value2) {
            addCriterion("currency not between", value1, value2, "currency");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(BigDecimal value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(BigDecimal value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(BigDecimal value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(BigDecimal value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<BigDecimal> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<BigDecimal> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andTtmIsNull() {
            addCriterion("ttm is null");
            return (Criteria) this;
        }

        public Criteria andTtmIsNotNull() {
            addCriterion("ttm is not null");
            return (Criteria) this;
        }

        public Criteria andTtmEqualTo(BigDecimal value) {
            addCriterion("ttm =", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmNotEqualTo(BigDecimal value) {
            addCriterion("ttm <>", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmGreaterThan(BigDecimal value) {
            addCriterion("ttm >", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ttm >=", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmLessThan(BigDecimal value) {
            addCriterion("ttm <", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ttm <=", value, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmIn(List<BigDecimal> values) {
            addCriterion("ttm in", values, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmNotIn(List<BigDecimal> values) {
            addCriterion("ttm not in", values, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ttm between", value1, value2, "ttm");
            return (Criteria) this;
        }

        public Criteria andTtmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ttm not between", value1, value2, "ttm");
            return (Criteria) this;
        }

        public Criteria andPtimeIsNull() {
            addCriterion("ptime is null");
            return (Criteria) this;
        }

        public Criteria andPtimeIsNotNull() {
            addCriterion("ptime is not null");
            return (Criteria) this;
        }

        public Criteria andPtimeEqualTo(String value) {
            addCriterion("ptime =", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotEqualTo(String value) {
            addCriterion("ptime <>", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeGreaterThan(String value) {
            addCriterion("ptime >", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ptime >=", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeLessThan(String value) {
            addCriterion("ptime <", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeLessThanOrEqualTo(String value) {
            addCriterion("ptime <=", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeLike(String value) {
            addCriterion("ptime like", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotLike(String value) {
            addCriterion("ptime not like", value, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeIn(List<String> values) {
            addCriterion("ptime in", values, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotIn(List<String> values) {
            addCriterion("ptime not in", values, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeBetween(String value1, String value2) {
            addCriterion("ptime between", value1, value2, "ptime");
            return (Criteria) this;
        }

        public Criteria andPtimeNotBetween(String value1, String value2) {
            addCriterion("ptime not between", value1, value2, "ptime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("`state` is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("`state` is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("`state` =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("`state` <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("`state` >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("`state` >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("`state` <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("`state` <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("`state` in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("`state` not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("`state` between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("`state` not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNull() {
            addCriterion("service_fee is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIsNotNull() {
            addCriterion("service_fee is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeEqualTo(Long value) {
            addCriterion("service_fee =", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotEqualTo(Long value) {
            addCriterion("service_fee <>", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThan(Long value) {
            addCriterion("service_fee >", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("service_fee >=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThan(Long value) {
            addCriterion("service_fee <", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeLessThanOrEqualTo(Long value) {
            addCriterion("service_fee <=", value, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeIn(List<Long> values) {
            addCriterion("service_fee in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotIn(List<Long> values) {
            addCriterion("service_fee not in", values, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeBetween(Long value1, Long value2) {
            addCriterion("service_fee between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andServiceFeeNotBetween(Long value1, Long value2) {
            addCriterion("service_fee not between", value1, value2, "serviceFee");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountIsNull() {
            addCriterion("principal_amount is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountIsNotNull() {
            addCriterion("principal_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountEqualTo(Long value) {
            addCriterion("principal_amount =", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountNotEqualTo(Long value) {
            addCriterion("principal_amount <>", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountGreaterThan(Long value) {
            addCriterion("principal_amount >", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("principal_amount >=", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountLessThan(Long value) {
            addCriterion("principal_amount <", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountLessThanOrEqualTo(Long value) {
            addCriterion("principal_amount <=", value, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountIn(List<Long> values) {
            addCriterion("principal_amount in", values, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountNotIn(List<Long> values) {
            addCriterion("principal_amount not in", values, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountBetween(Long value1, Long value2) {
            addCriterion("principal_amount between", value1, value2, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andPrincipalAmountNotBetween(Long value1, Long value2) {
            addCriterion("principal_amount not between", value1, value2, "principalAmount");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIsNull() {
            addCriterion("fee_ratio is null");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIsNotNull() {
            addCriterion("fee_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRatioEqualTo(BigDecimal value) {
            addCriterion("fee_ratio =", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotEqualTo(BigDecimal value) {
            addCriterion("fee_ratio <>", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioGreaterThan(BigDecimal value) {
            addCriterion("fee_ratio >", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_ratio >=", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioLessThan(BigDecimal value) {
            addCriterion("fee_ratio <", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fee_ratio <=", value, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioIn(List<BigDecimal> values) {
            addCriterion("fee_ratio in", values, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotIn(List<BigDecimal> values) {
            addCriterion("fee_ratio not in", values, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_ratio between", value1, value2, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andFeeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fee_ratio not between", value1, value2, "feeRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioIsNull() {
            addCriterion("principal_ratio is null");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioIsNotNull() {
            addCriterion("principal_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioEqualTo(BigDecimal value) {
            addCriterion("principal_ratio =", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioNotEqualTo(BigDecimal value) {
            addCriterion("principal_ratio <>", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioGreaterThan(BigDecimal value) {
            addCriterion("principal_ratio >", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_ratio >=", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioLessThan(BigDecimal value) {
            addCriterion("principal_ratio <", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("principal_ratio <=", value, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioIn(List<BigDecimal> values) {
            addCriterion("principal_ratio in", values, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioNotIn(List<BigDecimal> values) {
            addCriterion("principal_ratio not in", values, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_ratio between", value1, value2, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andPrincipalRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("principal_ratio not between", value1, value2, "principalRatio");
            return (Criteria) this;
        }

        public Criteria andTailAmountIsNull() {
            addCriterion("tail_amount is null");
            return (Criteria) this;
        }

        public Criteria andTailAmountIsNotNull() {
            addCriterion("tail_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTailAmountEqualTo(Long value) {
            addCriterion("tail_amount =", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountNotEqualTo(Long value) {
            addCriterion("tail_amount <>", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountGreaterThan(Long value) {
            addCriterion("tail_amount >", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("tail_amount >=", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountLessThan(Long value) {
            addCriterion("tail_amount <", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountLessThanOrEqualTo(Long value) {
            addCriterion("tail_amount <=", value, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountIn(List<Long> values) {
            addCriterion("tail_amount in", values, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountNotIn(List<Long> values) {
            addCriterion("tail_amount not in", values, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountBetween(Long value1, Long value2) {
            addCriterion("tail_amount between", value1, value2, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andTailAmountNotBetween(Long value1, Long value2) {
            addCriterion("tail_amount not between", value1, value2, "tailAmount");
            return (Criteria) this;
        }

        public Criteria andFreeRatioIsNull() {
            addCriterion("free_ratio is null");
            return (Criteria) this;
        }

        public Criteria andFreeRatioIsNotNull() {
            addCriterion("free_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andFreeRatioEqualTo(BigDecimal value) {
            addCriterion("free_ratio =", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioNotEqualTo(BigDecimal value) {
            addCriterion("free_ratio <>", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioGreaterThan(BigDecimal value) {
            addCriterion("free_ratio >", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("free_ratio >=", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioLessThan(BigDecimal value) {
            addCriterion("free_ratio <", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("free_ratio <=", value, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioIn(List<BigDecimal> values) {
            addCriterion("free_ratio in", values, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioNotIn(List<BigDecimal> values) {
            addCriterion("free_ratio not in", values, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_ratio between", value1, value2, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andFreeRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("free_ratio not between", value1, value2, "freeRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioIsNull() {
            addCriterion("reserve_ratio is null");
            return (Criteria) this;
        }

        public Criteria andReserveRatioIsNotNull() {
            addCriterion("reserve_ratio is not null");
            return (Criteria) this;
        }

        public Criteria andReserveRatioEqualTo(BigDecimal value) {
            addCriterion("reserve_ratio =", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioNotEqualTo(BigDecimal value) {
            addCriterion("reserve_ratio <>", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioGreaterThan(BigDecimal value) {
            addCriterion("reserve_ratio >", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_ratio >=", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioLessThan(BigDecimal value) {
            addCriterion("reserve_ratio <", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("reserve_ratio <=", value, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioIn(List<BigDecimal> values) {
            addCriterion("reserve_ratio in", values, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioNotIn(List<BigDecimal> values) {
            addCriterion("reserve_ratio not in", values, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_ratio between", value1, value2, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andReserveRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("reserve_ratio not between", value1, value2, "reserveRatio");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIsNull() {
            addCriterion("free_amount is null");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIsNotNull() {
            addCriterion("free_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFreeAmountEqualTo(Long value) {
            addCriterion("free_amount =", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotEqualTo(Long value) {
            addCriterion("free_amount <>", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountGreaterThan(Long value) {
            addCriterion("free_amount >", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("free_amount >=", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountLessThan(Long value) {
            addCriterion("free_amount <", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountLessThanOrEqualTo(Long value) {
            addCriterion("free_amount <=", value, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountIn(List<Long> values) {
            addCriterion("free_amount in", values, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotIn(List<Long> values) {
            addCriterion("free_amount not in", values, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountBetween(Long value1, Long value2) {
            addCriterion("free_amount between", value1, value2, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andFreeAmountNotBetween(Long value1, Long value2) {
            addCriterion("free_amount not between", value1, value2, "freeAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNull() {
            addCriterion("reserve_amount is null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIsNotNull() {
            addCriterion("reserve_amount is not null");
            return (Criteria) this;
        }

        public Criteria andReserveAmountEqualTo(Long value) {
            addCriterion("reserve_amount =", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotEqualTo(Long value) {
            addCriterion("reserve_amount <>", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThan(Long value) {
            addCriterion("reserve_amount >", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("reserve_amount >=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThan(Long value) {
            addCriterion("reserve_amount <", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountLessThanOrEqualTo(Long value) {
            addCriterion("reserve_amount <=", value, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountIn(List<Long> values) {
            addCriterion("reserve_amount in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotIn(List<Long> values) {
            addCriterion("reserve_amount not in", values, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountBetween(Long value1, Long value2) {
            addCriterion("reserve_amount between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andReserveAmountNotBetween(Long value1, Long value2) {
            addCriterion("reserve_amount not between", value1, value2, "reserveAmount");
            return (Criteria) this;
        }

        public Criteria andBankidIsNull() {
            addCriterion("bankid is null");
            return (Criteria) this;
        }

        public Criteria andBankidIsNotNull() {
            addCriterion("bankid is not null");
            return (Criteria) this;
        }

        public Criteria andBankidEqualTo(String value) {
            addCriterion("bankid =", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotEqualTo(String value) {
            addCriterion("bankid <>", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThan(String value) {
            addCriterion("bankid >", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidGreaterThanOrEqualTo(String value) {
            addCriterion("bankid >=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThan(String value) {
            addCriterion("bankid <", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLessThanOrEqualTo(String value) {
            addCriterion("bankid <=", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidLike(String value) {
            addCriterion("bankid like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotLike(String value) {
            addCriterion("bankid not like", value, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidIn(List<String> values) {
            addCriterion("bankid in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotIn(List<String> values) {
            addCriterion("bankid not in", values, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidBetween(String value1, String value2) {
            addCriterion("bankid between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andBankidNotBetween(String value1, String value2) {
            addCriterion("bankid not between", value1, value2, "bankid");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNull() {
            addCriterion("device is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIsNotNull() {
            addCriterion("device is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceEqualTo(String value) {
            addCriterion("device =", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotEqualTo(String value) {
            addCriterion("device <>", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThan(String value) {
            addCriterion("device >", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("device >=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThan(String value) {
            addCriterion("device <", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLessThanOrEqualTo(String value) {
            addCriterion("device <=", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceLike(String value) {
            addCriterion("device like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotLike(String value) {
            addCriterion("device not like", value, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceIn(List<String> values) {
            addCriterion("device in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotIn(List<String> values) {
            addCriterion("device not in", values, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceBetween(String value1, String value2) {
            addCriterion("device between", value1, value2, "device");
            return (Criteria) this;
        }

        public Criteria andDeviceNotBetween(String value1, String value2) {
            addCriterion("device not between", value1, value2, "device");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}