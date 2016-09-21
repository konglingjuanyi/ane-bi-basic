package com.ane56.bi.domain.operation;
import java.math.BigDecimal;
import java.util.Date;

public class BdpTgtVal {
    private String orgBrnchId;

    private String orgBrnchLvlCd;

    private String tgtValTypeCd;

    private String pridTypeCd;

    private Date tgtValDate;

    private String crtUserId;

    private Date crtTime;

    private String crtAppSysId;

    private String modfUserId;

    private Date modfTime;

    private String modfAppSysId;

    private BigDecimal tgtVal;

    public String getOrgBrnchId() {
        return orgBrnchId;
    }

    public void setOrgBrnchId(String orgBrnchId) {
        this.orgBrnchId = orgBrnchId == null ? null : orgBrnchId.trim();
    }

    public String getOrgBrnchLvlCd() {
        return orgBrnchLvlCd;
    }

    public void setOrgBrnchLvlCd(String orgBrnchLvlCd) {
        this.orgBrnchLvlCd = orgBrnchLvlCd == null ? null : orgBrnchLvlCd.trim();
    }

    public String getTgtValTypeCd() {
        return tgtValTypeCd;
    }

    public void setTgtValTypeCd(String tgtValTypeCd) {
        this.tgtValTypeCd = tgtValTypeCd == null ? null : tgtValTypeCd.trim();
    }

    public String getPridTypeCd() {
        return pridTypeCd;
    }

    public void setPridTypeCd(String pridTypeCd) {
        this.pridTypeCd = pridTypeCd == null ? null : pridTypeCd.trim();
    }

    public Date getTgtValDate() {
        return tgtValDate;
    }

    public void setTgtValDate(Date tgtValDate) {
        this.tgtValDate = tgtValDate;
    }

    public String getCrtUserId() {
        return crtUserId;
    }

    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId == null ? null : crtUserId.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public String getCrtAppSysId() {
        return crtAppSysId;
    }

    public void setCrtAppSysId(String crtAppSysId) {
        this.crtAppSysId = crtAppSysId == null ? null : crtAppSysId.trim();
    }

    public String getModfUserId() {
        return modfUserId;
    }

    public void setModfUserId(String modfUserId) {
        this.modfUserId = modfUserId == null ? null : modfUserId.trim();
    }

    public Date getModfTime() {
        return modfTime;
    }

    public void setModfTime(Date modfTime) {
        this.modfTime = modfTime;
    }

    public String getModfAppSysId() {
        return modfAppSysId;
    }

    public void setModfAppSysId(String modfAppSysId) {
        this.modfAppSysId = modfAppSysId == null ? null : modfAppSysId.trim();
    }

    public BigDecimal getTgtVal() {
        return tgtVal;
    }

    public void setTgtVal(BigDecimal tgtVal) {
        this.tgtVal = tgtVal;
    }
}