package com.aboutcourse.common.shared;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public class EntityBase<T extends EntityBase<T>> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Version
    @Column(name = "version")
    protected long version = 1;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof EntityBase)) {
            return false;
        }

        final T other = (T) o;
        return getId() != null && getId().equals(other.getId());
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

}
