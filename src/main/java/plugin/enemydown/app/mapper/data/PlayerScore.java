package plugin.enemydown.app.mapper.data;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * コメントはあえて意図的に消す
 * コメントは合ったほうがいいが、皆さんで考えてください。
 */
@Getter
@Setter
@NoArgsConstructor
public class PlayerScore {

  private int id;
  private  String playerName;
  private  int score;
  private String difficulty;
  private LocalDateTime registeredAt;

}
