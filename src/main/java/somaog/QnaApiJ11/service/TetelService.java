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

    @Autowired
    BasicAlgosRepositoryInOrder basicAlgosRepositoryInOrder;

    @Autowired
    BasicAlgosRepositoryRandom basicAlgosRepositoryRandom;

    @Autowired
    SysDesignRepositoryInOrder sysDesignRepositoryInOrder;

    @Autowired
    SysDesignRepositoryRandom sysDesignRepositoryRandom;

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

    public Tetel readBasicAlgosTetelRandom() throws Exception {
        return basicAlgosRepositoryRandom.readNext();
    }

    public Tetel readBasicAlgosTetelInOrder() throws Exception {
        return basicAlgosRepositoryInOrder.readNext();
    }

    public Tetel readSysDesignTetelRandom() throws Exception {
        return sysDesignRepositoryRandom.readNext();
    }

    public Tetel readSysDesignTetelInOrder() throws Exception {
        return sysDesignRepositoryInOrder.readNext();
    }
}
