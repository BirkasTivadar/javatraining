/*
A feladathoz szükség van egy soccer.TeamStatistics osztályra, amely egy tabella sor adatait tartalmazza.
    TeamStatistics osztály:
        Sok adatra van szüksége: csapat neve (teamName), lejátszott meccsek száma (played), győzelmek (won), döntetlenek (tied), vereségek (lost), rúgott gólok (goalsFor), kapott gólok (goalsAgainst), pontszám (points). Ezek egy részét szervezd ki egy belső osztályba az osztályon belül, és legyen a TeamStatistics-nek egy ilyen belső osztály típusú attribútuma!
        getterek
        equals és hashCode metódusok a teamName alapján legenerálva
        egy void played(int plusGoalsFor, int plusGoalsAgainst) metódus, amely egy lejátszott meccs eredményeit kapja paraméterül, és ezalapján módosítja az adatokat. Ez a metódus minden adatot módosítson, tehát a kapott és rúgott gólok számán kívül az összes lejátszott mérkőzések számát, a nyert, döntetlen vagy vesztett mérkőzések számát (természetesen a megkapott meccseredménytől függően), valamint a csapat összpontszámát! (A nyert mérkőzések 3, a döntetlenek 1, a vesztett mérkőzések 0 pontot érnek.)
*/

package nestedclasses.soccer;

import java.util.Objects;

public class TeamStatistics {

    private final String teamName;
    private int played;
    private int won;
    private int tied;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int points;

    public TeamStatistics(String teamName) {
        this.teamName = teamName;
    }

    void played(int plusGoalsFor, int plusGoalsAgainst) {
        played++;
        goalsFor += plusGoalsFor;
        goalsAgainst += plusGoalsAgainst;
        if (plusGoalsFor > plusGoalsAgainst) won++;
        else if (plusGoalsFor == plusGoalsAgainst) tied++;
        else lost++;
        points = won * 3 + tied;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getPlayed() {
        return played;
    }

    public int getWon() {
        return won;
    }

    public int getTied() {
        return tied;
    }

    public int getLost() {
        return lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamStatistics that)) return false;
        return Objects.equals(teamName, that.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName);
    }
}
