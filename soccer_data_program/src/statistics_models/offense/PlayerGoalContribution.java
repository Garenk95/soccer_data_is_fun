package statistics_models.offense;

import player_team_models.Player;
import statistics_models.OffensiveStat;

public class PlayerGoalContribution extends OffensiveStat {

  public PlayerGoalContribution(){}

  public int calculateSimpleGoalContribution( Player player){
    return player.getAssistCount() + player.getGoalCount();
  }

  public double calculateGoalContributionWithMinutes(Player player){
    if(player.getMinutesPlayed() == 0){
      return calculateSimpleGoalContribution( player );
    } else {
      return ((double) ( (player.getAssistCount() * 0.75) + player.getGoalCount() ) / player.getMinutesPlayed()) * 100;
    }
  }

  @Override
  public double calculate() {
    return 0;
  }
}
