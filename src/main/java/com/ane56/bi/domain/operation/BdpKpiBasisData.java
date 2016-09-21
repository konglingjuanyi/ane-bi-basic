package com.ane56.bi.domain.operation;

import java.util.Date;

public class BdpKpiBasisData {
    private String kpiId;

    private String crtUserId;

    private Date crtTime;

    private String crtAppSysId;

    private String modfUserId;

    private Date modfTime;

    private String modfAppSysId;

    private String kpiNm;

    private String kpiAbbr;

    private String kpiTypeCd;

    private Date validBgnTime;

    private Date validEndTime;

    public String getKpiId() {
        return kpiId;
    }

    public void setKpiId(String kpiId) {
        this.kpiId = kpiId == null ? null : kpiId.trim();
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

    public String getKpiNm() {
        return kpiNm;
    }

    public void setKpiNm(String kpiNm) {
        this.kpiNm = kpiNm == null ? null : kpiNm.trim();
    }

    public String getKpiAbbr() {
        return kpiAbbr;
    }

    public void setKpiAbbr(String kpiAbbr) {
        this.kpiAbbr = kpiAbbr == null ? null : kpiAbbr.trim();
    }

    public String getKpiTypeCd() {
        return kpiTypeCd;
    }

    public void setKpiTypeCd(String kpiTypeCd) {
        this.kpiTypeCd = kpiTypeCd == null ? null : kpiTypeCd.trim();
    }

    public Date getValidBgnTime() {
        return validBgnTime;
    }

    public void setValidBgnTime(Date validBgnTime) {
        this.validBgnTime = validBgnTime;
    }

    public Date getValidEndTime() {
        return validEndTime;
    }

    public void setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
    }
}