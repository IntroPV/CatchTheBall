package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.DeltaState

case class Cooldown(cooldown: Double, action: (() => Unit)) {
  var elapsed = 0.0
  def update(state: DeltaState) = {
    this.elapsed += state.getDelta
    if(elapsed >= cooldown){
      action()
      this.elapsed = 0.0
    }
  }
}

/**
 * @author pablitar
 */
object BallSpawner extends GameComponent[CatchTheBallScene] {
  val cooldown = Cooldown(2, () => spawnBall())
  
  override def update(state: DeltaState) = {
    cooldown.update(state)
  }

  def spawnBall() = {
    this.getScene.addComponent(new Ball())
  }
  
}