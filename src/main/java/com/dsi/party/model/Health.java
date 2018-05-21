package com.dsi.party.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nguym046 on 11/4/16.
 */
public class Health implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7422821786300037360L;

    private List<Double> cpu_load;
    private Long mem_free;
    private Double mem_free_percent;
    private Long mem_total;
    private Long os_uptime;

    public List<Double> getCpu_load() {
        return cpu_load;
    }
    public void setCpu_load(List<Double> cpu_load) {
        this.cpu_load = cpu_load;
    }
    public Long getMem_free() {
        return mem_free;
    }
    public void setMem_free(Long mem_free) {
        this.mem_free = mem_free;
    }
    public Double getMem_free_percent() {
        return mem_free_percent;
    }
    public void setMem_free_percent(Double mem_free_percent) {
        this.mem_free_percent = mem_free_percent;
    }
    public Long getMem_total() {
        return mem_total;
    }
    public void setMem_total(Long mem_total) {
        this.mem_total = mem_total;
    }
    public Long getOs_uptime() {
        return os_uptime;
    }
    public void setOs_uptime(Long os_uptime) {
        this.os_uptime = os_uptime;
    }

}
