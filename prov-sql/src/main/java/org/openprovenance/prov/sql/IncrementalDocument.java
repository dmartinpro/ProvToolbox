package org.openprovenance.prov.sql;

import org.openprovenance.prov.model.Document;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@javax.persistence.Entity(name = "IDocument")
@Table(name = "IDOCUMENT")
@Inheritance(strategy = InheritanceType.JOINED)

public class IncrementalDocument {

	public IncrementalDocument() {
		// TODO Auto-generated constructor stub
	}
	
	Long pk;
	 /**
     * Gets the value of the pk property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    @Id
    @Column(name = "PK")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getPk() {
        return pk;
    }

    /**
     * Sets the value of the pk property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPk(Long value) {
        this.pk = value;
    }


    private IncrementalDocument latest;
    
    @ManyToOne(targetEntity = org.openprovenance.prov.sql.IncrementalDocument.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "LATEST")
    
    public IncrementalDocument getLatest() {
    	return latest;
    }
    public void setLatest(IncrementalDocument latest) {
    	this.latest=latest;
    }
    
    

    

    private IncrementalDocument previous;
    
    @ManyToOne(targetEntity = org.openprovenance.prov.sql.IncrementalDocument.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "PREVIOUS")
    
    public IncrementalDocument getPrevious() {
    	return previous;
    }
    public void setPrevious(IncrementalDocument previous) {
    	this.previous=previous;
    }
    
  
    
    ////////
    
   
    
    private Document bindings;
    public void setBindings(Document bindings) {
    	this.bindings=bindings;
    }
    
    @ManyToOne(targetEntity = org.openprovenance.prov.sql.Document.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "BINDINGS")
    public Document getBindings() {
    	return bindings;
    }
   
    ///////////


    
    
    private Document template;
    public void setTemplate(Document template) {
    	this.template=template;
    }
    
    @ManyToOne(targetEntity = org.openprovenance.prov.sql.Document.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "TEMPLATE")
    public Document getTemplate() {
    	return template;
    }
    
    
    /////////////
    
    

    
    private Document logBinding;
    public void setLog(Document logBinding) {
    	this.logBinding=logBinding;
    }
    
    @ManyToOne(targetEntity = org.openprovenance.prov.sql.Document.class, cascade = {
        CascadeType.ALL
    })
    @JoinColumn(name = "LOG")
    
    public Document getLog() {
    	return logBinding;
    }
}
