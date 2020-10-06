package com.aboutcourse.common.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entity<T extends Entity<T>> {

    protected Long id;

    protected long version = 1;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Entity)) {
            return false;
        }

        final T other = (T) o;
        return getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

}
