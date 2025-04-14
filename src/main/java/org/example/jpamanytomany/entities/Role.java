package org.example.jpamanytomany.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Generated;

@Entity
public class Role {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "Description"
    )
    private String desc;
    @Column(
            length = 20,
            unique = true
    )
    private String roleName;
    @ManyToMany(
            fetch = FetchType.EAGER
    )
    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    private List<User> users = new ArrayList();

    @Generated
    public long getId() {
        return this.id;
    }

    @Generated
    public String getDesc() {
        return this.desc;
    }

    @Generated
    public String getRoleName() {
        return this.roleName;
    }

    @Generated
    public List<User> getUsers() {
        return this.users;
    }

    @Generated
    public void setId(final long id) {
        this.id = id;
    }

    @Generated
    public void setDesc(final String desc) {
        this.desc = desc;
    }

    @Generated
    public void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    @JsonProperty(
            access = Access.WRITE_ONLY
    )
    @Generated
    public void setUsers(final List<User> users) {
        this.users = users;
    }

    @Generated
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Role)) {
            return false;
        } else {
            Role other = (Role)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getId() != other.getId()) {
                return false;
            } else {
                Object this$desc = this.getDesc();
                Object other$desc = other.getDesc();
                if (this$desc == null) {
                    if (other$desc != null) {
                        return false;
                    }
                } else if (!this$desc.equals(other$desc)) {
                    return false;
                }

                Object this$roleName = this.getRoleName();
                Object other$roleName = other.getRoleName();
                if (this$roleName == null) {
                    if (other$roleName != null) {
                        return false;
                    }
                } else if (!this$roleName.equals(other$roleName)) {
                    return false;
                }

                Object this$users = this.getUsers();
                Object other$users = other.getUsers();
                if (this$users == null) {
                    if (other$users != null) {
                        return false;
                    }
                } else if (!this$users.equals(other$users)) {
                    return false;
                }

                return true;
            }
        }
    }

    @Generated
    protected boolean canEqual(final Object other) {
        return other instanceof Role;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        long $id = this.getId();
        result = result * 59 + (int)($id >>> 32 ^ $id);
        Object $desc = this.getDesc();
        result = result * 59 + ($desc == null ? 43 : $desc.hashCode());
        Object $roleName = this.getRoleName();
        result = result * 59 + ($roleName == null ? 43 : $roleName.hashCode());
        Object $users = this.getUsers();
        result = result * 59 + ($users == null ? 43 : $users.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        long var10000 = this.getId();
        return "Role(id=" + var10000 + ", desc=" + this.getDesc() + ", roleName=" + this.getRoleName() + ")";
    }

    @Generated
    public Role() {
    }

    @Generated
    public Role(final long id, final String desc, final String roleName, final List<User> users) {
        this.id = id;
        this.desc = desc;
        this.roleName = roleName;
        this.users = users;
    }
}

