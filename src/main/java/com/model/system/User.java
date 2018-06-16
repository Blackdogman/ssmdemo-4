package com.model.system;

import java.util.Date;

public class User {
    /** 用户ID */
    private String userId;
    /** 用户姓名 */
    private String userName;
    /** 登陆名 */
    private String loginName;
    /** 登陆密码 */
    private String password;
    /** 邮箱 */
    private String email;
    /** 性别 */
    private String sex;
    /** 生日 */
    private String birthday;
    /** */
    private Date intime;
    /** 籍贯 */
    private String nativePlace;
    /** 毕业院校 */
    private String recordSchool;
    /** 创建时间 */
    private Date createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getRecordSchool() {
        return recordSchool;
    }

    public void setRecordSchool(String recordSchool) {
        this.recordSchool = recordSchool;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", intime=" + intime +
                ", nativePlace='" + nativePlace + '\'' +
                ", recordSchool='" + recordSchool + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}