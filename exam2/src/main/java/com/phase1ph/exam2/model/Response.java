package com.phase1ph.exam2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="responses")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonIgnore
    private long id;
    public static final String DEFAULT_RESPONSE = "A – value of “a” \n" +
            "B – value of “b” \n" +
            "C – value of “c” \n" +
            "AVG – average of a, b, and c";
    @Column(name="response", columnDefinition = "json")
    private String response = DEFAULT_RESPONSE;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
