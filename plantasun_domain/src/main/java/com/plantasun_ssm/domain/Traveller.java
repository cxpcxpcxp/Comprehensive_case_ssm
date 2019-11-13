package com.plantasun_ssm.domain;

public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private Integer credentialsType;
    private String credentialsTypeStr;
    private String credentialsNum;
    private Integer travellerType;
    private String travellerTypeStr;

    public String getCredentialsTypeStr() {
        if(credentialsType==0){
            credentialsTypeStr = "身份证";
        }else{
            credentialsTypeStr = "残疾人证";
        }
        return credentialsTypeStr;
    }
}
