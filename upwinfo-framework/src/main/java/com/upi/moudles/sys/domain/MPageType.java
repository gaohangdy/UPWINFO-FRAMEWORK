/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upi.moudles.sys.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author hang
 */
@Entity
@Table(name = "m_page_type")
@NamedQueries({
    @NamedQuery(name = "MPageType.findAll", query = "SELECT m FROM MPageType m")})
public class MPageType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TYPE_ID")
    private Integer typeId;
    @Size(max = 64)
    @Column(name = "TYPE_NAME")
    private String typeName;
    @OneToMany(mappedBy = "pageType")
    private List<MPage> mPageList;

    public MPageType() {
    }

    public MPageType(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<MPage> getMPageList() {
        return mPageList;
    }

    public void setMPageList(List<MPage> mPageList) {
        this.mPageList = mPageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MPageType)) {
            return false;
        }
        MPageType other = (MPageType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.upi.moudles.sys.domain.MPageType[ typeId=" + typeId + " ]";
    }
    
}
