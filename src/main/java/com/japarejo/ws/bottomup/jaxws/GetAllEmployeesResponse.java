
package com.japarejo.ws.bottomup.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.japarejo.ws.Employee;

@XmlRootElement(name = "getAllEmployeesResponse", namespace = "http://bottomup.ws.japarejo.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllEmployeesResponse", namespace = "http://bottomup.ws.japarejo.com/")
public class GetAllEmployeesResponse {

    @XmlElement(name = "return", namespace = "")
    private List<Employee> _return;

    /**
     * 
     * @return
     *     returns List<Employee>
     */
    public List<Employee> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<Employee> _return) {
        this._return = _return;
    }

}
