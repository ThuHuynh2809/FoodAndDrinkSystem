package com.example.loginservice.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_permission")
@Getter @Setter
public class Permission extends BaseEntity{
    private String permissionName;
    private String permissionKey;
}
