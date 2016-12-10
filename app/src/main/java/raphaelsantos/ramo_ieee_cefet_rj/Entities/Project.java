package raphaelsantos.ramo_ieee_cefet_rj.Entities;

/**
 * Created by raphaelsantos on 12/6/16.
 */

public class Project {
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

    public void setTitle(String title) {
        this.title = title;
    }

    String title;
    String content;
    String leaders;
    String team_members;
    String sponsors;

}
