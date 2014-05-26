/**
 * 
 */
package org.omninet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.eaio.uuid.UUID;

/**
 * Abstract base class for all Model classes. Generates a UUID
 * (http://johannburkard.de/software/uuid/) for all new instances.
 * 
 * @author tfite
 * 
 */
@MappedSuperclass
public abstract class AbstractBaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "UUID")
    private final String uuid;

    @Column (name="CREATE_DT_TM")
    private final Date createDateTime;

    public AbstractBaseModel() {
        this.uuid = new UUID().toString();
        this.createDateTime = new Date();
    }

    /**
     * @return the id
     */
    public String getUuId() {
        return uuid;
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractBaseModel)) {
            return false;
        }
        AbstractBaseModel other = (AbstractBaseModel) obj;
        return getUuId().equals(other.getUuId());
    }
}
