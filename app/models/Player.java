package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Player extends Model {
  @Id
  public long id;

  @Required(message = "Vous devez spécifier un nom de joueur.")
  public String name;

  @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
  @JoinColumn(name="stats_id",insertable=true,
    updatable=true,nullable=true,unique=true)
  public Stats stats = new Stats();
}
