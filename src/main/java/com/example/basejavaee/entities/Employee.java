package com.example.basejavaee.entities;

import com.example.basejavaee.entities.basic.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {
    public int id;
    public String full_name;
    public String birthday;
    public String address;
    public String position;
    public String department;
}
