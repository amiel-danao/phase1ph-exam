package com.phase1ph.exam2.service;

import com.phase1ph.exam2.model.Pythagorean;
import com.phase1ph.exam2.model.Response;

public interface PythagoreanService {
    Pythagorean computePythagorean(int c);
    void addResponseToDb(Response response);
}
