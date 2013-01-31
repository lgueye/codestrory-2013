package org.diveintojee.codestory2013.jajascript;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable {

    private List<Rent> rents = Lists.newArrayList();

    @JsonProperty("path")
    public List<String> getPath() {
        return Lists.newArrayList(Collections2.transform(this.rents, new Function<Rent, String>() {
            @Override
            public String apply(Rent input) {
              return input.getName();
            }
        }));
    }

    @JsonProperty("gain")
    public int getRevenue() {
        int revenue = 0;
        for (Rent rent : rents) {
            revenue+= rent.getAmount();
        }
        return revenue;
    }

    public void addRent(Rent rent) {
        this.rents.add(rent);
    }

}
