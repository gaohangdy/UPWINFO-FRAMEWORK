/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.sys.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author hang
 */
@Entity
@Table(name = "m_page")
@NamedQueries({
    @NamedQuery(name = "MPage.findAll", query = "SELECT m FROM MPage m")})
public class MPage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PAGE_ID")
    private Integer pageId;
    @Size(max = 64)
    @Column(name = "PAGE_NAME")
    private String pageName;
    @Size(max = 128)
    @Column(name = "PAGE_PATH")
    private String pagePath;
    @Size(max = 32)
    @Column(name = "PAGE_ICON")
    private String pageIcon;
    @JoinColumn(name = "PAGE_TYPE", referencedColumnName = "TYPE_ID")
    @ManyToOne
    private MPageType pageType;

    public MPage() {
    }

    public MPage(Integer pageId) {
        this.pageId = pageId;
    }

    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getPageIcon() {
        return pageIcon;
    }

    public void setPageIcon(String pageIcon) {
        this.pageIcon = pageIcon;
    }

    public MPageType getPageType() {
        return pageType;
    }

    public void setPageType(MPageType pageType) {
        this.pageType = pageType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pageId != null ? pageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPage)) {
            return false;
        }
        MPage other = (MPage) object;
        if ((this.pageId == null && other.pageId != null) || (this.pageId != null && !this.pageId.equals(other.pageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.upi.moudles.sys.domain.MPage[ pageId=" + pageId + " ]";
    }
    
}
