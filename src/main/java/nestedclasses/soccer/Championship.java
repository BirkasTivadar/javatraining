/*
Focibajnokság
    Legyen egy soccer.Championship osztály, amellyel egy focibajnokság eredményeit megadva megkaphatjuk a tabellát! A feladathoz szükség van egy soccer.TeamStatistics osztályra, amely egy tabella sor adatait tartalmazza. A Championship osztály tartalmazzon egy GameResult static nested classt, amely egy meccs eredményét tartalmazza! Ennek alapján kell a TeamStatistics példányokat módosítani.
        TeamStatistics osztály:
        Sok adatra van szüksége: csapat neve (teamName), lejátszott meccsek száma (played), győzelmek (won), döntetlenek (tied), vereségek (lost), rúgott gólok (goalsFor), kapott gólok (goalsAgainst), pontszám (points). Ezek egy részét szervezd ki egy belső osztályba az osztályon belül, és legyen a TeamStatistics-nek egy ilyen belső osztály típusú attribútuma!
        getterek
        equals és hashCode metódusok a teamName alapján legenerálva
        egy void played(int plusGoalsFor, int plusGoalsAgainst) metódus, amely egy lejátszott meccs eredményeit kapja paraméterül, és ezalapján módosítja az adatokat. Ez a metódus minden adatot módosítson, tehát a kapott és rúgott gólok számán kívül az összes lejátszott mérkőzések számát, a nyert, döntetlen vagy vesztett mérkőzések számát (természetesen a megkapott meccseredménytől függően), valamint a csapat összpontszámát! (A nyert mérkőzések 3, a döntetlenek 1, a vesztett mérkőzések 0 pontot érnek.)
        GameResult belső osztály:
        Adatai: teamHome, teamGuest, goalHome, goalGuest
        Konstruktorra szükség van, de getterekre, setterekre nincs, mivel a külső osztály látja a tagosztály private attribútumait is.
        Championship osztály:
        Adata: TeamStatistics leagueTable lista
        Legyen hozzá getter
        Legyen egy metódus, amivel egy meccseredményt megadhatunk (public void addGame(GameResult result))
*/

package nestedclasses.soccer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Championship {

    private final List<TeamStatistics> leagueTable = new ArrayList<>();

    public List<TeamStatistics> getLeagueTable() {
        return new ArrayList<>(leagueTable);
    }

    public void addGame(GameResult gameResult) {
        TeamStatistics home = getTeam(gameResult.teamHome);
        home.played(gameResult.goalHome, gameResult.goalGuest);

        TeamStatistics guest = getTeam(gameResult.teamGuest);
        guest.played(gameResult.goalGuest, gameResult.goalHome);
    }

    private TeamStatistics getTeam(String team) {
        Optional<TeamStatistics> home = leagueTable.stream().filter(e -> e.equals(new TeamStatistics(team))).findAny();
        if (home.isPresent()) return home.get();
        TeamStatistics newTeam = new TeamStatistics(team);
        leagueTable.add(newTeam);
        return newTeam;
    }

    public record GameResult(String teamHome, String teamGuest, int goalHome, int goalGuest) {
    }
}
