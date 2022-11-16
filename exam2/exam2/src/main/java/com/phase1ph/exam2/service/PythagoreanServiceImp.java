package com.phase1ph.exam2.service;


import com.phase1ph.exam2.model.Pythagorean;
import com.phase1ph.exam2.model.Response;
import com.phase1ph.exam2.repository.PythagoreanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pythagoreanService")
public class PythagoreanServiceImp implements PythagoreanService {

    @Autowired
    private PythagoreanRepository pythagoreanRepository;

    @Override
    public Pythagorean computePythagorean(int c) {
        int k = (int) Math.sqrt(c/2.0);

        for (int i = 1; i <= k; i++) {
            int tmp = (int) Math.sqrt(c - i * i);
            if ((tmp * tmp) == (c - i * i)) {
                int a = (tmp*tmp - i*i);
                int b = 2 * tmp * i;

                Pythagorean result = new Pythagorean();
                result.setA(a);
                result.setB(b);
                result.setC(c);
                float average = (a + b + c) / 3f;
                result.setAverage(average);
                return result;
            }
        }

        return null;
    }

    @Override
    public void addResponseToDb(Response response) {
        pythagoreanRepository.save(response);
    }
}
