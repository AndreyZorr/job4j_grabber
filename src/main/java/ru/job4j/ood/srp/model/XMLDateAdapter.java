package ru.job4j.ood.srp.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class XMLDateAdapter extends XmlAdapter<String, Calendar> {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public String marshal(Calendar v) {
        return DATE_FORMAT.format(v.getTime());
    }

    @Override
    public Calendar unmarshal(String v) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(v));
        return calendar;
    }
}
