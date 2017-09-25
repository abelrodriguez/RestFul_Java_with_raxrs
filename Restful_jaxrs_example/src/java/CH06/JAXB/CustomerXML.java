/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06.JAXB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abel Rodríguez
 */
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerXML {
    
    @XmlAttribute
    protected int id;
    
    @XmlElement
    protected String fullname;
    
    @XmlElement
    protected AddressXML address;
    
    public CustomerXML() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    public AddressXML getAddress() {
        return address;
    }

    public void setAddress(AddressXML address) {
        this.address = address;
    }
    
    
    
    
    
}
