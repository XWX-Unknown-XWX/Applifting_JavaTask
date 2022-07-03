package microservice.task.applifting;

import microservice.task.applifting.model.MonitoredEndpoint;
import microservice.task.applifting.model.MonitoringResult;
import microservice.task.applifting.model.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

public class GeneratorTemp {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static EntityTransaction et;

    public GeneratorTemp() {
        emf = Persistence.createEntityManagerFactory("db");
        em = emf.createEntityManager();
    }

    public void close() {
        em.close();
        emf.close();
    }

    // --- MEP (MonitoredEndpoint) ---
    public MonitoredEndpoint createMEP(String name, String url, User owner) {
        et = em.getTransaction();
        et.begin();
        MonitoredEndpoint mep = new MonitoredEndpoint(name, url, owner);
        mep.setDateOfCreation(new Timestamp(System.currentTimeMillis()));
        em.persist(mep);
        et.commit();
        return mep;
    }

    public MonitoredEndpoint readMEP(String name, String url) {
        TypedQuery<MonitoredEndpoint> query = em.createQuery("SELECT m FROM MonitoredEndpoint m WHERE " +
                "m.name = :name " +
                "and m.url = :url ", MonitoredEndpoint.class);
        query.setParameter("name", name);
        query.setParameter("url", url);
        return query.getSingleResult();
    }

    public GeneratorTemp updateMEP(MonitoredEndpoint mep, String name, String url, User owner) {
        et = em.getTransaction();
        et.begin();
        mep.setName(name);
        mep.setUrl(url);
        mep.setOwner(owner);
        em.persist(mep);
        et.commit();
        System.out.println("Update MonitoredEndpoint{" +
                "name: \"" + name + "\"," +
                "url: \"" + url + "\"," +
                "owner: \"" + owner + "\"" +
                "}");
        return this;
    }

    public GeneratorTemp deleteMEP(MonitoredEndpoint mep) {
        et = em.getTransaction();
        et.begin();
        em.remove(mep);
        em.flush();
        et.commit();
        System.out.println("Remove MonitoredEndpoint (" + mep.toString() + ")");
        return this;
    }

    // --- MR (MonitoringResult) ---
    public MonitoringResult createMR(String returnedPayload, MonitoredEndpoint monitoredEPId) {
        et = em.getTransaction();
        et.begin();
        MonitoringResult mr = new MonitoringResult(returnedPayload, monitoredEPId);
        mr.setDateOfCheck(new Timestamp(System.currentTimeMillis()));
        em.persist(mr);
        et.commit();
        return mr;
    }

    public MonitoringResult readMR(Integer returnedHttp, String returnedPayload) {
        TypedQuery<MonitoringResult> query = em.createQuery("SELECT r FROM MonitoringResult r WHERE " +
                "r.returnedHttpStatusCode = :returnedHttp " +
                "and r.returnedPayload = :returnedPayload ", MonitoringResult.class);
        query.setParameter("returnedHttp", returnedHttp);
        query.setParameter("returnedPayload", returnedPayload);
        return query.getSingleResult();
    }

    public GeneratorTemp updateMR(MonitoringResult mr, Integer returnedHttp, String returnedPayload, MonitoredEndpoint monitoredEPId) {
        et = em.getTransaction();
        et.begin();
        mr.setReturnedHttpStatusCode(returnedHttp);
        mr.setReturnedPayload(returnedPayload);
        mr.setMonitoredEndpointId(monitoredEPId);
        em.persist(mr);
        et.commit();
        System.out.println("Update MonitoringResult{" +
                "returnedHttpStatusCode: \"" + returnedHttp + "\"," +
                "returnedPayload: \"" + returnedPayload + "\"," +
                "monitoredEndpointId: \"" + monitoredEPId + "\"" +
                "}");
        return this;
    }

    public GeneratorTemp deleteMR(MonitoringResult mr) {
        et = em.getTransaction();
        et.begin();
        em.remove(mr);
        em.flush();
        et.commit();
        System.out.println("Remove MonitoringResult (" + mr.toString() + ")");
        return this;
    }
}
