/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH06.JAXB;

/**
 *
 * @author Abel Rodríguez
 */
public class CustomerJSON {
    
    protected int id;
    protected String fullname;
    protected AddressXML address;
    
    public CustomerJSON() {}

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
