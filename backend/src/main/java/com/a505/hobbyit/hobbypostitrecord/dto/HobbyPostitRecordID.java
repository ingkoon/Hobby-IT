package com.a505.hobbyit.hobbypostitrecord.dto;

import com.a505.hobbyit.hobby.domain.Hobby;

import java.io.Serializable;

public class HobbyPostitRecordID implements Serializable {

    private Hobby hobby;
    private int year;
    private int month;
    private int day;
}
