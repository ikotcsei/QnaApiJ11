package somaog.QnaApiJ11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import somaog.QnaApiJ11.XMLInputHandlers.Tetel;
import somaog.QnaApiJ11.repository.*;

@Service
public class TetelService {

    @Autowired
    DesignPatternRepositoryInOrder designPatternRepositoryInOrder;

    @Autowired
    DesignPatternRepositoryRandom designPatternRepositoryRandom;

    @Autowired
    JavaBasicRepositoryInOrder javaBasicRepositoryInOrder;

    @Autowired
    JavaBasicRepositoryRandom javaBasicRepositoryRandom;

    public Tetel readDesPattRnd() throws Exception {
        return designPatternRepositoryRandom.readNext();
    }

    public Tetel readDesPattInOrder() throws Exception {
        return designPatternRepositoryInOrder.readNext();
    }

    public Tetel readJavaBasicTetelRandom() throws Exception {
        return javaBasicRepositoryRandom.readNext();
    }

    public Tetel readJavaBasicTetelInOrder() throws Exception {
        return javaBasicRepositoryInOrder.readNext();
    }
}
