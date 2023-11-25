package ru.otus.spring.integration.domain.xml;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.ArrayList;
import java.util.List;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "valute"
})
@XmlRootElement(name = "ValCurs")
public class ValCurs {

    @XmlAttribute(name = "Date", required = true)
    protected String date;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    @XmlElement(name = "Valute", required = true)
    protected List<Valute> valute;

    public List<Valute> getValute() {
        if (valute == null) {
            valute = new ArrayList<Valute>();
        }
        return this.valute;
    }

    public void setValute(List<Valute> valute) {
        this.valute = valute;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String value) {
        this.date = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "numCode",
        "charCode",
        "nominal",
        "name",
        "value",
        "vunitRate"
    })
    public static class Valute {

        @XmlElement(name = "NumCode")
        @XmlSchemaType(name = "unsignedShort")
        protected int numCode;
        @XmlElement(name = "CharCode", required = true)
        protected String charCode;
        @XmlElement(name = "Nominal")
        @XmlSchemaType(name = "unsignedInt")
        protected long nominal;
        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Value", required = true)
        protected String value;
        @XmlElement(name = "VunitRate", required = true)
        protected String vunitRate;
        @XmlAttribute(name = "ID", required = true)
        protected String id;

        public int getNumCode() {
            return numCode;
        }

        public void setNumCode(int value) {
            this.numCode = value;
        }

        public String getCharCode() {
            return charCode;
        }

        public void setCharCode(String value) {
            this.charCode = value;
        }

        public long getNominal() {
            return nominal;
        }

        public void setNominal(long value) {
            this.nominal = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String value) {
            this.name = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getVunitRate() {
            return vunitRate;
        }

        public void setVunitRate(String value) {
            this.vunitRate = value;
        }

        public String getID() {
            return id;
        }

        public void setID(String value) {
            this.id = value;
        }

    }

}
