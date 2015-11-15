package ar.pablitar.catchtheball

import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.events.constants.Key

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
  var spawning = true
  
  val cooldown = Cooldown(0.2, () => spawnBall())
  
  override def update(state: DeltaState) = {
    if(state.isKeyPressed(Key.SPACE)) {
      spawning = !spawning
    }
    
    if(spawning) {
      cooldown.update(state)
    }
  }

  def spawnBall() = {
    this.getScene.addComponent(Ball.spawn())
  }
  
}