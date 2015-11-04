package ar.pablitar.catchtheball

import com.uqbar.vainilla.GameComponent
import com.uqbar.vainilla.appearances.Rectangle
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.events.constants.Key

/**
 * @author pablitar
 */
object BallCatcher extends CatchTheBallGameComponent {
  val width = 100
  val height = 50
  this.setAppearance(new Rectangle(Color.BLUE, width, height))

  var speed: Vector2D = (0.0, 0.0)
  
  val speedMagnitude = 500.0

  this.position = ((CatchTheBallGame.width.toDouble - width) / 2, CatchTheBallGame.height - height.toDouble * 2)

  override def update(state: DeltaState) = {
    if (state.isKeyBeingHold(Key.LEFT)) {
      this.speed = (-speedMagnitude, 0.0)
    } else if (state.isKeyBeingHold(Key.RIGHT)) {
      this.speed = (speedMagnitude, 0.0)
    } else {
      this.speed = (0.0, 0.0)
    }

    this.position += this.speed * state.getDelta
  }
  
   override def position_=(v:Vector2D) = super.position_=(CatchTheBallGame.bounds.limit(v, (width.toDouble, height.toDouble)))

  def center = {
    position + (Vector2D(width, height) * 0.5)
  }
}