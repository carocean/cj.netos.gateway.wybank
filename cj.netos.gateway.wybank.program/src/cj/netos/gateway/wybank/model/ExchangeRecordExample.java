package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ExchangeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public ExchangeRecordExample() {
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

        public Criteria andExchangerIsNull() {
            addCriterion("exchanger is null");
            return (Criteria) this;
        }

        public Criteria andExchangerIsNotNull() {
            addCriterion("exchanger is not null");
            return (Criteria) this;
        }

        public Criteria andExchangerEqualTo(String value) {
            addCriterion("exchanger =", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerNotEqualTo(String value) {
            addCriterion("exchanger <>", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerGreaterThan(String value) {
            addCriterion("exchanger >", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerGreaterThanOrEqualTo(String value) {
            addCriterion("exchanger >=", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerLessThan(String value) {
            addCriterion("exchanger <", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerLessThanOrEqualTo(String value) {
            addCriterion("exchanger <=", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerLike(String value) {
            addCriterion("exchanger like", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerNotLike(String value) {
            addCriterion("exchanger not like", value, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerIn(List<String> values) {
            addCriterion("exchanger in", values, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerNotIn(List<String> values) {
            addCriterion("exchanger not in", values, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerBetween(String value1, String value2) {
            addCriterion("exchanger between", value1, value2, "exchanger");
            return (Criteria) this;
        }

        public Criteria andExchangerNotBetween(String value1, String value2) {
            addCriterion("exchanger not between", value1, value2, "exchanger");
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

        public Criteria andRefPurchaseIsNull() {
            addCriterion("ref_purchase is null");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseIsNotNull() {
            addCriterion("ref_purchase is not null");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseEqualTo(String value) {
            addCriterion("ref_purchase =", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseNotEqualTo(String value) {
            addCriterion("ref_purchase <>", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseGreaterThan(String value) {
            addCriterion("ref_purchase >", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseGreaterThanOrEqualTo(String value) {
            addCriterion("ref_purchase >=", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseLessThan(String value) {
            addCriterion("ref_purchase <", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseLessThanOrEqualTo(String value) {
            addCriterion("ref_purchase <=", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseLike(String value) {
            addCriterion("ref_purchase like", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseNotLike(String value) {
            addCriterion("ref_purchase not like", value, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseIn(List<String> values) {
            addCriterion("ref_purchase in", values, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseNotIn(List<String> values) {
            addCriterion("ref_purchase not in", values, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseBetween(String value1, String value2) {
            addCriterion("ref_purchase between", value1, value2, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andRefPurchaseNotBetween(String value1, String value2) {
            addCriterion("ref_purchase not between", value1, value2, "refPurchase");
            return (Criteria) this;
        }

        public Criteria andProfitIsNull() {
            addCriterion("profit is null");
            return (Criteria) this;
        }

        public Criteria andProfitIsNotNull() {
            addCriterion("profit is not null");
            return (Criteria) this;
        }

        public Criteria andProfitEqualTo(Long value) {
            addCriterion("profit =", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotEqualTo(Long value) {
            addCriterion("profit <>", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThan(Long value) {
            addCriterion("profit >", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitGreaterThanOrEqualTo(Long value) {
            addCriterion("profit >=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThan(Long value) {
            addCriterion("profit <", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitLessThanOrEqualTo(Long value) {
            addCriterion("profit <=", value, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitIn(List<Long> values) {
            addCriterion("profit in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotIn(List<Long> values) {
            addCriterion("profit not in", values, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitBetween(Long value1, Long value2) {
            addCriterion("profit between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andProfitNotBetween(Long value1, Long value2) {
            addCriterion("profit not between", value1, value2, "profit");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIsNull() {
            addCriterion("purchase_amount is null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIsNotNull() {
            addCriterion("purchase_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountEqualTo(Long value) {
            addCriterion("purchase_amount =", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotEqualTo(Long value) {
            addCriterion("purchase_amount <>", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThan(Long value) {
            addCriterion("purchase_amount >", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("purchase_amount >=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThan(Long value) {
            addCriterion("purchase_amount <", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountLessThanOrEqualTo(Long value) {
            addCriterion("purchase_amount <=", value, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountIn(List<Long> values) {
            addCriterion("purchase_amount in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotIn(List<Long> values) {
            addCriterion("purchase_amount not in", values, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountBetween(Long value1, Long value2) {
            addCriterion("purchase_amount between", value1, value2, "purchaseAmount");
            return (Criteria) this;
        }

        public Criteria andPurchaseAmountNotBetween(Long value1, Long value2) {
            addCriterion("purchase_amount not between", value1, value2, "purchaseAmount");
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

        public Criteria andServiceFeeamountIsNull() {
            addCriterion("service_feeAmount is null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountIsNotNull() {
            addCriterion("service_feeAmount is not null");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountEqualTo(Long value) {
            addCriterion("service_feeAmount =", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountNotEqualTo(Long value) {
            addCriterion("service_feeAmount <>", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountGreaterThan(Long value) {
            addCriterion("service_feeAmount >", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountGreaterThanOrEqualTo(Long value) {
            addCriterion("service_feeAmount >=", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountLessThan(Long value) {
            addCriterion("service_feeAmount <", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountLessThanOrEqualTo(Long value) {
            addCriterion("service_feeAmount <=", value, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountIn(List<Long> values) {
            addCriterion("service_feeAmount in", values, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountNotIn(List<Long> values) {
            addCriterion("service_feeAmount not in", values, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountBetween(Long value1, Long value2) {
            addCriterion("service_feeAmount between", value1, value2, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andServiceFeeamountNotBetween(Long value1, Long value2) {
            addCriterion("service_feeAmount not between", value1, value2, "serviceFeeamount");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNull() {
            addCriterion("purchase_price is null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIsNotNull() {
            addCriterion("purchase_price is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceEqualTo(BigDecimal value) {
            addCriterion("purchase_price =", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotEqualTo(BigDecimal value) {
            addCriterion("purchase_price <>", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThan(BigDecimal value) {
            addCriterion("purchase_price >", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price >=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThan(BigDecimal value) {
            addCriterion("purchase_price <", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("purchase_price <=", value, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceIn(List<BigDecimal> values) {
            addCriterion("purchase_price in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotIn(List<BigDecimal> values) {
            addCriterion("purchase_price not in", values, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andPurchasePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("purchase_price not between", value1, value2, "purchasePrice");
            return (Criteria) this;
        }

        public Criteria andDtimeIsNull() {
            addCriterion("dtime is null");
            return (Criteria) this;
        }

        public Criteria andDtimeIsNotNull() {
            addCriterion("dtime is not null");
            return (Criteria) this;
        }

        public Criteria andDtimeEqualTo(String value) {
            addCriterion("dtime =", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotEqualTo(String value) {
            addCriterion("dtime <>", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeGreaterThan(String value) {
            addCriterion("dtime >", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeGreaterThanOrEqualTo(String value) {
            addCriterion("dtime >=", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeLessThan(String value) {
            addCriterion("dtime <", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeLessThanOrEqualTo(String value) {
            addCriterion("dtime <=", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeLike(String value) {
            addCriterion("dtime like", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotLike(String value) {
            addCriterion("dtime not like", value, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeIn(List<String> values) {
            addCriterion("dtime in", values, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotIn(List<String> values) {
            addCriterion("dtime not in", values, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeBetween(String value1, String value2) {
            addCriterion("dtime between", value1, value2, "dtime");
            return (Criteria) this;
        }

        public Criteria andDtimeNotBetween(String value1, String value2) {
            addCriterion("dtime not between", value1, value2, "dtime");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(String value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(String value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(String value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(String value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(String value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLike(String value) {
            addCriterion("ctime like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotLike(String value) {
            addCriterion("ctime not like", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<String> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<String> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(String value1, String value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(String value1, String value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
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

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
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