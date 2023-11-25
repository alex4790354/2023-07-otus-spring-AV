package ru.otus.spring.integration.domain.xml;


import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "item"
})
@XmlRootElement(name = "Valuta")
public class Valuta {

    @XmlElement(name = "Item", required = true)
    protected List<Item> item;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "name",
        "engName",
        "nominal",
        "parentCode"
    })

    @Data
    public static class Item {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "EngName", required = true)
        protected String engName;
        @XmlElement(name = "Nominal")
        @XmlSchemaType(name = "unsignedInt")
        protected long nominal;
        @XmlElement(name = "ParentCode", required = true)
        protected String parentCode;
        @XmlAttribute(name = "ID", required = true)
        protected String id;

            }

}
