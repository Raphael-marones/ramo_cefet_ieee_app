package raphaelsantos.ramo_ieee_cefet_rj.Entities;

import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by raphaelsantos on 12/6/16.
 * alteração de teste
 */

public class Project implements Serializable {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLeaders() {
        return leaders;
    }

    public void setLeaders(String leaders) {
        this.leaders = leaders;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    public String getTeam_members() {
        return team_members;
    }

    public void setTeam_members(String team_members) {
        this.team_members = team_members;
    }

    public String getTitle() {
        return title;
    }

    public void getRoboticsSumoDataFromDatabase(Bundle datafromdatabase_robotics) {
        title = datafromdatabase_robotics.getString("title_robotics_sumo");
        content = datafromdatabase_robotics.getString("content_robotics_sumo");
        leaders = datafromdatabase_robotics.getString("leader_robotics_sumo");
        team_members =datafromdatabase_robotics.getString("participant_robotics_sumo");
    }
    public void getRoboticsTrekkingDataFromDatabase(Bundle datafromdatabase_robotics) {
        title = datafromdatabase_robotics.getString("title_robotics_trekking");
        content = datafromdatabase_robotics.getString("content_robotics_trekking");
        leaders = datafromdatabase_robotics.getString("leader_robotics_trekking");
        team_members =datafromdatabase_robotics.getString("participant_robotics_trekking");
    }
    public void getRoboticsLinefollowerDataFromDatabase(Bundle datafromdatabase_robotics) {
        title = datafromdatabase_robotics.getString("title_robotics_linefollower");
        content = datafromdatabase_robotics.getString("content_robotics_linefollower");
        leaders = datafromdatabase_robotics.getString("leader_robotics_linefollower");
        team_members =datafromdatabase_robotics.getString("participant_robotics_linefollower");
    }

    public void getCodersCompetitionDataFromDatabase(Bundle datafromdatabase_coders) {
        title = datafromdatabase_coders.getString("title_coders_competition");
        content = datafromdatabase_coders.getString("content_coders_competition");
        leaders = datafromdatabase_coders.getString("leader_coders_competition");
        team_members =datafromdatabase_coders.getString("participant_coders_competition");
    }
    public void getCodersMobileDataFromDatabase(Bundle datafromdatabase_coders) {
        title = datafromdatabase_coders.getString("title_coders_mobile");
        content = datafromdatabase_coders.getString("content_coders_mobile");
        leaders = datafromdatabase_coders.getString("leader_coders_mobile");
        team_members =datafromdatabase_coders.getString("participant_coders_mobile");
    }
    public void getCodersGamesDataFromDatabase(Bundle datafromdatabase_coders) {
        title = datafromdatabase_coders.getString("title_coders_games");
        content = datafromdatabase_coders.getString("content_coders_games");
        leaders = datafromdatabase_coders.getString("leader_coders_games");
        team_members =datafromdatabase_coders.getString("participant_coders_games");
    }



    public void setTitle(String title) {
        this.title = title;
    }

    String title;
    String content;
    String leaders;
    String team_members;
    String sponsors;

}
