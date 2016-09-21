package com.ane56.bi.domain.operation;

import java.util.Date;

public class BdpDlyrptMdl {
    private String mdlId;

    private String crtUserId;

    private Date crtTime;

    private String crtAppSysId;

    private String modfUserId;

    private Date modfTime;

    private String modfAppSysId;

    private String mdlNm;

    private String suprMdlId;

    private Long showSeqno;

    private String validFlag;

    public String getMdlId() {
        return mdlId;
    }

    public void setMdlId(String mdlId) {
        this.mdlId = mdlId == null ? null : mdlId.trim();
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

    public String getMdlNm() {
        return mdlNm;
    }

    public void setMdlNm(String mdlNm) {
        this.mdlNm = mdlNm == null ? null : mdlNm.trim();
    }

    public String getSuprMdlId() {
        return suprMdlId;
    }

    public void setSuprMdlId(String suprMdlId) {
        this.suprMdlId = suprMdlId == null ? null : suprMdlId.trim();
    }

    public Long getShowSeqno() {
        return showSeqno;
    }

    public void setShowSeqno(Long showSeqno) {
        this.showSeqno = showSeqno;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag == null ? null : validFlag.trim();
    }
}