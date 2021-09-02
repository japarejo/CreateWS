
package com.japarejo.ws.bottomup.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.japarejo.ws.Employee;

@XmlRootElement(name = "updateEmployee", namespace = "http://bottomup.ws.japarejo.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateEmployee", namespace = "http://bottomup.ws.japarejo.com/")
public class UpdateEmployee {

    @XmlElement(name = "arg0", namespace = "")
    private Employee arg0;

    /**
     * 
     * @return
     *     returns Employee
     */
    public Employee getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Employee arg0) {
        this.arg0 = arg0;
    }

}
