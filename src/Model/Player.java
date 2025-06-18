/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Gazez
 */
public class Player {

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the division
     */
    public String getDivision() {
        return division;
    }

    /**
     * @param division the division to set
     */
    public void setDivision(String division) {
        this.division = division;
    }

    /**
     * @return the id_player
     */
    public Integer getId_player() {
        return id_player;
    }

    /**
     * @param id_player the id_player to set
     */
    public void setId_player(Integer id_player) {
        this.id_player = id_player;
    }

    /**
     * @return the ign
     */
    public String getIgn() {
        return ign;
    }

    /**
     * @param ign the ign to set
     */
    public void setIgn(String ign) {
        this.ign = ign;
    }

    /**
     * @return the realname
     */
    public String getRealname() {
        return realname;
    }

    /**
     * @param realname the realname to set
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * @return the nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

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
    private Integer id_player;
    private String ign;
    private String realname;
    private String nationality;
    private String status;
    private Integer id_team;
    private String division;
    private Integer age;
}
