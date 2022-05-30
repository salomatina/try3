package ru.mephi;

public class Reactor {

    String type;
    Double burnup;
    Double kpd;
    Double enrichment;
    Double termalCapacity;
    Double electricalCapacity;
    Double lifeTime;
    Double firstLoad;
    String source;

    public void setType(String type) {
        this.type = type;
    }

    public void setBurnup(Double burnup) {
        this.burnup = burnup;
    }

    public void setKpd(Double kpd) {
        this.kpd = kpd;
    }

    public void setEnrichment(Double enrichment) {
        this.enrichment = enrichment;
    }

    public void setTermalCapacity(Double termalCapacity) {
        this.termalCapacity = termalCapacity;
    }

    public void setElectricalCapacity(Double electricalCapacity) {
        this.electricalCapacity = electricalCapacity;
    }

    public void setLifeTime(Double lifeTime) {
        this.lifeTime = lifeTime;
    }

    public void setFirstLoad(Double firstLoad) {
        this.firstLoad = firstLoad;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Reactor(){

    }

    public Reactor(String type, Double burnup, Double kpd, Double enrichment,
                   Double termalCapacity, Double electricalCapacity,
                   Double lifeTime, Double firstLoad, String source) {
        this.type = type;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termalCapacity = termalCapacity;
        this.electricalCapacity = electricalCapacity;
        this.lifeTime = lifeTime;
        this.firstLoad = firstLoad;
        this.source = source;
    }
}
