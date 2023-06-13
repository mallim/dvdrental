package com.mallim.dvdrental.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Rating
{
    GENERAL_AUDIENCES("G"),
    PARENTAL_GUIDANCE_SUGGESTED("PG"),
    PARENTS_STRONGLY_CAUTIONED("PG-13"),
    RESTRICTED("R"),
    ADULTS_ONLY("NC-17");

    final String code;

    public static Rating getByCode( String code )
    {
        for(Rating v : values()){
            if( v.getCode().equals(code)){
                return v;
            }
        }
        throw new IllegalArgumentException("oh no");
    }
}
