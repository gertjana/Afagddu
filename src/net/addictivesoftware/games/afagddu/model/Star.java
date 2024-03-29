//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.24 at 03:42:46 PM CEST 
//


package net.addictivesoftware.games.afagddu.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="RenderInfo" type="{http://www.addictivesoftware.net/afagddu}RenderInfo"/>
 *         &lt;group ref="{http://www.addictivesoftware.net/afagddu}Planets" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "description",
    "renderInfo",
    "planets"
})
@XmlRootElement(name = "Star")
public class Star {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Description", required = true)
    protected String description;
    @XmlElement(name = "RenderInfo", required = true)
    protected RenderInfo renderInfo;
    @XmlElement(name = "Planet", required = true)
    protected List<Planet> planets;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the renderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link RenderInfo }
     *     
     */
    public RenderInfo getRenderInfo() {
        return renderInfo;
    }

    /**
     * Sets the value of the renderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenderInfo }
     *     
     */
    public void setRenderInfo(RenderInfo value) {
        this.renderInfo = value;
    }

    /**
     * Gets the value of the planets property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planets property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanets().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Planet }
     * 
     * 
     */
    public List<Planet> getPlanets() {
        if (planets == null) {
            planets = new ArrayList<Planet>();
        }
        return this.planets;
    }

}
