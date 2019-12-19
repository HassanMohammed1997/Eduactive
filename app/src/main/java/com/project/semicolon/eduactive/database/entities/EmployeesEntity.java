package com.project.semicolon.eduactive.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "employees",
        foreignKeys = @ForeignKey(
                entity = DepartmentEntity.class,
                parentColumns = "dep_pk",
                childColumns = "departmentId"),
        indices = {@Index("departmentId")})
public class EmployeesEntity {
    @PrimaryKey
    @ColumnInfo(name = "emp_pk")
    public int eid;
    @ColumnInfo(name = "emp_name")
    private String employeeName;
    @ColumnInfo(name = "emp_birth_date")
    private Date birthdate;
    @ColumnInfo(name = "emp_state")
    private String state;
    @ColumnInfo(name = "emp_city")
    private String city;
    @ColumnInfo(name = "emp_address")
    private String address;
    @ColumnInfo(name = "salary")
    private String salary;
    @ColumnInfo(name = "emp_email")
    private String email;
    @ColumnInfo(name = "emp_image", typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
    @ColumnInfo(name = "emp_tel")
    private String telephone;
    @ColumnInfo(name = "emp_mob")
    private String mobile;
    private int departmentId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
