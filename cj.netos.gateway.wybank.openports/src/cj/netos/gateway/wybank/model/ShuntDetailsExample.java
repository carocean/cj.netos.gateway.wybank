package cj.netos.gateway.wybank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShuntDetailsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public ShuntDetailsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShunterIsNull() {
            addCriterion("shunter is null");
            return (Criteria) this;
        }

        public Criteria andShunterIsNotNull() {
            addCriterion("shunter is not null");
            return (Criteria) this;
        }

        public Criteria andShunterEqualTo(String value) {
            addCriterion("shunter =", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterNotEqualTo(String value) {
            addCriterion("shunter <>", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterGreaterThan(String value) {
            addCriterion("shunter >", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterGreaterThanOrEqualTo(String value) {
            addCriterion("shunter >=", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterLessThan(String value) {
            addCriterion("shunter <", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterLessThanOrEqualTo(String value) {
            addCriterion("shunter <=", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterLike(String value) {
            addCriterion("shunter like", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterNotLike(String value) {
            addCriterion("shunter not like", value, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterIn(List<String> values) {
            addCriterion("shunter in", values, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterNotIn(List<String> values) {
            addCriterion("shunter not in", values, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterBetween(String value1, String value2) {
            addCriterion("shunter between", value1, value2, "shunter");
            return (Criteria) this;
        }

        public Criteria andShunterNotBetween(String value1, String value2) {
            addCriterion("shunter not between", value1, value2, "shunter");
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

        public Criteria andRatioIsNull() {
            addCriterion("ratio is null");
            return (Criteria) this;
        }

        public Criteria andRatioIsNotNull() {
            addCriterion("ratio is not null");
            return (Criteria) this;
        }

        public Criteria andRatioEqualTo(BigDecimal value) {
            addCriterion("ratio =", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotEqualTo(BigDecimal value) {
            addCriterion("ratio <>", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThan(BigDecimal value) {
            addCriterion("ratio >", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ratio >=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThan(BigDecimal value) {
            addCriterion("ratio <", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ratio <=", value, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioIn(List<BigDecimal> values) {
            addCriterion("ratio in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotIn(List<BigDecimal> values) {
            addCriterion("ratio not in", values, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ratio between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ratio not between", value1, value2, "ratio");
            return (Criteria) this;
        }

        public Criteria andShuntSnIsNull() {
            addCriterion("shunt_sn is null");
            return (Criteria) this;
        }

        public Criteria andShuntSnIsNotNull() {
            addCriterion("shunt_sn is not null");
            return (Criteria) this;
        }

        public Criteria andShuntSnEqualTo(String value) {
            addCriterion("shunt_sn =", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnNotEqualTo(String value) {
            addCriterion("shunt_sn <>", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnGreaterThan(String value) {
            addCriterion("shunt_sn >", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnGreaterThanOrEqualTo(String value) {
            addCriterion("shunt_sn >=", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnLessThan(String value) {
            addCriterion("shunt_sn <", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnLessThanOrEqualTo(String value) {
            addCriterion("shunt_sn <=", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnLike(String value) {
            addCriterion("shunt_sn like", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnNotLike(String value) {
            addCriterion("shunt_sn not like", value, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnIn(List<String> values) {
            addCriterion("shunt_sn in", values, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnNotIn(List<String> values) {
            addCriterion("shunt_sn not in", values, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnBetween(String value1, String value2) {
            addCriterion("shunt_sn between", value1, value2, "shuntSn");
            return (Criteria) this;
        }

        public Criteria andShuntSnNotBetween(String value1, String value2) {
            addCriterion("shunt_sn not between", value1, value2, "shuntSn");
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