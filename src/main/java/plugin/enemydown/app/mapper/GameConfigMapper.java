package plugin.enemydown.app.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import plugin.enemydown.app.mapper.data.GameConfig;
import plugin.enemydown.app.mapper.data.SpawnEnemy;

@Mapper
public interface GameConfigMapper {

  @Select("select * from game_config order by id asc")
  List<GameConfig> selectConfigList();

  @Select("select * from game_config where difficulty = #{difficulty} order by id asc")
  GameConfig selectConfig(String difficulty);

  @Select("select * from spawn_enemy_ordered inner join game_config on spawn_enemy_ordered.difficulty = game_config.difficulty where spawn_enemy_ordered.difficulty = #{difficulty} order by spawn_enemy.id asc")
  List<SpawnEnemy> selectSpawnEnemyList(String difficulty);
  //inner join 結合したいtable名　にてインナージョイン設定することで、game_config側に存在しない難易度の敵は絶対に出なくなる

//tablesName is game_config,spawn_enemy_ordered,player_score,

  @Insert("insert game_config(game_time,difficulty) values(#{gameTime}, #{difficulty})")
  int insertConfig(GameConfig config);

  @Update("update spawn_enemy set score = #{score} where enemy_name = #{enemyName} and difficulty = #{difficulty}")
  int updateEnemyScore(SpawnEnemy enemy);

}
