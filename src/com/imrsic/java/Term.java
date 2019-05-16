package com.imrsic.java;

class Term {

    private Integer constant;
    private Integer xMultiplier;

    Term(Integer constant) {
        this.constant = constant;
        this.xMultiplier = 0;
    }

    Term(Integer xMultiplier, Integer constant) {
        this.constant = constant;
        this.xMultiplier = xMultiplier;
    }

    Integer getConstant() {
        return constant;
    }

    Integer getxMultiplier() {
        return xMultiplier;
    }

    void add(Term addend) {
        this.xMultiplier += addend.xMultiplier;
        this.constant += addend.constant;
    }

    void subtract(Term addend) {
        this.xMultiplier -= addend.xMultiplier;
        this.constant -= addend.constant;
    }

    void multiply(Term multiplier) {
        this.xMultiplier = this.xMultiplier * multiplier.constant + this.constant * multiplier.xMultiplier;
        this.constant *= multiplier.constant;
    }
}
