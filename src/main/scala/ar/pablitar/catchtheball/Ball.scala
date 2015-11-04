package ar.pablitar.catchtheball

import com.uqbar.vainilla.appearances.Circle
import java.awt.Color
import com.uqbar.vainilla.DeltaState
import com.uqbar.vainilla.colissions.CollisionDetector

/**
 * @author pablitar
 */
class Ball extends CatchTheBallGameComponent {

  val diameter = 80
  val radius = diameter.toDouble / 2

  this.setAppearance(new Circle(Color.YELLOW, diameter))

  this.position = (randomPosition(), CatchTheBallGame.height / 10.0)

  var gravityCenter = Vector2D(400, 300)

  var speed: Vector2D = (300.0, 0.0)
  val accelerationMagnitude = 800
  def acceleration: Vector2D = (gravityCenter - position).versor * accelerationMagnitude

  override def update(state: DeltaState) = {
    this.speed += acceleration * state.getDelta
    this.position += this.speed * state.getDelta

    if (CollisionDetector.INSTANCE.
      collidesCircleAgainstRect(getX, getY, diameter / 2,
        BallCatcher.getX, BallCatcher.getY, BallCatcher.width, BallCatcher.height) && this.speed.x2 > 0) {
      //this.speed = Vector2D(this.speed.x1, -this.speed.x2)
      this.speed = Vector2D(this.speed.x1 + calculateXSpeedAfterRebound, -this.speed.x2)

    }

    if (this.isBelowTheScreen) {
      this.destroy()
    }
  }

  def randomPosition() = {
    //CatchTheBallGame.width.toDouble / 2
    CatchTheBallGame.randomizer.nextDouble * CatchTheBallGame.width
  }

  def isBelowTheScreen = {
    this.position.x2 >= CatchTheBallGame.height
  }

  def calculateXSpeedAfterRebound = {
    println((this.center - BallCatcher.center).versor.toString())
    (this.center - BallCatcher.center).versor.x1 * speed.x2.abs
  }

  def center = {
    this.position + (radius, radius)
  }

  override def position_=(v: Vector2D) = super.position_=(boundWithWalls(v))

  def boundWithWalls(v: Vector2D) = {
    v
  }
}