/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HYPE AMD
 */
public class TeamEsports {

    /**
     * @return the id_team
     */
    public Integer getId_team() {
        return id_team;
    }

    /**
     * @param id_team the id_team to set
     */
    public void setId_team(Integer id_team) {
        this.id_team = id_team;
    }

    /**
     * @return the name_team
     */
    public String getName_team() {
        return name_team;
    }

    /**
     * @param name_team the name_team to set
     */
    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    /**
     * @return the location_team
     */
    public String getLocation_team() {
        return location_team;
    }

    /**
     * @param location_team the location_team to set
     */
    public void setLocation_team(String location_team) {
        this.location_team = location_team;
    }

    /**
     * @return the region_team
     */
    public String getRegion_team() {
        return region_team;
    }

    /**
     * @param region_team the region_team to set
     */
    public void setRegion_team(String region_team) {
        this.region_team = region_team;
    }

    /**
     * @return the years
     */
    public Integer getYears() {
        return years;
    }

    /**
     * @param years the years to set
     */
    public void setYears(Integer years) {
        this.years = years;
    }
    private Integer id_team;
    private String name_team;
    private String location_team;
    private String region_team;
    private Integer years;
}
