package com.aboutcourse.common.shared;

import java.util.List;

public abstract class ValueObject<T extends ValueObject<T>> {

    protected abstract List<Object> getEquityProperty();

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ValueObject)) {
            return false;
        }

        final T other = (T) o;

        return getEquityProperty().equals(other.getEquityProperty());
    }

    @Override
    public int hashCode() {
        return getEquityProperty().size() != 0 ?
                getEquityProperty().hashCode() : 0;
    }
}
